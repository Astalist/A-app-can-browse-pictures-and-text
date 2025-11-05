package com.example.demo.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.exception.MultiObjectDeleteException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CloudUtil {
    private static COSClient createCOSClient(){
        // 1 初始化用户身份信息（secretId, secretKey）。
// SECRETID 和 SECRETKEY 请登录访问管理控制台 https://console.cloud.tencent.com/cam/capi 进行查看和管理
        String secretId = ;//用户的 SecretId，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        String secretKey = ;//用户的 SecretKey，建议使用子账号密钥，授权遵循最小权限指引，降低使用风险。子账号密钥获取可参见 https://cloud.tencent.com/document/product/598/37140
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
// 2 设置 bucket 的地域, COS 地域的简称请参见 https://cloud.tencent.com/document/product/436/6224
// clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
// 这里建议设置使用 https 协议
// 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
// 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    /**
     *
     * @return 腾讯云桶中所有的文件
     */
    public static List<String> findFile(){
        COSClient cosClient = createCOSClient();

// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = "sku-1327428557";

        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
// 设置 bucket 名称
        listObjectsRequest.setBucketName(bucketName);
// 设置列出的对象名以 prefix 为前缀
        listObjectsRequest.setPrefix("");
// 设置最大列出多少个对象, 一次 listobject 最大支持1000
        listObjectsRequest.setMaxKeys(1000);

// 保存列出的结果
        ObjectListing objectListing = null;

        try {
            objectListing = cosClient.listObjects(listObjectsRequest);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        List<String> cloud = new ArrayList<>();
// object summary 表示此次列出的对象列表
        List<COSObjectSummary> cosObjectSummaries = objectListing.getObjectSummaries();
        for (COSObjectSummary cosObjectSummary : cosObjectSummaries) {
            // 对象的 key
            String key = cosObjectSummary.getKey();
            // 将文件的名字保存到 cloud中
            cloud.add(key);
        }

        if (objectListing.isTruncated()) {
            // 表示还没有列完，被截断了

            // 下一次开始的位置
            String nextMarker = objectListing.getNextMarker();
        }

// 确认本进程不再使用 cosClient 实例之后，关闭即可
        cosClient.shutdown();

        return cloud;
    }

    /**
     *
     * @param file 上传的文件
     * @return 存储在云中的文件名
     * @throws IOException
     */
    public static String upload(MultipartFile file) throws IOException {
//        System.out.println("jjjjjjjjjjjjj");
        COSClient cosClient = createCOSClient();
// 指定文件将要存放的存储桶
        String bucketName = ;
// 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
//        String key = "test.jpg";

        // 要获取文件的后缀名    abcda.jpg
        // 先获取上传的文件的原始名称
        String fileName = file.getOriginalFilename();
        // 获得最后一个 .的索引
        int index = fileName.lastIndexOf(".");
        String hzm = fileName.substring(index);
        // 随机生成一个32位长度的字符串
        String key = UUID.randomUUID().toString() + hzm;  // abcdasd-fas-dfasdfsdf
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(),null);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        return +key;
    }


    /**
     *
     * @param cloud 垃圾图片名称所组成的集合
     */
    public static void deleteFile(List<String> cloud){
        // 调用 COS 接口之前必须保证本进程存在一个 COSClient 实例，如果没有则创建
// 详细代码参见本页：简单操作 -> 创建 COSClient
        COSClient cosClient = createCOSClient();

// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
        String bucketName = ;

        DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(bucketName);
// 设置要删除的key列表, 最多一次删除1000个
        ArrayList<DeleteObjectsRequest.KeyVersion> keyList = new ArrayList<>();
// 传入要删除的文件名
// 注意文件名不允许以正斜线/或者反斜线\开头，例如：
// 存储桶目录下有a/b/c.txt文件，如果要删除，只能是 keyList.add(new KeyVersion("a/b/c.txt")), 若使用 keyList.add(new KeyVersion("/a/b/c.txt"))会导致删除不成功
        for (String s : cloud) {
            keyList.add(new DeleteObjectsRequest.KeyVersion(s));
        }
        deleteObjectsRequest.setKeys(keyList);

        try {
            DeleteObjectsResult deleteObjectsResult = cosClient.deleteObjects(deleteObjectsRequest);
            List<DeleteObjectsResult.DeletedObject> deleteObjectResultArray = deleteObjectsResult.getDeletedObjects();
        } catch (MultiObjectDeleteException mde) {
            // 如果部分删除成功部分失败, 返回 MultiObjectDeleteException
            List<DeleteObjectsResult.DeletedObject> deleteObjects = mde.getDeletedObjects();
            List<MultiObjectDeleteException.DeleteError> deleteErrors = mde.getErrors();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

// 确认本进程不再使用 cosClient 实例之后，关闭即可
        cosClient.shutdown();
    }
}
