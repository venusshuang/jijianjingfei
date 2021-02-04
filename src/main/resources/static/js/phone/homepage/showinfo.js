var _showinfoVue = new Vue({
	el:"#showinfo",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		infoid : $("#infoid").val(),
		infotitle : $("#infotitle").val(),
		
		info : {},
		
	},
	created : function(){
		var _this = this;
		
		_this.bindInfo();
	},
	methods:{
		
		// 绑定信息
		bindInfo : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/info/find_custom_one',{
				infoid : _this.infoid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.info = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
	}
})