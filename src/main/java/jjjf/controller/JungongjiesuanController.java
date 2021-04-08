package jjjf.controller;

import jjjf.model.Admin;
import jjjf.model.Jingfeiyusuan;
import jjjf.model.Jungongjiesuan;
import jjjf.service.AdminService;
import jjjf.service.JingfeiyusuanService;
import jjjf.service.JungongjiesuanService;
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
@RequestMapping("jungongjiesuan")
public class JungongjiesuanController {

    @Resource
    JungongjiesuanService ddService;
    @Resource
    JingfeiyusuanService ddJingfeiyusuanService;
    @Resource
    AdminService ddAdminService;

    public Logger log = LoggerFactory.getLogger(JungongjiesuanController.class);

    @RequestMapping("findjiesuanBydeptId")
    public JsonResult<?> findjiesuanBydeptId(@RequestParam("xiangmuname") String ppXiangmuName,
                                             @RequestParam("deptid") String ppDeptId,
                                             @RequestParam("pageindex") int ppPageIndex,
                                             @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppXiangmuName.equals("")) {
                ppXiangmuName = "%" + ppXiangmuName + "%";
            }
            List<Map<String, Object>> mmList=ddService.findJungongjiesuanBydeptId(ppXiangmuName,ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppXiangmuName,ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("JiesuanList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("jungongjiesuan/findjiesuanBydeptId:error",e);
            return JsonResult.getErrorResult("jungongjiesuan/findjiesuanBydeptId:error " + e.getMessage());
        }
    }
    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("adminId") String ppadminId,
                             @RequestParam("xiangmuId") String ppxiangmuId,
                             @RequestParam("jiesuanzhuangtaiid") String ppjiesuanzhuangtaiid,
                             @RequestParam("jiesuanwanchengtime") String ppjiesuanwanchengtime,
                             @RequestParam("jiesuanqingkuangid") String ppjiesuanqingkuangid,
                             @RequestParam("shifoujizhang") int ppshifoujizhang,
                             @RequestParam("jiesuanpifuwenhao") String ppjiesuanpifuwenhao,
                             @RequestParam("jiesuanpifujine") Double ppjiesuanpifujine,
                             @RequestParam("jieyushangjiaojine") Double ppjieyushangjiaojine){
        try {

            List<Jingfeiyusuan> mmList=ddJingfeiyusuanService.findJingfeiyusuanByXiangmuId(ppxiangmuId);
            if(mmList.size()!=1) {
                return JsonResult.getErrorResult("获取中心下达经费指标失败");
            }
            Admin mmAdmin = ddAdminService.findOne(ppadminId);
            //admin选择结算状态为【已结算】时计算
            if(mmAdmin.getDeptid().equals("1")&&ppjiesuanzhuangtaiid.equals("3")){
                Double mmzhongxinzhibiao=mmList.get(0).getZhongxinjingfeizhibiao();
                Double mmjiesuanpifujine=ppjiesuanpifujine;
                Double mmjieyushangjiaojine=ppjieyushangjiaojine;
                Double mmjysj=mmzhongxinzhibiao-mmjiesuanpifujine;
                if(!(Double.doubleToLongBits(mmjysj) == Double.doubleToLongBits(mmjieyushangjiaojine))){
                    return JsonResult.getErrorResult("结余上缴金额不符合要求，应为"+mmjysj+"万元!");
                }
            }



           SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");


            Jungongjiesuan mmJungongjiesuan=new Jungongjiesuan();
            mmJungongjiesuan.setJungongjiesuanid(UUID.randomUUID().toString());
            mmJungongjiesuan.setXiangmuid(ppxiangmuId);
            mmJungongjiesuan.setJiesuanzhuangtaiid(ppjiesuanzhuangtaiid);
            if(!ppjiesuanwanchengtime.equals("")){
                Date mmjiesuanwanchengtime=simdate.parse(ppjiesuanwanchengtime);
                mmJungongjiesuan.setJiesuanwanchengtime(mmjiesuanwanchengtime);
            }


            mmJungongjiesuan.setJiesuanqingkuangid(ppjiesuanqingkuangid);
            mmJungongjiesuan.setShifoujizhang(ppshifoujizhang);
            mmJungongjiesuan.setJiesuanpifuwenhao(ppjiesuanpifuwenhao);
            mmJungongjiesuan.setJiesuanpifujine(ppjiesuanpifujine);
            mmJungongjiesuan.setJieyushangjiaojine(ppjieyushangjiaojine);
            mmJungongjiesuan.setCreator(ppadminId);
            mmJungongjiesuan.setCreatetime(new Date());
            mmJungongjiesuan.setModifier(ppadminId);
            mmJungongjiesuan.setLastupdatetime(new Date());
            mmJungongjiesuan.setZhuangtai(100);
            return ddService.add(mmJungongjiesuan)==true? JsonResult.getSuccessResult("新增竣工结算和决算情况成功")
                    : JsonResult.getErrorResult("新增竣工结算和决算情况失败");


        }catch (Exception e) {
            e.printStackTrace();
            log.error("jungongjiesuan/add:error",e);
            return JsonResult.getErrorResult("jungongjiesuan/add:error " + e.getMessage());
        }
    }


    @RequestMapping("find_one")
    public JsonResult<?> findOne(@RequestParam("jungongjiesuanId") String ppjungongjiesuanId){
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppjungongjiesuanId));
        }catch (Exception e){
            e.printStackTrace();
            log.error("jungongjiesuan/findOne:error",e);
            return JsonResult.getErrorResult("jungongjiesuan/findOne:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(@RequestParam("adminId") String ppadminId,
                                @RequestParam("xiangmuId") String ppxiangmuId,
                                @RequestParam("jungongjiesuanId") String ppjungongjiesuanId,
                                @RequestParam("jiesuanzhuangtaiid") String ppjiesuanzhuangtaiid,
                                @RequestParam("jiesuanwanchengtime") String ppjiesuanwanchengtime,
                                @RequestParam("jiesuanqingkuangid") String ppjiesuanqingkuangid,
                                @RequestParam("shifoujizhang") int ppshifoujizhang,
                                @RequestParam("jiesuanpifuwenhao") String ppjiesuanpifuwenhao,
                                @RequestParam("jiesuanpifujine") Double ppjiesuanpifujine,
                                @RequestParam("jieyushangjiaojine") Double ppjieyushangjiaojine){

        try {
            List<Jingfeiyusuan> mmList=ddJingfeiyusuanService.findJingfeiyusuanByXiangmuId(ppxiangmuId);
            if(mmList.size()!=1) {
                return JsonResult.getErrorResult("获取错误");
            }
            Admin mmAdmin = ddAdminService.findOne(ppadminId);

            //admin选择结算状态为【已结算】时计算
            if(mmAdmin.getDeptid().equals("1")&&ppjiesuanzhuangtaiid.equals("3")){
                Double mmzhongxinzhibiao=mmList.get(0).getZhongxinjingfeizhibiao();
                Double mmjiesuanpifujine=ppjiesuanpifujine;
                Double mmjieyushangjiaojine=ppjieyushangjiaojine;
                Double mmjysj=mmzhongxinzhibiao-mmjiesuanpifujine;
                if(!(Double.doubleToLongBits(mmjysj) == Double.doubleToLongBits(mmjieyushangjiaojine))){
                    return JsonResult.getErrorResult("结余上缴金额不符合要求，应为"+mmjysj+"万元!");
                }
            }


            SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");

            Jungongjiesuan mmJungongjiesuan=new Jungongjiesuan();
            mmJungongjiesuan.setJungongjiesuanid(ppjungongjiesuanId);
            mmJungongjiesuan.setJiesuanzhuangtaiid(ppjiesuanzhuangtaiid);
            if(!ppjiesuanwanchengtime.equals("")){
                Date  mmjiesuanwanchengtime=simdate.parse(ppjiesuanwanchengtime);
                mmJungongjiesuan.setJiesuanwanchengtime(mmjiesuanwanchengtime);
            }
            mmJungongjiesuan.setJiesuanqingkuangid(ppjiesuanqingkuangid);
            mmJungongjiesuan.setShifoujizhang(ppshifoujizhang);
            mmJungongjiesuan.setJiesuanpifuwenhao(ppjiesuanpifuwenhao);
            mmJungongjiesuan.setJiesuanpifujine(ppjiesuanpifujine);
            mmJungongjiesuan.setJieyushangjiaojine(ppjieyushangjiaojine);
            mmJungongjiesuan.setModifier(ppadminId);
            mmJungongjiesuan.setLastupdatetime(new Date());
            mmJungongjiesuan.setZhuangtai(100);
            return ddService.modify(mmJungongjiesuan)==true? JsonResult.getSuccessResult("修改竣工结算和决算情况成功")
                    : JsonResult.getErrorResult("修改竣工结算和决算情况失败");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/modify:error",e);
            return JsonResult.getErrorResult("zijinbaozhang/modify:error " + e.getMessage());
        }

    }

    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("jungongjiesuanId") String ppjungongjiesuanId) {
        try {

            Jungongjiesuan mmJungongjiesuan=ddService.findOne(ppjungongjiesuanId);
            if (mmJungongjiesuan == null) {
                return JsonResult.getErrorResult("竣工结算和决算情况不存在!");
            }
            if (!ddService.delete(ppjungongjiesuanId)) {
                return JsonResult.getErrorResult("竣工结算和决算情况删除失败!");
            }
            return JsonResult.getSuccessResult("竣工结算和决算情况删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("zijinbaozhang/delete:error", e);
            return JsonResult.getErrorResult("zijinbaozhang/delete:error " + e.getMessage());
        }
    }

}
