var wodeyuyueVue = new Vue({
	el:"#wodeyuyue",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		
		wodeyuyuelist : [],//就诊信息列表
		id : '',//挂号或住院ID
		
		show : true,
	},
	created : function(){
		var _this = this;
		
		$("#listPart").show();
		_this.bindYuyueList();
	},
	methods:{
		
		// 绑定就诊信息列表 
		bindYuyueList : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/guahao/find_yuyue_by_userid',{
				userid : _this.userid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						if(data.length>0){
							_this.show = true;
							_this.wodeyuyuelist = data;
						}else{
							_this.show = false;
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toCancelGuahao : function(ppId){
			var _this = this;
			
			layer.open({type:3});
			
			$.post('../guahao/cancel', {
				guahaoid : ppId,
				shenhejieguo : '3',//3用户取消
				rdm:Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if (ppData != null) {
						if(ppData != null){
							var mmData = ppData;
							var result = mmData.result;
							var message = mmData.message;
							var data = mmData.resultContent;
							if(result == "1"){
								$("#js_toast").show()
								setTimeout(function(){
									location.reload();
								},'2000');
							}else{
								_this.showMessage(message);
							}
						}
					}
				}
			},"json");
		},
		
		toCancelZhuyuan : function(ppId){
			var _this = this;
			
			layer.open({type:3});
			
			$.post('../zhuyuan/cancel', {
				zhuyuanid : ppId,
				shenhejieguo : '3',//3用户取消
				rdm:Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if (ppData != null) {
						if(ppData != null){
							var mmData = ppData;
							var result = mmData.result;
							var message = mmData.message;
							var data = mmData.resultContent;
							if(result == "1"){
								$("#js_toast").show()
								setTimeout(function(){
									location.reload();
								},'2000');
							}else{
								_this.showMessage(message);
							}
						}
					}
				}
			},"json");
		},
	}
})