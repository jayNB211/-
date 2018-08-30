/**    
 * @Title: DocumentVo.java  
 * @Package com.clps.oas.util.excel.vo  
 * @Description: 页面文件信息DocumentVo
 * @author weigion.wu(吴跟强)    
 * @date  2018-06-05 13:33:00
 * @version V1.0    
 */
package com.clps.oas.util.excel.vo;


/**  
 * @ClassName: DocumentVo  
 * @Description: 页面文件信息DocumentVo
 * @author weigion.wu
 * @date  2018-06-05 13:33:00  
 */
public class DocumentVo {

	private String documentCount;				// 文件序号

    private String documentTitle; 				// 文件标题
    
    private String documentComment;				// 文件描述

    private String documentCreatedDatetime;		// 文件创建时间

    private String documentCreatedName;			// 文件创建人

    private String documentUpdatedDatetime;		// 文件修改时间

    private String documentUpdatedName;			// 文件修改人

	/**
	 * @return the documentCount
	 */
	public String getDocumentCount() {
		return documentCount;
	}

	/**
	 * @param documentCount the documentCount to set
	 */
	public void setDocumentCount(String documentCount) {
		this.documentCount = documentCount;
	}

	/**
	 * @return the documentTitle
	 */
	public String getDocumentTitle() {
		return documentTitle;
	}

	/**
	 * @param documentTitle the documentTitle to set
	 */
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}

	/**
	 * @return the documentComment
	 */
	public String getDocumentComment() {
		return documentComment;
	}

	/**
	 * @param documentComment the documentComment to set
	 */
	public void setDocumentComment(String documentComment) {
		this.documentComment = documentComment;
	}

	/**
	 * @return the documentCreatedDatetime
	 */
	public String getDocumentCreatedDatetime() {
		return documentCreatedDatetime;
	}

	/**
	 * @param documentCreatedDatetime the documentCreatedDatetime to set
	 */
	public void setDocumentCreatedDatetime(String documentCreatedDatetime) {
		this.documentCreatedDatetime = documentCreatedDatetime;
	}

	/**
	 * @return the documentCreatedName
	 */
	public String getDocumentCreatedName() {
		return documentCreatedName;
	}

	/**
	 * @param documentCreatedName the documentCreatedName to set
	 */
	public void setDocumentCreatedName(String documentCreatedName) {
		this.documentCreatedName = documentCreatedName;
	}

	/**
	 * @return the documentUpdatedDatetime
	 */
	public String getDocumentUpdatedDatetime() {
		return documentUpdatedDatetime;
	}

	/**
	 * @param documentUpdatedDatetime the documentUpdatedDatetime to set
	 */
	public void setDocumentUpdatedDatetime(String documentUpdatedDatetime) {
		this.documentUpdatedDatetime = documentUpdatedDatetime;
	}

	/**
	 * @return the documentUpdatedName
	 */
	public String getDocumentUpdatedName() {
		return documentUpdatedName;
	}

	/**
	 * @param documentUpdatedName the documentUpdatedName to set
	 */
	public void setDocumentUpdatedName(String documentUpdatedName) {
		this.documentUpdatedName = documentUpdatedName;
	}

	/* (non-Javadoc)
	 * <p>Title: toString</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see java.lang.Object#toString()  
	 */
	@Override
	public String toString() {
		return "DocumentVo [documentCount=" + documentCount + ", documentTitle=" + documentTitle + ", documentComment=" + documentComment
				+ ", documentCreatedDatetime=" + documentCreatedDatetime + ", documentCreatedName=" + documentCreatedName + ", documentUpdatedDatetime="
				+ documentUpdatedDatetime + ", documentUpdatedName=" + documentUpdatedName + "]";
	}

	

}
