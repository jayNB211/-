/**    
 * @Title: FileServiceImpl.java  
 * @Package com.clps.oas.util.file.service.impl  
 * @Description: 服务实现层
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-28 16:12:24
 * @version V1.0    
 */
package com.clps.oas.util.document.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.util.document.dao.DocumentMapper;
import com.clps.oas.util.document.pojo.Document;
import com.clps.oas.util.document.service.IDocumentService;
import com.clps.oas.util.paging.PagingVO;

/**  
 * @ClassName: FileServiceImpl  
 * @Description:  服务实现层
 * @author weigion.wu
 * @date  2018-05-28 16:12:24  
 */
@Service("documentService")
public class DocumentServiceImpl implements IDocumentService{

	@Autowired
	private DocumentMapper documentMapper;
	Logger logger = Logger.getLogger(DocumentServiceImpl.class);
	
	/**
	 * 新增文件信息
	 */
	@Override
	public String addDocument(Document document) {
		if(document != null){
			if((documentMapper.addDocument(document))>0){
				return ParamCommon.DOCUMENT_UPLOAD_SUCCESS;
			}else{
				return ParamCommon.DOCUMENT_UPLOAD_FAILURE;
			}
		}
		return ParamCommon.ADD_EMPTY;
	}

	/**
	 * 查询所有文件信息
	 */
	@Override
	public List<Document> queryAllDocuments() {
		
		return documentMapper.queryAllDocuments();
	}

	/**
	 * 更新文件信息
	 */
	@Override
	public String updateDocument(Document document) {
		try{
			this.documentMapper.updateDocument(document);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @Title: queryDocumentById  
	 * @Description: 通过id查找文件
	 * @param @param documentId
	 * @param @return 
	 * @return Document
	 * @throws
	 */
	@Override
	public Document queryDocumentById(Integer documentId) {
		try{
			return this.documentMapper.queryDocumentById(documentId);
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 
	 * @Title: deleteDocumentById  
	 * @Description: 逻辑删除  
	 * @param @param documentId
	 * @param @return 
	 * @return int  
	 * @throws
	 */
	@Override
	public int deleteDocumentById(Integer documentId) {
		
		return this.documentMapper.deleteDocumentById(documentId);
	}

	/**
	 * 通过标题模糊查询文件
	 */
	@Override
	public List<Document> queryDocumentLikeTitle(Document document) {
		
		return this.documentMapper.queryDocumentLikeTitle(document);
	}

	/**
	 * 分页查询文件信息
	 */
	@Override
	public List<Document> queryAllDocumentsByPaging(Integer toPage) {
		PagingVO pagingVO = new PagingVO();
		pagingVO.setToPage(toPage);
		return this.documentMapper.queryAllDocumentsByPaging(pagingVO);
	}

	/**
	 *  获取文件总数
	 */
	@Override
	public int countDocuments() {
		
		return this.documentMapper.countDocuments();
	}

}
