/**    
 * @Title: DocumentServiceImplTest.java  
 * @Package com.clps.oas.util.document.service.impl  
 * @Description: test
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-28 16:41:31
 * @version V1.0    
 */
package com.clps.oas.util.document.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.util.document.pojo.Document;
import com.clps.oas.util.document.service.IDocumentService;
import com.clps.oas.util.mybatis.MyBatisUtil;
import com.clps.oas.util.paging.PagingVO;
import com.clps.oas.util.spring.SpringTestBase;

/**  
 * @ClassName: DocumentServiceImplTest  
 * @Description: test
 * @author weigion.wu
 * @date  2018-05-28 16:41:31  
 */
public class DocumentServiceImplTest extends SpringTestBase{
	
	@Autowired
	private IDocumentService documentService;
	private Logger logger = Logger.getLogger(DocumentServiceImplTest.class);

	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	/**  
	 * @Title: setUp  
	 * @param @throws java.lang.Exception 
	 * @return void 
	 * @throws  
	 */
	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
	}

	/**  
	 * @Title: tearDown  
	 * @param @throws java.lang.Exception  
	 * @return void  
	 * @throws  
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for 新增文件信息
	 */
	@Test
	public void testAddDocument() {
		Document document = new Document("weigion5","1.jpg","ww",new Timestamp(new Date().getTime()),"1",new Timestamp(new Date().getTime()),"2",true);
		logger.info(documentService.addDocument(document));
	}

	/**
	 * Test method for 通过标题模糊查询
	 */
	@Test
	public void testQueryDocumentLikeTitle() {
		List<Document> documents = null;
		Document document = new Document();
		//设置模糊查询参数
		String patternTitle = "23";
		document.setDocumentTitle(patternTitle);
		documents = documentService.queryDocumentLikeTitle(document);
		
		Iterator<Document> its = documents.iterator();
		while(its.hasNext()){
			logger.info(its.next());
		}
	
	}
	
	/**
	 * Test method for 查询所有
	 */
	@Test
	public void testQueryAllDocuments() {
		logger.info(documentService.queryAllDocuments());
	}
	
	/**
	 * Test method for 通过id查询文件
	 */
	@Test
	public void testQueryDocumentById() {
		logger.info(documentService.queryDocumentById(1));
	}
	
	/**
	 * Test method for 更新文件
	 */
	@Test
	public void testUpdateDocument() {
		Document document = new Document(1,"weigion","1.jpg","ww",new Timestamp(new Date().getTime()),"1",new Timestamp(new Date().getTime()),"2",true);
		logger.info(documentService.updateDocument(document));
	}
	/**
	 * Test method for 逻辑删除
	 */
	@Test
	public void testDeleteDocumentById() {
		logger.info(documentService.deleteDocumentById(2));
	}

	/**
	 * 
	 * @Title: testQueryAllDocumentsByPaging  
	 * @Description: 测试分页  
	 * @param     设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	@Test
	public void testQueryAllDocumentsByPaging() {
		try {
			PagingVO pagingVo = new PagingVO();
			pagingVo.setTotalCountPage(1);
			pagingVo.setToPage(1);
			Iterator<Document> its = documentService.queryAllDocumentsByPaging(1).iterator();
			while (its.hasNext()) {
				logger.info(its.next());
			}
			session.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * 
	 * @Title: testCountDocuments  
	 * @Description: 测试文件数 
	 * @param     设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	@Test
	public void testCountDocuments() {
		try {
			int i = this.documentService.countDocuments();
			if (i > 0) {
				logger.info(i);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.UPDATE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
