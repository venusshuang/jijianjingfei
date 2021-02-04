var Doctor_Vue = new Vue({
	el : '#Doctor',
	data : {
		
		xingming : $("#xingming").val(),
		danwei : $("#danwei").val(),
		doctorlist : [],
		doctor : {},	
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		doctorid : '',	
		
		
	},
	
	created : function() {
		var _this = this;

		_this.bindDoctorList();
	},
	
	
	methods : {
	
	
		bindDoctorList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/doctor/findPatientByNameAndDept',{
				name:_this.xingming,
				dept:_this.danwei,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
					
						_this.doctorlist =ppData.resultContent;
						
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.xingming='';
			_this.danwei='';
			$("#xingming").val("");
			$("#danwei").val("");
		},
		
		allCheckDoctor : function(){
			var _this = this;

			if($("#allCheckDoctor").is(":checked"))
			{
			    $("input[name='doctorCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='doctorCheckbox']").prop('checked',false);
			}
	
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmDoctorIdList="";
			$("[name=doctorCheckbox]:checked").each(function(){
				mmDoctorIdList+="|"+this.value;
			})
			mmDoctorIdList=mmDoctorIdList!=""?mmDoctorIdList.substring(1):"";
			
			if(mmDoctorIdList == ""){
				layer.alert("请选择要删除的医生信息！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/doctor/deleteDoctorIdList',{
				DoctorIdList :mmDoctorIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindDoctorList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},

		perpareToLookDoctor : function(ppDoctorId){
			$('#editDoctorModal').modal();
			$("#myModalLabel_doctor").html("查看医生信息");

			this.doctorid = ppDoctorId;

			this.bindDoctor();
			
		},
		
		bindDoctor : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/doctor/find_one', {
				doctorid : _this.doctorid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.doctor = data;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		
		toAddBlack : function(ppDoctorID,ppName){
			var _this = this;
			layer.confirm("确定将该医生加入黑名单吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/black/saveBlack", {
					blacklistid : "",
					roles : "医生",
					userid : ppDoctorID,
					name : ppName,
					dept : "",
					shoujihao : "",
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
								content:"添加成功!",
							});
							
						}
					}
				},"json");
			})
		},

	}
})
