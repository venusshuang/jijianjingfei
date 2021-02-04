var _yuyueguahaoDetailVue = new Vue({
	el:"#yuyueguahaodetail",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		jiuzhenxinxiid : $("#jiuzhenxinxiid").val(),
		paibanid : $("#paibanid").val(),
		
		paiban : {},
		weekpaibanlist : [],
		expertid : '',
		
		showdetail : false,
		
	},
	created : function(){
		var _this = this;
		
		_this.bindPaiban();
	},
	methods:{
		
		// 绑定排班
		bindPaiban : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/paiban/find_custom_one',{
				paibanid : _this.paibanid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent[0];
						_this.paiban = data;
						_this.expertid = _this.paiban.expertid;
						_this.bindWeekPaiban(_this.expertid);
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 绑定本周内排班
		bindWeekPaiban : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/paiban/find_weekpaiban_by_expertid',{
				expertid : _this.expertid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.weekpaibanlist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toGuahao:function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/guahao/add',{
				jiuzhenxinxiid : _this.jiuzhenxinxiid,
				userid : _this.userid,
				paibanid : _this.paibanid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						$("#js_toast").show();
						setTimeout(function(){
							location.href="/homepage/yuyueguahao.html?jiuzhenxinxiid="+_this.jiuzhenxinxiid;
						},'2000');
					}else{
						$(".weui-toast__content").html(ppData.message);
						$("#js_toast").show();
						setTimeout(function(){
							location.href="/homepage/yuyueguahao.html?jiuzhenxinxiid="+_this.jiuzhenxinxiid;
						},'2000');
					}
				}
			},"json");
		},
		
		toDetail:function(ppPaibanId){
			var _this = this;
			
			location.href="/homepage/yuyueguahao_detail.html?paibanid="+ppPaibanId+"&jiuzhenxinxiid="+_this.jiuzhenxinxiid;
		},
		
		showDetail:function(){
			var _this = this;
			if(_this.showdetail){
				$("#jianjie_div").attr("style","float:left;width:100%;height:200px;overflow:hidden;")
				_this.showdetail = false;
			}else{
				$("#jianjie_div").attr("style","float:left;width:100%;height:auto;overflow:hidden;")
				_this.showdetail = true;
			}
		},
		
	}
})