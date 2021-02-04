var Black_Vue = new Vue({
	el : '#Black',
	data : {
		
		name : $("#name").val(),
		dept : $("#dept").val(),
		shoujihao : $("#shoujihao").val(),
		blacklist : [],// 黑名单列表
		black : {},	
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		blacklistid : '',
		
		
	},
	
	created : function() {
		var _this = this;

		_this.bindBlackList();
	},
	
	
	methods : {
	
	
		bindBlackList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/black/findBlackByNameAndDeptAndShoujihao',{
				name:_this.name,
				dept:_this.dept,
				shoujihao:_this.shoujihao,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
					
						_this.blacklist =ppData.resultContent;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.name='';
			_this.dept='';
			_this.shoujihao='';
			$("#name").val("");
			$("#dept").val("");
			$("#shoujihao").val("");
		},
		
		allCheckBlack : function(){
			var _this = this;
			
			var mmValue=$("#allCheckBlack:checked").val();
			
			if($("#allCheckBlack").is(":checked"))
			{
			    $("input[name='blackCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='blackCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmBlackIdList="";
			$("[name=blackCheckbox]:checked").each(function(){
				mmBlackIdList+="|"+this.value;
			})
			mmBlackIdList=mmBlackIdList!=""?mmBlackIdList.substring(1):"";
			
			if(mmBlackIdList == ""){
				layer.alert("请选择要删除的黑名单！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/black/deleteBlackIdList',{
				blackIdList :mmBlackIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindBlackList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
		

		
		
		
		
		
		
		perparetoLookBlack : function(ppBlacklistId){
			$('#editBlackModal').modal();
			$("#myModalLabel_black").html("查看黑名单信息");
			

			this.blacklistid = ppBlacklistId;

			this.bindBlack();
			
		},
		
		bindBlack : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/black/find_one', {
				blacklistid : _this.blacklistid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.black = data;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		
		
		toDelete : function(ppBlackId){
			var _this = this;
			layer.confirm("确定删除该黑名单信息吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/black/deleteBlack", {
					blacklistid : ppBlackId,
					random : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");
						if(ppData.result != "1"){
							layer.alert(ppData.message);
						}else{
							layer.open({
								time:1000,
								btn:[],
								content:"删除成功!",
							});
							_this.bindBlackList();
						}
					}
				},"json");
			})
		},
		
		
		
		
		
		
	}
})
