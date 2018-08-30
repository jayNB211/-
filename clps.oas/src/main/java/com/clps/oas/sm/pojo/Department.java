package com.clps.oas.sm.pojo;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable {
	/**
	 * 串行化
	 */
	private static final long serialVersionUID = 8187544886599426829L;

	// 部门编号
	private Integer depaNumber;

	// 部门名称
	private String depaName;

	// 上级部门编号
	private String depaFatherNumber;

	// 下级部门编号
	private String depaChildNumber;

	// 部门等级
	private String depaLevel;

	// 部门邮箱
	private String depaEmail;

	// 部门描述
	private String depaComment;

	// 部门创建人名
	private String depaCreateName;

	// 部门创建时间
	private Date depaCreateDatetime;

	// 部门更新时间
	private String depaUpdatedName;

	// 部门更新时间
	private Date depaUpdatedDatetime;
	
	private Account account;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 * @Title: getDepaNumber @param @return @return Integer @throws
	 */
	public Integer getDepaNumber() {
		return depaNumber;
	}

	/**
	 * 
	 * @Title: setDepaNumber @param @param depaNumber @return void @throws
	 */
	public void setDepaNumber(Integer depaNumber) {
		this.depaNumber = depaNumber;
	}

	/**
	 * 
	 * @Title: getDepaName @param @return @return String @throws
	 */
	public String getDepaName() {
		return depaName;
	}

	/**
	 * 
	 * @Title: setDepaName @param @param depaName @return void @throws
	 */
	public void setDepaName(String depaName) {
		this.depaName = depaName;
	}

	/**
	 * 
	 * @Title: getDepaFatherNumber @param @return @return String @throws
	 */
	public String getDepaFatherNumber() {
		return depaFatherNumber;
	}

	/**
	 * 
	 * @Title: setDepaFatherNumber @param @param depaFatherNumber @return
	 * void @throws
	 */
	public void setDepaFatherNumber(String depaFatherNumber) {
		this.depaFatherNumber = depaFatherNumber;
	}

	/**
	 * 
	 * @Title: getDepaChildNumber @param @return @return String @throws
	 */
	public String getDepaChildNumber() {
		return depaChildNumber;
	}

	/**
	 * 
	 * @Title: setDepaChildNumber @param @param depaChildNumber @return
	 * void @throws
	 */
	public void setDepaChildNumber(String depaChildNumber) {
		this.depaChildNumber = depaChildNumber;
	}

	/**
	 * 
	 * @Title: getDepaLevel @param @return @return String @throws
	 */
	public String getDepaLevel() {
		return depaLevel;
	}

	/**
	 * 
	 * @Title: setDepaLevel @param @param depaLevel @return void @throws
	 */
	public void setDepaLevel(String depaLevel) {
		this.depaLevel = depaLevel;
	}

	/**
	 * 
	 * @Title: getDepaEmail @param @return @return String @throws
	 */
	public String getDepaEmail() {
		return depaEmail;
	}

	/**
	 * 
	 * @Title: setDepaEmail @param @param depaEmail @return void @throws
	 */
	public void setDepaEmail(String depaEmail) {
		this.depaEmail = depaEmail;
	}

	/**
	 * 
	 * @Title: getDepaComment @param @return @return String @throws
	 */
	public String getDepaComment() {
		return depaComment;
	}

	/**
	 * 
	 * @Title: setDepaComment @param @param depaComment @return void @throws
	 */
	public void setDepaComment(String depaComment) {
		this.depaComment = depaComment;
	}

	/**
	 * 
	 * @Title: getDepaCreateName @param @return @return String @throws
	 */
	public String getDepaCreateName() {
		return depaCreateName;
	}

	/**
	 * 
	 * @Title: setDepaCreateName @param @param depaCreateName @return
	 * void @throws
	 */
	public void setDepaCreateName(String depaCreateName) {
		this.depaCreateName = depaCreateName;
	}

	/**
	 * 
	 * @Title: getDepaCreateDatetime @param @return @return Date @throws
	 */
	public Date getDepaCreateDatetime() {
		return depaCreateDatetime;
	}

	/**
	 * 
	 * @Title: setDepaCreateDatetime @param @param depaCreateDatetime @return
	 * void @throws
	 */
	public void setDepaCreateDatetime(Date depaCreateDatetime) {
		this.depaCreateDatetime = depaCreateDatetime;
	}

	/**
	 * 
	 * @Title: getDepaUpdatedName @param @return @return String @throws
	 */
	public String getDepaUpdatedName() {
		return depaUpdatedName;
	}

	/**
	 * 
	 * @Title: setDepaUpdatedName @param @param depaUpdatedName @return
	 * void @throws
	 */
	public void setDepaUpdatedName(String depaUpdatedName) {
		this.depaUpdatedName = depaUpdatedName;
	}

	/**
	 * 
	 * @Title: getDepaUpdatedDatetime @param @return @return Date @throws
	 */
	public Date getDepaUpdatedDatetime() {
		return depaUpdatedDatetime;
	}

	/**
	 * 
	 * @Title: setDepaUpdatedDatetime @param @param depaUpdatedDatetime @return
	 * void @throws
	 */
	public void setDepaUpdatedDatetime(Date depaUpdatedDatetime) {
		this.depaUpdatedDatetime = depaUpdatedDatetime;
	}

	
	
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Department(Integer depaNumber, String depaName, String depaFatherNumber, String depaChildNumber,
			String depaLevel, String depaEmail, String depaComment, String depaCreateName, Date depaCreateDatetime,
			String depaUpdatedName, Date depaUpdatedDatetime, Account account) {
		super();
		this.depaNumber = depaNumber;
		this.depaName = depaName;
		this.depaFatherNumber = depaFatherNumber;
		this.depaChildNumber = depaChildNumber;
		this.depaLevel = depaLevel;
		this.depaEmail = depaEmail;
		this.depaComment = depaComment;
		this.depaCreateName = depaCreateName;
		this.depaCreateDatetime = depaCreateDatetime;
		this.depaUpdatedName = depaUpdatedName;
		this.depaUpdatedDatetime = depaUpdatedDatetime;
		this.account = account;
	}

	/**
	 * @param depaNumber
	 * @param depaName
	 * @param depaFatherNumber
	 * @param depaChildNumber
	 * @param depaLevel
	 * @param depaEmail
	 * @param depaComment
	 * @param depaCreateName
	 * @param depaCreateDatetime
	 * @param depaUpdatedName
	 * @param depaUpdatedDatetime
	 */
	public Department(Integer depaNumber, String depaName, String depaFatherNumber, String depaChildNumber,
			String depaLevel, String depaEmail, String depaComment, String depaCreateName, Date depaCreateDatetime,
			String depaUpdatedName, Date depaUpdatedDatetime) {
		super();
		this.depaNumber = depaNumber;
		this.depaName = depaName;
		this.depaFatherNumber = depaFatherNumber;
		this.depaChildNumber = depaChildNumber;
		this.depaLevel = depaLevel;
		this.depaEmail = depaEmail;
		this.depaComment = depaComment;
		this.depaCreateName = depaCreateName;
		this.depaCreateDatetime = depaCreateDatetime;
		this.depaUpdatedName = depaUpdatedName;
		this.depaUpdatedDatetime = depaUpdatedDatetime;
	}

	/**
	 * 构造方法
	 */
	public Department() {
		super();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [depaNumber=" + depaNumber + ", depaName=" + depaName + ", depaFatherNumber="
				+ depaFatherNumber + ", depaChildNumber=" + depaChildNumber + ", depaLevel=" + depaLevel
				+ ", depaEmail=" + depaEmail + ", depaComment=" + depaComment + ", depaCreateName=" + depaCreateName
				+ ", depaCreateDatetime=" + depaCreateDatetime + ", depaUpdatedName=" + depaUpdatedName
				+ ", depaUpdatedDatetime=" + depaUpdatedDatetime + "]";
	}

}