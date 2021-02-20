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
    public JsonResult<?> findOne(@RequestParam("deptID") String ppdeptID){
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppdeptID));
        }catch (Exception e){
            e.printStackTrace();
            log.error("dept/findOne:error",e);
            return JsonResult.getErrorResult("dept/findOne:error " + e.getMessage());
        }
    }
    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("deptname") String ppdeptname,
                             @RequestParam("depttype") String ppdepttype,
                             @RequestParam("shangjideptid") String ppshangjideptid,
                             @RequestParam("creator") String ppcreator) {

        try {

            String mmDeptId= UUID.randomUUID().toString();
            Dept mmDept =new Dept();
            mmDept.setDeptid(mmDeptId);
            mmDept.setShangjideptid(ppshangjideptid);
            mmDept.setCreator(ppcreator);
            mmDept.setCreatetime(new Date());
            mmDept.setZhuangtai(100);



            BooleanMessage mmBooleanMessage = checkInputData(mmDept,ppdeptname,ppdepttype);
            if (!mmBooleanMessage.isOk()) {
                log.error("dept/add:error",mmBooleanMessage.getMessage().toString());
                return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
            }
            if (ddService.checkDeptname(ppdeptname)) {
                return JsonResult.getErrorResult("单位名称已存在，请重新输入！");
            }
            mmDept.setDeptname(ppdeptname);
            mmDept.setDepttype(ppdepttype);

            return ddService.add(mmDept) == true ? JsonResult.getSuccessResult("新增单位信息成功")
                    : JsonResult.getErrorResult("新增单位信息失败");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("dept/add:error",e);
            return JsonResult.getErrorResult("dept/add:error " + e.getMessage());
        }

    }
    @RequestMapping("modify")
    public JsonResult<?> modify(
            @RequestParam("deptid") String ppdeptid,
            @RequestParam("deptname") String ppdeptname,
            @RequestParam("depttype") String ppdepttype,
            @RequestParam("modifier") String ppmodifier){

        try {


            Dept mmDept =ddService.findOne(ppdeptid);
            if(mmDept==null){
                return JsonResult.getErrorResult("dept/modify:error ");
            }

            mmDept.setModifier(ppmodifier);
            mmDept.setLastupdatetime(new Date());


            BooleanMessage mmBooleanMessage = checkInputData(mmDept,ppdeptname,ppdepttype);
            if (!mmBooleanMessage.isOk()) {
                log.error("dept/modify:error",mmBooleanMessage.getMessage().toString());
                return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
            }
            if (ddService.checkDeptnameBydeptid(ppdeptname,ppdeptid)) {
                return JsonResult.getErrorResult("单位名称已存在，请重新输入！");
            }
            mmDept.setDeptname(ppdeptname);
            mmDept.setDepttype(ppdepttype);
            return ddService.modify(mmDept) ? JsonResult.getSuccessResult("修改成功")
                    : JsonResult.getErrorResult("修改失败");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("dept/modify:error",e);
            return JsonResult.getErrorResult("dept/modify:error " + e.getMessage());
        }
    }

    private BooleanMessage checkInputData(Dept ppDept,String ppdeptname,String ppdepttype) {


        if (StringHandle.getStringByteLength(ppdeptname) > 255) {
            return BooleanMessage.getErrorMessage("单位名称不能超过255字节");
        }
        if (StringHandle.getStringByteLength(ppdepttype) > 255) {
            return BooleanMessage.getErrorMessage("单位类型不能超过255字节");
        }

        return BooleanMessage.getSuccessMessage("验证通过");

    }
    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("deptID") String ppdeptID) {
        try {
            return ddService.delete(ppdeptID) == true ? JsonResult.getSuccessResult("删除单位信息成功")
                    : JsonResult.getErrorResult("删除单位信息失败");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("dept/delete:error",e);
            return JsonResult.getErrorResult("dept/delete:error " + e.getMessage());
        }
    }




}
