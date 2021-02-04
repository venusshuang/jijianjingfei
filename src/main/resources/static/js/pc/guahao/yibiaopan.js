var Yibiaopan_Vue = new Vue({
	el : '#Yibiaopan',
	data : {
		
		administratorid:$("#administratorid").val(),
		
		paibanriqi : $("#paibanriqi").val(),
		
		yibiaopanlist : [],
		
		editFlag : 0,// 0:单个，1：批量
		show : true,// 显示列表是否有数据
	
		expertid : '',	
		expertlist : [],// 下拉框的专家集合
	
		
		pageindex : 1,
	    pagesize : 10,
	    pageCount : "",
	    recordCount : "",
	    targetpage : "",
	    inputPageIndexValue : "",
	},
	
	created : function() {
		var _this = this;
		
		_this.bindExpertList();
		_this.bindYibiaopanList();
		
		setInterval(function(){
			_this.bindYibiaopanList();
		},'10000');
	},
	
watch : {
		
		//监控分页情况
		pageindex : function(){
			this.bindYibiaopanList();
		},
		pagesize : function(){
			this.pageindex = 1;
			this.bindYibiaopanList();
		},
		
	},
	
	
	methods : {
	
		getDate : function() {
			 var _this=this;
			 
			 _this.paibanriqi = $("#paibanriqi").val(); 
		},
		
		
		bindYibiaopanList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/paiban/findByExpertidAndPaibanriqi',{
				expertid:_this.expertid,
				paibanriqi:_this.paibanriqi,
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
							
							_this.yibiaopanlist = list;
							_this.recordCount = pageinfo.recordCount;
							_this.pageCount = pageinfo.pageCount;
							_this.targetpage = '';
						}else
						{
							_this.yibiaopanlist = [];
						}

						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		//绑定专家下拉列表
		bindExpertList : function(){
			var _this = this;
			layer.open({type:3});
			$.post('/expert/findExpertByName', {
				name:"",
				rdm:Math.random()
			},function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.expertlist = ppData.resultContent;
					}
				}
			},"json");
		},
		
		
		toRemove : function(){
			var _this = this;
			_this.paibanriqi='';
			_this.expertid='';
			$("#paibanriqi").val("");
			$("#expertid").val("");
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
		
		

	}
})
