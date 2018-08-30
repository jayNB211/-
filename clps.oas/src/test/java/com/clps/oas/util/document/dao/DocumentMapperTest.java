/**    
 * @Title: DocumentMapperTest.java  
 * @Package com.clps.oas.util.document.dao  
 * @Description:DocumentMapperTest
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-30 10:36:55
 * @version V1.0    
 */
package com.clps.oas.util.document.dao;


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
import com.clps.oas.util.mybatis.MyBatisUtil;
import com.clps.oas.util.spring.SpringTestBase;

/**  
 * @ClassName: DocumentMapperTest  
 * @Description:DocumentMapperTest
 * @author weigion.wu
 * @date  2018-05-30 10:36:55  
 */
public class DocumentMapperTest extends SpringTestBase{

	private SqlSessionFactory sf = null;
	private SqlSession session = null;	
	@Autowired
	private DocumentMapper documentMapper;
	private Logger logger = Logger.getLogger(DocumentMapperTest.class);
	/**  
	 * @Title: setUp  
	 * @Description:setUp 
	 * @param @throws java.lang.Exception    设定文件  
	 * @return void    返回类型  
	 * @throws  
	 */
	@Before
	public void setUp() throws Exception {
		
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		
	}

	/**  
	 * @Title: tearDown  
	 * @Description: 
	 * @param @throws java.lang.Exception    设定文件  
	 * @return void    返回类型  
	 * @throws  
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for 逻辑删除
	 */
	@Test
	public void testDeleteDocumentById() {
		try {
			int i = this.documentMapper.deleteDocumentById(2);
			if (i > 0) {
				logger.info(ParamCommon.DELETE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.DELETE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	/**
	 * Test method for 新增文件信息
	 */
	@Test
	public void testAddDocument() {
		Document document = new Document("weigion8","1.jpg","ww",new Timestamp(new Date().getTime()),"1",new Timestamp(new Date().getTime()),"2",true);
		logger.info(documentMapper.addDocument(document));
	}

	/**
	 * Test method for 通过标题模糊查询
	 */
	@Test
	public void testQueryDocumentLikeTitle() {
		List<Document> documents = null;
		Document document = new Document();
		//设置模糊查询参数
		String patternTitle = "2";
		document.setDocumentTitle(patternTitle);
		documents = documentMapper.queryDocumentLikeTitle(document);
		
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
		logger.info(documentMapper.queryAllDocuments());
	}
	
	/**
	 * Test method for 通过id查询文件
	 */
	@Test
	public void testQueryDocumentById() {
		logger.info(documentMapper.queryDocumentById(1));
	}
	
	/**
	 * Test method for 更新文件
	 */
	@Test
	public void testUpdateDocument() {
		Document document = new Document(1,"weigion","1.jpg","ww",new Timestamp(new Date().getTime()),"1",new Timestamp(new Date().getTime()),"2",true);
		logger.info(documentMapper.updateDocument(document));
	}

}
