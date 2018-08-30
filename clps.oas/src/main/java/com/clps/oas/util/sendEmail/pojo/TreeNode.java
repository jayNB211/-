
		package com.clps.oas.util.sendEmail.pojo;

import java.io.Serializable;

/**
 * @desc: clps.oas
 * @author: lilian
 * @createTime: 2018年5月21日 下午3:49:01
 * @version: v1.0
 */

public class TreeNode implements Serializable{

	
    private static final long serialVersionUID = 1L;

	private int nodeId;				//treeNode's id
	
    
    private int parentId;			//treeNode's parentId
    
    private int level;				//treeNode's level
    
    private String text;			//treeNode's name
   
    private String state;			//treeNode's state

    private String url;
		
	public TreeNode() {
		
				super();
			
	}


	
	
	
	/**
	 * @param text
	 * @param state
	 * @param url
	 */
		
	public TreeNode(String text, String state, String url) {
		super();
		this.text = text;
		this.state = state;
		this.url = url;
	}





	/**
	 * @param nodeId
	 * @param parentId
	 * @param text
	 * @param state
	 * @param url
	 */
		
	public TreeNode(int nodeId, int parentId, String text, String state, String url) {
		super();
		this.nodeId = nodeId;
		this.parentId = parentId;
		this.text = text;
		this.state = state;
		this.url = url;
	}



	/**
	 * @return the url
	 */
	
	public String getUrl() {
	
		return url;
	}



	

	
	
	/**
	 * @return the level
	 */
	
	public int getLevel() {
	
		return level;
	}





	
	/**
	 * @param level the level to set
	 */
	
	public void setLevel(int level) {
	
		this.level = level;
	}





	/**
	 * @param url the url to set
	 */
	
	public void setUrl(String url) {
	
		this.url = url;
	}
	
	
	/**
	 * @return the nodeId
	 */
	
	public int getNodeId() {
	
		return nodeId;
	}





	
	/**
	 * @param nodeId the nodeId to set
	 */
	
	public void setNodeId(int nodeId) {
	
		this.nodeId = nodeId;
	}





	/**
	 * @return the parentId
	 */
	
	public int getParentId() {
	
		return parentId;
	}





	
	/**
	 * @param parentId the parentId to set
	 */
	
	public void setParentId(int parentId) {
	
		this.parentId = parentId;
	}





	
	/**
	 * @return the text
	 */
	
	public String getText() {
	
		return text;
	}





	
	/**
	 * @param text the text to set
	 */
	
	public void setText(String text) {
	
		this.text = text;
	}





	
	/**
	 * @return the state
	 */
	
	public String getState() {
	
		return state;
	}





	
	/**
	 * @param state the state to set
	 */
	
	public void setState(String state) {
	
		this.state = state;
	}





	
	/*
	 *(non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
		
	@Override
	public String toString() {
		return "TreeNode [nodeId=" + nodeId + ", parentId=" + parentId + ", level=" + level + ", text=" + text
				+ ", state=" + state + ", url=" + url + "]";
	}


    
}



	