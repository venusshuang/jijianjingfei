var Jingfeiyusuan = new Vue({

    el : '#Jingfeiyusuan',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmutext:'',
        jingfei : {},
        jingfeilist : [],

        xiangmuId:'',
        jingfeiyusuanId:'',
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

        _this.bindJingfeiyusuanList();



    },
    methods : {

        bindJingfeiyusuanList :function (){
            var _this = this;
            layer.open({type:3});
            $.post("/jingfeiyusuan/findJingfeiBydeptId",{
                xiangmuname :_this.xiangmutext,
                deptid : _this.deptId,
                pageindex : _this.pageIndex,
                pagesize : _this.pageSize,
                rdm : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if (ppData != null){
                    if(ppData.result == "1"){
                        var data=ppData.resultContent;


                        if(data.JingFeiList.length > 0){
                            _this.show = true;
                            _this.jingfeilist=data.JingFeiList;

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

        toAdd : function (ppXiangmuName,ppXiangmuId){
            $('#editJingfeiyusuanModal').modal();
            $("#myModalLabel_jingfeiyusuan").html(ppXiangmuName);
            this.editFlag = 0;
            this.jingfei = {};
            this.xiangmuId=ppXiangmuId;

        },


        addJingfei:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/jingfeiyusuan/add',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    jingfeixiadaqingkuang:$.trim(_this.jingfei.jingfeixiadaqingkuang),
                    yusuanniandu:$.trim(_this.jingfei.yusuanniandu),
                    lianbaojingfeizhibiao:$.trim(_this.jingfei.lianbaojingfeizhibiao),
                    zhongxinjingfeizhibiao:$.trim(_this.jingfei.zhongxinjingfeizhibiao),
                    zhongxinyuliujine:$.trim(_this.jingfei.zhongxinyuliujine),
                    zhongxinkuaijihao:$.trim(_this.jingfei.zhongxinkuaijihao),
                    chengshoujingfeidanwei:$.trim(_this.jingfei.chengshoujingfeidanwei),
                    jingfeikemu:$.trim(_this.jingfei.jingfeikemu),
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
                            $("#editJingfeiyusuanModal").modal("hide");
                            _this.bindJingfeiyusuanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        perpareToModifyJingfei:function (ppXiangmuName,ppJingfeiyuansuanId,ppxiangmuid){
            $('#editJingfeiyusuanModal').modal();
            $("#myModalLabel_jingfeiyusuan").html(ppXiangmuName);
            this.editFlag = 1;
            this.jingfei = {};
            this.jingfeiyusuanId=ppJingfeiyuansuanId;
            this.xiangmuId=ppxiangmuid;


            this.bindJingfeiyusaun();
        },

        bindJingfeiyusaun:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/jingfeiyusuan/find_one', {
                jingfeiyusuanId : _this.jingfeiyusuanId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        var data = ppData.resultContent;
                        _this.jingfei = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        modifyJingfei:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/jingfeiyusuan/modify',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    jingfeiyusuanId : _this.jingfeiyusuanId,
                    jingfeixiadaqingkuang:$.trim(_this.jingfei.jingfeixiadaqingkuang),
                    yusuanniandu:$.trim(_this.jingfei.yusuanniandu),
                    lianbaojingfeizhibiao:$.trim(_this.jingfei.lianbaojingfeizhibiao),
                    zhongxinjingfeizhibiao:$.trim(_this.jingfei.zhongxinjingfeizhibiao),
                    zhongxinyuliujine:$.trim(_this.jingfei.zhongxinyuliujine),
                    zhongxinkuaijihao:$.trim(_this.jingfei.zhongxinkuaijihao),
                    chengshoujingfeidanwei:$.trim(_this.jingfei.chengshoujingfeidanwei),
                    jingfeikemu:$.trim(_this.jingfei.jingfeikemu),
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
                            $("#editJingfeiyusuanModal").modal("hide");
                            _this.bindJingfeiyusuanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        toDelete:function (ppjingfeiyuansuanid){
            var _this = this;

            layer.confirm("确定删除该条经费预算下达情况吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/jingfeiyusuan/delete", {
                    jingfeiyusuanId : ppjingfeiyuansuanid,
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

                            _this.bindJingfeiyusuanList();
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
        checkInputData : function() {
            var _this = this;

            var jingfeixiadaqingkuang = !_this.jingfei.jingfeixiadaqingkuang ? "" : $.trim(_this.jingfei.jingfeixiadaqingkuang);
            if("" == jingfeixiadaqingkuang){
                layer.alert("请填写两级经费下达情况！");
                return false;
            }

            var yusuanniandu = !_this.jingfei.yusuanniandu ? "" : $.trim(_this.jingfei.yusuanniandu);
            if("" == yusuanniandu){
                layer.alert("请填写预算年度！");
                return false;
            }

            var lianbaojingfeizhibiao = !_this.jingfei.lianbaojingfeizhibiao ? "" : $.trim(_this.jingfei.lianbaojingfeizhibiao);
            if("" == lianbaojingfeizhibiao){
                layer.alert("请填写联保下达经费指标！");
                return false;
            }
            if (!_this.checknum(lianbaojingfeizhibiao)) {
                layer.alert("联保下达经费指标请填写数字格式！");
                return false;
            }

            var zhongxinjingfeizhibiao = !_this.jingfei.zhongxinjingfeizhibiao ? "" : $.trim(_this.jingfei.zhongxinjingfeizhibiao);
            if("" == zhongxinjingfeizhibiao){
                layer.alert("请填写中心下达经费指标！");
                return false;
            }
            if (!_this.checknum(zhongxinjingfeizhibiao)) {
                layer.alert("中心下达经费指标请填写数字格式！");
                return false;
            }

            var zhongxinyuliujine = !_this.jingfei.zhongxinyuliujine ? "" : $.trim(_this.jingfei.zhongxinyuliujine);
            if("" == zhongxinyuliujine){
                layer.alert("请填写中心预留预备费！");
                return false;
            }
            if (!_this.checknum(zhongxinyuliujine)) {
                layer.alert("中心预留预备费请填写数字格式！");
                return false;
            }

            var zhongxinkuaijihao = !_this.jingfei.zhongxinkuaijihao ? "" : $.trim(_this.jingfei.zhongxinkuaijihao);
            if("" == zhongxinkuaijihao){
                layer.alert("请填写中心会计账凭证号！");
                return false;
            }

            var chengshoujingfeidanwei = !_this.jingfei.chengshoujingfeidanwei ? "" : $.trim(_this.jingfei.chengshoujingfeidanwei);
            if("" == chengshoujingfeidanwei){
                layer.alert("请填写承受经费指标单位名称！");
                return false;
            }

            var jingfeikemu = !_this.jingfei.jingfeikemu ? "" : $.trim(_this.jingfei.jingfeikemu);
            if("" == jingfeikemu){
                layer.alert("请填写经费科目！");
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
