var Administrator_Vue = new Vue({
	el : '#Administrator',
	data : {
		
		zhanghao : $("#zhanghao").val(),
		administratorlist : [],
		administrator : {},	
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		administratorid : '',	
		roleid : '',	
		rolelist : [],
		
		
	},
	
	created : function() {
		var _this = this;

		_this.bindAdministratorList();
	},
	
	
	methods : {
		
	
	
		bindAdministratorList : function(){
			
			var _this = this;
			layer.open({type:3});
			$.post('/administrator/findAdministratorByZhanghao',{
				zhanghao:_this.zhanghao,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						_this.administratorlist =ppData.resultContent;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.zhanghao='';
			$("#zhanghao").val("");
		},
		
		perparetoAddAdministrator : function(){
			$('#editAdministratorModal').modal();
			$("#myModalLabel_Administrator").html("新增管理员信息");
			this.editFlag = 0;
			this.administrator = {};
			this.administratorid="";
			this.bindRoleList();
		
		},
		
		bindRoleList : function(){
			var _this = this;
			layer.open({type:3});
			$.post('/Role/findRoleByRoleName', {
				rolename:"",
				rdm:Math.random()
			},function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.rolelist = ppData.resultContent;
					}
				}
			},"json");
		},
		
		perpareToModifyAdministrator : function(ppAdministratorId){

			$('#editAdministratorModal').modal();
			$("#myModalLabel_administrator").html("修改管理员信息");
			this.editFlag = 1;

			this.administratorid = ppAdministratorId;
			this.bindRoleList();
			this.bindAdministrator();
			
		},
		
		bindAdministrator : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/administrator/find_one', {
				administratorid : _this.administratorid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.administrator = data;
						_this.roleid = data.roleid;
						
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		addAdministrator : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/administrator/saveAdministrator',{
					administratorid:_this.administratorid,
					zhanghao:_this.administrator.zhanghao,
					password : !_this.administrator.password ? "" : $.trim(_this.administrator.password),
					roleid : _this.roleid,
					rolename : !_this.administrator.rolename ? "" : $.trim(_this.administrator.rolename),
					beizhu : !_this.administrator.beizhu ? "" : $.trim(_this.administrator.beizhu),
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
							$("#editAdministratorModal").modal("hide");
							_this.bindAdministratorList();
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
			
			
			
			_this.administrator.rolename = $("#roleid").find("option:selected").text();
			
			
			var zhanghao = !_this.administrator.zhanghao ? "" : $.trim(_this.administrator.zhanghao);
			if("" == zhanghao){
				layer.alert("请填写账户名！");
	    		return false;
			}
			
			var roleid = !_this.roleid ? "" : $.trim(_this.roleid);
			
			if("" == roleid){
				layer.alert("请选择角色！");
	    		return false;
			}
			

			var password = !_this.administrator.password ? "" : $.trim(_this.administrator.password);
			if("" == password){
				layer.alert("请填写密码！");
	    		return false;
			}
			
			var beizhu = !_this.administrator.beizhu ? "" : $.trim(_this.administrator.beizhu);
			if("" == beizhu){
				layer.alert("请填写备注！");
	    		return false;
			}

			return true;
		},
		
		allCheckAdministrator : function(){
			var _this = this;

			if($("#allCheckAdministrator").is(":checked"))
			{
			    $("input[name='administratorCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='administratorCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmAdministratorIdList="";
			$("[name=administratorCheckbox]:checked").each(function(){
				mmAdministratorIdList+="|"+this.value;
			})
			mmAdministratorIdList=mmAdministratorIdList!=""?mmAdministratorIdList.substring(1):"";
			
			if(mmAdministratorIdList == ""){
				layer.alert("请选择要删除的管理员！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/administrator/deleteAdministratorIdList',{
				administratorIdList :mmAdministratorIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindAdministratorList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
			
		
		
		
		modifyAdministrator : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/administrator/saveAdministrator',{
					administratorid:_this.administratorid,
					zhanghao:_this.administrator.zhanghao,
					password : !_this.administrator.password ? "" : $.trim(_this.administrator.password),
					roleid : _this.roleid,
					rolename : !_this.administrator.rolename ? "" : $.trim(_this.administrator.rolename),
					beizhu : !_this.administrator.beizhu ? "" : $.trim(_this.administrator.beizhu),
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
							$("#editAdministratorModal").modal("hide");
							_this.bindAdministratorList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		toDelete : function(ppAdministratorId){
			var _this = this;
			layer.confirm("确定删除该管理员信息吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/administrator/deleteAdministrator", {
					administratorid : ppAdministratorId,
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
							_this.bindAdministratorList();
						}
					}
				},"json");
			})
		},
		
		
		
		
		
		
	}
})
