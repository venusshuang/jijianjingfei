var DanWei = new Vue({

    el : '#Danweilist',
    data :{

        AdminID : $("#AdminID").val(),
        DeptID : $("#DeptID").val(),
        danwei : {},
        danweilist : [],


        editFlag : 0,					// 0:新增，1：修改
        show : false,					// 显示列表是否有数据

        pageIndex : 1,
        pageSize : 2,
        pageCount : 0,
        recordCount : 0,
        inputPageIndexValue : "",


    },
    created : function() {
        this.findVaild();

    },
    methods : {

        findVaild: function(){
            var _this = this;
            layer.open({type:3});
            $.post("/dept/findVaild",{
                pageindex : _this.pageIndex,
                pagesize : _this.pageSize,
                rdm : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if (ppData != null){
                    if(ppData.result == "1"){
                        var data=ppData.resultContent;



                        if(data.DanweiList.length > 0){
                            _this.show = true;
                            _this.danweilist=data.DanweiList;

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

        bindDanwei :function(){

            var _this = this;
            layer.open({type:3});
            $.post('/dept/findOne', {
                deptID : _this.deptId,
                rdm : Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if(ppData != null){

                    if(ppData.result == "1"){
                        var data = ppData.resultContent
                        _this.guanliyuan = data;
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");
        },


        toAdd : function(){

            $("#danweiModal").modal();
            this.editFlag = 0;
            $("#myModalLabel").html("新增单位");
            this.findVaild();
            this.danwei.deptname='';
            this.danwei.depttype='';



        },


        add: function(){
            alert(AdminID);
            alert(DeptID);
            var _this = this;
            if (!$.trim(_this.danwei.deptname)) {
                layer.alert("请填写单位名称！");
                return false;
            }

            if (!$.trim(_this.danwei.depttype)) {
                layer.alert("请填写单位类型！");
                return false;
            }

            layer.open({type:3});
            $.post('/dept/add',{
                deptname:$.trim(_this.danwei.deptname),
                depttype:$.trim(_this.danwei.depttype),


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
                        $("#danweiModal").modal("hide");
                        _this.findVaild();
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");

        },





        toModify : function(ppGuanliyuanID){
            $("#guanliyuanModal").modal();
            this.editFlag = 1;
            $("#myModalLabel").html("修改管理员信息");

            this.guanliyuanId=ppGuanliyuanID;
            this.guanliyuan = {};
            this.bindGuanliyuan();
        },

        modify : function(){
            var _this = this;
            if (!$.trim(_this.guanliyuan.loginname)) {
                layer.alert("请填写登录账号！");
                return false;
            }

            if (!$.trim(_this.guanliyuan.loginpassword)) {
                layer.alert("请填写登录密码！");
                return false;
            }

            if (!$.trim(_this.guanliyuan.truename)) {
                layer.alert("请填写姓名！");
                return false;
            }

            if (!$.trim(_this.guanliyuan.lianxihaoma)) {
                layer.alert("请填写联系号码！");
                return false;
            }

            if (!$.trim(_this.guanliyuan.keshi)) {
                layer.alert("请填写科室！");
                return false;
            }


            layer.open({type:3});
            $.post('/admin/modify_all',{
                guanliyuanID:_this.guanliyuanId,
                loginname:$.trim(_this.guanliyuan.loginname),
                loginpassword:$.trim(_this.guanliyuan.loginpassword),
                truename:$.trim(_this.guanliyuan.truename),
                lianxihaoma:$.trim(_this.guanliyuan.lianxihaoma),
                keshi:$.trim(_this.guanliyuan.keshi),

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
                        $("#guanliyuanModal").modal("hide");
                        _this.findVaild();
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");


        },


        toDelete : function(ppGuanliyuanID){
            var _this = this;
            layer.confirm("确定删除该条管理员信息吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/admin/delete", {
                    guanliyuanID : ppGuanliyuanID,
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

                            _this.findVaild();
                        }
                    }
                },"json");
            })
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
            this.findVaild();
        }
    }

});
