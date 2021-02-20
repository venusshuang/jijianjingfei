var Zijinbaozhang = new Vue({

    el : '#Zijinbaozhang',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmutext:'',
        zijin : {},
        zijinlist : [],

        xiangmuId:'',
        zijinbaozhangId:'',
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
        _this.bindZijinbaozhangList();

    },
    methods : {


        getsqsj : function(){
            this.zijin.shenqingshijian = $("#sqsj").val();
        },
        getsqbfsj : function(){
            this.zijin.xianglianbaoshenqingbofushijian = $("#sqbfsj").val();
        },
        getlbbfsj : function(){
            this.zijin.lianbaobofushijian = $("#lbbfsj").val();
        },
        getzxbfsj : function(){
            this.zijin.zhongxinbofushijian = $("#zxbfsj").val();
        },

        bindZijinbaozhangList:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/zijinbaozhang/findZijinBydeptId",{
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


                        if(data.ZijinList.length > 0){
                            _this.show = true;
                            _this.zijinlist=data.ZijinList;

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
            $('#editZijinbaozhangModal').modal();
            $("#myModalLabel_zijinbaozhang").html(ppXiangmuName);
            this.editFlag = 0;
            this.zijin = {};
            this.xiangmuId=ppXiangmuId;

        },

        addZijin:function (){
            var _this = this;

            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/zijinbaozhang/add',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    xiangzhongxinshenqingzijin:$.trim(_this.zijin.xiangzhongxinshenqingzijin),
                    shenqingshijian:$.trim(_this.zijin.shenqingshijian),
                    xianglianbaoshenqingzijin:$.trim(_this.zijin.xianglianbaoshenqingzijin),
                    xianglianbaoshenqingbofushijian:$.trim(_this.zijin.xianglianbaoshenqingbofushijian),
                    lianbaobofujine:$.trim(_this.zijin.lianbaobofujine),
                    lianbaobofushijian:$.trim(_this.zijin.lianbaobofushijian),
                    zhongxinbofujine:$.trim(_this.zijin.zhongxinbofujine),
                    zhongxinbofushijian:$.trim(_this.zijin.zhongxinbofushijian),
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
                            $("#editZijinbaozhangModal").modal("hide");
                            _this.bindZijinbaozhangList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        perpareToModifyZijin :function (ppXiangmuName,ppZijinbaozhangId){
            $('#editZijinbaozhangModal').modal();
            $("#myModalLabel_zijinbaozhang").html(ppXiangmuName);
            this.editFlag = 1;
            this.zijin = {};
            this.zijinbaozhangId=ppZijinbaozhangId;

            this.bindZijinbaozhang();
        },
        bindZijinbaozhang:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/zijinbaozhang/find_one', {
                zijinbaozhangId : _this.zijinbaozhangId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        var data = ppData.resultContent;
                        _this.zijin = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");

        },

        modifyZijin:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/zijinbaozhang/modify',{
                    adminId : _this.adminId,
                    zijinbaozhangId : _this.zijinbaozhangId,
                    xiangzhongxinshenqingzijin:$.trim(_this.zijin.xiangzhongxinshenqingzijin),
                    shenqingshijian:$.trim(_this.zijin.shenqingshijian),
                    xianglianbaoshenqingzijin:$.trim(_this.zijin.xianglianbaoshenqingzijin),
                    xianglianbaoshenqingbofushijian:$.trim(_this.zijin.xianglianbaoshenqingbofushijian),
                    lianbaobofujine:$.trim(_this.zijin.lianbaobofujine),
                    lianbaobofushijian:$.trim(_this.zijin.lianbaobofushijian),
                    zhongxinbofujine:$.trim(_this.zijin.zhongxinbofujine),
                    zhongxinbofushijian:$.trim(_this.zijin.zhongxinbofushijian),
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
                            $("#editZijinbaozhangModal").modal("hide");
                            _this.bindZijinbaozhangList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        toDelete:function (ppzijinbaozhangid){
            var _this = this;

            layer.confirm("确定删除该条资金保障情况吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/zijinbaozhang/delete", {
                    zijinbaozhangId : ppzijinbaozhangid,
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

                            _this.bindZijinbaozhangList();
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


            var xiangzhongxinshenqingzijin = !_this.zijin.xiangzhongxinshenqingzijin ? "" : $.trim(_this.zijin.xiangzhongxinshenqingzijin);
            if("" == xiangzhongxinshenqingzijin){
                layer.alert("请填写向中心申请资金！");
                return false;
            }
            if (!_this.checknum(xiangzhongxinshenqingzijin)) {
                layer.alert("向中心申请资金请填写数字格式！");
                return false;
            }

            var shenqingshijian = !_this.zijin.shenqingshijian ? "" : $.trim(_this.zijin.shenqingshijian);
            if("" == shenqingshijian){
                layer.alert("请选择申请时间！");
                return false;
            }

            var xianglianbaoshenqingzijin = !_this.zijin.xianglianbaoshenqingzijin ? "" : $.trim(_this.zijin.xianglianbaoshenqingzijin);
            if("" == xianglianbaoshenqingzijin){
                layer.alert("请填写向联保申请拨付金额！");
                return false;
            }
            if (!_this.checknum(xianglianbaoshenqingzijin)) {
                layer.alert("向联保申请拨付金额请填写数字格式！");
                return false;
            }

            var xianglianbaoshenqingbofushijian = !_this.zijin.xianglianbaoshenqingbofushijian ? "" : $.trim(_this.zijin.xianglianbaoshenqingbofushijian);
            if("" == xianglianbaoshenqingbofushijian){
                layer.alert("请选择向联保申请拨付时间！");
                return false;
            }

            var lianbaobofujine = !_this.zijin.lianbaobofujine ? "" : $.trim(_this.zijin.lianbaobofujine);
            if("" == lianbaobofujine){
                layer.alert("请填写联保拨付金额！");
                return false;
            }
            if (!_this.checknum(lianbaobofujine)) {
                layer.alert("联保拨付金额请填写数字格式！");
                return false;
            }

            var lianbaobofushijian = !_this.zijin.lianbaobofushijian ? "" : $.trim(_this.zijin.lianbaobofushijian);
            if("" == lianbaobofushijian){
                layer.alert("请选择联保拨付时间！");
                return false;
            }

            var zhongxinbofujine = !_this.zijin.zhongxinbofujine ? "" : $.trim(_this.zijin.zhongxinbofujine);
            if("" == zhongxinbofujine){
                layer.alert("请填写中心资金拨付金额！");
                return false;
            }
            if (!_this.checknum(zhongxinbofujine)) {
                layer.alert("中心资金拨付金额请填写数字格式！");
                return false;
            }

            var zhongxinbofushijian = !_this.zijin.zhongxinbofushijian ? "" : $.trim(_this.zijin.zhongxinbofushijian);
            if("" == zhongxinbofushijian){
                layer.alert("请选择中心拨付时间！");
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