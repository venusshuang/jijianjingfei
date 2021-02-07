package jjjf.controller;


import jjjf.model.Admin;
import jjjf.service.AdminService;
import jjjf.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    AdminService ddService;

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
