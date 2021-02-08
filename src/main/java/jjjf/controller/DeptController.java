package jjjf.controller;



import jjjf.model.Dept;
import jjjf.service.DeptService;
import jjjf.util.BooleanMessage;
import jjjf.util.JsonResult;
import jjjf.util.PageInfo;
import jjjf.util.StringHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("dept")
public class DeptController {
    @Resource
    DeptService ddService;
    public Logger log = LoggerFactory.getLogger(JungongjiesuanController.class);

    //有效单位
    @RequestMapping("findVaild")
    public JsonResult<?> findvaild(@RequestParam("pageindex") int ppPageIndex,
                                   @RequestParam("pagesize") int ppPageSize){
        try {
            List<Map<String, Object>> mmList=ddService.findVaild(ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountByisvalid();
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);

            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("DanweiList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("dept/findvaild:error " + e.getMessage());
        }
    }

    @RequestMapping("findOne")
    public JsonResult<?> findOne(@RequestParam("deptId") String ppdeptId){
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppdeptId));
        }catch (Exception e){
            e.printStackTrace();
            log.error("dept/findOne:error",e);
            return JsonResult.getErrorResult("dept/findOne:error " + e.getMessage());
        }
    }
    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("deptname") String ppdeptname,
                             @RequestParam("depttype") String ppdepttype) {

        try {

            String mmDeptId= UUID.randomUUID().toString();
            Dept mmDept =new Dept();
            mmDept.setDeptid(mmDeptId);
            mmDept.setCreatetime(new Date());



            BooleanMessage mmBooleanMessage = checkInputData(mmDept,ppdeptname,ppdepttype);
            if (!mmBooleanMessage.isOk()) {
                log.error("admin/add:error",mmBooleanMessage.getMessage().toString());
                return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
            }

            return ddService.add(mmDept) == true ? JsonResult.getSuccessResult("新增单位信息成功")
                    : JsonResult.getErrorResult("新增单位信息失败");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("dept/add:error",e);
            return JsonResult.getErrorResult("dept/add:error " + e.getMessage());
        }

    }
    private BooleanMessage checkInputData(Dept ppDept,String ppdeptname,String ppdepttype) {


        if (StringHandle.getStringByteLength(ppdeptname) > 255) {
            return BooleanMessage.getErrorMessage("单位名称不能超过255字节");
        }
        if (StringHandle.getStringByteLength(ppdepttype) > 255) {
            return BooleanMessage.getErrorMessage("单位类型不能超过255字节");
        }



        ppDept.setDeptname(ppdeptname);
        ppDept.setDepttype(ppdepttype);


        return BooleanMessage.getSuccessMessage(ppDept);

    }


}