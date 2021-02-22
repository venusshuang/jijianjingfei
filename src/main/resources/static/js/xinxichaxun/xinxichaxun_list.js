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