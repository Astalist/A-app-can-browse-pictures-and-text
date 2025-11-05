<template>
	<view class="container" style="background: linear-gradient(to bottom, #fff4ee, #fee0d4);">
		<div class="profile" @click="openLoginPopup()">
			<img id="avatar" src="../../static/neko.png" alt="头像" style="margin-top: 20px;">
			<h3>{{ userName }}</h3>
		</div>
		<uni-section title="" type="none">
			<uni-collapse >
				<uni-collapse-item title="管理" style="text-align: left; padding-left: 0;font-size: ;" >
					
					<view class="content">
						<div class="guanli" @click="change()">我的内容</div>
						<div class="guanli" @click="logout()">退出账号</div>
					</view>
				</uni-collapse-item>
				<!-- <div @click="selectAllMyCard()">
					<uni-collapse-item title="管理" style="text-align: left; padding-left: 0;" >
						<uni-section title=""  type="">
							<uni-card v-for="(card,index) in cards" :key="card.userid" :cover="card.cardpicurl">
								<text class="uni-body" @click="onClick(card)">
									{{card.cardtext}}
								</text>
								<view slot="actions" class="card-actions">
									<view class="card-actions-item" @click="actionsClick('删除',card.cardid)">
										<uni-icons type="trash" size="18" color="#999"></uni-icons>
										<text class="card-actions-item-text">删除</text>
									</view>
									<view class="card-actions-item" @click="actionsClick('修改',card.cardid)">
										<uni-icons type="refresh" size="18" color="#999"></uni-icons>
										<text class="card-actions-item-text">修改</text>
									</view>
								</view>
							</uni-card>
						</uni-section>
					</uni-collapse-item>
				</div> -->
				
				
			</uni-collapse>
		</uni-section>

		<!-- 登录弹窗 -->
		<div class="popup" v-if="showLoginPopup">
			<div class="popup-content">
				<h2>登录</h2>
				<label for="userId">用户名:</label>
				<input type="text" id="userId" v-model="userId" placeholder="请输入用户名" required >
				<label for="userPassword">密码:</label>
				<input type="password" id="userPassword" v-model="userPassword" placeholder="请输入密码" required>
				<button @click="login">登录</button>
				<button @click="closeLoginPopup">取消</button>
			</div>
		</div>
	</view>
</template>

<script>
	export default{
		data(){
			return {
				userId:"",
				userName:'请点击此处登录',
				userPassword:"",
				userPic:"../../static/neko.png",
				// isLogged:false,
				showLoginPopup: false,
				baseurl:"http://localhost:8088",
				showCol:false,
				cards:[],
			}
		},
		onLoad(){
			
		},
		mounted(){
			this.userName = sessionStorage.getItem('user') || '请点击此处登录';
			this.showCol = sessionStorage.getItem('state') || false;
			sessionStorage.setItem('userid',null);
		},
		methods:{
			openLoginPopup() {
				if (this.userName === '请点击此处登录') {
					this.showLoginPopup = true;
				}
			},
			closeLoginPopup() {
				this.showLoginPopup = false;
			},
			login(){
				uni.request({
					url:this.baseurl+"/userinfo/login",
					method:"POST",
					data:{
						userid:this.userId,
						userpassword:this.userPassword
					},
					success:(res)=>{
						console.log(res.data.username)
						console.log(res.data.userid)
						this.showLoginPopup=false,
						sessionStorage.setItem('user', res.data.username),
						sessionStorage.setItem('userid',res.data.userid),
						sessionStorage.setItem('state',true),
						this.userName=sessionStorage.getItem('user')
						this.userId=sessionStorage.getItem('userid')
						// uni.setStorageSync('userid', res.data.userid);
						this.showCol=true,
						console.log(res)
					},
					fail() {
						console.log("something wrong!")
					}
				})
			},
			change(){
				console.log(sessionStorage.getItem('userid'))
				if(sessionStorage.getItem('userid')=='null'){
					uni.showToast({
					  	title: '请先登录',
						icon: 'none',
					  	duration: 1500
					})  
					return;
				}
				uni.navigateTo({
					url:'/pages/index/fourth'
				})
			},
			logout(){
				if(sessionStorage.getItem('userid')=='null'){
					uni.showToast({
					  	title: '请先登录',
						icon: 'none',
					  	duration: 1500
					})  
					return;
				}
				sessionStorage.setItem('user', '请点击此处登录');
				sessionStorage.setItem('userid',null);
				sessionStorage.setItem('state',false);
				this.userName === '请点击此处登录';
				this.showCol =false
				window.location.reload();
			},
			selectAllMyCard(){
				// console.log("adds" + this.userId)
				this.userId=sessionStorage.getItem('userid');
				uni.request({
					url:this.baseurl+"/card/mycard",
					method:'POST',
					data: {
						userId: this.userId  // 传递 String 类型的 userId
					},
					success:(res)=>{
						this.cards=res.data;
						console.log(res)
					},
					fail() {
						console.log("cuowu")
					}
				})
			},
			actionsClick(text,id){
				if(text=='删除'){
					uni.request({
						url:this.baseurl+'/card/delmycard',
						method:'DELETE',
						data:{
							cardid:id,
							userid:sessionStorage.getItem('userid')
						},
						header: {
							'Content-Type': 'application/json'  // 设置请求内容为 JSON 格式
						},
						success:(res)=>{
							console.log("删除成功");
						}
					})
				}else if(text=='修改'){
					uni.showToast({
					  	title: '目前不支持修改',
						icon: 'none',
					  	duration: 1500
					})  
				}
			}
			
		}
	}
</script>

<style>
	body {
	    font-family: Arial, sans-serif;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    height: 100vh;
	    margin: 0;
	    background-color: #f4f4f4;
	}
	
	.content {
			padding: 15px;
		}
	
	.container {
	    text-align: center;
	}
	
	/* 头像部分 */
	.profile {
	    cursor: pointer;
		margin-bottom: 30px;
		display: flex;
		flex-direction: column;
		align-items: center;
		transition: transform 0.3s ease-in-out;
	}
	
	#avatar {
	    width: 100px;
	    height: 100px;
	    border-radius: 50%;
	}
	
	h3 {
	    margin-top: 10px;
	    color: #333;
	}
	.guanli{
		margin-bottom:10px ;
		padding-bottom: 10px;
		border-bottom:1px solid #e3e3e3;
	}
	
	.card-actions {
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		align-items: center;
		height: 45px;
		border-top: 1px #eee solid;
	}
	.card-actions-item {
		display: flex;
		flex-direction: row;
		align-items: center;
	}
	.card-actions-item-text {
		font-size: 12px;
		color: #666;
		margin-left: 5px;
	}
	
	
	.manage {
		margin-top: 20px;
	}
	
	.manage h3 {
		cursor: pointer;
		background-color: #4CAF50;
		color: white;
		padding: 10px;
		border-radius: 5px;
	}
	
	.dropdown-content {
		display: none;
		background-color: #f9f9f9;
		position: absolute;
		border-radius: 5px;
		width: 150px;
		box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
	}
	
	.dropdown-content ul {
		padding: 10px 0;
		margin: 0;
		list-style: none;
		text-align: left;
	}
	
	.dropdown-content li {
		padding: 8px 16px;
		cursor: pointer;
	}
	
	.dropdown-content li:hover {
		background-color: #ddd;
	}
	
	/* 展开下拉菜单 */
	.dropdown-content[v-show="true"] {
		display: block;
	}
	
	
	
	
	/* 登录弹窗样式 */
	.popup {
	    display: flex;
	    position: fixed;
	    top: 0;
	    left: 0;
	    right: 0;
	    bottom: 0;
	    background-color: rgba(0, 0, 0, 0.5);
	    justify-content: center;
	    align-items: center;
	}
	
	.popup-content {
	    background-color: white;
	    padding: 30px;
	    border-radius: 5px;
	    width: 300px;
	    text-align: center;
	}
	
	.popup-content input {
	    width: 100%;
	    padding: 10px;
	    margin: 10px 0;
	    border-radius: 5px;
	    border: 1px solid #ddd;
	}
	
	.popup-content button {
	    width: 100%;
	    padding: 10px;
	    background-color: #ffe4cd;
	    color: #868686;
	    border: none;
	    border-radius: 5px;
	    cursor: pointer;
	    margin-top: 10px;
	}
	
	.popup-content button:hover {
	    background-color: #ffe4cd;
	}
</style>