/**    
 * @Title: PositionVo.java  
 * @Package com.clps.oas.util.excel.vo  
 * @Description: 职位信息导入导出部分字段  
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-21 22:00:48
 * @version V1.0    
 */
package com.clps.oas.util.excel.vo;

import java.util.Date;

/**
 * @ClassName: PositionVo
 * @Description: 职位信息导入导出部分字段
 * @author weigion.wu
 * @date 2018-05-21 22:00:48
 */
public class PositionVo {

	private String positionId;					//职位编号

	private String positionName;				//职位名称

	private String positionDescription;			//职位描述

	private String positionLevel;				//职位等级

	private String positionDepartment;			//部门所属部门
	
	private Date positionCreatedDatetime;		//职位创建时间
	
	private String positionCreatedName;			//职位创建人
	
	private Date positionUpdatedDatetime;		//职位更新时间
	
	private String positionUpdatedName;         //职位更新人

	/**
	 * @return the positionId
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId the positionId to set
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * @param positionName the positionName to set
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * @return the positionDescription
	 */
	public String getPositionDescription() {
		return positionDescription;
	}

	/**
	 * @param positionDescription the positionDescription to set
	 */
	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	/**
	 * @return the positionLevel
	 */
	public String getPositionLevel() {
		return positionLevel;
	}

	/**
	 * @param positionLevel the positionLevel to set
	 */
	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	/**
	 * @return the positionDepartment
	 */
	public String getPositionDepartment() {
		return positionDepartment;
	}

	/**
	 * @param positionDepartment the positionDepartment to set
	 */
	public void setPositionDepartment(String positionDepartment) {
		this.positionDepartment = positionDepartment;
	}

	/**
	 * @return the positionCreatedDatetime
	 */
	public Date getPositionCreatedDatetime() {
		return positionCreatedDatetime;
	}

	/**
	 * @param positionCreatedDatetime the positionCreatedDatetime to set
	 */
	public void setPositionCreatedDatetime(Date positionCreatedDatetime) {
		this.positionCreatedDatetime = positionCreatedDatetime;
	}

	/**
	 * @return the positionCreatedName
	 */
	public String getPositionCreatedName() {
		return positionCreatedName;
	}

	/**
	 * @param positionCreatedName the positionCreatedName to set
	 */
	public void setPositionCreatedName(String positionCreatedName) {
		this.positionCreatedName = positionCreatedName;
	}

	/**
	 * @return the positionUpdatedDatetime
	 */
	public Date getPositionUpdatedDatetime() {
		return positionUpdatedDatetime;
	}

	/**
	 * @param positionUpdatedDatetime the positionUpdatedDatetime to set
	 */
	public void setPositionUpdatedDatetime(Date positionUpdatedDatetime) {
		this.positionUpdatedDatetime = positionUpdatedDatetime;
	}

	/**
	 * @return the positionUpdatedName
	 */
	public String getPositionUpdatedName() {
		return positionUpdatedName;
	}

	/**
	 * @param positionUpdatedName the positionUpdatedName to set
	 */
	public void setPositionUpdatedName(String positionUpdatedName) {
		this.positionUpdatedName = positionUpdatedName;
	}

	

	
}
