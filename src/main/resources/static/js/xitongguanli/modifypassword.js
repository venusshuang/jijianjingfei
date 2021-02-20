var Modifypassword = new Vue({
	
	el : '#Adminlist',
	data :{
		
		admin:{},
		adminlist:[],

		adminID : $("#AdminID").val(),
		account: '',
        password: '',
        againpassword:'',

		
	},
	created : function() {

		this.bindAdmin();
		
	},
	
	methods : {
	
		bindAdmin :function(){
			
			var _this = this;
			layer.open({type:3});
			$.post('/admin/find_one', {
				adminID : _this.adminID,
				rdm : Math.random()
			},function(ppData) {
				layer.closeAll("loading");
				if(ppData != null){
					
					if(ppData.result == "1"){
						var data = ppData.resultContent
						_this.admin = data;												
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");						
		},
		
		modify : function(){
			
			var _this = this;
			
			if(_this.checkInputData()){		
				$.post('/admin/modify',{

					adminID : _this.adminID,
					account:$.trim(_this.admin.account),
					password:$.trim(_this.admin.againpassword),

					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"修改成功!",
							});
							
							_this.bindAdmin();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json");
			}
		},
		
	

		//检查输入信息
		checkInputData : function(){
			var _this=this;
			
			var account = !_this.admin.account ? "" : $.trim(_this.admin.account);
			if("" == account){
				layer.alert("请填写登录账户！");
	    		return false;
			}
			
			var password = $.trim(_this.admin.password);
			if(!password){
				layer.alert("请填写登录密码！");
	    		return false;
			}
			
			var againpassword = $.trim(_this.admin.againpassword);
			if(!againpassword){
				layer.alert("请填写重复密码！");
	    		return false;
			}
			
			if(password != againpassword){
				layer.alert("两次密码不一致！");
				return false;
			}
			
			return true;
		},
		
	},
	
	watch :{
		//监控分页情况，刷新列表
		pageIndex : function(){
			this.bindAdmin();
		}
	}
	
});
