package jjjf.controller;


import jjjf.model.Gongchengjinzhan;
import jjjf.service.GongchengjinzhanService;
import jjjf.util.DateUtil;
import jjjf.util.JsonResult;
import jjjf.util.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("gongchengjinzhan")
public class GongchengjinzhanController {

    @Resource
    GongchengjinzhanService ddService;
    public Logger log = LoggerFactory.getLogger(GongchengjinzhanController.class);

    @RequestMapping("findJinzhanBydeptId")
    public JsonResult<?> findJinzhanBydeptId(@RequestParam("xiangmuname") String ppXiangmuName,
                                            @RequestParam("deptid") String ppDeptId,
                                            @RequestParam("pageindex") int ppPageIndex,
                                            @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppXiangmuName.equals("")) {
                ppXiangmuName = "%" + ppXiangmuName + "%";
            }
            List<Map<String, Object>> mmList=ddService.findGongchengjinzhanBydeptId(ppXiangmuName,ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppXiangmuName,ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("JinzhaniList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("gongchengjinzhan/findJinzhanBydeptId:error",e);
            return JsonResult.getErrorResult("gongchengjinzhan/findJinzhanBydeptId:error " + e.getMessage());
        }
    }


    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("adminId") String ppadminId,
                             @RequestParam("xiangmuId") String ppxiangmuId,
                             @RequestParam("xiangmuzhuangtaiid") String ppxiangmuzhuangtaiid,
                             @RequestParam("kaigongshijian") String ppkaigongshijian,
                             @RequestParam("hetongzongjia") Double pphetongzongjia,
                             @RequestParam("wangchengtouzi") Double ppwangchengtouzi,
                             @RequestParam("jindukuaizhifu") Double ppjindukuaizhifu,
                             @RequestParam("jindukuanbili") String ppjindukuanbili,
                             @RequestParam("wangongshijian") String ppwangongshijian){

        try {
            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");

            Date mmkaigongshijian=simdate.parse(ppkaigongshijian);
            Date mmwangongshijian=simdate.parse(ppwangongshijian);

            Gongchengjinzhan mmGongchengjinzhan=new Gongchengjinzhan();
            mmGongchengjinzhan.setGongchengjinzhanid(UUID.randomUUID().toString());
            mmGongchengjinzhan.setXiangmuid(ppxiangmuId);
            mmGongchengjinzhan.setXiangmuzhuangtaiid(ppxiangmuzhuangtaiid);
            mmGongchengjinzhan.setKaigongshijian(mmkaigongshijian);
            mmGongchengjinzhan.setHetongzongjia(pphetongzongjia);
            mmGongchengjinzhan.setWangchengtouzi(ppwangchengtouzi);
            mmGongchengjinzhan.setJindukuaizhifu(ppjindukuaizhifu);
            mmGongchengjinzhan.setJindukuanbili(ppjindukuanbili);
            mmGongchengjinzhan.setWangongshijian(mmwangongshijian);
            mmGongchengjinzhan.setCreater(ppadminId);
            mmGongchengjinzhan.setCreatetime(new Date());
            mmGongchengjinzhan.setModifier(ppadminId);
            mmGongchengjinzhan.setLastupdatetime(new Date());
            mmGongchengjinzhan.setZhuangtai(100);

            return ddService.add(mmGongchengjinzhan)==true? JsonResult.getSuccessResult("新增工程进展情况成功")
                    : JsonResult.getErrorResult("新增工程进展情况失败");


        }catch (Exception e) {
            e.printStackTrace();
            log.error("gongchengjinzhan/add:error",e);
            return JsonResult.getErrorResult("gongchengjinzhan/add:error " + e.getMessage());
        }
    }


    @RequestMapping("find_one")
    public JsonResult<?> find_one(@RequestParam("gongchengjinzhanId") String ppgongchengjinzhanId) {
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppgongchengjinzhanId));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("gongchengjinzhan/find_one:error",e);
            return JsonResult.getErrorResult("gongchengjinzhan/find_one:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(@RequestParam("adminId") String ppadminId,
                                @RequestParam("gongchengjinzhanId") String ppgongchengjinzhanId,
                                @RequestParam("xiangmuzhuangtaiid") String ppxiangmuzhuangtaiid,
                                @RequestParam("kaigongshijian") String ppkaigongshijian,
                                @RequestParam("hetongzongjia") Double pphetongzongjia,
                                @RequestParam("wangchengtouzi") Double ppwangchengtouzi,
                                @RequestParam("jindukuaizhifu") Double ppjindukuaizhifu,
                                @RequestParam("jindukuanbili") String ppjindukuanbili,
                                @RequestParam("wangongshijian") String ppwangongshijian){
        try {
            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");

            Date mmkaigongshijian=simdate.parse(ppkaigongshijian);
            Date mmwangongshijian=simdate.parse(ppwangongshijian);

            Gongchengjinzhan mmGongchengjinzhan=new Gongchengjinzhan();
            mmGongchengjinzhan.setGongchengjinzhanid(ppgongchengjinzhanId);
            mmGongchengjinzhan.setXiangmuzhuangtaiid(ppxiangmuzhuangtaiid);
            mmGongchengjinzhan.setKaigongshijian(mmkaigongshijian);
            mmGongchengjinzhan.setHetongzongjia(pphetongzongjia);
            mmGongchengjinzhan.setWangchengtouzi(ppwangchengtouzi);
            mmGongchengjinzhan.setJindukuaizhifu(ppjindukuaizhifu);
            mmGongchengjinzhan.setJindukuanbili(ppjindukuanbili);
            mmGongchengjinzhan.setWangongshijian(mmwangongshijian);
            mmGongchengjinzhan.setModifier(ppadminId);
            mmGongchengjinzhan.setLastupdatetime(new Date());
            mmGongchengjinzhan.setZhuangtai(100);
            return ddService.modify(mmGongchengjinzhan)==true? JsonResult.getSuccessResult("修改工程进展情况成功")
                    : JsonResult.getErrorResult("修改工程进展情况失败");


        }catch (Exception e) {
            e.printStackTrace();
            log.error("gongchengjinzhan/modify:error",e);
            return JsonResult.getErrorResult("gongchengjinzhan/modify:error " + e.getMessage());
        }
    }



    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("gongchengjinzhanId") String ppgongchengjinzhanId) {
        try {
            Gongchengjinzhan mmGongchengjinzhan = ddService.findOne(ppgongchengjinzhanId);
            if (mmGongchengjinzhan==null){
                return JsonResult.getErrorResult("工程进展情况不存在!");
            }
            if (!ddService.delete(ppgongchengjinzhanId)){
                return JsonResult.getErrorResult("工程进展情况删除失败!");
            }
            return JsonResult.getSuccessResult("工程进展情况删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("gongchengjinzhan/delete:error",e);
            return JsonResult.getErrorResult("gongchengjinzhan/delete:error " + e.getMessage());
        }

    }

}
