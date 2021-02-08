var Junjianxiada = new Vue({

    el : '#Junjianxiada',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmu : {},
        xiangmulist : [],
        leibielist:[],
        danweilist:[],

        xiangmuId:'',
        editFlag : 0,					// 0:新增，1：修改
        show : false,					// 显示列表是否有数据

        pageIndex : 1,
        pageSize : 10,
        pageCount : 0,
        recordCount : 0,
        inputPageIndexValue : "",

    },
    created : function() {
        var _this = this;

        _this.bindXiadaList();
        _this.bindLeibielist();
        _this.bindDanweilist();


    },
    methods : {
        bindXiadaList:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/junjianxiangmu/findXiangmuBydeptId",{
                deptid : _this.deptId,
                pageindex : _this.pageIndex,
                pagesize : _this.pageSize,
                rdm : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if (ppData != null){
                    if(ppData.result == "1"){
                        var data=ppData.resultContent;


                        if(data.XiangMuList.length > 0){
                            _this.show = true;
                            _this.xiangmulist=data.XiangMuList;

                            var PageInfo = data.PageInfo;
                            _this.pageIndex = PageInfo.pageIndex;
                            _this.recordCount = PageInfo.recordCount;
                            _this.pageCount = PageInfo.pageCount;

                        }else {
                            _this.show = false;
                        }

                    }else{
                        layer.alert(ppData.message);
                    }
                }

            },"json");
        },

        toAdd : function (){
            $('#editXiadaxiamgmuModal').modal();
            $("#myModalLabel_xiadaxiangmu").html("新增军建计划下达情况");
            this.editFlag = 0;
            this.xiangmu = {};
            this.xiangmuId="";


        },

        bindLeibielist:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/leibiebiaoqian/find_all',{
                biaoqian:"",
                rdm:Math.random()
            },function(ppData){

                layer.closeAll("loading");
                if(ppData!=null){
                    if(ppData.result == '1'){
                        _this.leibielist =ppData.resultContent;

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        bindDanweilist:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/dept/findVaild",{
                pageindex : 1,
                pagesize : 1000,
                rdm : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if (ppData != null){
                    if(ppData.result == "1"){
                        var data=ppData.resultContent;
                        if(data.DanweiList.length > 0){
                            _this.danweilist=data.DanweiList;
                        }else {
                            _this.show = false;
                        }

                    }else{
                        layer.alert(ppData.message);
                    }
                }

            },"json");
        },

        addXiangmu:function(){

            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/junjianxiangmu/add',{
                    adminId : _this.adminId,
                    xiangmuname:$.trim(_this.xiangmu.xiangmuname),
                    xiangmupifu:$.trim(_this.xiangmu.xiangmupifu),
                    lianbaopifujine:$.trim(_this.xiangmu.lianbaopifujine),
                    zhongxinpifujine:$.trim(_this.xiangmu.zhongxinpifujine),
                    lianbaoyuliujine:$.trim(_this.xiangmu.lianbaoyuliujine),
                    xiangmuleibie:$.trim(_this.xiangmu.xiangmuleibie),
                    jieshoudanweiid:$.trim(_this.xiangmu.jieshoudanweiid),
                    beizhu:$.trim(_this.xiangmu.beizhu),
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
                            $("#editXiadaxiamgmuModal").modal("hide");
                            _this.bindXiadaList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }



        },

        perpareToModifyXiangmu : function (ppxiangmuid){

            $('#editXiadaxiamgmuModal').modal();
            $("#myModalLabel_xiadaxiangmu").html("修改军建计划下达情况");
            this.editFlag = 1;
            this.xiangmu = {};
            this.xiangmuId=ppxiangmuid;
            this.bindXiangmu();

        },
        bindXiangmu:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/junjianxiangmu/find_one', {
                xiangmuid : _this.xiangmuId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        var data = ppData.resultContent;
                        _this.xiangmu = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        modifyXiangmu:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/junjianxiangmu/modify',{
                    xiangmuId: _this.xiangmuId,
                    adminId : _this.adminId,
                    xiangmuname:$.trim(_this.xiangmu.xiangmuname),
                    xiangmupifu:$.trim(_this.xiangmu.xiangmupifu),
                    lianbaopifujine:$.trim(_this.xiangmu.lianbaopifujine),
                    zhongxinpifujine:$.trim(_this.xiangmu.zhongxinpifujine),
                    lianbaoyuliujine:$.trim(_this.xiangmu.lianbaoyuliujine),
                    xiangmuleibie:$.trim(_this.xiangmu.xiangmuleibie),
                    jieshoudanweiid:$.trim(_this.xiangmu.jieshoudanweiid),
                    beizhu:$.trim(_this.xiangmu.beizhu),
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
                            $("#editXiadaxiamgmuModal").modal("hide");
                            _this.bindXiadaList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },


        toDelete:function (ppxiangmuid){
            var _this = this;

            layer.confirm("确定删除该条军建计划吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/junjianxiangmu/delete", {
                    xiangmuid : ppxiangmuid,
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

                            _this.bindXiadaList();
                        }
                    }
                },"json");
            })
        },




        //检查数字
        checknum : function(ppNum) {
            var regPos = /^\d+(\.\d+)?$/; //非负浮点数
            var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数

            if (regPos.test(ppNum) || regNeg.test(ppNum)) {
                return true;
            } else {
                return false;
            }
        },

        //检查输入信息
        checkInputData : function(){
            var _this=this;

            var xiangmuname = !_this.xiangmu.xiangmuname ? "" : $.trim(_this.xiangmu.xiangmuname);
            if("" == xiangmuname){
                layer.alert("请填写项目名称！");
                return false;
            }

            var xiangmupifu = !_this.xiangmu.xiangmupifu ? "" : $.trim(_this.xiangmu.xiangmupifu);
            if("" == xiangmupifu){
                layer.alert("请填写两级建设计划或设计任务书批复！");
                return false;
            }

            var lianbaopifujine = !_this.xiangmu.lianbaopifujine ? "" : $.trim(_this.xiangmu.lianbaopifujine);
            if("" == lianbaopifujine){
                layer.alert("请填写联保建设计划批复金额！");
                return false;
            }
            if (!_this.checknum(lianbaopifujine)) {
                layer.alert("联保建设计划批复金额请填写数字格式！");
                return false;
            }

            var zhongxinpifujine = !_this.xiangmu.zhongxinpifujine ? "" : $.trim(_this.xiangmu.zhongxinpifujine);
            if("" == zhongxinpifujine){
                layer.alert("请填写中心建设计划批复金额！");
                return false;
            }
            if (!_this.checknum(zhongxinpifujine)) {
                layer.alert("中心建设计划批复金额请填写数字格式！");
                return false;
            }

            var lianbaoyuliujine = !_this.xiangmu.lianbaoyuliujine ? "" : $.trim(_this.xiangmu.lianbaoyuliujine);
            if("" == lianbaoyuliujine){
                layer.alert("请填写联保预留预备费！");
                return false;
            }
            if (!_this.checknum(lianbaoyuliujine)) {
                layer.alert("联保预留预备费请填写数字格式！");
                return false;
            }

            var xiangmuleibie = !_this.xiangmu.xiangmuleibie ? "" : $.trim(_this.xiangmu.xiangmuleibie);
            if("" == xiangmuleibie){
                layer.alert("请选择类别！");
                return false;
            }


            var jieshoudanweiid = !_this.xiangmu.jieshoudanweiid ? "" : $.trim(_this.xiangmu.jieshoudanweiid);
            if("" == jieshoudanweiid){
                layer.alert("请选择接受单位！");
                return false;
            }


            return true;
        },




        //跳到首页
        SetPageIndex : function(){
            this.pageIndex = 1;
        },
        SetPageEnd : function(){
            this.pageIndex = this.pageCount;
        },
        //上一页
        SetPageIndexPrePage : function(){
            var PrePage = ((this.pageIndex -1) <= 0) ? 1 : (this.pageIndex -1);
            this.pageIndex = PrePage;
        },
        //下一页
        SetPageIndexNextPage : function(){
            var NextPage = ((this.pageIndex +1) >= this.pageCount) ? this.pageCount : (this.pageIndex +1);
            this.pageIndex = NextPage;
        },
        //跳转界面
        JumpPage : function(){
            if(this.inputPageIndexValue <= 1){
                this.inputPageIndexValue = 1;
            }else if(this.inputPageIndexValue >= this.pageCount){
                this.inputPageIndexValue = this.pageCount;
            }
            this.pageIndex = this.inputPageIndexValue;
            this.inputPageIndexValue = '';
        },


    },

    watch :{
        //监控分页情况，刷新列表
        pageIndex : function(){
            this.bindXiadaList();
        }
    }


})
