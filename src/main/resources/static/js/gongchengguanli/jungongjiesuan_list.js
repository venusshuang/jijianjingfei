var Jungongjiesuan = new Vue({

    el : '#Jungongjiesuan',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmutext:'',
        jiesuan : {},
        jiesuanlist : [],
        jiesuanzhuangtailist:[],
        jiesuanqingkuanglist:[],



        xiangmuId:'',
        jungongjiesuanId:'',
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
        _this.bindJungongjiesuanList();
        _this.bindJiesuanzhuangtaiList();
        _this.bindJiesuanqingkuangList();
    },
    methods : {

        getjgsj : function(){
            this.jiesuan.jiesuanwanchengtime = $("#jgsj").val();
        },


        bindJiesuanzhuangtaiList:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/jiesuanzhuangtai/find_all',{
                text:"",
                rdm:Math.random()
            },function(ppData){

                layer.closeAll("loading");
                if(ppData!=null){
                    if(ppData.result == '1'){
                        _this.jiesuanzhuangtailist =ppData.resultContent;

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },

        bindJiesuanqingkuangList:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/jiesuanqingkuang/find_all',{
                text:"",
                rdm:Math.random()
            },function(ppData){

                layer.closeAll("loading");
                if(ppData!=null){
                    if(ppData.result == '1'){
                        _this.jiesuanqingkuanglist =ppData.resultContent;

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },




        bindJungongjiesuanList:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/jungongjiesuan/findjiesuanBydeptId",{
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


                        if(data.JiesuanList.length > 0){
                            _this.show = true;
                            _this.jiesuanlist=data.JiesuanList;

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
            $('#editJungongjiesuanModal').modal();
            $("#myModalLabel_jungongjiesuan").html(ppXiangmuName);
            this.editFlag = 0;
            this.jiesuan = {};
            this.xiangmuId=ppXiangmuId;
            $("#shifoujizhang_y").prop('checked',false);
            $("#shifoujizhang_n").prop('checked',true);
            this.jiesuan.shifoujizhang='0';

        },
        addJiesuan:function () {
            var _this = this;


            if(_this.deptId!='1'){

                _this.jiesuan.jiesuanpifujine=0;
                _this.jiesuan.jieyushangjiaojine=0;
            }

            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/jungongjiesuan/add',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    jiesuanzhuangtaiid:$.trim(_this.jiesuan.jiesuanzhuangtaiid),
                    jiesuanwanchengtime:$.trim(_this.jiesuan.jiesuanwanchengtime),
                    jiesuanqingkuangid:$.trim(_this.jiesuan.jiesuanqingkuangid),
                    shifoujizhang:$.trim(_this.jiesuan.shifoujizhang),
                    jiesuanpifuwenhao:$.trim(_this.jiesuan.jiesuanpifuwenhao),
                    jiesuanpifujine:$.trim(_this.jiesuan.jiesuanpifujine),
                    jieyushangjiaojine:$.trim(_this.jiesuan.jieyushangjiaojine),
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
                            $("#editJungongjiesuanModal").modal("hide");
                            _this.bindJungongjiesuanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");

            }
        },

        perpareToModifyJiesuan :function (ppXiangmuName,ppJungongjiesuanId,ppxiangmuid){
            $('#editJungongjiesuanModal').modal();
            $("#myModalLabel_jungongjiesuan").html(ppXiangmuName);
            this.editFlag = 1;
            this.jiesuan = {};
            this.jungongjiesuanId=ppJungongjiesuanId;
            this.xiangmuId=ppxiangmuid;

            this.bindJungongjiesuan();
        },

        bindJungongjiesuan:function (){
            var _this = this;
            layer.open({type:3});
            $.post('/jungongjiesuan/find_one', {
                jungongjiesuanId : _this.jungongjiesuanId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){
                    if(ppData.result == "1"){
                        var data = ppData.resultContent;
                        _this.jiesuan = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },
        modifyJiesuan:function (){
            var _this = this;
            if(_this.checkInputData()){
                layer.open({type:3});

                $.post('/jungongjiesuan/modify',{
                    adminId : _this.adminId,
                    xiangmuId:_this.xiangmuId,
                    jungongjiesuanId : _this.jungongjiesuanId,
                    jiesuanzhuangtaiid:$.trim(_this.jiesuan.jiesuanzhuangtaiid),
                    jiesuanwanchengtime:$.trim(_this.jiesuan.jiesuanwanchengtime),
                    jiesuanqingkuangid:$.trim(_this.jiesuan.jiesuanqingkuangid),
                    shifoujizhang:$.trim(_this.jiesuan.shifoujizhang),
                    jiesuanpifuwenhao:$.trim(_this.jiesuan.jiesuanpifuwenhao),
                    jiesuanpifujine:$.trim(_this.jiesuan.jiesuanpifujine),
                    jieyushangjiaojine:$.trim(_this.jiesuan.jieyushangjiaojine),
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
                            $("#editJungongjiesuanModal").modal("hide");
                            _this.bindJungongjiesuanList();
                        }else{
                            layer.alert(ppData.message);
                        }
                    }
                },"json");
            }
        },

        toDelete:function (jungongjiesuanid){
            var _this = this;

            layer.confirm("确定删除该条竣工结算和决算情况吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/jungongjiesuan/delete", {
                    jungongjiesuanId : jungongjiesuanid,
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

                            _this.bindJungongjiesuanList();
                        }
                    }
                },"json");
            })
        },


        //检查输入信息
        checkInputData : function() {
            var _this = this;

            var jiesuanzhuangtaiid = !_this.jiesuan.jiesuanzhuangtaiid ? "" : $.trim(_this.jiesuan.jiesuanzhuangtaiid);
            if("" == jiesuanzhuangtaiid&&_this.deptId!="1"){
                layer.alert("请选择竣工结算状态！");
                return false;
            }

            var jiesuanqingkuangid = !_this.jiesuan.jiesuanqingkuangid ? "" : $.trim(_this.jiesuan.jiesuanqingkuangid);
            if("" == jiesuanqingkuangid&&_this.deptId!="1"){
                layer.alert("请选择竣工决算情况！");
                return false;
            }

            var shifoujizhang = !_this.jiesuan.shifoujizhang ? "" : $.trim(_this.jiesuan.shifoujizhang);
            if("" == shifoujizhang&&_this.deptId!="1"){
                layer.alert("请选择决算是否记账和登记资产！");
                return false;
            }

            var jiesuanpifuwenhao = !_this.jiesuan.jiesuanpifuwenhao ? "" : $.trim(_this.jiesuan.jiesuanpifuwenhao);
            if("" == jiesuanpifuwenhao&&_this.deptId=="1"){
                layer.alert("请填写两级决算批复文号！");
                return false;
            }

          var jiesuanpifujine = !_this.jiesuan.jiesuanpifujine ? "" : $.trim(_this.jiesuan.jiesuanpifujine);

            if("" == jiesuanpifujine&&_this.deptId=="1"){
                layer.alert("请填写决算批复金额！");
                return false;
            }
            if (!_this.checknum(jiesuanpifujine)&&_this.deptId=="1") {
                layer.alert("决算批复金额请填写数字格式！");
                return false;
            }

            var jieyushangjiaojine = !_this.jiesuan.jieyushangjiaojine ? "" : $.trim(_this.jiesuan.jieyushangjiaojine);
            if("" == jieyushangjiaojine&&_this.deptId=="1"){
                layer.alert("请填写结余上缴金额！");
                return false;
            }
            if (!_this.checknum(jieyushangjiaojine)&&_this.deptId=="1") {
                layer.alert("结余上缴金额请填写数字格式！");
                return false;
            }



            return true;

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