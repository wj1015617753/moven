package com.wj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wj.dao.PrivDao;
import com.wj.dao.RoleDao;
import com.wj.entity.Priv;
import com.wj.entity.Role;
import com.wj.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	RoleDao roleDao ;
	@Resource
	PrivDao privDao ;
	public List<Role> showRole() {
		List<Role> lr = roleDao.selAllRole();
		for (Role role : lr) {
			List<Priv> lp = privDao.selPrivByRid(role.getRid());
			role.setLp(lp);
		}
		
		return lr;
	}

	@Override
	public List<Role> getRoleById(int rid) {
		List<Role> role = roleDao.selRoleById(rid);
		List<Priv> lp = privDao.selPrivByRid(rid);
		((Role) role).setLp(lp);
		return role;
	}
	

	
	public List<Priv> getAllPrivs() {
		// TODO 自动生成的方法存根
		return privDao.selAllPrivs();
	}

	@Override
	public boolean addRole(Role role) {
		// TODO 自动生成的方法存根
			int i = 0;
			roleDao.addRole(role);
			for(Priv lr : role.getLp()) {
				role.setPid(lr.getPid());
				i+=roleDao.addRolePrivs(role);
			}
		
	
		return i>0?true:false;
		
	}

	@Override
	public boolean delRole(int rid) {
		// TODO 自动生成的方法存根
		int r = roleDao.deleteRlPriv(rid);
		int p = roleDao.deleteRoles(rid);
		return r+p>=2?true:false;
		
	}

	@Override
	public boolean updateRole(Role role) {
		// TODO 自动生成的方法存根
		int r = roleDao.updateRl(role);
		int p = roleDao.deleteRlPriv(role.getRid());
		int rp = roleDao.addRolePrivs(role);
		return r+p+rp>=3?true:false;
	}

	public Role showRoleByRid(int rid) {
		// TODO 自动生成的方法存根
		Role role = roleDao.selRoleByRid(rid);
		List<Priv> lp = privDao.selPrivByRid(rid);
		role.setLp(lp);
		return role;
	}

	public boolean updateRoleByRid(Role role) {
		int i = roleDao.updateRoleByRid(role);
		int j = roleDao.delRoPrByRid(role);
		int k = 0;
		Role r = new Role();
		for (Priv priv : role.getLp()) {
			r.setRid(role.getRid());
			r.setPid(priv.getPid());
			k += roleDao.insertRoPr(r);
		}
		return i > 0 && j > 0 && k > 0 ? true : false;
	}

}

