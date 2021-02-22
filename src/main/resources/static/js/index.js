var vm_index = new Vue({
	el : "#index_div",
	data : {

		adminId : $("#adminid").val(),
		deptId : $("#deptid").val(),

		roletype : $("#roletype").val(),
	},
	created : function(){

	},
	methods : {
		// 退出登录
		logout : function(){
			var _this = this;

			layer.open({type:3});
			$.post('/admin/logout',{
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData){
					window.location.href="/manage/login.html";
				}
			},"json");
		},
	},
})