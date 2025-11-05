# cc-SearchBarHisView 


##uniapp专属精品组件页面模板（由前端组件开发出品）精品组件页面模板

###●组件模板规划：
由前端组件开发出品的精品组件页面模板，将陆续发布，预计高达约几百种供您使用，是快速快发项目、创业的必备精品。

合集地址： uni-app模板合集地址：(https://ext.dcloud.net.cn/publisher?id=274945) 如查看全部页面模板，请前往上述uniapp插件市场合集地址；

###●组件模板效果图：
可下载项目后预览，效果图见右侧图片；

###●组件模板费用：
学习：免费下载，进行学习，无费用；

使用/商用：本页面地址赞赏10元后，可终身商用；

###●组件模板使用版权/商用：
本组件模板免费下载可供学习，如需使用及商用，请在本组件页面模板进行赞赏10元

（仅需10元获取精品页面模板代码-物有所值，1个组件页面市场价100元 ）

赞赏10后（当前项目产生赞赏订单可追溯）即可终身商用当前本地址下载的页面模版代码，不同下载地址需进行不同的赞赏。（不赞赏就进行商用使用者，面临侵权！保留追究知识产权法律责任！后果自负！）


### 我的技术公众号(私信可加前端技术交流群)

群内气氛挺不错的，应该或许可能大概，算是为数不多的，专搞技术的前端群，偶尔聊天摸鱼

![图片](https://i.postimg.cc/RZ0sjnYP/front-End-Component.jpg)




#### 使用方法 
```使用方法
	

<view style="margin-top: 16px;">
	
<!-- keyStr: 设置storage存储key  hisClick: 设置历史事件 searchClick:设置搜索事件 -->
<cc-SearchBarHisView keyStr="productHisArr" searchPlaceHolder="请输入产品名称、关键字" @hisClick="selHisClick"
			@searchClick="goSearchClick"></cc-SearchBarHisView>
	
	
</view>	

			
					


```

#### HTML代码实现部分
```html

<template>
	<view class="content">
		<view style="margin-top: 16px;">

			<!-- keyStr: 设置storage存储key  hisClick: 设置历史事件 searchClick:设置搜索事件 -->
			<cc-SearchBarHisView keyStr="productHisArr" searchPlaceHolder="请输入产品名称、关键字" @hisClick="selHisClick"
				@searchClick="goSearchClick"></cc-SearchBarHisView>


		</view>
	</view>
</template>

<script>

	export default {
		components: {
			
		},
		data() {
			return {
				
			}
		},
		onLoad() {

		},
		methods: {


			selHisClick(item) {

				console.log('选择的值 = ' + item);
				uni.navigateTo({
					url: '/pages/index/search?name=' + item
				})
			},
			goSearchClick(item) {



				uni.navigateTo({
					url: '/pages/index/search?name=' + item
				})



			},
		}
	}
</script>

<style scoped>
	page {
	
		background-color: '#F6F7FA' !important;
	}
	

	
	.content {
		display: flex;
		flex-direction: column;
		background-color: #F6F7FA;
		height: 100vh;
	
	
	}

</style>


```
