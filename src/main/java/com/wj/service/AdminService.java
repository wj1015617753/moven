package com.wj.service;


import com.wj.entity.*;

public interface AdminService {
	/**
	 * 检查用户输入的信息，登陆成功将用户和权限绑定
	 * @param admin
	 * @return
	 */
	public Admin selectAdmin(Admin admin);
	public boolean updatePassword(Admin admin); 
	public boolean updateAdminMsg(Admin admin);
}




