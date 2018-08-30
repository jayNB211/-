/**    
 * @Title: ExcelImportExportController.java  
 * @Package com.clps.oas.util.excel.controller  
 * @Description: 实现对前台表格数据的导出以及从表格中数据传入前台页面显示
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-22 10:59:47
 * @version V1.0    
 */
package com.clps.oas.util.excel.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.clps.oas.sm.pojo.Department;
import com.clps.oas.sm.service.IDepartmentService;
import com.clps.oas.util.document.pojo.Document;
import com.clps.oas.util.document.service.IDocumentService;
import com.clps.oas.util.excel.vo.DepartmentVo;
import com.clps.oas.util.excel.vo.DocumentVo;
import com.clps.oas.util.factory.UtilFactory;

/**
 * @ClassName: ExcelImportExportController
 * @Description: 实现对前台表格数据的导出以及从表格中数据传入前台页面显示
 * @author weigion.wu
 * @param <Position>
 * @date 2018-05-22 10:59:47
 */
@Controller
@RequestMapping(value = "/sm")
public class ExcelImportExportController {

	private Logger logger = Logger.getLogger(ExcelImportExportController.class);
	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;

	@Autowired
	@Qualifier("documentService")
	private IDocumentService documentService;

	// 从表格中读取Document信息上传到页面显示出来
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/importDocumentVoFromExcel")
	public ModelAndView importDocumentVoFromExcel(Model model, ModelAndView modelAndView, HttpSession session, HttpServletRequest request) {
		List<Object> list = null;
		// 获取上传文件的目录
		ServletContext sc = request.getSession().getServletContext();

		// 上传位置
		String fileSaveRootPath = sc.getRealPath("/doc/excelTemplate");

		// 得到文件
		File file = new File(fileSaveRootPath + "\\" + "documentVo.xls");

		// 如果文件不存在
		if (!file.exists()) {
			request.setAttribute("message", "您要上传的文件不存在！！");
			logger.info("您要上传的文件不存在！！");
		}

		try {
			list = UtilFactory.getInstanceOfExcelUtilHandleDocumentVo().ImportFromExcel(file, 0);
			// list.remove(0);
			if (list.size() > 0) {
				for (int i = 1; i < list.size(); i++) {
					@SuppressWarnings("unchecked")
					List<String> documentList = (List<String>) list.get(i);
					Document document = new Document();
					document.setDocumentTitle(documentList.get(1));
					document.setDocumentComment(documentList.get(2));
					document.setDocumentName("weigion.jpg");
					document.setDocumentCreatedDatetime(UtilFactory.getInstanceOfDateUtil().StringToDate1(documentList.get(3)));
					document.setDocumentCreatedName(documentList.get(4));
					document.setDocumentUpdatedDatetime(UtilFactory.getInstanceOfDateUtil().StringToDate1(documentList.get(5)));
					document.setDocumentUpdatedName(documentList.get(6));
					document.setDocumentIsvalid(true);
					// 插入数据库
					documentService.addDocument(document);
				}

			} else {
				logger.info(list.size() == 0);
			}
		} catch (IOException e) {
			logger.error("文件不存在:" + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 返回
		modelAndView.setViewName("redirect:/sm/documentList");
		// 返回
		return modelAndView;

	}

	// 导出文件信息到表格
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/exportDocumentVoToExcel")
	public void exportDocumentVoToExcel(Model model, HttpServletRequest request, HttpServletResponse response) {

		ArrayList<DocumentVo> list = new ArrayList<DocumentVo>();
		List<Document> documents = documentService.queryAllDocuments();
		for (int i = 0; i < documents.size(); i++) {
			Document document = documents.get(i);
			DocumentVo documentVo = new DocumentVo();
			documentVo.setDocumentCount(i + 1 + "");
			documentVo.setDocumentTitle(document.getDocumentTitle());
			documentVo.setDocumentComment(document.getDocumentComment());
			documentVo.setDocumentCreatedDatetime(UtilFactory.getInstanceOfDateUtil().DateToString1(document.getDocumentCreatedDatetime()));
			documentVo.setDocumentCreatedName(String.valueOf(document.getDocumentCreatedName()));
			documentVo.setDocumentUpdatedDatetime(UtilFactory.getInstanceOfDateUtil().DateToString1(document.getDocumentUpdatedDatetime()));
			documentVo.setDocumentUpdatedName(String.valueOf(document.getDocumentUpdatedName()));
			list.add(documentVo);
		}

		String[] headers = { "序号", "文件标题", "文件描述", "创建时间", "创建人", "修改时间", "修改人" };
		// 获取上传文件的目录
		ServletContext sc = request.getSession().getServletContext();
		// 下载位置
		String fileSaveRootPath = sc.getRealPath("/fileUpload/");
		String fileName = "documentVo.xls";
		// 获得要下载文件的File对象
		File file = new File(fileSaveRootPath + File.separator + fileName);

		// 如果文件不存在
		if (!file.exists()) {
			logger.info("您要下载的文件已被删除！！");
		}

		// 设置响应头，控制浏览器下载该文件
		response.setContentType("application;charset=UTF-8");
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		// 创建输出流
		OutputStream out = null;
		;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		UtilFactory.getInstanceOfExcelUtilHandleDocumentVo().exportToExcel("文件信息", headers, list, out);
		logger.info("文件创建成功");
		Iterator<DocumentVo> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}

	}

	// 从表格中读取Department信息上传到页面显示出来
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/importDepartmentVoFromExcel")
	public ModelAndView importDepartmentVoFromExcel(Model model, ModelAndView modelAndView, HttpSession session, HttpServletRequest request) {
		List<Object> list = null;
		// 获取上传文件的目录
		ServletContext sc = request.getSession().getServletContext();

		// 上传位置
		String fileSaveRootPath = sc.getRealPath("/doc/excelTemplate");

		// 得到文件
		File file = new File(fileSaveRootPath + "\\" + "departmentVo.xls");

		// 如果文件不存在
		if (!file.exists()) {
			request.setAttribute("message", "您要上传的文件不存在！！");
			logger.info("您要上传的文件不存在！！");
		}

		try {
			list = UtilFactory.getInstanceOfExcelUtilHandleDepartmentVo().ImportFromExcel(file, 0);
			// list.remove(0);
			if (list.size() > 0) {
				for (int i = 1; i < list.size(); i++) {
					@SuppressWarnings("unchecked")
					List<String> departmentList = (List<String>) list.get(i);
					Department department = new Department();
					department.setDepaName(departmentList.get(1));
					department.setDepaFatherNumber(departmentList.get(2));
					department.setDepaChildNumber(departmentList.get(3));
					department.setDepaLevel(departmentList.get(4));
					department.setDepaEmail(departmentList.get(5));
					department.setDepaComment(departmentList.get(6));
					department.setDepaCreateName(departmentList.get(7));
					department.setDepaCreateDatetime(UtilFactory.getInstanceOfDateUtil().StringToDate1(departmentList.get(8)));
					department.setDepaUpdatedName(departmentList.get(9));
					department.setDepaUpdatedDatetime(UtilFactory.getInstanceOfDateUtil().StringToDate1(departmentList.get(10)));
					// 插入数据库
					departmentService.insertSelective(department);
				}

			} else {
				logger.info(list.size() == 0);
			}
		} catch (IOException e) {
			logger.error("文件不存在:" + e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 返回
		modelAndView.setViewName("redirect:/sm/departmentList");
		// 返回
		return modelAndView;

	}

	// 导出部门信息到表格
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/exportDepartmentVoToExcel")
	public void exportDepartmentVoToExcel(Model model, HttpServletRequest request, HttpServletResponse response) {

		ArrayList<DepartmentVo> list = new ArrayList<DepartmentVo>();
		List<Department> departments = departmentService.showDepartment();
		for (int i = 0; i < departments.size(); i++) {
			Department department = departments.get(i);
			DepartmentVo departmentVo = new DepartmentVo();
			departmentVo.setDepaNumber(i + 1 + "");
			departmentVo.setDepaName(String.valueOf(department.getDepaNumber()));
			departmentVo.setDepaFatherNumber(department.getDepaFatherNumber());
			departmentVo.setDepaChildNumber(department.getDepaChildNumber());
			departmentVo.setDepaLevel(department.getDepaLevel());
			departmentVo.setDepaEmail(department.getDepaEmail());
			departmentVo.setDepaComment(department.getDepaComment());
			departmentVo.setDepaCreateName(department.getDepaCreateName());
			departmentVo.setDepaCreateDatetime(UtilFactory.getInstanceOfDateUtil().DateToString1(department.getDepaCreateDatetime()));
			departmentVo.setDepaUpdatedName(department.getDepaUpdatedName());
			departmentVo.setDepaUpdatedDatetime(UtilFactory.getInstanceOfDateUtil().DateToString1(department.getDepaUpdatedDatetime()));
			list.add(departmentVo);
		}

		String[] headers = { "部门编号", "部门名称", "上级部门编号", "下级部门编号", "部门等级", "部门邮箱", "部门描述", "部门创建人名", "部门创建日期", "部门修改人名", "部门修改日期" };
		// 获取上传文件的目录
		ServletContext sc = request.getSession().getServletContext();
		// 下载位置
		String fileSaveRootPath = sc.getRealPath("/fileUpload/");
		String fileName = "departmentVo.xls";
		// 获得要下载文件的File对象
		File file = new File(fileSaveRootPath + File.separator + fileName);

		// 如果文件不存在
		if (!file.exists()) {
			logger.info("您要下载的文件已被删除！！");
		}
		
		// 设置响应头，控制浏览器下载该文件
		response.setContentType("application;charset=UTF-8");
		try {
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		// 创建输出流
		OutputStream out = null;
		;
		try {
			out = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		UtilFactory.getInstanceOfExcelUtilHandleDepartmentVo().exportToExcel("部门信息", headers, list, out);
		logger.info("文件创建成功");
		Iterator<DepartmentVo> its = list.iterator();
		while (its.hasNext()) {
			logger.info(its.next());
		}

	}

	/**
	 * 该方法用来产生一个时间字符串（即：时间戳）
	 * 
	 * @return
	 *//*
		 * public static String getTimeStamp() { SimpleDateFormat dateFormat =
		 * new SimpleDateFormat( "yyyy-MM-dd hh:MM:ss"); Date date = new Date();
		 * return dateFormat.format(date); }
		 */
}
