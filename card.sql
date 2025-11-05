/*
 Navicat Premium Data Transfer

 Source Server         : try
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : mawaru

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 30/12/2024 09:37:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card`  (
  `cardid` int NOT NULL AUTO_INCREMENT,
  `cardpicurl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cardtext` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `cardgoodcnt` int NULL DEFAULT NULL,
  `userid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cardid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2032476162 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES (-2052775934, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/623e19b3-431f-4ba2-8760-1927d1b1dde1.jpg', '给耀神做的生日蛋糕，但是当时放吉利丁比例搞错了，但是大家还是吃了，很开心', 265, '217');
INSERT INTO `card` VALUES (-1998249983, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/b65039b5-a31b-4ebe-b249-ce70c84e6564.jpg', '像蘑菇的树', 14, '217');
INSERT INTO `card` VALUES (-1897586686, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/09192d11-8423-42a8-a757-5106d90241d9.jpg', '青岛第几海水浴场记不清楚了，但是哥几个非常明智的穿拖鞋去的啊，直接下水，冰死了', 256, '217');
INSERT INTO `card` VALUES (-1817894910, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/17690ab1-0a25-4590-9c4c-40aad6efaa60.jpg', '将将胡开三张啊', 656, '217');
INSERT INTO `card` VALUES (-1683677183, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/56ebd9a7-07f5-4ea1-96a1-fbe695b014c4.jpg', '漂亮的不像真的的真三花', 6, '217');
INSERT INTO `card` VALUES (-1587208191, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/901f7c2e-346f-4b42-aaa5-178763022de4.jpg', '这张照片我也很喜欢啊啊啊', 9, '217');
INSERT INTO `card` VALUES (-1532682239, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/c51832c3-6fc6-4afc-91d1-a6afbfbb3a67.png', '这时候我不得不说出那句伤人心的话', 767, '217');
INSERT INTO `card` VALUES (-1385881599, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/fa166672-d4bf-4147-b02e-cc7fffe95f6e.jpg', '谁家的好人玩德国心脏病把铃拍坏了', 64, '217');
INSERT INTO `card` VALUES (-1377492990, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/373a0fde-e76f-4571-a110-01b63a113f5c.jpg', '青岛海洋公园里面的炸毛企鹅', 364, '217');
INSERT INTO `card` VALUES (-1360715774, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/c9c9bbc1-7219-46ad-8b43-2ebfde78e3ac.jpg', '1617的帅猫', 789, '217');
INSERT INTO `card` VALUES (-1025171454, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/1a250110-4f1f-4e5d-af37-07d596e8e1f0.jpg', '杭州蟹黄面，感谢苏神请客', 32, '217');
INSERT INTO `card` VALUES (-945479678, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/07c234a1-cd00-4564-8ea7-6c7421d1be73.jpg', '常德下雪的诗墙', 14, '217');
INSERT INTO `card` VALUES (-853204991, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/6070b652-9e82-41f3-bef5-c6c82d7c4421.png', '没打进全国大赛，爸爸说了很伤千夏心的话', 58, '217');
INSERT INTO `card` VALUES (-832233471, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/0aee7d94-01da-47b8-a914-5bc92fdf951d.png', 'gl的至理名言，花花世界迷人眼，真的太对了', 520, '217');
INSERT INTO `card` VALUES (-802873342, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/9d81b026-6817-4586-b5b3-499fdc2d927c.jpg', '杭州KTV，抢镜的185男大和后面想长高的蘑菇', 121, '217');
INSERT INTO `card` VALUES (-781901822, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/49ef8436-5fad-46f5-982d-21a895ac5bf4.jpg', '不知道谁发给我的gl照片', 85, '217');
INSERT INTO `card` VALUES (-723181566, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/47eef4a7-9164-4ca0-a80e-717d66d10970.png', '很臭的表情包', 456, '217');
INSERT INTO `card` VALUES (-702210047, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/c3387205-634a-4b43-9781-2bd110bec94c.jpg', '很好的照片，独特的美感', 56, '217');
INSERT INTO `card` VALUES (-505077759, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/51feee21-2364-479f-8125-7bbd4741c6ab.jpg', '看甄嬛传时觉得很对的一句话', 26, '217');
INSERT INTO `card` VALUES (-500883454, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/5180a0ec-3b52-4e23-8f59-d231ac39160e.jpg', '中间这个我抓的，一发就抓到了，没人敢质疑', 353, '217');
INSERT INTO `card` VALUES (-475717630, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/506222d3-47fd-4add-9926-f37d061193c8.jpg', '孤峰塔，被照骗过去的', 76, '217');
INSERT INTO `card` VALUES (-425385982, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/3267e2ac-0595-4d58-b79d-a9a074058636.jpg', '哥们喝醉了就是哪里都是床，手里的手机还在给前女友发消息，笑死了', 49, '217');
INSERT INTO `card` VALUES (-421191679, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/fd714fa0-501a-4fea-b876-02575e5bdf7d.jpg', '杭州小饮与食的餐点，看着还是会想吃，家人', 76, '217');
INSERT INTO `card` VALUES (-362471423, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/2727a432-adc3-4e73-9060-5669e1af390e.jpg', '趁人家洗澡烟熏内裤', 25, '217');
INSERT INTO `card` VALUES (-299556862, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/af47cc92-81e5-43be-9138-bbc78d283e81.jpg', '谁叫我，我再睡会', 53, '217');
INSERT INTO `card` VALUES (-102424574, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/6cd4091c-d1e9-4dec-a132-8519b314fe63.jpg', '青岛什么海洋公园海边的巨大石头', 86, '217');
INSERT INTO `card` VALUES (-1761278, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/78fd606c-2712-4539-9391-ce79a2528214.jpg', '很喜欢的照片，现在还是壁纸', 75, '217');
INSERT INTO `card` VALUES (90513409, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/43ac850a-0666-494c-b9ce-65453ecd1f7b.jpg', '闪现广州的晚上自助甜品', 45, '217');
INSERT INTO `card` VALUES (241508353, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/fa5928c4-4246-4e30-8493-ed52104f5bc4.jpg', '找老鼠在哪', 98, '217');
INSERT INTO `card` VALUES (346365953, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/67ec4262-597c-4e32-bdd6-7dd547805d0e.jpg', '这个是很成功的芒果···什么慕斯，也不记得了哈哈哈', 145, '217');
INSERT INTO `card` VALUES (400891905, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/fd5ed9ac-446c-489b-8b03-724d7caef0f0.png', '天花姐帅死了', 684, '217');
INSERT INTO `card` VALUES (400891906, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/2d3c74c8-ce01-4cd1-9067-62515a18a9cb.jpg', '自己烤的杏仁薄脆，回馈是可以开私房了，谢谢夸奖', 1233, '217');
INSERT INTO `card` VALUES (543498241, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/1d93617d-ae93-405e-a3d8-13c570694d5d.jpg', '杭州小饮与食，墙上的至理名言', 876, '217');
INSERT INTO `card` VALUES (564469762, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/3590d3ee-ceab-4d7d-957d-ec612659680c.jpg', '杭州，帅狗啊', 69, '217');
INSERT INTO `card` VALUES (572858370, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/da224784-1a76-4a1b-ab5e-57e898046d40.jpg', '都在等他交卷，不知道在磨蹭些什么', 45, '217');
INSERT INTO `card` VALUES (577052673, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/9eceb58d-c760-4695-860c-10c7490e9a19.jpg', '青岛崂山的小猫，它有粉色的鼻子欸', 56, '217');
INSERT INTO `card` VALUES (690298882, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/91f47c9c-71dc-413f-95bf-abaa7c0db85c.jpg', '常德老家睡的很舒服的小猫', 65, '217');
INSERT INTO `card` VALUES (799350786, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/caf70670-e2de-4ce0-b70a-364ca0efdffd.jpg', '忘记这个叫什么了，反正过程巨难搞，味道一般般', 85, '217');
INSERT INTO `card` VALUES (824516609, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/a695e8a9-ab26-42d9-9ee5-0242de818ff5.jpg', '高中补习时想睡觉的蘑菇', 78, '217');
INSERT INTO `card` VALUES (845488130, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/30ba761c-0227-4619-8528-0f115f5c0b90.jpg', '假猫', 96, '217');
INSERT INTO `card` VALUES (1239752706, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/9a9918fe-5d05-42f0-9d78-17dc0cbdc572.jpg', '有时候很想使用的表情包', 36, '217');
INSERT INTO `card` VALUES (1503993858, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/92b0c73b-90e1-483e-b0bd-f4320e077b27.jpg', '青岛崂山上的端庄小猫，我觉得这几个树枝有点像一个画框', 14, '217');
INSERT INTO `card` VALUES (1814372353, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/5c01eea5-c968-46b9-8fa0-f6d1508187ca.jpg', '青岛崂山最高峰的185男大', 56, '217');
INSERT INTO `card` VALUES (1852121090, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/51323ed7-a274-438a-a7c7-7541b455cb33.jpg', '青岛街边，危险废物和蘑菇和耀神', 65, '217');
INSERT INTO `card` VALUES (1910841345, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/e9eb34d3-8b2f-45c5-8b23-7305fc976245.jpg', '无锡的帅猫，就是没有看镜头', 87, '217');
INSERT INTO `card` VALUES (2032476161, 'https://sku-1327428557.cos.ap-guangzhou.myqcloud.com/86e5b356-9ee7-46d5-a9f0-51f5e170ddf5.png', '博人和川木立场转换，佐娜良受到巨大情感冲击，二勾玉直接变万花筒', 69, '217');

SET FOREIGN_KEY_CHECKS = 1;
