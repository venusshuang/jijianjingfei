var Junjianxiada = new Vue({

    el : '#Junjianxiada',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        xiangmutext:'',
        xiangmu : {},
        xiangmulist : [],
        leibielist:[],
        danweilist:[],

        excelxiangmulist:[],//批量导入

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



        showUploadXls : function(){
            $("#uploadModal").modal("show");
            this.getFileUrl("jjjf",'20','xls,xlsx',"");
        },

        getFileUrl : function(ppFolderName,ppFileSize,ppShangChuanWenJianLeiXing,ppPiciId){
            var _this = this;
            $("#uploadModal-body").load("upload_batch.html?fujianpath=/jjjf/"+ppFolderName+"&filesize="+ppFileSize, function(){
                UploadVue.Init(ppShangChuanWenJianLeiXing,ppFileSize+"kb",function(jsonList){
                    if(jsonList.length==0){
                        return;
                    }
                    var filename=jsonList[0].filename;
                    var fileurl=jsonList[0].fileurl;
                    var filesize=jsonList[0].filesize;
                    _this.getValue(fileurl);

                },function(){
                    $("#uploadModal").modal("hide");
                });
            });
        },
        getValue : function(ppFileurl){

            var _this=this;
            layer.open({type:3});
            $.post("/import_xiangmu/get_value",{
                fileurl:ppFileurl,
                random : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if(ppData != null){
                    var mmData = ppData;
                    var result = mmData.result;
                    var message = mmData.message;
                    var data = mmData.resultContent;
                    if(result == "1") {
                        _this.excelxiangmulist = ppData.resultContent;
                        _this.importXiangmu();

                    }else{
                        layer.alert(message);
                    }
                }
            },"json");
        },

        importXiangmu : function(){
            var _this = this;
            layer.confirm("确定要导入所有经费项目吗？",{
                btn : ["是","否"]
            },function(){
                layer.closeAll("dialog");
                _this.startDaoru();
            });
        },
        startDaoru : function(){
            var _this = this;
            layer.open({type:3});
            //$("#daoru").attr("disabled","disabled");
            _this.daoru(0);
        },
        daoru : function(ppMuluCurrentIndex){
            layer.open({type:3});
            var _this=this;
            var  CurrentIndex = ppMuluCurrentIndex+1;
            layer.open({
                type: 3,
                content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在导入基建经费<br/>当前进度    "+CurrentIndex+" / "+_this.excelxiangmulist.length+"</div>"
            });

            $.post("/import_xiangmu/import",{

                xiangmuname:_this.excelxiangmulist[ppMuluCurrentIndex].项目名称,
                xiangmupifu:_this.excelxiangmulist[ppMuluCurrentIndex].两级批复情况,
                lianbaopifujine:_this.excelxiangmulist[ppMuluCurrentIndex].联保批复金额,
                zhongxinpifujine:_this.excelxiangmulist[ppMuluCurrentIndex].中心批复金额,
                lianbaoyuliujine:_this.excelxiangmulist[ppMuluCurrentIndex].联保预留预备费,

                jingfeixiadaqingkuang:_this.excelxiangmulist[ppMuluCurrentIndex].两级经费下达情况,
                yusuanniandu:_this.excelxiangmulist[ppMuluCurrentIndex].预算年度,
                lianbaojingfeizhibiao:_this.excelxiangmulist[ppMuluCurrentIndex].联保下达经费指标,
                zhongxinjingfeizhibiao:_this.excelxiangmulist[ppMuluCurrentIndex].中心下达经费指标,
                zhongxinyuliujine:_this.excelxiangmulist[ppMuluCurrentIndex].中心预留预备费,
                zhongxinkuaijihao:_this.excelxiangmulist[ppMuluCurrentIndex].中心会计账凭证号,
                chengshoujingfeidanwei:_this.excelxiangmulist[ppMuluCurrentIndex].承受经费单位名称,
                jingfeikemu:_this.excelxiangmulist[ppMuluCurrentIndex].经费科目,

                xiangmuzhuangtai:_this.excelxiangmulist[ppMuluCurrentIndex].项目状态,
                kaigongshijian:_this.excelxiangmulist[ppMuluCurrentIndex].开工时间,
                hetongzongjia:_this.excelxiangmulist[ppMuluCurrentIndex].各类合同总价,
                wangchengtouzi:_this.excelxiangmulist[ppMuluCurrentIndex].完成投资,
                jindukuaizhifu:_this.excelxiangmulist[ppMuluCurrentIndex].进度款支付,
                jindukuanbili:_this.excelxiangmulist[ppMuluCurrentIndex].进度款占总合同比例,
                wangongshijian:_this.excelxiangmulist[ppMuluCurrentIndex].完工时间,

                xiangzhongxinshenqingzijin:_this.excelxiangmulist[ppMuluCurrentIndex].向中心申请资金,
                shenqingshijian:_this.excelxiangmulist[ppMuluCurrentIndex].申请时间,
                xianglianbaoshenqingzijin:_this.excelxiangmulist[ppMuluCurrentIndex].向联保申请拨付金额,
                xianglianbaoshenqingbofushijian:_this.excelxiangmulist[ppMuluCurrentIndex].向联保申请拨付时间,
                lianbaobofujine:_this.excelxiangmulist[ppMuluCurrentIndex].联保拨付金额,
                lianbaobofushijian:_this.excelxiangmulist[ppMuluCurrentIndex].联保拨付时间,
                zhongxinbofujine:_this.excelxiangmulist[ppMuluCurrentIndex].中心资金拨付金额,
                zhongxinbofushijian:_this.excelxiangmulist[ppMuluCurrentIndex].中心拨付时间,

                jiesuanzhuangtai:_this.excelxiangmulist[ppMuluCurrentIndex].竣工结算状态,
                jiesuanwanchengtime:_this.excelxiangmulist[ppMuluCurrentIndex].竣工结算完成时间,
                jiesuanqingkuang:_this.excelxiangmulist[ppMuluCurrentIndex].竣工决算情况,
                shifoujizhang:_this.excelxiangmulist[ppMuluCurrentIndex].是否记账和登记,
                jiesuanpifuwenhao:_this.excelxiangmulist[ppMuluCurrentIndex].两级决算批复文号,
                jiesuanpifujine:_this.excelxiangmulist[ppMuluCurrentIndex].决算批复金额,
                jieyushangjiaojine:_this.excelxiangmulist[ppMuluCurrentIndex].结余上缴金额,

                xiangmuleibie:_this.excelxiangmulist[ppMuluCurrentIndex].类别,
                beizhu:_this.excelxiangmulist[ppMuluCurrentIndex].备注,
                random : Math.random()
            }, function(ppData) {
                layer.closeAll("loading");

                if (ppData.result == "0") {
                    layer.alert(message);
                }else{

                    if(ppMuluCurrentIndex >=_this.excelxiangmulist.length - 1){

                        layer.alert("导入完成！");
                        _this.bindXiadaList();
                    }else{
                        ppMuluCurrentIndex++;
                        _this.daoru(ppMuluCurrentIndex);
                    }
                }
            },"json")
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

            /*var xiangmuleibie = !_this.xiangmu.xiangmuleibie ? "" : $.trim(_this.xiangmu.xiangmuleibie);
            if("" == xiangmuleibie){
                layer.alert("请选择类别！");
                return false;
            }*/


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
