var vm_zhuanzhen = new Vue({
	el : "#zhuanzhen",
	data : {
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),

		zhuanzhenlist : [],
	},
	created : function(){
		// 根据医生id查询转诊列表
		this.findZhuanzhenList();

	},
	methods : {
		
		// 根据医生id查询转诊列表
		findZhuanzhenList : function(){
			var _this = this;
			layer.open({type:3});

			$.post('/referral/find_by_doctorid',{
				doctorid : _this.userid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");

				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;

						_this.zhuanzhenlist = data;
						
						// 根据医生id查询是否有未读消息
						_this.findIsWeiduXiaoxi();

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 根据医生id查询是否有未读消息
		findIsWeiduXiaoxi : function(){
			var _this = this;
			layer.open({type:3});

			$.post('/news/find_weidu_by_shoujianren',{
				shoujianren : _this.userid,
				newstype : "3",
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");

				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						
						for(var i = 0 ; i < data.length ; i++){
							var mmOwnerid = data[i].ownerid;
							
							$("img[id='"+mmOwnerid+"']").css("display","inline");
						}
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 点击转诊信息div，跳转到专家意见页面
		prepareToZhuanzhenYijian : function(ppReferraId){
			window.location.href = "/homepage/zhuanzhen_yijian.html?referraid="+ppReferraId;
		},

	}


})