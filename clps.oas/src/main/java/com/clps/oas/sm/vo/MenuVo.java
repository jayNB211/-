
		package com.clps.oas.sm.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @desc: clps.oas
 * @author: lilian
 * @createTime: 2018年6月5日 下午2:09:32
 * @version: v1.0
 */

public class MenuVo implements Serializable{

	private static final long serialVersionUID = 3901931508416593699L;

	private Integer menuId;				//menu's id

    private String menuName;			//menu's name 

    private Integer menuSortId;			//menu's sort id

    private Integer menuLevel;			//menu's level

    private Integer menuParentid;		//menu's parent id

    private String menuUrl;				//menu's url

    private Integer menuIsvariable;		//menu's state

    private String menuComment;			//menu's comment

    private Timestamp menuCreatedDatetime;	//menu's created  time

    private Integer menuCreatedName;	//menu's created name

    private String accountName;			//account's name

	
		
	public MenuVo() {
		
				super();
	}



	
	/**
	 * @param menuId
	 * @param menuName
	 * @param menuSortId
	 * @param menuLevel
	 * @param menuParentid
	 * @param menuUrl
	 * @param menuIsvariable
	 * @param menuComment
	 * @param menuCreatedDatetime
	 * @param menuCreatedName
	 * @param accountName
	 */
		
	public MenuVo(Integer menuId, String menuName, Integer menuSortId, Integer menuLevel, Integer menuParentid,
			String menuUrl, Integer menuIsvariable, String menuComment, Timestamp menuCreatedDatetime,
			Integer menuCreatedName, String accountName) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuSortId = menuSortId;
		this.menuLevel = menuLevel;
		this.menuParentid = menuParentid;
		this.menuUrl = menuUrl;
		this.menuIsvariable = menuIsvariable;
		this.menuComment = menuComment;
		this.menuCreatedDatetime = menuCreatedDatetime;
		this.menuCreatedName = menuCreatedName;
		this.accountName = accountName;
	}




	
	/**
	 * @return the menuId
	 */
	
	public Integer getMenuId() {
	
		return menuId;
	}




	
	/**
	 * @param menuId the menuId to set
	 */
	
	public void setMenuId(Integer menuId) {
	
		this.menuId = menuId;
	}




	
	/**
	 * @return the menuName
	 */
	
	public String getMenuName() {
	
		return menuName;
	}




	
	/**
	 * @param menuName the menuName to set
	 */
	
	public void setMenuName(String menuName) {
	
		this.menuName = menuName;
	}




	
	/**
	 * @return the menuSortId
	 */
	
	public Integer getMenuSortId() {
	
		return menuSortId;
	}




	
	/**
	 * @param menuSortId the menuSortId to set
	 */
	
	public void setMenuSortId(Integer menuSortId) {
	
		this.menuSortId = menuSortId;
	}




	
	/**
	 * @return the menuLevel
	 */
	
	public Integer getMenuLevel() {
	
		return menuLevel;
	}




	
	/**
	 * @param menuLevel the menuLevel to set
	 */
	
	public void setMenuLevel(Integer menuLevel) {
	
		this.menuLevel = menuLevel;
	}




	
	/**
	 * @return the menuParentid
	 */
	
	public Integer getMenuParentid() {
	
		return menuParentid;
	}




	
	/**
	 * @param menuParentid the menuParentid to set
	 */
	
	public void setMenuParentid(Integer menuParentid) {
	
		this.menuParentid = menuParentid;
	}




	
	/**
	 * @return the menuUrl
	 */
	
	public String getMenuUrl() {
	
		return menuUrl;
	}




	
	/**
	 * @param menuUrl the menuUrl to set
	 */
	
	public void setMenuUrl(String menuUrl) {
	
		this.menuUrl = menuUrl;
	}




	
	/**
	 * @return the menuIsvariable
	 */
	
	public Integer getMenuIsvariable() {
	
		return menuIsvariable;
	}




	
	/**
	 * @param menuIsvariable the menuIsvariable to set
	 */
	
	public void setMenuIsvariable(Integer menuIsvariable) {
	
		this.menuIsvariable = menuIsvariable;
	}




	
	/**
	 * @return the menuComment
	 */
	
	public String getMenuComment() {
	
		return menuComment;
	}




	
	/**
	 * @param menuComment the menuComment to set
	 */
	
	public void setMenuComment(String menuComment) {
	
		this.menuComment = menuComment;
	}




	
	/**
	 * @return the menuCreatedDatetime
	 */
	
	public Timestamp getMenuCreatedDatetime() {
	
		return menuCreatedDatetime;
	}




	
	/**
	 * @param menuCreatedDatetime the menuCreatedDatetime to set
	 */
	
	public void setMenuCreatedDatetime(Timestamp menuCreatedDatetime) {
	
		this.menuCreatedDatetime = menuCreatedDatetime;
	}




	
	/**
	 * @return the menuCreatedName
	 */
	
	public Integer getMenuCreatedName() {
	
		return menuCreatedName;
	}




	
	/**
	 * @param menuCreatedName the menuCreatedName to set
	 */
	
	public void setMenuCreatedName(Integer menuCreatedName) {
	
		this.menuCreatedName = menuCreatedName;
	}




	
	/**
	 * @return the accountName
	 */
	
	public String getAccountName() {
	
		return accountName;
	}




	
	/**
	 * @param accountName the accountName to set
	 */
	
	public void setAccountName(String accountName) {
	
		this.accountName = accountName;
	}




	
	/*
	 *(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
		
	@Override
	public String toString() {
		return "MenuVo [menuId=" + menuId + ", menuName=" + menuName + ", menuSortId=" + menuSortId + ", menuLevel="
				+ menuLevel + ", menuParentid=" + menuParentid + ", menuUrl=" + menuUrl + ", menuIsvariable="
				+ menuIsvariable + ", menuComment=" + menuComment + ", menuCreatedDatetime=" + menuCreatedDatetime
				+ ", menuCreatedName=" + menuCreatedName + ", accountName=" + accountName + "]";
	}
    
    
	
}

	