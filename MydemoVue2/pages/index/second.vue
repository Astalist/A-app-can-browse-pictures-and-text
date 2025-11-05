<template>
	<view class="container">
		<view class="upload-section" >
		    <text class="label">请选择图片：</text>
		    <button @click="chooseImage()">上传图片</button>
		    
		    <view v-if="imageUrl">
		      <text>已选择图片：</text>
		      <image :src="imageUrl" mode="widthFix" class="uploaded-image"></image>
		    </view>
		  </view>

		<!-- 文字输入部分 -->
		<view class="text-section" style="margin-right: 25px;">
			<text class="label">请输入文字：</text>
			<textarea v-model="textContent" placeholder="请输入发布内容" class="textarea"></textarea>
		</view>

		<!-- 提交按钮 -->
		<view class="submit-section">
			<button @click="submit">发布</button>
		</view>

		
	</view>
</template>

<script>
export default {
	data() {
		return {
			imageStyles: {
				width: 64,
				height: 64,
				border: {
					radius: '50%'
				},
			},
			listStyles: {
				// 是否显示边框
				border: true,
				// 是否显示分隔线
				dividline: true,
				// 线条样式
				borderStyle: {
					width: 1,
					color: 'blue',
					style: 'dashed',
					radius: 2
				}
			},
			// fileLists: [{
			// 	url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/shuijiao-small.jpg',
			// 	extname: 'png',
			// 	name: 'shuijiao.png'
			// }, {
			// 	url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/shuijiao-small.jpg',
			// 	extname: 'png',
			// 	name: 'uniapp-logo.png'
			// }, {
			// 	url: 'https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/shuijiao-small.jpg',
			// 	extname: 'png',
			// 	name: 'shuijiao.png'
			// }],
			imageUrl: "",  // 存储选择的图片 URL
			textContent: "",  // 存储输入的文字内容
			imageFile: null,
			baseurl:"http://localhost:8088",
			userName:"",
			userid:""
		};
	},
	methods: {
		chooseImage() {
			uni.chooseImage({
				count: 1,  // 只允许选择1张图片
				success: (res) => {
					this.imageUrl = res.tempFilePaths[0];  
					this.imageFile = res.tempFiles[0];
					// console.log(res)
					// this.uploadImage();
				},
				fail: (err) => {
					console.log("选择图片失败", err);
				}
			});
		},
    // 提交表单
		submit() {
			this.userName=sessionStorage.getItem('user')|| 'Guest';
			this.userId=sessionStorage.getItem('userid')
			if(this.userName=='Guest'||this.userName==='null'||this.userName==='请点击此处登录'){
				uni.showToast({
				  	title: '请先登录',
					icon: 'none',
				  	duration: 1500
				})  
				return ;
			}
			if (!this.textContent) {
				uni.showToast({ title: "文字内容不能为空", icon: "none" });
				return;
			}

			if (!this.imageUrl) {
				uni.showToast({ title: "图片不能为空", icon: "none" });
				return;
			}
			uni.uploadFile({
				url:this.baseurl+'/card/picupdata',
				filePath:this.imageUrl,
				name:'file',
				success:(resid)=>{
					console.log(resid.data)	
					console.log(this.userName)
					uni.request({
						url:this.baseurl+"/card/textupdata",
						method:'PUT',
						data:{
							cardid: resid.data,
							cardtext:this.textContent,
							userid:this.userId,
						},
						success:(res)=>{
							console.log("完成")
							this.imageUrl=""
							this.textContent=""
							this.imageFile=null
						}
					})
				}
				
			})
		}
	}
};
</script>

<style lang="scss" scoped>
.container {
  padding: 20px;
}

.upload-section, .text-section, .submit-section {
  margin-bottom: 20px;
}

.label {
  font-size: 16px;
  font-weight: bold;
}

.uploaded-image {
  width: 100%;
  max-width: 300px;
  margin-top: 10px;
}

.textarea {
  width: 100%;
  height: 100px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  margin-top: 10px;
}

button {
  padding: 10px 20px;
  background-color: #ffe4cd;
  color: #868686;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:disabled {
  background-color: #aaa;
}


.example-body {
		padding: 10px;
		padding-top: 0;
	}

	.custom-image-box {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}

</style>
