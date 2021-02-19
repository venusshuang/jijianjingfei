var Gongchengjinzhan = new Vue({


    el : '#Gonfchengjinzhan',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmutext:'',
        jinzhan : {},
        jinzhanlist : [],
        xiangmuzhuangtailist:[],

        xiangmuId:'',
        gongchengjinzhanId:'',
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
        _this.bindGongchengjinzhanList();
        _this.bindXiangmuzhuangtaiList();

    },
    methods : {


        getkgsj : function(){
            this.jinzhan.kaigongshijian = $("#kgsj").val();
        },
        getwgsj : function(){
            this.jinzhan.wangongshijian = $("#wgsj").val();
        },

        bindXiangmuzhuangtaiList:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/xiangmuzhuangtai/find_all',{
                zhuangtai:"",
                rdm:Math.random()
            },function(ppData){

                layer.closeAll("loading");
                if(ppData!=null){
                    if(ppData.result == '1'){
                        _this.xiangmuzhuangtailist =ppData.resultContent;

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        bindGongchengjinzhanList:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/gongchengjinzhan/findJinzhanBydeptId",{
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


                        if(data.JinzhaniList.length > 0){
                            _this.show = true;
                            _this.jinzhanlist=data.JinzhaniList;

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
            $('#editGongchengjinzhanModal').modal();
            $("#myModalLabel_gongchengjinzhan").html(ppXiangmuName);
            this.editFlag = 0;
            this.jinzhan = {};
            this.xiangmuId=ppXiangmuId;

        },

        addJinzhan:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/gongchengjinzhan/add',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    xiangmuzhuangtaiid:$.trim(_this.jinzhan.xiangmuzhuangtaiid),
                    kaigongshijian:$.trim(_this.jinzhan.kaigongshijian),
                    hetongzongjia:$.trim(_this.jinzhan.hetongzongjia),
                    wangchengtouzi:$.trim(_this.jinzhan.wangchengtouzi),
                    jindukuaizhifu:$.trim(_this.jinzhan.jindukuaizhifu),
                    jindukuanbili:$.trim(_this.jinzhan.jindukuanbili),
                    wangongshijian:$.trim(_this.jinzhan.wangongshijian),
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
                            $("#editGongchengjinzhanModal").modal("hide");
                            _this.bindGongchengjinzhanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        perpareToModifyJinzhan :function (ppXiangmuName,ppGongchengjinzhanId){
            $('#editGongchengjinzhanModal').modal();
            $("#myModalLabel_gongchengjinzhan").html(ppXiangmuName);
            this.editFlag = 1;
            this.jinzhan = {};
            this.gongchengjinzhanId=ppGongchengjinzhanId;

            this.bindGongchengjinzhan();
        },
        bindGongchengjinzhan:function(){
            var _this = this;
            layer.open({type:3});
            $.post('/gongchengjinzhan/find_one', {
                gongchengjinzhanId : _this.gongchengjinzhanId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        var data = ppData.resultContent;
                        _this.jinzhan = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },


        modifyJinzhan : function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/gongchengjinzhan/modify',{
                    adminId : _this.adminId,
                    gongchengjinzhanId : _this.gongchengjinzhanId,
                    xiangmuzhuangtaiid:$.trim(_this.jinzhan.xiangmuzhuangtaiid),
                    kaigongshijian:$.trim(_this.jinzhan.kaigongshijian),
                    hetongzongjia:$.trim(_this.jinzhan.hetongzongjia),
                    wangchengtouzi:$.trim(_this.jinzhan.wangchengtouzi),
                    jindukuaizhifu:$.trim(_this.jinzhan.jindukuaizhifu),
                    jindukuanbili:$.trim(_this.jinzhan.jindukuanbili),
                    wangongshijian:$.trim(_this.jinzhan.wangongshijian),
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
                            $("#editGongchengjinzhanModal").modal("hide");
                            _this.bindGongchengjinzhanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        toDelete:function (ppgongchengjinzhanid){
            var _this = this;

            layer.confirm("确定删除该条工程进展情况吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/gongchengjinzhan/delete", {
                    gongchengjinzhanId : ppgongchengjinzhanid,
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

                            _this.bindGongchengjinzhanList();
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

            var xiangmuzhuangtaiid = !_this.jinzhan.xiangmuzhuangtaiid ? "" : $.trim(_this.jinzhan.xiangmuzhuangtaiid);
            if("" == xiangmuzhuangtaiid){
                layer.alert("请选择项目状态！");
                return false;
            }

            var kaigongshijian = !_this.jinzhan.kaigongshijian ? "" : $.trim(_this.jinzhan.kaigongshijian);
            if("" == kaigongshijian){
                layer.alert("请选择开工时间！");
                return false;
            }

            var hetongzongjia = !_this.jinzhan.hetongzongjia ? "" : $.trim(_this.jinzhan.hetongzongjia);
            if("" == hetongzongjia){
                layer.alert("请填写各类合同总价！");
                return false;
            }
            if (!_this.checknum(hetongzongjia)) {
                layer.alert("各类合同总价请填写数字格式！");
                return false;
            }

            var wangchengtouzi = !_this.jinzhan.wangchengtouzi ? "" : $.trim(_this.jinzhan.wangchengtouzi);
            if("" == wangchengtouzi){
                layer.alert("请填写完成投资！");
                return false;
            }
            if (!_this.checknum(wangchengtouzi)) {
                layer.alert("完成投资请填写数字格式！");
                return false;
            }

            var jindukuaizhifu = !_this.jinzhan.wangchengtouzi ? "" : $.trim(_this.jinzhan.wangchengtouzi);
            if("" == jindukuaizhifu){
                layer.alert("请填写进度款支付！");
                return false;
            }
            if (!_this.checknum(jindukuaizhifu)) {
                layer.alert("进度款支付请填写数字格式！");
                return false;
            }

            var jindukuanbili = !_this.jinzhan.jindukuanbili ? "" : $.trim(_this.jinzhan.jindukuanbili);
            if("" == jindukuanbili){
                layer.alert("请填写进度款占总合同比例！");
                return false;
            }

            var wangongshijian = !_this.jinzhan.wangongshijian ? "" : $.trim(_this.jinzhan.wangongshijian);
            if("" == wangongshijian){
                layer.alert("请选择完工时间！");
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
