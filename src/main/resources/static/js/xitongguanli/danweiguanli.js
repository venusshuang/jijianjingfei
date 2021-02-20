var DanWei = new Vue({

    el : '#Danweilist',
    data :{

        adminID : $("#AdminID").val(),
        deptID : $("#DeptID").val(),
        danwei : {},
        danweilist : [],
        admin : {},
        adminlist : [],


        editFlag : 0,					// 0:新增，1：修改
        show : false,					// 显示列表是否有数据

        pageIndex : 1,
        pageSize :6,
        pageCount : 0,
        recordCount : 0,
        inputPageIndexValue : "",


    },
    created : function() {

        this.findVaild();

    },
    methods : {
        toSeeYonghu : function(ppdeptID){

            $("#yonghuModal").modal();
            $("#chakanModalLabel").html("查看用户");
            this.deptID=ppdeptID;
            this.adminlist = [];
            this.toBindadminlist();

        },
        toBindadminlist : function(){

            var _this = this;
            layer.open({type:3});

            $.post('/admin/findSomeByDeptId', {
                deptID : _this.deptID,
                rdm:Math.random()
            },function(ppData) {
                layer.closeAll("loading");
                if (ppData != null) {

                    if(ppData.result == "1"){
                        _this.adminlist = ppData.resultContent;
                    }
                }
            },"json");
        },
        toAddYonghu : function(ppdeptID){

            $("#xinzengModal").modal();
            $("#xinzengModalLabel").html("新增用户");
            this.deptID=ppdeptID;
            this.admin={};

        },
        addYonghu: function(){
            var _this = this;

            if (!$.trim(_this.admin.adminname)) {
                layer.alert("请填写管理员姓名！");
                return false;
            }

            if (!$.trim(_this.admin.contactinformation)) {
                layer.alert("请填写联系方式！");
                return false;
            }
            if (!$.trim(_this.admin.buzhibie)) {
                layer.alert("请填写部职别！");
                return false;
            }
            if (!$.trim(_this.admin.account)) {
                layer.alert("请填写账号！");
                return false;
            }
            if (!$.trim(_this.admin.password)) {
                layer.alert("请填写密码！");
                return false;
            }

            layer.open({type:3});
            $.post('/admin/add',{
                deptID : _this.deptID,
                adminname:$.trim(_this.admin.adminname),
                contactinformation:$.trim(_this.admin.contactinformation),
                buzhibie:$.trim(_this.admin.buzhibie),
                account:$.trim(_this.admin.account),
                password:$.trim(_this.admin.password),
                creator:$.trim(_this.adminID),

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
                        $("#xinzengModal").modal("hide");
                        _this.toBindadminlist();

                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");

        },




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
                        _this.danwei = data;
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
                shangjideptid:$.trim(_this.deptID),
                creator:$.trim(_this.adminID),

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





        toModify : function(ppDeptID){
            $("#danweiModal").modal();
            this.editFlag = 1;
            $("#myModalLabel").html("修改单位信息");

            this.deptId=ppDeptID;
            this.danwei = {};
            this.bindDanwei();
        },

        modify : function(){
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
            $.post('/dept/modify',{
                deptid:_this.deptId,
                deptname:$.trim(_this.danwei.deptname),
                depttype:$.trim(_this.danwei.depttype),
                modifier:$.trim(_this.adminID),


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
                        $("#danweiModal").modal("hide");
                        _this.findVaild();
                    }else{
                        layer.alert(ppData.message);
                    }
                }
            },"json");


        },


        toDelete : function(ppDeptID){
            var _this = this;
            layer.confirm("确定删除该条单位信息吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/dept/delete", {
                    deptID : ppDeptID,
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
        toDeleteYonghu : function(ppAdminId){
            var _this = this;
            layer.confirm("确定删除该条用户信息吗？",{
                btn : ['是','否']
            },function(){
                layer.open({type:3});

                $.post("/admin/delete", {
                    adminID : ppAdminId,
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

                            _this.toBindadminlist();
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
