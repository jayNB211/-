/**    
* @Title: DeaprtmentController.java  
* @Package com.clps.oas.sm.controller  
* @author ft   
* @date 2018年5月8日 上午9:40:21  
* @version V1.0    
*/
package com.clps.oas.sm.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Department;
import com.clps.oas.sm.service.IDepartmentService;
import com.clps.oas.util.paging.PagingVO;

/**
 * @ClassName: DeaprtmentController
 * @author Aiden
 * @date 2018年5月8日 上午9:40:21
 * 
 */
@Controller
@RequestMapping(value = "/sm")
public class DeaprtmentController {
	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;

	// 部门信息列表
	@RequestMapping(value = "/departmentList")
	public String showDepartment(Model model,Integer page) {

		List<Department> departments = null;
		// 页码对象
		PagingVO pagingVO = new PagingVO();
		// 设置总页数
		pagingVO.setTotalCountPage(departmentService.getCountDepartment());
		if (page == null || page == 0) {
			pagingVO.setToPage(1);
			departments=departmentService.findDepartmentPages(1);
		} else {
			pagingVO.setToPage(page);
			departments = departmentService.findDepartmentPages(page);
		}
		
		model.addAttribute("departments", departments);
		model.addAttribute("pagingVO", pagingVO);		
		
		return "sm/department_list";
	}

	// 跳转到新增页面
	@RequestMapping(value = "/toAddDepartment")
	public String toAddDepartment() {
		return "sm/department_add";
	}

	// 新增方法
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String addDepartment(Model model, HttpServletRequest request, Department department,Integer page) {

		department.setDepaCreateDatetime(new Timestamp(new Date().getTime()));
		department.setDepaUpdatedDatetime(new Timestamp(new Date().getTime()));
		String result = departmentService.insertSelective(department);
		if (result.equals(ParamCommon.ADD_SUCCESS) == true) {
			List<Department> departments = null;
			// 页码对象
			PagingVO pagingVO = new PagingVO();
			// 设置总页数
			pagingVO.setTotalCountPage(departmentService.getCountDepartment());
			if (page == null || page == 0) {
				pagingVO.setToPage(1);
				departments=departmentService.findDepartmentPages(1);
			} else {
				pagingVO.setToPage(page);
				departments = departmentService.findDepartmentPages(page);
			}
			
			model.addAttribute("departments", departments);
			model.addAttribute("pagingVO", pagingVO);		
			
			return "sm/department_list";
		} else {

			return "sm/department_add";
		}

	}

	// 删除操作
	@RequestMapping(value = "/delDepartment")
	public String delDepartment(int depaNumber, Model model,Integer page) {

		String result = departmentService.deleteByPrimaryKey(depaNumber);
		if (result.equals(ParamCommon.DELETE_SUCCESS) == true) {
			List<Department> departments = null;
			// 页码对象
			PagingVO pagingVO = new PagingVO();
			// 设置总页数
			pagingVO.setTotalCountPage(departmentService.getCountDepartment());
			if (page == null || page == 0) {
				pagingVO.setToPage(1);
				departments=departmentService.findDepartmentPages(1);
			} else {
				pagingVO.setToPage(page);
				departments = departmentService.findDepartmentPages(page);
			}
			
			model.addAttribute("departments", departments);
			model.addAttribute("pagingVO", pagingVO);		
			
			return "sm/department_list";
		} else
			return ParamCommon.DELETE_FAILURE;

	}

	// 跳转到更新页面
	@RequestMapping(value = "/updateView")
	public String updateView(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("depaNumber").trim());
		Department department = departmentService.queryDepartmentsById(id);
		model.addAttribute("department", department);
		return "sm/department_update";
	}

	// 更新操作
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public String updateDepartment(Model model, HttpServletRequest request, Department department,Integer page) {

		department.setDepaName(request.getParameter("depaName"));
		department.setDepaFatherNumber(request.getParameter("depaFatherNumber"));
		department.setDepaChildNumber(request.getParameter("depaChildNumber"));
		department.setDepaLevel(request.getParameter("depaLevel"));
		department.setDepaEmail(request.getParameter("depaEmail"));
		department.setDepaComment(request.getParameter("depaComment"));
		department.setDepaCreateName(request.getParameter("depaCreateName"));
		//department.setDepaCreateDatetime(new Timestamp(new Date().getTime()));
	    department.setDepaUpdatedName(request.getParameter("depaUpdatedName"));
		department.setDepaUpdatedDatetime(new Timestamp(new Date().getTime()));
		String result = departmentService.updateByPrimaryKeySelective(department);
		if (result.equals(ParamCommon.UPDATE_SUCCESS) == true) {
			List<Department> departments = null;
			// 页码对象
			PagingVO pagingVO = new PagingVO();
			// 设置总页数
			pagingVO.setTotalCountPage(departmentService.getCountDepartment());
			if (page == null || page == 0) {
				pagingVO.setToPage(1);
				departments=departmentService.findDepartmentPages(1);
			} else {
				pagingVO.setToPage(page);
				departments = departmentService.findDepartmentPages(page);
			}
			
			model.addAttribute("departments", departments);
			model.addAttribute("pagingVO", pagingVO);		
			
			return "sm/department_list";
		} else
			return "sm/department_update";

	}

	// 通过id号查询
	@RequestMapping(value = "/queryDepartmentById")
	public String queryDepartmentById(Model model, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("depaNumber").trim());
		List<Department> departments = departmentService.queryDepartmentsByIdlist(id);
		model.addAttribute("departments", departments);
		return "sm/department_list";

	}
	@RequestMapping(value="/queryDepartmentsByName",method = RequestMethod.POST)
	public String queryDepartmentsByName(Model model, HttpServletRequest request){
		String depaName=request.getParameter("depaName");
		List<Department> departments = departmentService.queryDepartmentsByName(depaName);
		model.addAttribute("departments", departments);
		return "sm/department_list";
	}

}
