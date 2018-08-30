/**    
 * @Title: IDocumentService.java  
 * @Package com.clps.oas.util.document.service  
 * @Description: 服务层 
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-28 16:08:41
 * @version V1.0    
 */
package com.clps.oas.util.document.service;

import java.util.List;

import com.clps.oas.util.document.pojo.Document;

/**  
 * @ClassName: IDocumentService  
 * @Description: 服务层  
 * @author weigion.wu
 * @date  2018-05-28 16:08:41  
 */
public interface IDocumentService {
	
	/**
	 * @Title: addDocument  
	 * @Description: 新增文件接口  
	 * @param @param document 
	 * @param @return
	 * @return String 
	 * @throws
	 */
	public String addDocument(Document document);
	
	/**
	 * 
	 * @Title: queryAllDocuments  
	 * @Description: 查询所有文件信息 
	 * @param @return 
	 * @return List<Document>
	 * @throws
	 */
	public List<Document> queryAllDocuments();

	/**
	 * 
	 * @Title: updateDocument  
	 * @Description: 更新文件  
	 * @param @param document
	 * @param @return    
	 * @return String    
	 * @throws
	 */
	public String updateDocument(Document document);
	
	/**
	 * 
	 * @Title: queryDocumentById  
	 * @Description: 通过id查找文件 
	 * @param @param documentId
	 * @param @return 
	 * @return Document
	 * @throws
	 */
	public Document queryDocumentById(Integer documentId);
	
	/**
	 * 
	 * @Title: deleteDocumentById  
	 * @Description: 逻辑删除id  
	 * @param @param documentId
	 * @param @return    设定文件  
	 * @return int    返回类型  
	 * @throws
	 */
	public int deleteDocumentById(Integer documentId);
	
	/**
	 * 
	 * @Title: queryDocumentLikeTitle  
	 * @Description: 通过文件标题模糊查找document对象   
	 * @param @param documentTitle
	 * @param @return    设定文件  
	 * @return List<Document>    返回类型  
	 * @throws
	 */
	public List<Document> queryDocumentLikeTitle(Document document);
	
	/**
	 * 
	 * @Title: queryAllDocumentsByPaging  
	 * @Description: 分页查询文件信息
	 * @param @param toPage
	 * @param @return    设定文件  
	 * @return List<Document>    返回类型  
	 * @throws
	 */
	List<Document> queryAllDocumentsByPaging(Integer toPage);
	
	/**
	 * 
	 * @Title: countDocuments  
	 * @Description: 获取文件总数
	 * @param @return    设定文件  
	 * @return int    返回类型  
	 * @throws
	 */
	int countDocuments();
}
