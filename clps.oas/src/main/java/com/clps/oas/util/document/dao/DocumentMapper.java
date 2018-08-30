package com.clps.oas.util.document.dao;

import java.util.List;

import com.clps.oas.util.document.pojo.Document;
import com.clps.oas.util.paging.PagingVO;

/**
 * 
 * @ClassName: DocumentMapper  
 * @Description: documentMapper 
 * @author weigion.wu
 * @date  2018-05-28 16:03:05
 */
public interface DocumentMapper {
	
	/**
	 * @Title: addDocument  
	 * @Description: 新增文件  
	 * @param @param document
	 * @param @return 
	 * @return int 
	 * @throws
	 */
	public int addDocument(Document document);
	
	/**
	 * 
	 * @Title: queryAllFiles  
	 * @Description: 查询所有文件信息  
	 * @param @return
	 * @return List<Document> 
	 * @throws
	 */
	public List<Document> queryAllDocuments();
	
	/**
	 * 
	 * @Title: deleteDocumentById  
	 * @Description: 对文件进行逻辑删除
	 * @param @param documentId
	 * @param @return    设定文件  
	 * @return int    返回类型  
	 * @throws
	 */
    int deleteDocumentById(Integer documentId);
 
    /**
     * 
     * @Title: queryDocumentById  
     * @Description: 通过id查询文件 
     * @param @param documentId
     * @param @return
     * @return Document 
     * @throws
     */
    Document queryDocumentById(Integer documentId);

   /**
    * 
    * @Title: updateDocument  
    * @Description:更新文件
    * @param @param document
    * @param @return 
    * @return int
    * @throws
    */
	int updateDocument(Document document);
	
	/**
	 * 
	 * @Title: queryDocumentLikeTitle  
	 * @Description: 通过文件标题模糊查找document对象 
	 * @param @param documentTitle
	 * @param @return    设定文件  
	 * @return List<Document>    返回类型  
	 * @throws
	 */
	List<Document> queryDocumentLikeTitle(Document document);
	
	/**
	 * 
	 * @Title: queryAllDocumentsByPaging  
	 * @Description: 分页查询文件信息
	 * @param @param toPage
	 * @param @return    设定文件  
	 * @return List<Document>    返回类型  
	 * @throws
	 */
	List<Document> queryAllDocumentsByPaging(PagingVO pagingVO);
	
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