package com.wj.dao;

import com.wj.entity.Admin;

public interface AdminDao {
	/**
	 * 根据用户名和密码查询管理员
	 * @return
	 */
	public Admin selAdminByNP(Admin admin);
	public int updatePassword(Admin admin);
	public int updeteAdminMsg(Admin admin);
}
