var Xinxichaxun = new Vue({

    el : '#Xinxichaxun',
    data :{
        adminId : $("#adminid").val(),
        deptId : $("#deptid").val(),
        s_danweimingcheng:'',
        s_xiangmumingcheng:'',
        s_jihuawenhao:'',
        s_yusuanwenhao:'',
        s_jingfeikemu:'',
        s_xiangmuzhuangtaiid:'',
        s_jungongzhuangtaiid:'',
        s_jiesuanqingkuangid:'',
        searchxiangmulist:[],

        xiangmuzhuangtailist:[],
        jiesuanzhuangtailist:[],
        jiesuanqingkuanglist:[],

        pageIndex : 1,
        pageSize : 10,
        pageCount : 0,
        recordCount : 0,
        inputPageIndexValue : "",

    },
    created : function() {
        var _this = this;
        $("#searchresult").hide();
        _this.bindXiangmuzhuangtaiList();
        _this.bindJiesuanzhuangtaiList();
        _this.bindJiesuanqingkuangList();
    },
    methods : {

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

        bindXiangmuList:function (){
            var _this = this;
            layer.open({type:3});
            $.post("/junjianxiangmu/searchXiangmu",{
                xiangmumingcheng :_this.s_xiangmumingcheng,
                danweimingcheng : _this.s_danweimingcheng,
                jihuawenhao : _this.s_jihuawenhao,
                yusuanwenhao : _this.s_yusuanwenhao,
                jingfeikemu : _this.s_jingfeikemu,
                xiangmuzhuangtaiid : _this.s_xiangmuzhuangtaiid,
                jungongzhuangtaiid : _this.s_jungongzhuangtaiid,
                jiesuanqingkuangid : _this.s_jiesuanqingkuangid,
                pageindex : _this.pageIndex,
                pagesize : _this.pageSize,
                rdm : Math.random()
            },function(ppData){
                layer.closeAll("loading");
                if (ppData != null){
                    if(ppData.result == "1"){
                        var data=ppData.resultContent;


                        if(data.SearchxiangmuList.length > 0){
                            $("#searchresult").show();
                            _this.searchxiangmulist=data.SearchxiangmuList;

                            var PageInfo = data.PageInfo;
                            _this.pageIndex = PageInfo.pageIndex;
                            _this.recordCount = PageInfo.recordCount;
                            _this.pageCount = PageInfo.pageCount;

                        }else {
                            $("#searchresult").hide();
                            layer.alert("未查询到符合条件数据！");

                        }

                    }else{
                        layer.alert(ppData.message);
                    }
                }

            },"json");
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