package jjjf.controller;


import jjjf.model.Admin;
import jjjf.model.Dept;
import jjjf.service.AdminService;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    AdminService ddService;
    public Logger log = LoggerFactory.getLogger(JungongjiesuanController.class);

    @RequestMapping("find_one")
    public JsonResult<?> find_one(@RequestParam("adminID") String ppAdminId) {
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppAdminId));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("admin/find_one:error",e);
            return JsonResult.getErrorResult("admin/find_one:error " + e.getMessage());
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(
            @RequestParam("adminID") String ppadminID,
            @RequestParam("account") String ppaccount,
            @RequestParam("password") String pppassword){

        try {

            Admin mmAdmin =ddService.findOne(ppadminID);
            if(mmAdmin==null){
                return JsonResult.getErrorResult("admin/modify:error ");
            }
            mmAdmin.setPassword(pppassword);

            return ddService.modify(mmAdmin) == true ? JsonResult.getSuccessResult("修改密码成功")
                    : JsonResult.getErrorResult("修改密码失败");


        } catch (Exception e) {
            e.printStackTrace();
            log.error("admin/modify:error",e);
            return JsonResult.getErrorResult("admin/modify:error " + e.getMessage());
        }
    }

    @RequestMapping("findSomeByDeptId")
    public JsonResult<?> findSomeByDeptId(@RequestParam("deptID") String ppdeptID) {

        try {
            return JsonResult.getSuccessResult(ddService.findSomeByDeptId(ppdeptID));

        }catch (Exception e) {
            e.printStackTrace();
            log.error("admin/findSomeByDeptId:error",e);
            return JsonResult.getErrorResult("admin/findSomeByDeptId:error " + e.getMessage());
        }
    }
    @RequestMapping("add")
    public JsonResult<?> add(@RequestParam("deptID") String ppdeptID,
                             @RequestParam("adminname") String ppadminname,
                             @RequestParam("contactinformation") String ppcontactinformation,
                             @RequestParam("buzhibie") String ppbuzhibie,
                             @RequestParam("account") String ppaccount,
                             @RequestParam("password") String pppassword,
                             @RequestParam("creator") String ppcreator) {

        try {

            String mmAdminID= UUID.randomUUID().toString();
            Admin mmAdmin =new Admin();
            mmAdmin.setAdminid(mmAdminID);
            mmAdmin.setDeptid(ppdeptID);

            mmAdmin.setCreator(ppcreator);
            mmAdmin.setCreatetime(new Date());
            mmAdmin.setZhuangtai(100);



            BooleanMessage mmBooleanMessage = checkInputData(mmAdmin,ppadminname,ppcontactinformation,ppbuzhibie,ppaccount,pppassword);
            if (!mmBooleanMessage.isOk()) {
                log.error("admin/add:error",mmBooleanMessage.getMessage().toString());
                return JsonResult.getErrorResult(mmBooleanMessage.getMessage().toString());
            }

            return ddService.add(mmAdmin) == true ? JsonResult.getSuccessResult("新增用户成功")
                    : JsonResult.getErrorResult("新增用户失败");

        } catch (Exception e) {
            e.printStackTrace();
            log.error("admin/add:error",e);
            return JsonResult.getErrorResult("admin/add:error " + e.getMessage());
        }

    }

    private BooleanMessage checkInputData(Admin ppAdmin,String ppadminname,
                                          String ppcontactinformation,
                                          String ppbuzhibie,
                                          String ppaccount,
                                          String pppassword ) {


        if (StringHandle.getStringByteLength(ppadminname) > 255) {
            return BooleanMessage.getErrorMessage("管理员姓名不能超过255字节");
        }
        if (StringHandle.getStringByteLength(ppcontactinformation) > 255) {
            return BooleanMessage.getErrorMessage("联系方式不能超过255字节");
        }
        if(ppcontactinformation.length() != 11) {
            return BooleanMessage.getErrorMessage("保存失败！联系方式长度必须为11位数。");
        }
        Pattern pattern = Pattern.compile("[0-9]*");
        if (!pattern.matcher(ppcontactinformation.toString()).matches()) {
            return BooleanMessage.getErrorMessage("保存失败！联系方式只能为正整数");
        }
        if (StringHandle.getStringByteLength(ppbuzhibie) > 255) {
            return BooleanMessage.getErrorMessage("部职别不能超过255字节");
        }
        if (StringHandle.getStringByteLength(ppaccount) > 255) {
            return BooleanMessage.getErrorMessage("账号不能超过255字节");
        }
        if (StringHandle.getStringByteLength(pppassword) > 255) {
            return BooleanMessage.getErrorMessage("密码不能超过255字节");
        }

        if (ddService.checkAccount(ppaccount)) {
            return BooleanMessage.getErrorMessage("账号已存在，请重新输入！");
        }

        ppAdmin.setAdminname(ppadminname);
        ppAdmin.setContactinformation(ppcontactinformation);
        ppAdmin.setBuzhibie(ppbuzhibie);
        ppAdmin.setAccount(ppaccount);
        ppAdmin.setPassword(pppassword);



        return BooleanMessage.getSuccessMessage(ppAdmin);

    }

    @RequestMapping("delete")
    public JsonResult<?> delete(@RequestParam("adminID") String ppadminID) {
        try {
            return ddService.delete(ppadminID) == true ? JsonResult.getSuccessResult("删除用户信息成功")
                    : JsonResult.getErrorResult("删除单位信息失败");
        }catch (Exception e) {
            e.printStackTrace();
            log.error("admin/delete:error",e);
            return JsonResult.getErrorResult("admin/delete:error " + e.getMessage());
        }
    }

    //登录
    @RequestMapping("login")
    public JsonResult<?> login(
            @RequestParam("account") String ppLoginName,
            @RequestParam("password") String ppLoginPassword,
            HttpServletRequest request){
        try {
            ppLoginName = ppLoginName.trim();
            ppLoginPassword = ppLoginPassword.trim();

            Admin mmAdmin = ddService.login(ppLoginName,ppLoginPassword);
            // 登录失败
            if(mmAdmin == null) {
                return JsonResult.getErrorResult("登录失败！登录名密码错误或账号无效!");
            }
            // 登录成功,记录session
            HttpSession session = request.getSession();
            session.setAttribute("ADMINID", mmAdmin.getAdminid());
            session.setAttribute("DEPTID", mmAdmin.getDeptid());
            return JsonResult.getSuccessResult("登录成功");

        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("登录失败！"+e);
        }
    }

    //登出
    @RequestMapping("logout")
    public boolean logout(
            HttpServletRequest request){
        try {
            HttpSession session = request.getSession();
            session.removeAttribute("ADMINID");
            session.removeAttribute("RoleType");
            return true;

        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
