/**    
 * @Title: DepartmentVo.java  
 * @Package com.clps.oas.util.excel.vo  
 * @Description: departmentVo前台使用
 * @author weigion.wu(吴跟强)    
 * @date  2018-06-04 13:33:57
 * @version V1.0    
 */
package com.clps.oas.util.excel.vo;

/**
 * @ClassName: DepartmentVo
 * @Description: departmentVo前台使用
 * @author weigion.wu
 * @date 2018-06-04 13:33:57
 */
public class DepartmentVo {

	// 部门编号
	private String depaNumber;

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
	private String depaCreateDatetime;

	// 部门更新时间
	private String depaUpdatedName;

	// 部门更新时间
	private String depaUpdatedDatetime;

	/**
	 * @return the depaNumber
	 */
	public String getDepaNumber() {
		return depaNumber;
	}

	/**
	 * @param depaNumber the depaNumber to set
	 */
	public void setDepaNumber(String depaNumber) {
		this.depaNumber = depaNumber;
	}

	/**
	 * @return the depaName
	 */
	public String getDepaName() {
		return depaName;
	}

	/**
	 * @param depaName the depaName to set
	 */
	public void setDepaName(String depaName) {
		this.depaName = depaName;
	}

	/**
	 * @return the depaFatherNumber
	 */
	public String getDepaFatherNumber() {
		return depaFatherNumber;
	}

	/**
	 * @param depaFatherNumber the depaFatherNumber to set
	 */
	public void setDepaFatherNumber(String depaFatherNumber) {
		this.depaFatherNumber = depaFatherNumber;
	}

	/**
	 * @return the depaChildNumber
	 */
	public String getDepaChildNumber() {
		return depaChildNumber;
	}

	/**
	 * @param depaChildNumber the depaChildNumber to set
	 */
	public void setDepaChildNumber(String depaChildNumber) {
		this.depaChildNumber = depaChildNumber;
	}

	/**
	 * @return the depaLevel
	 */
	public String getDepaLevel() {
		return depaLevel;
	}

	/**
	 * @param depaLevel the depaLevel to set
	 */
	public void setDepaLevel(String depaLevel) {
		this.depaLevel = depaLevel;
	}

	/**
	 * @return the depaEmail
	 */
	public String getDepaEmail() {
		return depaEmail;
	}

	/**
	 * @param depaEmail the depaEmail to set
	 */
	public void setDepaEmail(String depaEmail) {
		this.depaEmail = depaEmail;
	}

	/**
	 * @return the depaComment
	 */
	public String getDepaComment() {
		return depaComment;
	}

	/**
	 * @param depaComment the depaComment to set
	 */
	public void setDepaComment(String depaComment) {
		this.depaComment = depaComment;
	}

	/**
	 * @return the depaCreateName
	 */
	public String getDepaCreateName() {
		return depaCreateName;
	}

	/**
	 * @param depaCreateName the depaCreateName to set
	 */
	public void setDepaCreateName(String depaCreateName) {
		this.depaCreateName = depaCreateName;
	}

	/**
	 * @return the depaCreateDatetime
	 */
	public String getDepaCreateDatetime() {
		return depaCreateDatetime;
	}

	/**
	 * @param depaCreateDatetime the depaCreateDatetime to set
	 */
	public void setDepaCreateDatetime(String depaCreateDatetime) {
		this.depaCreateDatetime = depaCreateDatetime;
	}

	/**
	 * @return the depaUpdatedName
	 */
	public String getDepaUpdatedName() {
		return depaUpdatedName;
	}

	/**
	 * @param depaUpdatedName the depaUpdatedName to set
	 */
	public void setDepaUpdatedName(String depaUpdatedName) {
		this.depaUpdatedName = depaUpdatedName;
	}

	/**
	 * @return the depaUpdatedDatetime
	 */
	public String getDepaUpdatedDatetime() {
		return depaUpdatedDatetime;
	}

	/**
	 * @param depaUpdatedDatetime the depaUpdatedDatetime to set
	 */
	public void setDepaUpdatedDatetime(String depaUpdatedDatetime) {
		this.depaUpdatedDatetime = depaUpdatedDatetime;
	}

}
