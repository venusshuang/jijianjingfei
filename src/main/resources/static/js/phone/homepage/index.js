var vm_index = new Vue({
	el : "#indexpage",
	data : {
		usertype : $("#usertype").val(),	// 当前登录的用户类型
		userid : $("#userid").val(),	// 当前登录的用户id
	},
	created : function(){
		
		if(this.usertype == "doctor"){
			// 医生：转诊、智慧诊疗
			$("#a_zhuanzhen").css("pointer-events","auto");
			$("#a_zhihuizhenliao").css("pointer-events","auto");
		}else if(this.usertype == "patient"){
			// 患者：挂号、住院、智慧诊疗
			$("#a_guahao").css("pointer-events","auto");
			$("#a_zhuyuan").css("pointer-events","auto");
			$("#a_zhihuizhenliao").css("pointer-events","auto");
		}
	},
	methods : {
		
	},
	
})