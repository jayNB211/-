/**    
 * @Title: ExcelUtilTest.java  
 * @Package com.clps.oas.util.excel  
 * @Description: 工具类导入导出测试 
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-14 14:17:07
 * @version V1.0    
 */
package com.clps.oas.util.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.clps.oas.util.date.DateUtil;
//导入部门页面显示数据实体类信息
import com.clps.oas.util.excel.vo.DepartmentVo;
//导入文件页面显示数据实体类信息
import com.clps.oas.util.excel.vo.DocumentVo;
import com.clps.oas.util.excel.vo.PositionVo;
import com.clps.oas.util.factory.UtilFactory;

/**
 * 
 * @ClassName: ExcelUtilTest
 * @Description: 工具类导入导出测试
 * @author weigion.wu
 * @date 2018-05-14 14:17:07
 *
 */
public class ExcelUtilTest{

	private Logger logger = Logger.getLogger(ExcelUtilTest.class);
	
	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	// 测试导出Department信息到excel中
	@Test
	public void testExportDepartmentVoToExcel() {

		ArrayList<DepartmentVo> list = new ArrayList<DepartmentVo>();
		DepartmentVo department = new DepartmentVo();
		department.setDepaNumber("1");
		department.setDepaName("技术部");
		department.setDepaFatherNumber("0");
		department.setDepaChildNumber("2");
		department.setDepaLevel("1");
		department.setDepaEmail("2422676183@qq.com");
		department.setDepaComment("good");
		department.setDepaCreateName("1");
		UtilFactory.getInstanceOfDateUtil();
		department.setDepaCreateDatetime(DateUtil.DateToString1(new Timestamp(new Date().getTime())));
		department.setDepaUpdatedName("2");
		UtilFactory.getInstanceOfDateUtil();
		department.setDepaUpdatedDatetime(DateUtil.DateToString1(new Timestamp(new Date().getTime())));
		

		list.add(department);
		String[] headers = { "部门编号", "部门名称", "上级部门编号", "下级部门编号", "部门等级", "部门邮箱", "部门描述", "部门创建人名", "部门创建日期", "部门修改人名", "部门修改日期" };

		OutputStream out = null;
		try {
			out = new FileOutputStream("src\\main\\webapp\\doc\\excelTemplate\\departmentVo.xls");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		UtilFactory.getInstanceOfExcelUtilHandleDepartmentVo().exportToExcel("部门信息", headers, list, out);
		logger.info("文件创建成功");
		Iterator<DepartmentVo> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
	}

	// 测试从excel中导入Department信息
	@Test
	public void testImportDepartmentVoFromExcel() {

		List<Object> list = null;
		try {
			list = UtilFactory.getInstanceOfExcelUtilHandleDepartmentVo().ImportFromExcel(new File("src\\main\\webapp\\doc\\excelTemplate\\departmentVo.xls"), 0);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		Iterator<Object> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
	}

	// 测试导出PositionVo信息到excel中
	@Test
	public void testExportPositionVoToExcel() {

		ArrayList<PositionVo> list = new ArrayList<PositionVo>();
		PositionVo position = new PositionVo();
		position.setPositionId("1");
		position.setPositionName("Java工程师");
		position.setPositionDescription("good");
		position.setPositionLevel("2");
		position.setPositionDepartment("1");
		position.setPositionCreatedDatetime(new Timestamp(new Date().getTime()));
		position.setPositionCreatedName("1");
		position.setPositionUpdatedDatetime(new Timestamp(new Date().getTime()));
		position.setPositionUpdatedName("2");
		list.add(position);
		

		String[] headers = { "职位编号", "职位名称", "职位描述", "职位等级", "职位所属部门", "职位创建时间", "职位创建人", "职位更新时间", "职位更新人" };

		OutputStream out = null;
		try {
			out = new FileOutputStream("src\\main\\webapp\\doc\\excelTemplate\\positionVo.xls");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		UtilFactory.getInstanceOfExcelUtilHandlePositionVo().exportToExcel("职位信息", headers, list, out);
		logger.info("文件创建成功");
		Iterator<PositionVo> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
	}

	// 测试从excel中导入PositionVo信息
	@Test
	public void testImportPositionVoFromExcel() {
		List<Object> list = null;
		try {
			list = UtilFactory.getInstanceOfExcelUtilHandlePositionVo().ImportFromExcel(new File("src\\main\\webapp\\doc\\excelTemplate\\positionVo.xls"), 0);
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i);
					logger.info(list.get(i));
				}
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		Iterator<Object> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());

		}
	}

	// 测试导出Document文件信息到excel中
	@Test
	public void testExportDocumentVoToExcel() {

		ArrayList<DocumentVo> list = new ArrayList<DocumentVo>();
		DocumentVo document = new DocumentVo();
		document.setDocumentCount("1");
		document.setDocumentTitle("J2ee_Study");
		document.setDocumentComment("good");
		UtilFactory.getInstanceOfDateUtil();
		document.setDocumentCreatedDatetime(DateUtil.DateToString1(new Timestamp(new Date().getTime())));
		document.setDocumentCreatedName("1");
		UtilFactory.getInstanceOfDateUtil();
		document.setDocumentUpdatedDatetime(DateUtil.DateToString1(new Timestamp(new Date().getTime())));
		document.setDocumentUpdatedName("2");

		list.add(document);
		String[] headers = { "序号", "文件标题", "文件描述", "创建时间", "创建人", "修改时间", "修改人"};

		OutputStream out = null;
		try {
			out = new FileOutputStream("src\\main\\webapp\\doc\\excelTemplate\\documentVo.xls");
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}

		UtilFactory.getInstanceOfExcelUtilHandleDocumentVo().exportToExcel("文件信息", headers, list, out);
		logger.info("文件创建成功");
		Iterator<DocumentVo> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
	}

	// 测试从excel中导入Document文件信息
	@Test
	public void testImportDocumentVoFromExcel() {

		List<Object> list = null;
		try {
			list = UtilFactory.getInstanceOfExcelUtilHandleDocumentVo().ImportFromExcel(new File("src\\main\\webapp\\doc\\excelTemplate\\documentVo.xls"), 0);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}

		Iterator<Object> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}
	}

}
