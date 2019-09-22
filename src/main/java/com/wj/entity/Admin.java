package com.wj.entity;



import java.sql.Date;
import java.util.List;



public class Admin {

	private Integer id;	//管理员id
	private String aname;	//管理员姓名
	private String acname;	//管理员账号
	private String apwd;	//管理员密码
	private String atel;	//管理员电话
	private String aemail;	//管理员email
	private String aimg;	//管理员头像
	
	private String createUser;	//创建者
	private Date createTime;	//创建时间
	private String updateUser;	//修改者
	private Date updateTime;	//修改时间
	
	private String by001;	//备用字段1
	private String by002;	//备用字段2
	private int by003;		//备用字段3
	private Date by004;		//备用字段4
	
	private List<Priv> lp;	//管理员权限
	private List<Role> lr;
	public Admin() {}
	
	public String getLr_string() {
		String lr_string = "";
		if(lr != null) {
			for(int i = 0 ; i < lr.size() ;i++) {
				if(i == lr.size()-1)
					lr_string+=lr.get(i).getRname();
				else
					lr_string+=lr.get(i).getRname()+",";
			}
		}
		return lr_string;
	}
	
	public Admin(int id, String aname, String atel, String aemail) {
		this.id = id;
		this.aname = aname;
		this.atel = atel;
		this.aemail = aemail;
	}
		
	
	public Admin(String acname, String apwd) {
		this.acname = acname;
		this.apwd = apwd;
	}

	




	public Admin(Integer id, String apwd) {
		super();
		this.id = id;
		this.apwd = apwd;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAcname() {
		return acname;
	}

	public void setAcname(String acname) {
		this.acname = acname;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public String getAtel() {
		return atel;
	}

	public void setAtel(String atel) {
		this.atel = atel;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getAimg() {
		return aimg;
	}

	public void setAimg(String aimg) {
		this.aimg = aimg;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getBy001() {
		return by001;
	}

	public void setBy001(String by001) {
		this.by001 = by001;
	}

	public String getBy002() {
		return by002;
	}

	public void setBy002(String by002) {
		this.by002 = by002;
	}

	public int getBy003() {
		return by003;
	}

	public void setBy003(int by003) {
		this.by003 = by003;
	}

	public Date getBy004() {
		return by004;
	}

	public void setBy004(Date by004) {
		this.by004 = by004;
	}

	public List<Priv> getLp() {
		return lp;
	}

	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", aname=" + aname + ", acname=" + acname + ", apwd=" + apwd + ", atel=" + atel
				+ ", aemail=" + aemail + ", aimg=" + aimg + ", lp=" + lp + "]";
	}




	public List<Role> getLr() {
		return lr;
	}




	public void setLr(List<Role> lr) {
		this.lr = lr;
	}

}

