package com.clps.oas.sm.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
/** 
* @author  noah.zhou 
* @date 创建时间：2018年5月11日 上午10:40:00
* @des  Permission Entity
* @version 1.0 
* @parameter  
* @since  
* @return  
*/

public class Permission implements Serializable {

	private static final long serialVersionUID = -8102237062820932041L;

	private Integer permissionId;// 权限ID

	private String permissionName;// 权限名字

	private String permissionCode;// 权限编码

	private String permissionComment;// 权限描述

	private Timestamp permissionCreatedDateTime;// 权限创建时间

	private Integer permissionCreatedName;// 权限创建人

	private Timestamp permissionUpdatedDateTime;// 权限修改时间

	private Integer permissionUpdatedName;// 权限修改人

	private Integer isVisible;// 是否有效（是否审核通过）

	// 无参构造方法
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Permission(Integer permissionId, String permissionName, String permissionCode, String permissionComment,
			Timestamp permissionCreatedDateTime, Integer permissionCreatedName, Timestamp permissionUpdatedDateTime,
			Integer permissionUpdatedName, Integer isVisible) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionCode = permissionCode;
		this.permissionComment = permissionComment;
		this.permissionCreatedDateTime = permissionCreatedDateTime;
		this.permissionCreatedName = permissionCreatedName;
		this.permissionUpdatedDateTime = permissionUpdatedDateTime;
		this.permissionUpdatedName = permissionUpdatedName;
		this.isVisible = isVisible;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public String getPermissionComment() {
		return permissionComment;
	}

	public void setPermissionComment(String permissionComment) {
		this.permissionComment = permissionComment;
	}

	public Timestamp getPermissionCreatedDateTime() {
		return permissionCreatedDateTime;
	}

	public void setPermissionCreatedDateTime(Timestamp permissionCreatedDateTime) {
		this.permissionCreatedDateTime = permissionCreatedDateTime;
	}

	public Integer getPermissionCreatedName() {
		return permissionCreatedName;
	}

	public void setPermissionCreatedName(Integer permissionCreatedName) {
		this.permissionCreatedName = permissionCreatedName;
	}

	public Timestamp getPermissionUpdatedDateTime() {
		return permissionUpdatedDateTime;
	}

	public void setPermissionUpdatedDateTime(Timestamp permissionUpdatedDateTime) {
		this.permissionUpdatedDateTime = permissionUpdatedDateTime;
	}

	public Integer getPermissionUpdatedName() {
		return permissionUpdatedName;
	}

	public void setPermissionUpdatedName(Integer permissionUpdatedName) {
		this.permissionUpdatedName = permissionUpdatedName;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionCode="
				+ permissionCode + ", permissionComment=" + permissionComment + ", permissionCreatedDateTime="
				+ permissionCreatedDateTime + ", permissionCreatedName=" + permissionCreatedName
				+ ", permissionUpdatedDateTime=" + permissionUpdatedDateTime + ", permissionUpdatedName="
				+ permissionUpdatedName + ", isVisible=" + isVisible + "]";
	}

}