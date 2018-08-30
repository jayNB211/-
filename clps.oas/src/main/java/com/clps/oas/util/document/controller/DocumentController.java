/**    
 * @Title: DocumentController.java  
 * @Package com.clps.oas.util.document.controller  
 * @Description: 处理上传下载文件请求控制器
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-29 10:41:16
 * @version V1.0    
 */
package com.clps.oas.util.document.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.clps.oas.util.document.pojo.Document;
import com.clps.oas.util.document.service.IDocumentService;
import com.clps.oas.util.paging.PagingVO;

/**
 * @ClassName: DocumentController
 * @Description: 处理上传下载文件请求控制器
 * @author weigion.wu
 * @date 2018-05-29 10:41:16
 */
@Controller
@RequestMapping(value = "/sm")
public class DocumentController {

	/**
	 * 自动注入 documentService
	 */
	@Autowired
	@Qualifier("documentService")
	private IDocumentService documentService;
	private Logger logger = Logger.getLogger(DocumentController.class);

	/**
	 * 
	 * @Title: documentList
	 * @Description:文件列表，显示所有文件信息
	 * @param model
	 * @param @return
	 * @return String
	 */
	@RequestMapping(value = "/documentList")
	public String documentList(Model model, Integer page) {
		/* 查询Document信息 */
		/* List<Document> documents = documentService.queryAllDocuments(); */
		List<Document> documents = null;
		// 页码对象
		PagingVO pagingVO = new PagingVO();
		// 设置总页数
		pagingVO.setTotalCountPage(documentService.countDocuments());
		if (page == null || page == 0) {
			pagingVO.setToPage(1);
			documents = documentService.queryAllDocumentsByPaging(1);
		} else {
			pagingVO.setToPage(page);
			documents = documentService.queryAllDocumentsByPaging(page);
		}

		model.addAttribute("documents", documents);
		model.addAttribute("pagingVO", pagingVO);
		return "util/document/document_list";
	}

	// 定位到上传的文件界面 /clps.oas/sm/documentUpload
	@RequestMapping(value = "/documentUpload", method = RequestMethod.GET)
	public String documentUpload() {
		
		return "util/document/document_upload";
	}

	/**
	 * 
	 * @Title: doUpload  
	 * @Description:实现文件上传控制  
	 * @param @param document
	 * @param @param modelAndView
	 * @param @param session
	 * @param @return
	 * @param @throws Exception    设定文件  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/doUpload")
	public ModelAndView doUpload(@ModelAttribute Document document, ModelAndView modelAndView, HttpSession session) throws Exception {
		// 上传文件路径
		String path = session.getServletContext().getRealPath("/fileUpload/");
		logger.info(path);
		// 上传文件名
		String fileName = document.getFile().getOriginalFilename();
		// 将上传文件保存到一个目标文件当中
		document.getFile().transferTo(new File(path + File.separator + fileName));

		// 插入数据库
		// 设置fileName
		String loginName = (String) session.getAttribute("loginName");
		document.setDocumentName(fileName);
		document.setDocumentCreatedDatetime(new Timestamp(new Date().getTime()));
		document.setDocumentCreatedName(loginName);
		document.setDocumentUpdatedDatetime(new Timestamp(new Date().getTime()));
		document.setDocumentUpdatedName(loginName);
		document.setDocumentIsvalid(true);	
		// 插入数据库
		documentService.addDocument(document);
		// 返回
		modelAndView.setViewName("redirect:/sm/documentList");
		// 返回
		return modelAndView;
	}

	/**
	 * 
	 * @Title: documentDelete  
	 * @Description: 处理删除文档请求
	 * @param @param request
	 * @param @param mv
	 * @param @return    设定文件  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/documentDelete")
	public ModelAndView documentDelete(HttpServletRequest request, ModelAndView mv) {

		String id = request.getParameter("documentId");

		// 根据id删除文档
		documentService.deleteDocumentById(Integer.parseInt(id));

		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/sm/documentList");
		// 返回ModelAndView
		return mv;
	}

	/**
	 * 
	 * @Title: updateDocument  
	 * @Description:处理修改文档请求
	 * @param @param request
	 * @param @param document
	 * @param @param mv
	 * @param @return    设定文件  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/documentUpdate")
	public ModelAndView updateDocument(HttpServletRequest request, @ModelAttribute Document document, ModelAndView mv) {
		String id = request.getParameter("documentId");
		// 根据id查询文档
		Document target = documentService.queryDocumentById(Integer.parseInt(id));
		// 设置Model数据
		mv.addObject("document", target);
		// 设置跳转到修改页面
		mv.setViewName("util/document/document_update");
		return mv;

	}

	/**
	 * 
	 * @Title: doUpdate  
	 * @Description: 执行更新 
	 * @param @param request
	 * @param @param document
	 * @param @param mv
	 * @param @param session
	 * @param @return
	 * @param @throws Exception
	 * @param @throws IOException    设定文件  
	 * @return ModelAndView    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/doUpdate")
	public ModelAndView doUpdate(HttpServletRequest request, @ModelAttribute Document document, ModelAndView mv, HttpSession session)
			throws Exception, IOException {
		String id = request.getParameter("documentId");
		// 上传文件路径
		String path = session.getServletContext().getRealPath("/fileUpload/");
		logger.info(path);
		// 上传文件名
		String fileName = document.getFile().getOriginalFilename();
		// 将上传文件保存到一个目标文件当中
		document.getFile().transferTo(new File(path + File.separator + fileName));

		String loginName = (String) session.getAttribute("loginName");
		document.setDocumentId(Integer.parseInt(id));
		document.setDocumentName(fileName);
		document.setDocumentUpdatedDatetime(new Timestamp(new Date().getTime()));
		document.setDocumentUpdatedName(loginName);
		// 执行修改操作
		documentService.updateDocument(document);
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/sm/documentList");

		// 返回
		return mv;
	}

	/**
	 * 
	 * @Title: documentDownLoad  
	 * @Description: 处理文档下载请求  
	 * @param @param request
	 * @param @param response
	 * @param @param session    设定文件  
	 * @return void    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/documentDownload")
	public void documentDownLoad(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 根据id查询文档
		String id = request.getParameter("documentId");
		Document target = documentService.queryDocumentById(Integer.parseInt(id));
		logger.info(target);
		String fileName = target.getDocumentName();
		try {

			// 上传文件路径
			String path = session.getServletContext().getRealPath("/fileUpload/");

			// 获得要下载文件的File对象
			File file = new File(path + File.separator + fileName);

			// 如果文件不存在
			if (!file.exists()) {
				logger.info("您要下载的文件已被删除！！");
			}

			// 设置响应头，控制浏览器下载该文件
			response.setContentType("application;charset=UTF-8");
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
			// 读取要下载的文件，保存到文件输入流
			FileInputStream in = new FileInputStream(path + "\\" + fileName);
			// 创建输出流
			OutputStream out = response.getOutputStream();
			// 创建缓冲区
			byte buffer[] = new byte[1024];
			int len = 0;
			// 循环将输入流中的内容读取到缓冲区当中
			while ((len = in.read(buffer)) > 0) {
				// 输出缓冲区的内容到浏览器，实现文件下载
				out.write(buffer, 0, len);
			}
			// 关闭文件输入流
			in.close();
			// 关闭输出流
			out.close();
		} catch (Exception e) {
			logger.error(e.getMessage());

		}
	}

	/**
	 * 
	 * @Title: queryDocumentLikeTitle  
	 * @Description: 通过标题模糊查询  
	 * @param @param patternTitle
	 * @param @param model
	 * @param @return    设定文件  
	 * @return String    返回类型  
	 * @throws
	 */
	@RequestMapping(value = "/queryDocumentLikeTitle")
	public String queryDocumentLikeTitle(@RequestParam("patternTitle") String patternTitle, Model model) {

		Document document = new Document();
		document.setDocumentTitle(patternTitle);

		/* 查询Document信息 */
		List<Document> documents = documentService.queryDocumentLikeTitle(document);
		model.addAttribute("documents", documents);

		return "util/document/document_list";
	}

}
