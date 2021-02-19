package jjjf.controller;


import jjjf.model.Jingfeiyusuan;
import jjjf.service.JingfeiyusuanService;
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
@RequestMapping("jingfeiyusuan")
public class JingfeiyusuanController {

    @Resource
    JingfeiyusuanService ddService;
    public Logger log = LoggerFactory.getLogger(JingfeiyusuanController.class);

    @RequestMapping("findJingfeiBydeptId")
    public JsonResult<?> findVaildByAdminId(@RequestParam("xiangmuname") String ppXiangmuName,
                                            @RequestParam("deptid") String ppDeptId,
                                            @RequestParam("pageindex") int ppPageIndex,
                                            @RequestParam("pagesize") int ppPageSize) {
        try {
            if(!ppXiangmuName.equals("")) {
                ppXiangmuName = "%" + ppXiangmuName + "%";
            }

            List<Map<String, Object>> mmList=ddService.findJingfeiyusuanBydeptId(ppXiangmuName,ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppXiangmuName,ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);
            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("JingFeiList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("jingfeiyusuan/findJingfeiBydeptId:error",e);
            return JsonResult.getErrorResult("jingfeiyusuan/findJingfeiBydeptId:error " + e.getMessage());
        }
    }

    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("adminId") String ppadminId,
                             @RequestParam("xiangmuId") String ppxiangmuId,
                             @RequestParam("jingfeixiadaqingkuang") String ppjingfeixiadaqingkuang,
                             @RequestParam("yusuanniandu") String ppyusuanniandu,
                             @RequestParam("lianbaojingfeizhibiao") Double pplianbaojingfeizhibiao,
                             @RequestParam("zhongxinjingfeizhibiao") Double ppzhongxinjingfeizhibiao,
                             @RequestParam("zhongxinyuliujine") Double ppzhongxinyuliujine,
                             @RequestParam("zhongxinkuaijihao") String ppzhongxinkuaijihao,
                             @RequestParam("chengshoujingfeidanwei") String ppchengshoujingfeidanwei,
                             @RequestParam("jingfeikemu") String ppjingfeikemu){
        try {
            Jingfeiyusuan mmJingfeiyusuan=new Jingfeiyusuan();
            mmJingfeiyusuan.setJingfeiyuansuanid(UUID.randomUUID().toString());
            mmJingfeiyusuan.setXiangmuid(ppxiangmuId);
            mmJingfeiyusuan.setJingfeixiadaqingkuang(ppjingfeixiadaqingkuang);
            mmJingfeiyusuan.setYusuanniandu(ppyusuanniandu);
            mmJingfeiyusuan.setLianbaojingfeizhibiao(pplianbaojingfeizhibiao);
            mmJingfeiyusuan.setZhongxinjingfeizhibiao(ppzhongxinjingfeizhibiao);
            mmJingfeiyusuan.setZhongxinyuliujine(ppzhongxinyuliujine);
            mmJingfeiyusuan.setZhongxinkuaijihao(ppzhongxinkuaijihao);
            mmJingfeiyusuan.setChengshoujingfeidanwei(ppchengshoujingfeidanwei);
            mmJingfeiyusuan.setJingfeikemu(ppjingfeikemu);
            mmJingfeiyusuan.setCreater(ppadminId);
            mmJingfeiyusuan.setCreatetime(new Date());
            mmJingfeiyusuan.setModifier(ppadminId);
            mmJingfeiyusuan.setLastupdatetime(new Date());
            mmJingfeiyusuan.setZhuangtai(100);

            return ddService.add(mmJingfeiyusuan)==true? JsonResult.getSuccessResult("新增经费预算下达情况成功")
                    : JsonResult.getErrorResult("新增经费预算下达情况失败");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("jingfeiyusuan/add:error",e);
            return JsonResult.getErrorResult("jingfeiyusuan/add:error " + e.getMessage());
        }
    }

    @RequestMapping("find_one")
    public JsonResult<?> find_one(@RequestParam("jingfeiyusuanId") String ppjingfeiyusuanId) {
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppjingfeiyusuanId));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("jingfeiyusuan/find_one:error",e);
            return JsonResult.getErrorResult("jingfeiyusuan/find_one:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(@RequestParam("adminId") String ppadminId,
                                @RequestParam("jingfeiyusuanId") String ppjingfeiyusuanId,
                                @RequestParam("jingfeixiadaqingkuang") String ppjingfeixiadaqingkuang,
                                @RequestParam("yusuanniandu") String ppyusuanniandu,
                                @RequestParam("lianbaojingfeizhibiao") Double pplianbaojingfeizhibiao,
                                @RequestParam("zhongxinjingfeizhibiao") Double ppzhongxinjingfeizhibiao,
                                @RequestParam("zhongxinyuliujine") Double ppzhongxinyuliujine,
                                @RequestParam("zhongxinkuaijihao") String ppzhongxinkuaijihao,
                                @RequestParam("chengshoujingfeidanwei") String ppchengshoujingfeidanwei,
                                @RequestParam("jingfeikemu") String ppjingfeikemu){

        try {
            Jingfeiyusuan mmJingfeiyusuan=new Jingfeiyusuan();
            mmJingfeiyusuan.setJingfeiyuansuanid(ppjingfeiyusuanId);
            mmJingfeiyusuan.setJingfeixiadaqingkuang(ppjingfeixiadaqingkuang);
            mmJingfeiyusuan.setYusuanniandu(ppyusuanniandu);
            mmJingfeiyusuan.setLianbaojingfeizhibiao(pplianbaojingfeizhibiao);
            mmJingfeiyusuan.setZhongxinjingfeizhibiao(ppzhongxinjingfeizhibiao);
            mmJingfeiyusuan.setZhongxinyuliujine(ppzhongxinyuliujine);
            mmJingfeiyusuan.setZhongxinkuaijihao(ppzhongxinkuaijihao);
            mmJingfeiyusuan.setChengshoujingfeidanwei(ppchengshoujingfeidanwei);
            mmJingfeiyusuan.setJingfeikemu(ppjingfeikemu);
            mmJingfeiyusuan.setModifier(ppadminId);
            mmJingfeiyusuan.setLastupdatetime(new Date());
            mmJingfeiyusuan.setZhuangtai(100);

            return ddService.modify(mmJingfeiyusuan)==true? JsonResult.getSuccessResult("修改经费预算下达情况成功")
                    : JsonResult.getErrorResult("修改经费预算下达情况失败");



        }catch (Exception e) {
            e.printStackTrace();
            log.error("jingfeiyusuan/modify:error",e);
            return JsonResult.getErrorResult("jingfeiyusuan/modify:error " + e.getMessage());
        }


    }


    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("jingfeiyusuanId") String ppjingfeiyusuanId) {
        try {
            Jingfeiyusuan mmJingfeiyusuan=ddService.findOne(ppjingfeiyusuanId);
            if (mmJingfeiyusuan==null){
                return JsonResult.getErrorResult("经费预算不存在!");
            }
            if (!ddService.delete(ppjingfeiyusuanId)){
                return JsonResult.getErrorResult("经费预算删除失败!");
            }
            return JsonResult.getSuccessResult("经费预算删除成功!");

        }catch (Exception e) {
            e.printStackTrace();
            log.error("jingfeiyusuan/delete:error",e);
            return JsonResult.getErrorResult("jingfeiyusuan/delete:error " + e.getMessage());
        }
    }

}
