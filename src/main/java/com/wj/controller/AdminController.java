package com.wj.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wj.entity.Admin;
import com.wj.service.AdminService;
//this is a first modify！
@Controller
public class AdminController {
	
	@Resource
	AdminService adminService;
	@RequestMapping("/login.do")
	public String login(Admin admin,HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		admin.setAcname(username);
		admin.setApwd(password);
		Admin ad = (Admin)adminService.selectAdmin(admin);
		System.out.println(ad);
		if(ad == null) {
			request.setAttribute("admin", admin);
			request.setAttribute("msg", "用户名或者密码错误");
			return "forward:login.jsp";
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("admin1",ad );
			return "index";
			}
		
	}
	@RequestMapping("/exitAction.do")
	public void exitAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		String path = request.getServletContext().getContextPath();
		response.sendRedirect(path+"/login.jsp");
		
	}
	@RequestMapping("/updateAction.do")
	public String updateAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String oldpwd = request.getParameter("oldpassword");
		String newpwd = request.getParameter("newpassword");
		String id = request.getParameter("id");
		
		Admin admin = (Admin) request.getSession().getAttribute("admin1");
		System.out.println(admin);
		if(oldpwd.equals(admin.getApwd())) {
			admin.setApwd(newpwd);
			//AdminService admins = new AdminServiceImpl();
			boolean i = adminService.updatePassword(new Admin(Integer.parseInt(id),newpwd));
			if(i) {
				request.getSession().setAttribute("Admin",admin);
				return "forward:login.jsp";
				
			}
			else {
				request.setAttribute("msg","对不起，密码修改失败");
				return "user/user_modi_pwd";
			}
		}
		else {
				request.setAttribute("msg", "输入密码错误");
				return "user/user_modi_pwd";
		}
		
		
	}
	@RequestMapping("/updateAdminMsgAction.do")
	public void updateAdminMsgAction(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String id = request.getParameter("aid");
		String aname = request.getParameter("aname");
		String atel = request.getParameter("atel");
		String aemail = request.getParameter("aemail");
		
		//修改session的值
		Admin ad = (Admin) request.getSession().getAttribute("admin1");
		ad.setAname(aname);
		ad.setAtel(atel);
		ad.setAemail(aemail);
		request.getSession().setAttribute("admin", ad);
		
		boolean b =  adminService.updateAdminMsg(new Admin(Integer.parseInt(id),aname,atel,aemail));
		if(b)
			response.getWriter().print("ok");
		else
			response.getWriter().print("fail");
	}
		
		
	
}
