package com.itek.entity;

/**
 * User用户实体类
 * 
 * @author zhangyu
 * @date 2016年8月24日
 */
public class User {

	private Integer id; // 用户id
	private String userName;// 用户名
	private String password;// 密码
	private String trueName;// 真实名
	private String email;// 邮箱
	private String phone;// 电话
	private String roleName;// 角色名

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
