/**    
* @Title: DeptWithPositionVo.java  
* @Package com.clps.oas.sm.vo  
* @Description: TODO(用一句话描述该文件做什么)  
* @author leonardo.wang    
* @date 2018年5月24日 下午2:34:08  
* @version V1.0    
*/
package com.clps.oas.sm.vo;

import java.util.Date;

/**
 * @ClassName: DeptWithPositionVo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author leonardo.wang
 * @date 2018年5月24日 下午2:34:08
 * 
 */
public class DeptWithPositionVo {

	private Integer depaNumber;

	private String depaName;

	private String depaFatherNumber;

	private String depaChildNumber;

	private String depaLevel;

	private String depaEmail;

	private String depaComment;

	private String depaCreateName;

	private Date depaCreateDatetime;

	private String depaUpdatedName;

	private Date depaUpdatedDatetime;

	
	
	private Integer positionId;

	private String positionName;

	private String positionDescription;

	private String positionLevel;

	private Integer positionDepartmentId;

	private Date positionCreatedDatetime;

	private Integer positionCreatedName;

	private Date positionUpdatedDatetime;

	private Integer positionUpdatedName;

	private String positionDefault1;

	private String positionDefault2;

	private Integer positionIsvalued;

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public DeptWithPositionVo() {
		super();
	}

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
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
	 * @param positionId
	 * @param positionName
	 * @param positionDescription
	 * @param positionLevel
	 * @param positionDepartmentId
	 * @param positionCreatedDatetime
	 * @param positionCreatedName
	 * @param positionUpdatedDatetime
	 * @param positionUpdatedName
	 * @param positionDefault1
	 * @param positionDefault2
	 * @param positionIsvalued
	 */
	public DeptWithPositionVo(Integer depaNumber, String depaName, String depaFatherNumber, String depaChildNumber,
			String depaLevel, String depaEmail, String depaComment, String depaCreateName, Date depaCreateDatetime,
			String depaUpdatedName, Date depaUpdatedDatetime, Integer positionId, String positionName,
			String positionDescription, String positionLevel, Integer positionDepartmentId,
			Date positionCreatedDatetime, Integer positionCreatedName, Date positionUpdatedDatetime,
			Integer positionUpdatedName, String positionDefault1, String positionDefault2, Integer positionIsvalued) {
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
		this.positionId = positionId;
		this.positionName = positionName;
		this.positionDescription = positionDescription;
		this.positionLevel = positionLevel;
		this.positionDepartmentId = positionDepartmentId;
		this.positionCreatedDatetime = positionCreatedDatetime;
		this.positionCreatedName = positionCreatedName;
		this.positionUpdatedDatetime = positionUpdatedDatetime;
		this.positionUpdatedName = positionUpdatedName;
		this.positionDefault1 = positionDefault1;
		this.positionDefault2 = positionDefault2;
		this.positionIsvalued = positionIsvalued;
	}

	/**
	 * @return the depaNumber
	 */
	public final Integer getDepaNumber() {
		return depaNumber;
	}

	/**
	 * @param depaNumber
	 *            the depaNumber to set
	 */
	public final void setDepaNumber(Integer depaNumber) {
		this.depaNumber = depaNumber;
	}

	/**
	 * @return the depaName
	 */
	public final String getDepaName() {
		return depaName;
	}

	/**
	 * @param depaName
	 *            the depaName to set
	 */
	public final void setDepaName(String depaName) {
		this.depaName = depaName;
	}

	/**
	 * @return the depaFatherNumber
	 */
	public final String getDepaFatherNumber() {
		return depaFatherNumber;
	}

	/**
	 * @param depaFatherNumber
	 *            the depaFatherNumber to set
	 */
	public final void setDepaFatherNumber(String depaFatherNumber) {
		this.depaFatherNumber = depaFatherNumber;
	}

	/**
	 * @return the depaChildNumber
	 */
	public final String getDepaChildNumber() {
		return depaChildNumber;
	}

	/**
	 * @param depaChildNumber
	 *            the depaChildNumber to set
	 */
	public final void setDepaChildNumber(String depaChildNumber) {
		this.depaChildNumber = depaChildNumber;
	}

	/**
	 * @return the depaLevel
	 */
	public final String getDepaLevel() {
		return depaLevel;
	}

	/**
	 * @param depaLevel
	 *            the depaLevel to set
	 */
	public final void setDepaLevel(String depaLevel) {
		this.depaLevel = depaLevel;
	}

	/**
	 * @return the depaEmail
	 */
	public final String getDepaEmail() {
		return depaEmail;
	}

	/**
	 * @param depaEmail
	 *            the depaEmail to set
	 */
	public final void setDepaEmail(String depaEmail) {
		this.depaEmail = depaEmail;
	}

	/**
	 * @return the depaComment
	 */
	public final String getDepaComment() {
		return depaComment;
	}

	/**
	 * @param depaComment
	 *            the depaComment to set
	 */
	public final void setDepaComment(String depaComment) {
		this.depaComment = depaComment;
	}

	/**
	 * @return the depaCreateName
	 */
	public final String getDepaCreateName() {
		return depaCreateName;
	}

	/**
	 * @param depaCreateName
	 *            the depaCreateName to set
	 */
	public final void setDepaCreateName(String depaCreateName) {
		this.depaCreateName = depaCreateName;
	}

	/**
	 * @return the depaCreateDatetime
	 */
	public final Date getDepaCreateDatetime() {
		return depaCreateDatetime;
	}

	/**
	 * @param depaCreateDatetime
	 *            the depaCreateDatetime to set
	 */
	public final void setDepaCreateDatetime(Date depaCreateDatetime) {
		this.depaCreateDatetime = depaCreateDatetime;
	}

	/**
	 * @return the depaUpdatedName
	 */
	public final String getDepaUpdatedName() {
		return depaUpdatedName;
	}

	/**
	 * @param depaUpdatedName
	 *            the depaUpdatedName to set
	 */
	public final void setDepaUpdatedName(String depaUpdatedName) {
		this.depaUpdatedName = depaUpdatedName;
	}

	/**
	 * @return the depaUpdatedDatetime
	 */
	public final Date getDepaUpdatedDatetime() {
		return depaUpdatedDatetime;
	}

	/**
	 * @param depaUpdatedDatetime
	 *            the depaUpdatedDatetime to set
	 */
	public final void setDepaUpdatedDatetime(Date depaUpdatedDatetime) {
		this.depaUpdatedDatetime = depaUpdatedDatetime;
	}

	/**
	 * @return the positionId
	 */
	public final Integer getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId
	 *            the positionId to set
	 */
	public final void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the positionName
	 */
	public final String getPositionName() {
		return positionName;
	}

	/**
	 * @param positionName
	 *            the positionName to set
	 */
	public final void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * @return the positionDescription
	 */
	public final String getPositionDescription() {
		return positionDescription;
	}

	/**
	 * @param positionDescription
	 *            the positionDescription to set
	 */
	public final void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	/**
	 * @return the positionLevel
	 */
	public final String getPositionLevel() {
		return positionLevel;
	}

	/**
	 * @param positionLevel
	 *            the positionLevel to set
	 */
	public final void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	/**
	 * @return the positionDepartmentId
	 */
	public final Integer getPositionDepartmentId() {
		return positionDepartmentId;
	}

	/**
	 * @param positionDepartmentId
	 *            the positionDepartmentId to set
	 */
	public final void setPositionDepartmentId(Integer positionDepartmentId) {
		this.positionDepartmentId = positionDepartmentId;
	}

	/**
	 * @return the positionCreatedDatetime
	 */
	public final Date getPositionCreatedDatetime() {
		return positionCreatedDatetime;
	}

	/**
	 * @param positionCreatedDatetime
	 *            the positionCreatedDatetime to set
	 */
	public final void setPositionCreatedDatetime(Date positionCreatedDatetime) {
		this.positionCreatedDatetime = positionCreatedDatetime;
	}

	/**
	 * @return the positionCreatedName
	 */
	public final Integer getPositionCreatedName() {
		return positionCreatedName;
	}

	/**
	 * @param positionCreatedName
	 *            the positionCreatedName to set
	 */
	public final void setPositionCreatedName(Integer positionCreatedName) {
		this.positionCreatedName = positionCreatedName;
	}

	/**
	 * @return the positionUpdatedDatetime
	 */
	public final Date getPositionUpdatedDatetime() {
		return positionUpdatedDatetime;
	}

	/**
	 * @param positionUpdatedDatetime
	 *            the positionUpdatedDatetime to set
	 */
	public final void setPositionUpdatedDatetime(Date positionUpdatedDatetime) {
		this.positionUpdatedDatetime = positionUpdatedDatetime;
	}

	/**
	 * @return the positionUpdatedName
	 */
	public final Integer getPositionUpdatedName() {
		return positionUpdatedName;
	}

	/**
	 * @param positionUpdatedName
	 *            the positionUpdatedName to set
	 */
	public final void setPositionUpdatedName(Integer positionUpdatedName) {
		this.positionUpdatedName = positionUpdatedName;
	}

	/**
	 * @return the positionDefault1
	 */
	public final String getPositionDefault1() {
		return positionDefault1;
	}

	/**
	 * @param positionDefault1
	 *            the positionDefault1 to set
	 */
	public final void setPositionDefault1(String positionDefault1) {
		this.positionDefault1 = positionDefault1;
	}

	/**
	 * @return the positionDefault2
	 */
	public final String getPositionDefault2() {
		return positionDefault2;
	}

	/**
	 * @param positionDefault2
	 *            the positionDefault2 to set
	 */
	public final void setPositionDefault2(String positionDefault2) {
		this.positionDefault2 = positionDefault2;
	}

	/**
	 * @return the positionIsvalued
	 */
	public final Integer getPositionIsvalued() {
		return positionIsvalued;
	}

	/**
	 * @param positionIsvalued
	 *            the positionIsvalued to set
	 */
	public final void setPositionIsvalued(Integer positionIsvalued) {
		this.positionIsvalued = positionIsvalued;
	}

	/*
	 * <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DeptWithPositionVo [depaNumber=" + depaNumber + ", depaName=" + depaName + ", depaFatherNumber="
				+ depaFatherNumber + ", depaChildNumber=" + depaChildNumber + ", depaLevel=" + depaLevel
				+ ", depaEmail=" + depaEmail + ", depaComment=" + depaComment + ", depaCreateName=" + depaCreateName
				+ ", depaCreateDatetime=" + depaCreateDatetime + ", depaUpdatedName=" + depaUpdatedName
				+ ", depaUpdatedDatetime=" + depaUpdatedDatetime + ", positionId=" + positionId + ", positionName="
				+ positionName + ", positionDescription=" + positionDescription + ", positionLevel=" + positionLevel
				+ ", positionDepartmentId=" + positionDepartmentId + ", positionCreatedDatetime="
				+ positionCreatedDatetime + ", positionCreatedName=" + positionCreatedName
				+ ", positionUpdatedDatetime=" + positionUpdatedDatetime + ", positionUpdatedName="
				+ positionUpdatedName + ", positionDefault1=" + positionDefault1 + ", positionDefault2="
				+ positionDefault2 + ", positionIsvalued=" + positionIsvalued + "]";
	}

}
