var Expert_Vue = new Vue({
	el : '#Expert',
	data : {
		
		name : $("#name").val(),
		expertlist : [],// 专家列表
		expert : {},	//某一专家情况
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		expertid : '',	//当前的专家id
		
		
	},
	
	created : function() {
		var _this = this;

		_this.bindExpertList();
	},
	
	
	methods : {
	
		// 绑定专家列表 
		bindExpertList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/expert/findExpertByName',{
				name:_this.name,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
					
						_this.expertlist =ppData.resultContent;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.name='';
			$("#name").val("");
		},
		
		allCheckExpert : function(){
			var _this = this;
			
			var mmValue=$("#allCheckExpert:checked").val();
			
			if($("#allCheckExpert").is(":checked"))
			{
			    $("input[name='expertCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='expertCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmExpertIdList="";
			$("[name=expertCheckbox]:checked").each(function(){
				mmExpertIdList+="|"+this.value;
			})
			mmExpertIdList=mmExpertIdList!=""?mmExpertIdList.substring(1):"";
			
			if(mmExpertIdList == ""){
				layer.alert("请选择要删除的专家！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/expert/deleteExpertIdList',{
				expertIdList :mmExpertIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindExpertList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
		

		perparetoAddExpert : function(){
			$('#editExpertModal').modal();
			$("#myModalLabel_expert").html("新增专家信息");
			this.editFlag = 0;
			this.expert = {};
			this.expertid="";
		
		},
		
		addExpert : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/expert/saveExpert',{
					expertid:_this.expertid,
					name : !_this.expert.name ? "" : $.trim(_this.expert.name),
					danwei : !_this.expert.danwei ? "" : $.trim(_this.expert.danwei),
					keshi : !_this.expert.keshi ? "" : $.trim(_this.expert.keshi),
				    zhiwu : !_this.expert.zhiwu ? "" : $.trim(_this.expert.zhiwu),
				    chushengnianyue : !_this.expert.chushengnianyue ? "" : $.trim(_this.expert.chushengnianyue),
					jianjie : !_this.expert.jianjie ? "" : $.trim(_this.expert.jianjie),
					zhuangtai : !_this.expert.zhuangtai ? "" : $.trim(_this.expert.zhuangtai),
					imageurl : $("#imageurl").val(),
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"新增成功!",
							});
							$("#editExpertModal").modal("hide");
							_this.bindExpertList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		//检查输入信息
		checkInputData : function(){
			var _this = this;
			
			var name = !_this.expert.name ? "" : $.trim(_this.expert.name);
			if("" == name){
				layer.alert("请填写专家姓名！");
	    		return false;
			}
			
			var zhiwu = !_this.expert.zhiwu ? "" : $.trim(_this.expert.zhiwu);
			if("" == zhiwu){
				layer.alert("请填写专家职位！");
	    		return false;
			}
			
			var jianjie = !_this.expert.jianjie ? "" : $.trim(_this.expert.jianjie);
			if("" == jianjie){
				layer.alert("请填写专家简介！");
	    		return false;
			}

			return true;
		},
		
		
		perparetoModifyExpert : function(ppExpertId){
			$('#editExpertModal').modal();
			$("#myModalLabel_expert").html("修改专家信息");
			this.editFlag = 1;

			this.expertid = ppExpertId;

			this.bindExpert();
			
		},
		
		bindExpert : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/expert/find_one', {
				expertid : _this.expertid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.expert = data;
						$("#imageurl").val(_this.expert.imageurl);
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		modifyExpert : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/expert/saveExpert',{
					expertid:_this.expertid,
					name : !_this.expert.name ? "" : $.trim(_this.expert.name),
					danwei : !_this.expert.danwei ? "" : $.trim(_this.expert.danwei),
					keshi : !_this.expert.keshi ? "" : $.trim(_this.expert.keshi),
				    zhiwu : !_this.expert.zhiwu ? "" : $.trim(_this.expert.zhiwu),
				    chushengnianyue : !_this.expert.chushengnianyue ? "" : $.trim(_this.expert.chushengnianyue),
					jianjie : !_this.expert.jianjie ? "" : $.trim(_this.expert.jianjie),
					zhuangtai : !_this.expert.zhuangtai ? "" : $.trim(_this.expert.zhuangtai),
					imageurl : $("#imageurl").val(),
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
							$("#editExpertModal").modal("hide");
							_this.bindExpertList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		toDelete : function(ppExpertId){
			var _this = this;
			layer.confirm("确定删除该专家信息吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/expert/deleteExpert", {
					expertid : ppExpertId,
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
							_this.bindExpertList();
						}
					}
				},"json");
			})
		},
		
		
	}
})
