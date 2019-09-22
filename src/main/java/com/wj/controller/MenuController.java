package com.wj.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wj.entity.Role;
import com.wj.service.RoleService;

@Controller

public class MenuController {
	@Resource
	RoleService roleService;
@RequestMapping("view/index.do")
public String index() {
	
	return "index";
}
@RequestMapping("view/user/user_info.do")
public String user_info() {
	
	return "user/user_info";
}
@RequestMapping("view/user/user_modi_pwd.do")
public String user_modi_pwd() {
	
	return "user/user_modi_pwd";
}
@RequestMapping("view/role/role_list.do")
public String role_list(HttpServletRequest request) {
	
	List<Role> lr  = roleService.showRole();
	request.getSession().setAttribute("roles", lr);
	return "role/role_list";
}
@RequestMapping("view/role/role_add.do")
public String role_add() {
	
	return "role/role_add";
}
@RequestMapping("view/role/role_modi.do")
public String role_modi() {
	
	return "role/role_modi";
}


}
