package com.wj.service.impl;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wj.dao.AdminDao;
import com.wj.dao.PrivDao;
import com.wj.dao.RoleDao;
import com.wj.entity.Admin;
import com.wj.entity.Priv;
import com.wj.entity.Role;
import com.wj.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	AdminDao adminDao;
	@Resource
	PrivDao privDao;
	@Resource
	RoleDao roleDao;
	@Override
	public Admin selectAdmin(Admin admin) {

		//根据用户名和密码查询数据库，查到了将结果封装到admin2中
			Admin ad1 = adminDao.selAdminByNP(admin);
			if(ad1 != null) {
			List<Priv> lp = privDao.selPrivByAid(ad1.getId());
			
			ad1.setLp(lp);
			List<Role> lr = roleDao.selRnameByAid(ad1.getId());
			ad1.setLr(lr);
			}
			//System.out.println(ad1);
			//return adminDao.selAdminByNP(admin);
			return ad1;
		}
		
		
	

	@Override
	public boolean updatePassword(Admin admin) {
		// TODO 自动生成的方法存根
		int i = adminDao.updatePassword(admin);
		if(i>0) return true;
		return false;
	}

	@Override
	public boolean updateAdminMsg(Admin admin) {
		// TODO 自动生成的方法存根
		int i = adminDao.updeteAdminMsg(admin);
		if(i>0) return true;
		return false;
	}
}
