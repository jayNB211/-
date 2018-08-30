package com.clps.oas.sm.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月28日 上午10:47:55
 * @version: v1.0
 */
public class Account implements Serializable {

	private static final long serialVersionUID = -4768160831833824746L;

	// 账户id
	private Integer accountId;

	// 帐户名
	private String accountName;

	// 用户姓名
	private String accountRealName;

	// 账户密码
	private String accountPass;

	// 账户邮箱
	private String accountMail;

	// 地址
	private String accountAddress;

	// 手机
	private String accountPhone;

	// 角色
	private Integer accountRoleId;

	// 职位
	private Integer accountPositionId;

	// 公司
	private Integer accountCompanyId;

	// 创建时间
	private Date accountCreatedDatetime;

	// 创建人名
	private String accountCreatedName;

	// 更新时间
	private Date accountUpdatedDatetime;

	// 更新人名
	private String accountUpdatedName;

	// 是否可见
	private Boolean accountIsvalid;

	public Account() {

		super();

	}

	public Account(String accountName, String accountRealName, String accountPass, String accountMail,
			String accountAddress, String accountPhone, Integer accountRoleId, Integer accountPositionId,
			Integer accountCompanyId, Date accountCreatedDatetime, String accountCreatedName,
			Date accountUpdatedDatetime, String accountUpdatedName, Boolean accountIsvalid) {
		super();
		this.accountName = accountName;
		this.accountRealName = accountRealName;
		this.accountPass = accountPass;
		this.accountMail = accountMail;
		this.accountAddress = accountAddress;
		this.accountPhone = accountPhone;
		this.accountRoleId = accountRoleId;
		this.accountPositionId = accountPositionId;
		this.accountCompanyId = accountCompanyId;
		this.accountCreatedDatetime = accountCreatedDatetime;
		this.accountCreatedName = accountCreatedName;
		this.accountUpdatedDatetime = accountUpdatedDatetime;
		this.accountUpdatedName = accountUpdatedName;
		this.accountIsvalid = accountIsvalid;
	}

	public Integer getAccountId() {

		return accountId;
	}

	public void setAccountId(Integer accountId) {

		this.accountId = accountId;
	}

	public String getAccountName() {

		return accountName;
	}

	public void setAccountName(String accountName) {

		this.accountName = accountName;
	}

	public String getAccountRealName() {

		return accountRealName;
	}

	public void setAccountRealName(String accountRealName) {

		this.accountRealName = accountRealName;
	}

	public String getAccountPass() {

		return accountPass;
	}

	public void setAccountPass(String accountPass) {

		this.accountPass = accountPass;
	}

	public String getAccountMail() {

		return accountMail;
	}

	public void setAccountMail(String accountMail) {

		this.accountMail = accountMail;
	}

	public String getAccountAddress() {

		return accountAddress;
	}

	public void setAccountAddress(String accountAddress) {

		this.accountAddress = accountAddress;
	}

	public String getAccountPhone() {

		return accountPhone;
	}

	public void setAccountPhone(String accountPhone) {

		this.accountPhone = accountPhone;
	}

	public Integer getAccountRoleId() {

		return accountRoleId;
	}

	public void setAccountRoleId(Integer accountRoleId) {

		this.accountRoleId = accountRoleId;
	}

	public Integer getAccountPositionId() {

		return accountPositionId;
	}

	public void setAccountPositionId(Integer accountPositionId) {

		this.accountPositionId = accountPositionId;
	}

	public Integer getAccountCompanyId() {

		return accountCompanyId;
	}

	public void setAccountCompanyId(Integer accountCompanyId) {

		this.accountCompanyId = accountCompanyId;
	}

	public Date getAccountCreatedDatetime() {

		return accountCreatedDatetime;
	}

	public void setAccountCreatedDatetime(Date accountCreatedDatetime) {

		this.accountCreatedDatetime = accountCreatedDatetime;
	}

	public String getAccountCreatedName() {

		return accountCreatedName;
	}

	public void setAccountCreatedName(String accountCreatedName) {

		this.accountCreatedName = accountCreatedName;
	}

	public Date getAccountUpdatedDatetime() {

		return accountUpdatedDatetime;
	}

	public void setAccountUpdatedDatetime(Date accountUpdatedDatetime) {

		this.accountUpdatedDatetime = accountUpdatedDatetime;
	}

	public String getAccountUpdatedName() {

		return accountUpdatedName;
	}

	public void setAccountUpdatedName(String accountUpdatedName) {

		this.accountUpdatedName = accountUpdatedName;
	}

	public Boolean getAccountIsvalid() {

		return accountIsvalid;
	}

	public void setAccountIsvalid(Boolean accountIsvalid) {

		this.accountIsvalid = accountIsvalid;
	}

	public static long getSerialversionuid() {

		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", accountRealName=" + accountRealName + ", accountPass="
				+ accountPass + ", accountMail=" + accountMail + ", accountProvince=" + ", accountAddress="
				+ accountAddress + ", accountPhone=" + accountPhone + ", accountTelephone=" + ", accountPositionId="
				+ accountPositionId + ", accountCompanyId=" + accountCompanyId + ", accountCreatedDatetime="
				+ accountCreatedDatetime + ", accountCreatedName=" + accountCreatedName + ", accountUpdatedDatetime="
				+ accountUpdatedDatetime + ", accountUpdatedName=" + accountUpdatedName + ", accountIsvalid="
				+ accountIsvalid + "]";
	}

}