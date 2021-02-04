var infolistVue = new Vue({
	el:"#infolist",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		categoryid : $("#categoryid").val(),
		categoryname : $("#categoryname").val(),
		
		pageindex:1,
		pagesize:99,
		
		infolist : [],//信息列表
		id : '',//ID
		
		show : true,
	},
	created : function(){
		var _this = this;
		
		_this.bindInfoList();
	},
	methods:{
		
		// 绑定信息列表 
		bindInfoList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$(".top").html(_this.categoryname);
			
			$.post('/info/find_passed_by_categoryid_paging',{
				categoryid : _this.categoryid,
				pageindex : _this.pageindex,
				pagesize : _this.pagesize,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						if(data.size>0){
							_this.show = true;
							_this.infolist = data.list;
						}else{
							_this.show = false;
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toDetail : function(ppInfoId){
			location.href = "/homepage/showinfo.html?infoid="+ppInfoId;
		},
		
	}
})