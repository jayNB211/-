package com.clps.oas.sm.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/** 
* @description  this is des
* @author  noah.zhou 
* @date 创建时间：2018年5月29日 下午1:49:52 
* @version 1.0 
*/
public class PermissionVO implements Serializable{

	private static final long serialVersionUID = 3965236543742239451L;

	private Integer permissionId;//权限ID
	
	private String permissionName;//权限名字

    private String permissionCode;//权限编码

    private String permissionComment;//权限描述

    private Timestamp permissionCreatedDateTime;//权限创建时间
    
    private Integer permissionCreatedName;//权限创建人
    
    private Timestamp permissionUpdatedDateTime;//权限修改时间
    
    private Integer permissionUpdatedName;//权限修改人
    
	public PermissionVO() {
		super();
	}

	public PermissionVO(Integer permissionId, String permissionName, String permissionCode, String permissionComment,
			Timestamp permissionCreatedDateTime, Integer permissionCreatedName, Timestamp permissionUpdatedDateTime,
			Integer permissionUpdatedName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionCode = permissionCode;
		this.permissionComment = permissionComment;
		this.permissionCreatedDateTime = permissionCreatedDateTime;
		this.permissionCreatedName = permissionCreatedName;
		this.permissionUpdatedDateTime = permissionUpdatedDateTime;
		this.permissionUpdatedName = permissionUpdatedName;
	}

	public PermissionVO(String permissionName, String permissionCode, String permissionComment,
			Timestamp permissionCreatedDateTime, Integer permissionCreatedName, Timestamp permissionUpdatedDateTime,
			Integer permissionUpdatedName) {
		super();
		this.permissionName = permissionName;
		this.permissionCode = permissionCode;
		this.permissionComment = permissionComment;
		this.permissionCreatedDateTime = permissionCreatedDateTime;
		this.permissionCreatedName = permissionCreatedName;
		this.permissionUpdatedDateTime = permissionUpdatedDateTime;
		this.permissionUpdatedName = permissionUpdatedName;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PermissionVO [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionCode="
				+ permissionCode + ", permissionComment=" + permissionComment + ", permissionCreatedDateTime="
				+ permissionCreatedDateTime + ", permissionCreatedName=" + permissionCreatedName
				+ ", permissionUpdatedDateTime=" + permissionUpdatedDateTime + ", permissionUpdatedName="
				+ permissionUpdatedName + "]";
	}


}
