package com.wj.dao;

import java.util.List;

import com.wj.entity.Role;

public interface RoleDao {

	/**
	 * 查询所有的角色
	 * @return
	 */
	public List<Role> selRoleById(int rid);
	public List<Role> selAllRole();
	public List<Role> selRnameByAid(int aid);
	public int addRole(Role role);
	public int addRolePrivs(Role role);
	public int deleteRoles(int rid);
	public int deleteRlPriv(int  rid);
	public int updateRl(Role role);
	public Role selRoleByRid(int rid);
	public int updateRoleByRid(Role role);
	public int delRoPrByRid(Role role);
	public int insertRoPr(Role role);
	
	
}

