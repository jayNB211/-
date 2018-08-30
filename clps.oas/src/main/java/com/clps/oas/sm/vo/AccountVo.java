package com.clps.oas.sm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月28日 上午10:50:05
 * @version: v1.0
 */
public class AccountVo implements Serializable {

	private static final long serialVersionUID = 7527578179768927181L;

	// 账号id
	private String accountId;

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
	private String accountRoleName;

	// 职位
	private String accountPositionName;

	// 部门
	private String accountDepartmentName;

	// 公司
	private String accountCompanyId;

	// 创建时间
	private Date accountCreatedDatetime;

	// 创建人名
	private String accountCreatedName;

	// 修改时间
	private Date accountUpdatedDatetime;

	// 更新人名
	private String accountUpdatedName;

	// 是否可见
	private Boolean accountIsvalid;

	public AccountVo() {
		super();
	}

	public AccountVo(String accountName, String accountRealName, String accountPass, String accountMail,
			String accountAddress, String accountPhone, String accountRoleName, String accountPositionName,
			String accountDepartmentName, String accountCompanyId, Date accountCreatedDatetime,
			String accountCreatedName, Date accountUpdatedDatetime, String accountUpdatedName, Boolean accountIsvalid) {
		super();
		this.accountName = accountName;
		this.accountRealName = accountRealName;
		this.accountPass = accountPass;
		this.accountMail = accountMail;
		this.accountAddress = accountAddress;
		this.accountPhone = accountPhone;
		this.accountRoleName = accountRoleName;
		this.accountPositionName = accountPositionName;
		this.accountDepartmentName = accountDepartmentName;
		this.accountCompanyId = accountCompanyId;
		this.accountCreatedDatetime = accountCreatedDatetime;
		this.accountCreatedName = accountCreatedName;
		this.accountUpdatedDatetime = accountUpdatedDatetime;
		this.accountUpdatedName = accountUpdatedName;
		this.accountIsvalid = accountIsvalid;
	}

	public String getAccountId() {

		return accountId;
	}

	public void setAccountId(String accountId) {

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

	public String getAccountRoleName() {

		return accountRoleName;
	}

	public void setAccountRoleName(String accountRoleName) {

		this.accountRoleName = accountRoleName;
	}

	public String getAccountPositionName() {

		return accountPositionName;
	}

	public void setAccountPositionName(String accountPositionName) {

		this.accountPositionName = accountPositionName;
	}

	public String getAccountDepartmentName() {

		return accountDepartmentName;
	}

	public void setAccountDepartmentName(String accountDepartmentName) {

		this.accountDepartmentName = accountDepartmentName;
	}

	public String getAccountCompanyId() {

		return accountCompanyId;
	}

	public void setAccountCompanyId(String accountCompanyId) {

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
		return "AccountVo [accountName=" + accountName + ", accountRealName=" + accountRealName + ", accountPass="
				+ accountPass + ", accountMail=" + accountMail + ", accountAddress=" + accountAddress
				+ ", accountPhone=" + accountPhone + ", accountTelephone=" + ", accountRoleName=" + accountRoleName
				+ ", accountPositionName=" + accountPositionName + ", accountDepartmentName=" + accountDepartmentName
				+ ", accountCompanyId=" + accountCompanyId + ", accountCreatedDatetime=" + accountCreatedDatetime
				+ ", accountCreatedName=" + accountCreatedName + ", accountUpdatedDatetime=" + accountUpdatedDatetime
				+ ", accountUpdatedName=" + accountUpdatedName + ", accountIsvalid=" + accountIsvalid + "]";
	}

}
