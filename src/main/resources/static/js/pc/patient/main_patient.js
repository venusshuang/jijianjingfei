var Patient_Vue = new Vue({
	el : '#Patient',
	data : {
		roletype : $("#roletype").val(),
		name : $("#name").val(),
		shoujihao : $("#shoujihao").val(),
		patientlist : [],
		patient : {},	
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		jiuzhenxinxiid : '',	//当前的就诊信息id
		
		pageindex : 1,
	    pagesize : 10,
	    pageCount : "",
	    recordCount : "",
	    targetpage : "",
	    inputPageIndexValue : "",
		
	},
	
	created : function() {
		var _this = this;

		_this.bindPatientList();
	},
	
watch : {
		
		//监控分页情况
		pageindex : function(){
			this.bindPatientList();
		},
		pagesize : function(){
			this.pageindex = 1;
			this.bindPatientList();
		},
		
	},
	
	
	methods : {
	
	
		bindPatientList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/patient_jiuzhenxinxi/findPatientByNameAndShoujihao',{
				name:_this.name,
				shoujihao:_this.shoujihao,
				pageindex:_this.pageindex,
				pagesize:_this.pagesize,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						
						var data = ppData.resultContent;
						var list = data.List;
						var pageinfo = data.PageInfo;
						if(list.length>0){
							
							_this.patientlist = list;
							_this.recordCount = pageinfo.recordCount;
							_this.pageCount = pageinfo.pageCount;
							_this.targetpage = '';
						}else
						{
							_this.patientlist = [];
						}
						
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.name='';
			_this.shoujihao='';
			$("#name").val("");
			$("#shoujihao").val("");
		},
		
		allCheckPatient : function(){
			var _this = this;
			
			var mmValue=$("#allCheckPatient:checked").val();
			
			if($("#allCheckPatient").is(":checked"))
			{
			    $("input[name='patientCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='patientCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmPatientIdList="";
			$("[name=patientCheckbox]:checked").each(function(){
				mmPatientIdList+="|"+this.value;
			})
			mmPatientIdList=mmPatientIdList!=""?mmPatientIdList.substring(1):"";
			
			if(mmPatientIdList == ""){
				layer.alert("请选择要删除的患者就诊信息！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/patient_jiuzhenxinxi/deleteJiuzhenxinxiIdList',{
				JiuzhenxinxiIdList :mmPatientIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindPatientList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
		

	
		
		perpareToLookPatient : function(ppJiuzhenxinxiId){
			$('#editPatientModal').modal();
			$("#myModalLabel_patient").html("查看患者就诊信息");

			this.jiuzhenxinxiid = ppJiuzhenxinxiId;

			this.bindPatient();
			
		},
		
		bindPatient : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/patient_jiuzhenxinxi/find_one', {
				jiuzhenxinxiid : _this.jiuzhenxinxiid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.patient = data;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		//首页
		firstPage : function(){
			this.pageindex = 1;
		},
		
		//尾页
		lastPage : function(){
			this.pageindex = this.pageCount;
		},
		
		//上一页
		prePage : function(){
			var prePage = ((this.pageindex -1) <= 0) ? 1 : (this.pageindex -1);
			this.pageindex = prePage;
		},
		
		//下一页
		nextPage : function(){
			var nextPage = ((this.pageindex +1) >= this.pageCount) ? this.pageCount : (this.pageindex +1);
			this.pageindex = nextPage;
		},
		
		//跳到目标页
		targetPage : function() {
			if( this.targetpage != '' && this.targetpage <= this.pageCount && this.targetpage > 0){
				this.pageindex = this.targetpage;
				this.targetpage = '';
			}
		},
		
		
		
		toAddBlack : function(ppJiuzhenxinxiID,ppName,ppShoujihao){
			var _this = this;
			layer.confirm("确定将该患者就诊信息加入黑名单吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/black/saveBlack", {
					blacklistid : "",
					roles : "患者",
					userid : ppJiuzhenxinxiID,
					name : ppName,
					dept : "",
					shoujihao : ppShoujihao,
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
