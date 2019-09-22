package com.wj.dao;

import java.util.List;

import com.wj.entity.Priv;

public interface PrivDao {
	/**
	 * 通过管理员id获得管理员所有的权限
	 * @param Aid
	 * @return
	 */
	public List<Priv> selPrivByAid(int aid);
	/**
	 * 通过角色id获得角色所有的权限
	 * @param rid
	 * @return
	 */
	public List<Priv> selPrivByRid(int rid);
	public List<Priv> selAllPrivs();
}
