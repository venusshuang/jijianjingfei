package jjjf.controller;


import jjjf.model.Jingfeiyusuan;
import jjjf.model.Zijinbaozhang;
import jjjf.service.JingfeiyusuanService;
import jjjf.service.ZijinbaozhangService;
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
@RequestMapping("zijinbaozhang")
public class ZijinbaozhangController {

    @Resource
    ZijinbaozhangService ddService;
    @Resource
    JingfeiyusuanService ddJingfeiyusuanService;

    public Logger log = LoggerFactory.getLogger(ZijinbaozhangController.class);

    @RequestMapping("findZijinBydeptId")
    public JsonResult<?> findJinzhanBydeptId(@RequestParam("xiangmuname") String ppXiangmuName,
                                             @RequestParam("deptid") String ppDeptId,
                                             @RequestParam("pageindex") int ppPageIndex,
                                             @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppXiangmuName.equals("")) {
                ppXiangmuName = "%" + ppXiangmuName + "%";
            }
            List<Map<String, Object>> mmList=ddService.findZijinbaozhangBydeptId(ppXiangmuName,ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppXiangmuName,ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("ZijinList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);
        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/findZijinBydeptId:error",e);
            return JsonResult.getErrorResult("zijinbaozhang/findZijinBydeptId:error " + e.getMessage());
        }
    }

    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("adminId") String ppadminId,
                             @RequestParam("xiangmuId") String ppxiangmuId,
                             @RequestParam("xiangzhongxinshenqingzijin") Double ppxiangzhongxinshenqingzijin,
                             @RequestParam("shenqingshijian") String ppshenqingshijian,
                             @RequestParam("xianglianbaoshenqingzijin") Double ppxianglianbaoshenqingzijin,
                             @RequestParam("xianglianbaoshenqingbofushijian") String ppxianglianbaoshenqingbofushijian,
                             @RequestParam("lianbaobofujine") Double pplianbaobofujine,
                             @RequestParam("lianbaobofushijian") String pplianbaobofushijian,
                             @RequestParam("zhongxinbofujine") Double ppzhongxinbofujine,
                             @RequestParam("zhongxinbofushijian") String ppzhongxinbofushijian){
        try {

            List<Jingfeiyusuan> mmList=ddJingfeiyusuanService.findJingfeiyusuanByXiangmuId(ppxiangmuId);
            if(mmList.size()!=1) {
                return JsonResult.getErrorResult("获取错误");
            }
            Double mmzhongxinzhibiao=mmList.get(0).getZhongxinjingfeizhibiao();
            Double mmxiangzhongxinshenqingzijin=ppxiangzhongxinshenqingzijin;
            if(Double.doubleToLongBits(mmzhongxinzhibiao) < Double.doubleToLongBits(mmxiangzhongxinshenqingzijin)){
                return JsonResult.getErrorResult("向中心申请资金不能大于中心下达经费指标");
            }

            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");

            Date mmshenqingshijian=simdate.parse(ppshenqingshijian);
            Date mmxianglianbaoshenqingbofushijian=simdate.parse(ppxianglianbaoshenqingbofushijian);
            Date mmlianbaobofushijian=simdate.parse(pplianbaobofushijian);
            Date mmzhongxinbofushijian=simdate.parse(ppzhongxinbofushijian);

            Zijinbaozhang mmZijinbaozhang=new Zijinbaozhang();
            mmZijinbaozhang.setZijinbaozhangid(UUID.randomUUID().toString());
            mmZijinbaozhang.setXiangmuid(ppxiangmuId);
            mmZijinbaozhang.setXiangzhongxinshenqingzijin(ppxiangzhongxinshenqingzijin);
            mmZijinbaozhang.setShenqingshijian(mmshenqingshijian);
            mmZijinbaozhang.setXianglianbaoshenqingzijin(ppxianglianbaoshenqingzijin);
            mmZijinbaozhang.setXianglianbaoshenqingbofushijian(mmxianglianbaoshenqingbofushijian);
            mmZijinbaozhang.setLianbaobofujine(pplianbaobofujine);
            mmZijinbaozhang.setLianbaobofushijian(mmlianbaobofushijian);
            mmZijinbaozhang.setZhongxinbofujine(ppzhongxinbofujine);
            mmZijinbaozhang.setZhongxinbofushijian(mmzhongxinbofushijian);
            mmZijinbaozhang.setCreater(ppadminId);
            mmZijinbaozhang.setCreatetime(new Date());
            mmZijinbaozhang.setModifier(ppadminId);
            mmZijinbaozhang.setLastupdatetime(new Date());
            mmZijinbaozhang.setZhuangtai(100);
            return ddService.add(mmZijinbaozhang)==true? JsonResult.getSuccessResult("新增资金保障情况成功")
                    : JsonResult.getErrorResult("新增资金保障情况失败");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/add:error",e);
            return JsonResult.getErrorResult("zijinbaozhang/add:error " + e.getMessage());
        }
    }

    @RequestMapping("find_one")
    public JsonResult<?> find_one(@RequestParam("zijinbaozhangId") String ppzijinbaozhangId) {
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppzijinbaozhangId));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/find_one:error",e);
            return JsonResult.getErrorResult("zijinbaozhang/find_one:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(@RequestParam("adminId") String ppadminId,
                                @RequestParam("xiangmuId") String ppxiangmuId,
                                @RequestParam("zijinbaozhangId") String ppzijinbaozhangId,
                                @RequestParam("xiangzhongxinshenqingzijin") Double ppxiangzhongxinshenqingzijin,
                                @RequestParam("shenqingshijian") String ppshenqingshijian,
                                @RequestParam("xianglianbaoshenqingzijin") Double ppxianglianbaoshenqingzijin,
                                @RequestParam("xianglianbaoshenqingbofushijian") String ppxianglianbaoshenqingbofushijian,
                                @RequestParam("lianbaobofujine") Double pplianbaobofujine,
                                @RequestParam("lianbaobofushijian") String pplianbaobofushijian,
                                @RequestParam("zhongxinbofujine") Double ppzhongxinbofujine,
                                @RequestParam("zhongxinbofushijian") String ppzhongxinbofushijian){

        try {

            List<Jingfeiyusuan> mmList=ddJingfeiyusuanService.findJingfeiyusuanByXiangmuId(ppxiangmuId);
            if(mmList.size()!=1) {
                return JsonResult.getErrorResult("获取错误");
            }
            Double mmzhongxinzhibiao=mmList.get(0).getZhongxinjingfeizhibiao();
            Double mmxiangzhongxinshenqingzijin=ppxiangzhongxinshenqingzijin;
            if(Double.doubleToLongBits(mmzhongxinzhibiao) < Double.doubleToLongBits(mmxiangzhongxinshenqingzijin)){
                return JsonResult.getErrorResult("向中心申请资金不能大于中心下达经费指标");
            }

            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");

            Date mmshenqingshijian=simdate.parse(ppshenqingshijian);
            Date mmxianglianbaoshenqingbofushijian=simdate.parse(ppxianglianbaoshenqingbofushijian);
            Date mmlianbaobofushijian=simdate.parse(pplianbaobofushijian);
            Date mmzhongxinbofushijian=simdate.parse(ppzhongxinbofushijian);

            Zijinbaozhang mmZijinbaozhang=new Zijinbaozhang();
            mmZijinbaozhang.setZijinbaozhangid(ppzijinbaozhangId);
            mmZijinbaozhang.setXiangzhongxinshenqingzijin(ppxiangzhongxinshenqingzijin);
            mmZijinbaozhang.setShenqingshijian(mmshenqingshijian);
            mmZijinbaozhang.setXianglianbaoshenqingzijin(ppxianglianbaoshenqingzijin);
            mmZijinbaozhang.setXianglianbaoshenqingbofushijian(mmxianglianbaoshenqingbofushijian);
            mmZijinbaozhang.setLianbaobofujine(pplianbaobofujine);
            mmZijinbaozhang.setLianbaobofushijian(mmlianbaobofushijian);
            mmZijinbaozhang.setZhongxinbofujine(ppzhongxinbofujine);
            mmZijinbaozhang.setZhongxinbofushijian(mmzhongxinbofushijian);
            mmZijinbaozhang.setModifier(ppadminId);
            mmZijinbaozhang.setLastupdatetime(new Date());
            mmZijinbaozhang.setZhuangtai(100);
            return ddService.modify(mmZijinbaozhang)==true? JsonResult.getSuccessResult("修改资金保障情况成功")
                    : JsonResult.getErrorResult("修改资金保障情况失败");


        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/modify:error",e);
            return JsonResult.getErrorResult("zijinbaozhang/modify:error " + e.getMessage());
        }

    }


    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("zijinbaozhangId") String ppzijinbaozhangId) {
        try {
            Zijinbaozhang mmZijinbaozhang = ddService.findOne(ppzijinbaozhangId);
            if (mmZijinbaozhang == null) {
                return JsonResult.getErrorResult("资金保障情况不存在!");
            }
            if (!ddService.delete(ppzijinbaozhangId)) {
                return JsonResult.getErrorResult("资金保障情况删除失败!");
            }
            return JsonResult.getSuccessResult("资金保障情况删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/delete:error", e);
            return JsonResult.getErrorResult("zijinbaozhang/delete:error " + e.getMessage());
        }
    }
}
