var Leibiebiaoqian = new Vue({
    el : '#leibiebiaoqian',
    data : {
        biaoqiantext : $("#biaoqian").val(),
        biaoqianlist : [],
        biaoqian : {},
        editFlag : 0,// 0:新增，1：修改
        show : true,// 显示列表是否有数据
        biaoqianid : '',
        roleid : '',
        rolelist : [],
        xiangmuzhuangtailist:[],


    },

    created : function() {
        //this.bindBiaoqianList();
    },

    methods : {
        bindBiaoqianList : function(){
            let _this = this;
            layer.open({type:3});
            $.post('/leibiebiaoqian/find_all',{
                biaoqian:_this.biaoqiantext,
                rdm:Math.random()
            },function(ppData){

                layer.closeAll("loading");
                if(ppData!=null){
                    if(ppData.result == '1'){
                        _this.biaoqianlist =ppData.resultContent;

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        perparetoAddBiaoqian : function(){
            $('#editBiaoqianModal').modal();
            $("#myModalLabel_biaoqian").html("新增类别标签");
            this.editFlag = 0;
            this.biaoqian = {};
            this.biaoqianid="";
            this.biaoqian.isvalid=1;

        },

        perpareToModifyBiaoqian  : function(ppBiaoqianId){
            $('#editBiaoqianModal').modal();
            $("#myModalLabel_biaoqian").html("修改类别标签");
            this.editFlag = 1;
            this.biaoqianid = ppBiaoqianId;
            this.bindBiaoqian();

        },

        bindBiaoqian : function(){
            var _this = this;
            layer.open({type:3});
            $.post('/leibiebiaoqian/find_one', {
                id : _this.biaoqianid,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        let data = ppData.resultContent;
                        _this.biaoqian = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        addBiaoqian  : function(){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});
                $.post('/leibiebiaoqian/add',{
                    text:!_this.biaoqian.text?"" : $.trim(_this.biaoqian.text),
                    isvalid:$("#shifouyouxiao").is(":checked")?1:0,
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
                            $("#editBiaoqianModal").modal("hide");
                            _this.bindBiaoqianList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json")
            }
        },
        modifyBiaoqian : function(){
            let _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});
                $.post('/leibiebiaoqian/modify',{
                    id:_this.biaoqian.id,
                    text:!_this.biaoqian.text?"" : $.trim(_this.biaoqian.text),
                    isvalid:$("#shifouyouxiao").is(":checked")?1:0,
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
                            $("#editBiaoqianModal").modal("hide");
                            _this.bindBiaoqianList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json")
            }
        },
        //检查输入信息
        checkInputData : function(){
            let mmText = !this.biaoqian.text ? "" : $.trim(this.biaoqian.text);
            if("" == mmText){
                layer.alert("请填写类别标签名称！");
                return false;
            }
            return true;
        },
        toDelete : function(ppId){
            var _this = this;
            layer.confirm("确定删除该类别标签吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});
                $.post("/leibiebiaoqian/delete", {
                    id : ppId,
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
                            _this.bindBiaoqianList();
                        }
                    }
                },"json");
            })
        },
    }
})