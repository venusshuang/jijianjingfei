package jjjf.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PageController {


	// 手机端注册
	@RequestMapping("/homepage/register.html")
	public String HomepageRegister() {
		return "phone/manage/register";
	}

	// 手机端登录
	@RequestMapping("/homepage/login.html")
	public String HomepageLogin() {
		return "phone/manage/login";
	}

	// 手机端忘记密码-密码找回
	@RequestMapping("/homepage/forgotPassword.html")
	public String HomepageForgotPassword() {
		return "phone/manage/forgotPassword";
	}

	// 手机端修改密码
	@RequestMapping("/homepage/modifyPassword.html")
	public String ForgotPassword(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/manage/modifyPassword";
	}

	// 判断手机端是否登录
	public boolean isLoginPhone(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("UserId") == null) {
			return false;
		}
		return true;
	}

	// 手机端医生首页
	@RequestMapping("/homepage/index_doctor.html")
	public String IndexDoctor(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/index_doctor";
	}

	// 手机端医生首页
	@RequestMapping("/homepage/index_patient.html")
	public String IndexPatient(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/index_patient";
	}

	// 手机端预约住院
	@RequestMapping("/homepage/yuyuezhuyuan.html")
	public String HomepageYuyuezhuyuan(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/yuyuezhuyuan";
	}

	// 手机端转诊列表
	@RequestMapping("/homepage/zhuanzhen_list.html")
	public String zhuanzhenList(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhuanzhen_list";
	}

	// 手机端新增转诊病例
	@RequestMapping("/homepage/zhuanzhen_edit.html")
	public String zhuanzhenEdit(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		String mmReferraId = request.getParameter("referraid") == null ? "" : request.getParameter("referraid").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);
		map.put("ReferraId", mmReferraId);

		return "phone/homepage/zhuanzhen_edit";
	}

	// 手机端转诊_专家意见
	@RequestMapping("/homepage/zhuanzhen_yijian.html")
	public String zhuanzhenYijian(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		String mmReferraId = request.getParameter("referraid") == null ? "" : request.getParameter("referraid").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);
		map.put("ReferraId", mmReferraId);

		return "phone/homepage/zhuanzhen_yijian";
	}


	// 手机端智慧诊疗
	@RequestMapping("/homepage/zhihuizhenliao.html")
	public String zhihuizhenliao(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhihuizhenliao";
	}

	// 手机端智慧诊疗之营养管理
	@RequestMapping("/homepage/zhzl_yingyangguanli.html")
	public String zhzl_yingyangguanli(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_yingyangguanli";
	}
	
	//手机端智慧诊疗之体表面积
	@RequestMapping("/homepage/zhzl_tbmj.html")
	public String zhzl_tbmj(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_tbmj";
	}
	
	//手机端智慧诊疗之尿肌酐
	@RequestMapping("/homepage/zhzl_njg.html")
	public String zhzl_njg(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_njg";
	}
	
	//手机端智慧诊疗之eGFR
	@RequestMapping("/homepage/zhzl_eGFR.html")
	public String zhzl_eGFR(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_eGFR";
	}
	
	//手机端智慧诊疗之高尿酸血症
	@RequestMapping("/homepage/zhzl_gns.html")
	public String zhzl_gns(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_gns";
	}
	
	//手机端智慧诊疗之EER
	@RequestMapping("/homepage/zhzl_eer.html")
	public String zhzl_eer(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_eer";
	}
	
	//手机端智慧诊疗之sle
	@RequestMapping("/homepage/zhzl_sle.html")
	public String zhzl_sle(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/zhzl_sle";
	}


	// 手机端就诊信息列表
	@RequestMapping("/homepage/jiuzhenxinxi_list.html")
	public String HomepageJiuzhenxinxiList(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();


		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/jiuzhenxinxi_list";
	}

	// 手机端就诊信息编辑
	@RequestMapping("/homepage/jiuzhenxinxi_edit.html")
	public String HomepageJiuzhenxinxiEdit(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);

		return "phone/homepage/jiuzhenxinxi_edit";
	}

	// 手机端预约挂号
	@RequestMapping("/homepage/yuyueguahao.html")
	public String HomepageYuyueguahao(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		String mmJiuzhenxinxiId = request.getParameter("jiuzhenxinxiid") == null ? "" : request.getParameter("jiuzhenxinxiid").toString();

		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);
		map.put("JiuzhenxinxiId", mmJiuzhenxinxiId);

		return "phone/homepage/yuyueguahao";
	}

	// 手机端预约挂号详情
	@RequestMapping("/homepage/yuyueguahao_detail.html")
	public String HomepageYuyueguahaoDetail(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		String mmJiuzhenxinxiId = request.getParameter("jiuzhenxinxiid") == null ? "" : request.getParameter("jiuzhenxinxiid").toString();
		String mmPaibanId = request.getParameter("paibanid") == null ? "" : request.getParameter("paibanid").toString();		map.put("UserType", mmUserType);
		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);
		map.put("JiuzhenxinxiId", mmJiuzhenxinxiId);
		map.put("PaibanId", mmPaibanId);		
		return "phone/homepage/yuyueguahao_detail";
	}

	// 手机端我的预约
	@RequestMapping("/homepage/wodeyuyue_list.html")
	public String HomepageWodeyuyueList(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);

		return "phone/homepage/wodeyuyue_list";
	}

	// 手机端我的消息
	@RequestMapping("/homepage/wodexiaoxi_list.html")
	public String HomepageWodexiaoxiList(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();	

		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);

		return "phone/homepage/wodexiaoxi_list";
	}

	// 手机端我的消息
	@RequestMapping("/homepage/wodexiaoxi_edit.html")
	public String HomepageWodexiaoxiEdit(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();
		String mmId = request.getParameter("id") == null ? "" : request.getParameter("id").toString();	
		String mmType = request.getParameter("type") == null ? "" : request.getParameter("type").toString();
		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);
		map.put("Id", mmId);
		map.put("Type", mmType);

		return "phone/homepage/wodexiaoxi_edit";
	}

	// 手机端中心简介
	@RequestMapping("/homepage/zhongxinjianjie.html")
	public String HomepageZhongxinjianjie(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();	

		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);

		return "phone/homepage/zhongxinjianjie";
	}

	// 手机端精英团队
	@RequestMapping("/homepage/jingyingtuandui.html")
	public String HomepageJingyingtuandui(HttpServletRequest request, ModelMap map) {
		if(!isLoginPhone(request)) {
			return "redirect:/homepage/login.html";
		}

		String mmUserType = request.getSession().getAttribute("UserType").toString();
		String mmUserId = request.getSession().getAttribute("UserId").toString();	

		map.put("UserId", mmUserId);
		map.put("UserType", mmUserType);

		return "phone/homepage/jingyingtuandui";
	}

	// PC管理端
	// 登录
	@RequestMapping("/manage/login.html")
	public String ManageLogin() {
		return "pc/manage/login";
	}

	// 判断PC端是否登录
	public boolean isLoginPC(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session == null || session.getAttribute("AdministratorId") == null) {
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

		String mmRoleType = request.getSession().getAttribute("RoleType").toString();
		String mmAdministratorId = request.getSession().getAttribute("AdministratorId").toString();
		map.put("RoleType", mmRoleType);
		map.put("AdministratorId", mmAdministratorId);

		return "pc/index";
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



}
