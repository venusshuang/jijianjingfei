package jjjf.controller;



import jjjf.model.Junjianxiangmu;
import jjjf.service.JunjianxiangmuService;
import jjjf.util.JsonResult;
import jjjf.util.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("junjianxiangmu")
public class JunjianxiangmuContorller {

    @Resource
    JunjianxiangmuService ddService;

    public Logger log = LoggerFactory.getLogger(JunjianxiangmuContorller.class);

    @RequestMapping("findXiangmuBydeptId")
    public JsonResult<?> findVaildByAdminId(@RequestParam("xiangmuname") String ppXiangmuName,
                                            @RequestParam("deptid") String ppDeptId,
                                            @RequestParam("pageindex") int ppPageIndex,
                                            @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppXiangmuName.equals("")) {
                ppXiangmuName = "%" + ppXiangmuName + "%";
            }
            List<Map<String, Object>> mmList=ddService.findXiangmuBydeptId(ppXiangmuName,ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppXiangmuName,ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);

            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("XiangMuList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/findXiangmuBydeptId:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/findXiangmuBydeptId:error " + e.getMessage());
        }
    }


    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("adminId") String ppadminId,
                             @RequestParam("xiangmuname") String ppxiangmuname,
                             @RequestParam("xiangmupifu") String ppxiangmupifu,
                             @RequestParam("lianbaopifujine") Double pplianbaopifujine,
                             @RequestParam("zhongxinpifujine") Double ppzhongxinpifujine,
                             @RequestParam("lianbaoyuliujine") Double pplianbaoyuliujine,
                             @RequestParam("xiangmuleibie") String ppxiangmuleibie,
                             @RequestParam("jieshoudanweiid") String ppjieshoudanweiid,
                             @RequestParam("beizhu") String ppbeizhu){

        try {

            Junjianxiangmu mmJunjianxiangmu=new Junjianxiangmu();
            mmJunjianxiangmu.setXiangmuid(UUID.randomUUID().toString());
            mmJunjianxiangmu.setXiangmuname(ppxiangmuname);
            mmJunjianxiangmu.setXiangmupifu(ppxiangmupifu);
            mmJunjianxiangmu.setLianbaopifujine(pplianbaopifujine);
            mmJunjianxiangmu.setZhongxinpifujine(ppzhongxinpifujine);
            mmJunjianxiangmu.setLianbaoyuliujine(pplianbaoyuliujine);
            mmJunjianxiangmu.setXiangmuleibie(ppxiangmuleibie);
            mmJunjianxiangmu.setJieshoudanweiid(ppjieshoudanweiid);
            mmJunjianxiangmu.setBeizhu(ppbeizhu);
            mmJunjianxiangmu.setCreater(ppadminId);
            mmJunjianxiangmu.setCreatetime(new Date());
            mmJunjianxiangmu.setModifier(ppadminId);
            mmJunjianxiangmu.setLastupdatetime(new Date());
            mmJunjianxiangmu.setZhuangtai(100);

            return ddService.add(mmJunjianxiangmu)==true? JsonResult.getSuccessResult("新增军建计划下达情况成功")
                    : JsonResult.getErrorResult("新增军建计划下达情况失败");


        }catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/add:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/add:error " + e.getMessage());
        }
    }

    @RequestMapping("find_one")
    public JsonResult<?> find_one(@RequestParam("xiangmuid") String ppXiangmuId) {
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppXiangmuId));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/find_one:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/find_one:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(@RequestParam("xiangmuId") String ppxiangmuId,
                                @RequestParam("adminId") String ppadminId,
                                @RequestParam("xiangmuname") String ppxiangmuname,
                                @RequestParam("xiangmupifu") String ppxiangmupifu,
                                @RequestParam("lianbaopifujine") Double pplianbaopifujine,
                                @RequestParam("zhongxinpifujine") Double ppzhongxinpifujine,
                                @RequestParam("lianbaoyuliujine") Double pplianbaoyuliujine,
                                @RequestParam("xiangmuleibie") String ppxiangmuleibie,
                                @RequestParam("jieshoudanweiid") String ppjieshoudanweiid,
                                @RequestParam("beizhu") String ppbeizhu){
        try {
            Junjianxiangmu mmJunjianxiangmu=new Junjianxiangmu();
            mmJunjianxiangmu.setXiangmuid(ppxiangmuId);
            mmJunjianxiangmu.setXiangmuname(ppxiangmuname);
            mmJunjianxiangmu.setXiangmupifu(ppxiangmupifu);
            mmJunjianxiangmu.setLianbaopifujine(pplianbaopifujine);
            mmJunjianxiangmu.setZhongxinpifujine(ppzhongxinpifujine);
            mmJunjianxiangmu.setLianbaoyuliujine(pplianbaoyuliujine);
            mmJunjianxiangmu.setXiangmuleibie(ppxiangmuleibie);
            mmJunjianxiangmu.setJieshoudanweiid(ppjieshoudanweiid);
            mmJunjianxiangmu.setBeizhu(ppbeizhu);
            mmJunjianxiangmu.setCreater(ppadminId);
            mmJunjianxiangmu.setCreatetime(new Date());
            mmJunjianxiangmu.setModifier(ppadminId);
            mmJunjianxiangmu.setLastupdatetime(new Date());
            mmJunjianxiangmu.setZhuangtai(100);
            return ddService.modify(mmJunjianxiangmu)==true? JsonResult.getSuccessResult("修改军建计划下达情况成功")
                    : JsonResult.getErrorResult("修改军建计划下达情况失败");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/modify:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/modify:error " + e.getMessage());
        }
    }




    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("xiangmuid") String ppxiangmuId) {
        try {

            Junjianxiangmu mmJunjianxiangmu=ddService.findOne(ppxiangmuId);
            if (mmJunjianxiangmu==null){
                return JsonResult.getErrorResult("军建计划不存在!");
            }
            if (!ddService.delete(ppxiangmuId)){
                return JsonResult.getErrorResult("军建计划删除失败!");
            }
            return JsonResult.getSuccessResult("军建计划删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/delete:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/delete:error " + e.getMessage());
        }
    }

    @RequestMapping("searchXiangmu")
    public JsonResult<?> searchXiangmu(@RequestParam("xiangmumingcheng") String ppxiangmumingcheng,
                                            @RequestParam("danweimingcheng") String ppdanweimingcheng,
                                            @RequestParam("jihuawenhao") String ppjihuawenhao,
                                            @RequestParam("yusuanwenhao") String ppyusuanwenhao,
                                            @RequestParam("jingfeikemu") String ppjingfeikemu,
                                            @RequestParam("xiangmuzhuangtaiid") String ppxiangmuzhuangtaiid,
                                            @RequestParam("jungongzhuangtaiid") String ppjungongzhuangtaiid,
                                            @RequestParam("jiesuanqingkuangid") String ppjiesuanqingkuangid,
                                            @RequestParam("pageindex") int ppPageIndex,
                                            @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppxiangmumingcheng.equals("")) {
                ppxiangmumingcheng = "%" + ppxiangmumingcheng + "%";
            }
            if(!ppdanweimingcheng.equals("")) {
                ppdanweimingcheng = "%" + ppdanweimingcheng + "%";
            }
            if(!ppjihuawenhao.equals("")) {
                ppjihuawenhao = "%" + ppjihuawenhao + "%";
            }
            if(!ppyusuanwenhao.equals("")) {
                ppyusuanwenhao = "%" + ppyusuanwenhao + "%";
            }
            if(!ppjingfeikemu.equals("")) {
                ppjingfeikemu = "%" + ppjingfeikemu + "%";
            }
            List<Map<String, Object>> mmList=ddService.searchXiangmu(ppxiangmumingcheng,ppdanweimingcheng,
                    ppjihuawenhao,ppyusuanwenhao,ppjingfeikemu,ppxiangmuzhuangtaiid,ppjungongzhuangtaiid,
                    ppjiesuanqingkuangid,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getSearchXiangmuCount(ppxiangmumingcheng,ppdanweimingcheng,
                    ppjihuawenhao,ppyusuanwenhao,ppjingfeikemu,ppxiangmuzhuangtaiid,ppjungongzhuangtaiid,
                    ppjiesuanqingkuangid);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);

            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("SearchxiangmuList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);


        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/findXiangmuBydeptId:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/findXiangmuBydeptId:error " + e.getMessage());
        }
    }




}
