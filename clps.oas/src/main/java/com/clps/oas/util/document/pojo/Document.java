package com.clps.oas.util.document.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @ClassName: Document
 * @Description: Document pojo
 * @author weigion.wu
 * @date 2018-05-28 15:42:15
 */
public class Document implements Serializable {

	/**
	 * @Fields serialVersionUID : 串行化
	 */
	private static final long serialVersionUID = -2117665622637919929L;

	private Integer documentId;						 // 文件编号

	private String documentTitle;					 // 文件标题

	private String documentName;					 // 文件名称

	private MultipartFile file; 					 // 文件

	private String documentComment;					 // 文件描述

	private Date documentCreatedDatetime;			 // 文件创建时间

	private String documentCreatedName;				 // 文件创建人

	private Date documentUpdatedDatetime;			 // 文件修改时间

	private String documentUpdatedName;				 // 文件修改人

	private Boolean documentIsvalid;				 // 文件是否有效

	/**  
	 * @Title:  
	 * @Description: 无参构造
	 * @param     设定文件  
	 * @return 
	 * @throws  
	 */
	public Document() {
		super();
		
	}

	/**
	 * @return the documentId
	 */
	public Integer getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
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
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	/**
	 * @return the file
	 */
	public MultipartFile getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile file) {
		this.file = file;
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
	public Date getDocumentCreatedDatetime() {
		return documentCreatedDatetime;
	}

	/**
	 * @param documentCreatedDatetime the documentCreatedDatetime to set
	 */
	public void setDocumentCreatedDatetime(Date documentCreatedDatetime) {
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
	public Date getDocumentUpdatedDatetime() {
		return documentUpdatedDatetime;
	}

	/**
	 * @param documentUpdatedDatetime the documentUpdatedDatetime to set
	 */
	public void setDocumentUpdatedDatetime(Date documentUpdatedDatetime) {
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

	/**
	 * @return the documentIsvalid
	 */
	public Boolean getDocumentIsvalid() {
		return documentIsvalid;
	}

	/**
	 * @param documentIsvalid the documentIsvalid to set
	 */
	public void setDocumentIsvalid(Boolean documentIsvalid) {
		this.documentIsvalid = documentIsvalid;
	}

	/**  
	 * @Title:  
	 * @param @param documentTitle
	 * @param @param documentName
	 * @param @param file
	 * @param @param documentComment
	 * @param @param documentCreatedDatetime
	 * @param @param documentCreatedName
	 * @param @param documentUpdatedDatetime
	 * @param @param documentUpdatedName
	 * @param @param documentIsvalid    设定文件  
	 * @return 
	 * @throws  
	 */
	public Document(String documentTitle, String documentName,String documentComment, Date documentCreatedDatetime,
			String documentCreatedName, Date documentUpdatedDatetime, String documentUpdatedName, Boolean documentIsvalid) {
		super();
		this.documentTitle = documentTitle;
		this.documentName = documentName;
		this.documentComment = documentComment;
		this.documentCreatedDatetime = documentCreatedDatetime;
		this.documentCreatedName = documentCreatedName;
		this.documentUpdatedDatetime = documentUpdatedDatetime;
		this.documentUpdatedName = documentUpdatedName;
		this.documentIsvalid = documentIsvalid;
	}

	/**  
	 * @Title:  
	 * @param @param documentId
	 * @param @param documentTitle
	 * @param @param documentName
	 * @param @param documentComment
	 * @param @param documentCreatedDatetime
	 * @param @param documentCreatedName
	 * @param @param documentUpdatedDatetime
	 * @param @param documentUpdatedName
	 * @param @param documentIsvalid    设定文件  
	 * @return 
	 * @throws  
	 */
	public Document(Integer documentId, String documentTitle, String documentName, String documentComment, Date documentCreatedDatetime,
			String documentCreatedName, Date documentUpdatedDatetime, String documentUpdatedName, Boolean documentIsvalid) {
		super();
		this.documentId = documentId;
		this.documentTitle = documentTitle;
		this.documentName = documentName;
		this.documentComment = documentComment;
		this.documentCreatedDatetime = documentCreatedDatetime;
		this.documentCreatedName = documentCreatedName;
		this.documentUpdatedDatetime = documentUpdatedDatetime;
		this.documentUpdatedName = documentUpdatedName;
		this.documentIsvalid = documentIsvalid;
	}

	/* (non-Javadoc)
	 * <p>Title: toString</p>  
	 * <p>Description: </p>  
	 * @return  
	 * @see java.lang.Object#toString()  
	 */
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentTitle=" + documentTitle + ", documentName=" + documentName + ", documentComment="
				+ documentComment + ", documentCreatedDatetime=" + documentCreatedDatetime + ", documentCreatedName=" + documentCreatedName
				+ ", documentUpdatedDatetime=" + documentUpdatedDatetime + ", documentUpdatedName=" + documentUpdatedName + ", documentIsvalid="
				+ documentIsvalid + "]";
	}
	
}