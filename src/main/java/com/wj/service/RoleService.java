package com.wj.service;

import java.util.List;

import com.wj.entity.Priv;
import com.wj.entity.Role;

public interface RoleService {
	/**
	 * 得到所有的角色，并将角色和角色所拥有的权限一一绑定
	 * @return
	 */
	public List<Role> showRole();
	public List<Role> getRoleById(int rid);
	public List<Priv> getAllPrivs();
	public boolean addRole(Role role);
	public boolean delRole(int rid);
	public boolean updateRole(Role role);
	public Role showRoleByRid(int rid);
	public boolean updateRoleByRid(Role role);
	
}
