package com.wj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wj.entity.Priv;
import com.wj.entity.Role;
import com.wj.service.RoleService;

@Controller
public class RoleController {
	@Resource
	RoleService roleService;
	@RequestMapping("privsAction.do")
	public String priv_list(HttpServletRequest request,HttpServletResponse response) throws IOException {
		List<Priv> lp = roleService.getAllPrivs();
		request.getSession().setAttribute("privs", lp);
		return("role/role_add");
		
	}
	@RequestMapping("deleteRoleMsg.do")
	public String deleteRoleMsg(HttpServletRequest request,HttpServletResponse response) {
		String rid = request.getParameter("rid");
		boolean b = roleService.delRole(Integer.parseInt(rid));
		//System.out.println(rid);
		if(b) {
			request.setAttribute("msg", "删除成功");
			return	"role/role_list";
		}else {
			request.setAttribute("msg", "删除失败");
			return  "role/role_list";
		}
		
		
	}
	@RequestMapping("roleAddAction.do")
	public String roleAddAction(HttpServletRequest request,HttpServletResponse response) {
		String rname = request.getParameter("rname");
		String [] Myprivs = request.getParameterValues("myPrivs");
		List<Priv> lp = new ArrayList<>();
		for(String mypriv : Myprivs) {
			Priv pv = new Priv();
			pv.setPid(Integer.parseInt(mypriv));
			lp.add(pv);
		}
		
		Role rl = new Role();
		rl.setRname(rname);
		rl.setLp(lp);
		System.out.println(rl);
		boolean b = roleService.addRole(rl);
		if(b) {
			request.setAttribute("msg", "添加成功");
			return "role/role_list";
			
		}else {
			request.setAttribute("msg", "添加失败");
			return "role/role_add";
		}
		
	}
	@RequestMapping("updateRoleAction.do")
	public String updateRoleAction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
        Role role = roleService.showRoleByRid(Integer.parseInt(rid));
        request.setAttribute("role",role);
        return "role/role_modi";
		
		
	}
	@RequestMapping("updateRoleMsg.do")
	public String updateRoleMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		 	String rid = request.getParameter("rid");
	        String rname = request.getParameter("rname");
	        String[] pids = request.getParameterValues("pids");
	        List<Priv> lp = new ArrayList<>();
	        for (String pid : pids) {
	            lp.add(new Priv(Integer.parseInt(pid)));
	        }
	        boolean b =  roleService.updateRoleByRid(new Role(Integer.parseInt(rid), rname, lp));
	        if(b){
	            request.setAttribute("msg","修改成功！");
	        }else {
	            request.setAttribute("msg","修改失败！");
	        }
	        return "redirect:view/role/role_list.do";
	        //request.getRequestDispatcher("").forward(request,response);
	    }
		
		
	}
		
	


