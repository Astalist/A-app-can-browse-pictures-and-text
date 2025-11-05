<template>
	<view class="">
		<uni-section style="background: linear-gradient(to bottom, #fff4ee, #fee0d4);" title=""  type="">
			<uni-card v-for="(card,index) in cards" :key="card.cardid" :cover="card.cardpicurl">
				<text class="uni-body" @click="onClick(card)">
					{{card.cardtext}}
				</text>
				<view slot="actions" class="card-actions">
					<view class="card-actions-item" @click="showToast('分享')">
						<uni-icons type="paperplane" size="18" color="#999"></uni-icons>
						<text class="card-actions-item-text">分享</text>
					</view>
					<view class="card-actions-item" @click="showToast('评论')">
						<uni-icons type="chatbubble" size="18" color="#999"></uni-icons>
						<text class="card-actions-item-text">评论</text>
					</view>
					<view class="card-actions-item" @click="actionsClick('点赞',card.cardid)">
						<uni-icons v-if="likedflag[card.cardid]" type="hand-up-filled" size="18" color="red"></uni-icons>
						<uni-icons v-else type="hand-up" size="18" color="#999"></uni-icons>
						<text class="card-actions-item-text">{{card.cardgoodcnt}}</text>
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
					likedflag:{},
					cards:[],
					userloveid:[],
					baseurl:"http://localhost:8088",
					userName:"",
					flag:false,

					
				}
			},
			mounted() {
				this.selectAllCards()
			},
			onShow() {
				this.selectAllCards()
			},
			methods: {
				selectAllCards(){
					uni.request({
						url:this.baseurl+"/card/all",
						method:"GET",
						success:(res)=>{
							this.cards=res.data;
							this.userName = sessionStorage.getItem('user') || 'Guest';
							console.log(this.userName)
							if(this.userName!="Guest"&&this.userName!="请点击此处登录"){
								this.selectUserLove();
								console.log(111)
							}
						},
						fail:(err)=>{
							console.log("Wrong!")
						}
					});
				},
				
				selectUserLove(){
					uni.request({
						url:this.baseurl+"/card/good",
						method:"GET",
						success:(res)=>{
							this.userloveid=res.data;
							this.updateLikeStatus();
						}
					})
				},
				
				updateLikeStatus() {
					this.cards.forEach(card => {
						this.$set(this.likedflag, card.cardid, false);
						for (var tem of this.userloveid){
							if(tem["userloveid"]==card.cardid){
								this.$set(this.likedflag, card.cardid, true);
								break;
							}
						}
						
					});
				},
				showToast(message) {
				    uni.showToast({
				      	title: '目前不支持'+message,
						icon: 'none',
				      	duration: 1500
				    })  
				},
				actionsClick(text,id){
					Object.entries(this.likedflag).forEach(([key, value]) => {
						// console.log(`${key}`+"    "+id)这两个都是字符串注意
						if(`${key}`==id){
							// console.log("!!!"+`${value}`+"!!!")
							if(`${value}`=='true'){
								uni.request({
									url:this.baseurl+"/card/delgood",
									method:'DELETE',
									data:{
										userloveid:id,
									},
									success:(res)=>{
										this.selectAllCards();
									}
								})
							}else{
								uni.request({
									url:this.baseurl+"/card/addgood",
									method:'POST',
									data:{
										userloveid:id,
									},
									success:(res)=>{
										this.selectAllCards();
									}
								})
							}
						}
					});
					
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