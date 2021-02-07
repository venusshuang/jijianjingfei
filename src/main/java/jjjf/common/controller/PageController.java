package jjjf.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {

	// PC管理端
	// 登录
	@RequestMapping("/manage/login.html")
	public String ManageLogin() {
		return "manage/login";
	}

	// 判断PC端是否登录
	public boolean isLoginPC(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("ADMINID") == null) {
			return false;
		}
		return true;
	}

	// 首页
	@RequestMapping("/index.html")
	public String index(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmAdminId = request.getSession().getAttribute("ADMINID").toString();
		String mmDeptId = request.getSession().getAttribute("DEPTID").toString();
		map.put("AdminID", mmAdminId);
		map.put("DeptID", mmDeptId);
		return "index";
	}

	// 欢迎页
	@RequestMapping("/welcome.html")
	public String welcome(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);

		return "pc/welcome";
	}

	// 专家管理
	@RequestMapping("/expert/main_expert.html")
	public String MainExpert(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/expert/main_expert";
	}
	
	// 仪表盘
	@RequestMapping("/guahao/yibiaopan.html")
	public String Yibiaopan(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/guahao/yibiaopan";
	}

	// 周排班管理
	@RequestMapping("/paibanguanli/main_schedule.html")
	public String MainSchedule(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/paibanguanli/main_schedule";
	}

	// 排班管理
	@RequestMapping("/paibanguanli/main_paibanguanli.html")
	public String MainPaiBanGuanLi(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/paibanguanli/main_paibanguanli";
	}

	// 黑名单管理
	@RequestMapping("/black/main_black.html")
	public String MainBlack(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/black/main_black";
	}

	// 患者管理
	@RequestMapping("/patient/main_patient.html")
	public String MainPatient(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/patient/main_patient";
	}

	// 医生管理
	@RequestMapping("/doctor/main_doctor.html")
	public String MainDoctor(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/doctor/main_doctor";
	}

	// 角色管理
	@RequestMapping("/administrator/main_role.html")
	public String MainRole(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/administrator/main_role";
	}

	// 账号列表
	@RequestMapping("/administrator/main_administrator.html")
	public String MainAdministrator(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/administrator/main_administrator";
	}

	// 信息发布管理
	@RequestMapping("/info/main_info.html")
	public String MainInfo(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/info/infomanage";
	}

	// 挂号
	@RequestMapping("/guahao/main_guahao.html")
	public String MainGuahao(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);

		return "pc/guahao/main_guahao";
	}

	// 住院
	@RequestMapping("/zhuyuan/main_zhuyuan.html")
	public String MainZhuyuan(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);
		return "pc/zhuyuan/main_zhuyuan";
	}

	// 转诊
	@RequestMapping("/zhuanzhen/zhuanzhen.html")
	public String Zhuanzhen(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);

		return "pc/zhuanzhen/zhuanzhen_list";
	}

	// 小工具
	@RequestMapping("/tool/tool.html")
	public String Tool(HttpServletRequest request, ModelMap map) {
		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);

		return "pc/tool/tool";
	}


	//军建计划下达情况
	@RequestMapping("/gongchenguanli/junjianxiada.html")
	public String Junjianxiada(HttpServletRequest request, ModelMap map) {

		if(!isLoginPC(request)) {
			return "redirect:/manage/login.html";
		}

		String mmAdminId = request.getSession().getAttribute("ADMINID").toString();
		String mmDeptId = request.getSession().getAttribute("DEPTID").toString();
		map.put("AdminID", mmAdminId);
		map.put("DeptID", mmDeptId);



		return "gongchenguanli/junjianxiada_list";

	}

}
