package com.clps.oas.sm.controller;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.sm.service.IParameterService;
import com.clps.oas.util.factory.UtilFactory;
import com.clps.oas.util.paging.PagingVO;


@Controller
@RequestMapping(value="/sm")
public class ParameterController extends HttpServlet{
	
	
	/**
	 * serialVersionUID:(用一句话描述这个变量表示什么).
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = -6887981111418836793L;
	
	/**
	 * 自动注入IParameterService
	 */
	@Autowired
	@Qualifier("patService")
	@Resource
	private IParameterService patService;
	private Parameter parameterInfo;
	private Timestamp ts;
	Logger log=Logger.getLogger(ParameterController.class);
	
	
	
	public ParameterController() {

		this.ts= getTimestampServlet();
		parameterInfo=new Parameter();
	}
	
	private Timestamp getTimestampServlet() {
		return UtilFactory.getInstanceOfDateUtil().getTimestamp();
	}
	
	/**
	 * 
	 * showParameter:(查询所有参数). 
	 *  处理/parameterList请求
	 *
	 * @author hjq
	 *
	 * @since JDK 1.8
	 */
	@RequestMapping(value="/parameterList")
	public String showParameter(Model model, Integer page){
		
		List<Parameter> parameters=null;
		// 页码对象
				PagingVO pagingVO = new PagingVO();
				// 设置总页数
				pagingVO.setTotalCountPage(patService.countParameters());
				if (page == null || page == 0) {
					pagingVO.setToPage(1);
					parameters = patService.queryAllParametersByPaging(1);
				} else {
					pagingVO.setToPage(page);
					parameters = patService.queryAllParametersByPaging(page);
				}
		model.addAttribute("parameters", parameters);
		model.addAttribute("pagingVO", pagingVO);
		
		return "sm/parameter_list";
	}
	
	// 搜索参数
    @RequestMapping(value = "selectParameter", method = RequestMethod.POST)
    private String selectParameter(String findByName, Model model) throws Exception {

        List<Parameter> list = patService.findByName(findByName);

        model.addAttribute("parameters", list);
        return "sm/parameter_list";
    }
	
    // 修改学生信息页面显示
	@RequestMapping(value="/parameterAdd")
	public String parameterAdd(){
		return "sm/parameter_add";
		
		
	}
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 *  添加学生信息操作
	 */
	@RequestMapping(value="/addParameter",method=RequestMethod.POST)
	public String addParameter(Model model,HttpServletRequest request) throws ServletException, IOException{
		setParameter(request);
		String result=this.patService.addParameter(this.parameterInfo);
		
		if(result=="1")
		{
			List<Parameter> parameters=this.patService.showParameters();
			model.addAttribute("parameters", parameters);
			return "sm/parameter_list";
			
		}else{
			
			return "sm/parameter_add";
		}
		
		
	}
	
	//  修改学生信息页面显示
	@RequestMapping(value="/findParameterById")
	public String findParameterById(Model model,HttpServletRequest request){
		String parameterId= request.getParameter("parameterId");
		this.parameterInfo=this.patService.queryParameterById(Integer.parseInt(parameterId));
		if(parameterInfo!=null){
			model.addAttribute("parameter",parameterInfo);
			//request.setAttribute("parameter", parameterInfo);
			//mv.setView(new RedirectView("parameter_update"));
			return "sm/parameter_update";
			
		}else{
			//mv.addObject("message","the input is null");
			//mv.setViewName("sm/parameter_list");
			return "sm/parameter_list";
		}
						
		
	}
	
	// 修改学生信息操作
	@RequestMapping(value="/updateParameter",method=RequestMethod.POST)
	public String updateParameter(Model model,HttpServletRequest request){
		setParameter(request);
		String result=this.patService.updateParameter(this.parameterInfo);
		log.info("update start...");
		if(result=="1")
		{
			List<Parameter> parameters=this.patService.showParameters();
			model.addAttribute("parameters", parameters);
			return "sm/parameter_list";
			
		}else{
			log.info("update failed!");
			return "sm/parameter_update";
		}
		
		//return mv;
		
		
	}

	@RequestMapping(value="/deleteParameter")
	public String deleteParameter(Model model,HttpServletRequest request) {
		
		String parameterId=request.getParameter("parameterId");
		log.info(parameterId);
		String result=this.patService.delectParameter(Integer.parseInt(parameterId));
		if(result=="1")
		{
			List<Parameter> parameters=this.patService.showParameters();
			model.addAttribute("parameters", parameters);
			return "sm/parameter_list";
			
		}else{
			
			return "sm/parameter_list";
		}
		
		
		
	}
	

private void setParameter(HttpServletRequest request) {
		
		String parameterName= request.getParameter("parameterName");
		String parameterConent= request.getParameter("parameterConent");
		String parameterSpuelid=request.getParameter("parameterSpuelid");
		String parameterComment= request.getParameter("parameterComment");
		String inputParameterId= request.getParameter("parameterId");
		Parameter parameter= new Parameter();
		HttpSession session= request.getSession();
		String loginName = (String) session.getAttribute("loginName");
		if(inputParameterId==null&&parameterInfo==null){
			parameter.setParameterId(0);
		}else{
			parameter.setParameterId(parameterInfo.getParameterId());
		}
		parameter.setParameterName(parameterName);
		parameter.setParameterConent(parameterConent);
		parameter.setParameterSpuelid(Integer.parseInt(parameterSpuelid));
		parameter.setParameterComment(parameterComment);
		parameter.setParameterCreatedName(loginName);
		parameter.setParameterCreatedDatetime(this.ts);
		parameter.setParameterUpdatedName(loginName);
		parameter.setParameterUpdatedDatetime(this.ts);
		parameter.setParameterIsvariable(1);
		this.parameterInfo=parameter;
		
		
	}
}
