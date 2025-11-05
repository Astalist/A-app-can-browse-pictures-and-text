<template>
	
	<view class="">
		<!-- <uni-section title="" type="">
			<uni-search-bar v-model="searchValue" ></uni-search-bar>
		</uni-section> -->
		<uni-section  title=""  type="">
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
		
	</view>
	
</template>

<script>
	export default {
			components: {},
			data() {
				return {
					searchValue: '',
					cards:[],
					baseurl:"http://localhost:8088",
					flag:false,

					
				}
			},
			mounted() {
				this.selectAllMyCard()
			},
			methods: {
				selectAllMyCard(){
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
								uni.showToast({
								  	title: '删除成功',
									icon: 'success',
								  	duration: 1500
								})
								// console.log("删除成功");
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

<style lang="scss">

	.container {
		overflow: hidden;
	}

	.custom-cover {
		flex: 1;
		flex-direction: row;
		position: relative;
	}

	.cover-content {
		position: absolute;
		bottom: 0;
		left: 0;
		right: 0;
		height: 40px;
		background-color: rgba($color: #000000, $alpha: 0.4);
		display: flex;
		flex-direction: row;
		align-items: center;
		padding-left: 15px;
		font-size: 14px;
		color: #fff;
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
	.cover-image {
		flex: 1;
		height: 150px;
	}
	.no-border {
		border-width: 0;
	}
</style>