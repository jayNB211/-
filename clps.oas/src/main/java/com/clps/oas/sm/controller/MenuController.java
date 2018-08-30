
/*
* clps.oas 下午11:55:30
*
*/

package com.clps.oas.sm.controller;


import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.clps.oas.sm.pojo.Menu;
import com.clps.oas.sm.service.IMenuService;
import com.clps.oas.util.sendEmail.pojo.TreeNode;
import com.clps.oas.util.tree.TreeUtil;

/**
 * @desc: clps.oas
 * @author: lxj
 * @createTime: 2018年5月5日 下午11:55:30
 * @version: v1.0
 */
@Controller
@RequestMapping(value = "/sm")
public class MenuController {

	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;
	public static Log log = LogFactory.getLog(MenuController.class);

	/**
	 * insert menu
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月8日 下午10:55:50
	 * @param mv
	 * @param request
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/menuAdd",method=RequestMethod.POST)
	public ModelAndView insertMenu(ModelAndView mv, HttpServletRequest request,HttpSession session, Menu menu) {

		String topMenu=request.getParameter("topMenu");
		String[] arr = topMenu.split("-");
		menu.setMenuParentid(Integer.parseInt(arr[1]));
		menu.setMenuLevel(Integer.parseInt(arr[2]));
			String result1 = menuService.queryMenuNameIsRepeat(menu.getMenuName(), menu.getMenuLevel(), menu.getMenuParentid());
			String result2 = menuService.queryMenuSortIdIsRepeat(menu.getMenuSortId(), menu.getMenuLevel(),
					menu.getMenuParentid());
			String result3 = menuService.queryMenuUrlIsRepeat(menu.getMenuUrl());
			int r1 = Integer.parseInt(result1);
			int r2 = Integer.parseInt(result2);
			int r3 = Integer.parseInt(result3);
			if (r1 > 0 ||r2 > 0 ||r3 > 0) {
				mv.addObject("message", "the input is repeat");
				mv.setViewName("sm/menu_add");
			} else {
				menu.setMenuId(null);
				menu.setMenuCreatedDatetime(new Timestamp(new Date().getTime()));
				String loginName = (String) session.getAttribute("loginName");
				menu.setMenuCreatedName(loginName);
				menu.setMenuUpdatedDatetime(new Timestamp(new Date().getTime()));
				menu.setMenuUpdatedName(loginName);
				String result = menuService.addMenu(menu);
				int r = Integer.parseInt(result);
				if (r > 0) {
					mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
				} else {
					mv.addObject("message", "insert failure");
					mv.setViewName("sm/menu_add");
				}
			}
		return mv;
	}
	/**
	 * find menu by id to update
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月8日 下午11:02:37
	 * @param model
	 * @param request
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/findMenuById")
	public String findMenu(Model model, HttpServletRequest request) {

		String menuId = request.getParameter("menuId");
		String menuParentid = request.getParameter("menuParentid");
		if (menuId == null || menuId.equals("")) {
			return "sm/menu_list";
		} else {
			int id = Integer.parseInt(menuId);
			int parentId = Integer.parseInt(menuParentid);
			if(parentId==0){
				parentId=1;
			}
			Menu menu = menuService.queryMenuById(id);
			Menu m = menuService.queryMenuById(parentId);
			m.setMenuLevel(m.getMenuLevel()+1);
			if (menu != null) {
				model.addAttribute("menuInfo", menu);
				model.addAttribute("menuTopMenu", m);
				return "sm/menu_edit";

			} else {
				return "sm/menu_list";
			}
		}

	}

	/**
	* update menu
	* @author: lxj
	* @createTime: 2018年5月8日 下午11:02:58
	* @param mv
	* @param request
	* @param session
	* @return ModelAndView
	*/
	@RequestMapping(value="/menuUpdate",method=RequestMethod.POST)
	public ModelAndView updateMenu(ModelAndView mv,HttpServletRequest request,HttpSession session,Menu menu){
		
		String topMenu=request.getParameter("topMenu");
		String[] arr = topMenu.split("-");
		menu.setMenuParentid(Integer.parseInt(arr[1]));
		menu.setMenuLevel(Integer.parseInt(arr[2]));
		String result1=menuService.queryMenuNameIsRepeat(menu.getMenuName(), menu.getMenuLevel(), menu.getMenuParentid());
		String result2=menuService.queryMenuSortIdIsRepeat(menu.getMenuSortId(), menu.getMenuLevel(), menu.getMenuParentid());
		String result3=menuService.queryMenuUrlIsRepeat(menu.getMenuUrl());
		int r1=Integer.parseInt(result1);
		int r2=Integer.parseInt(result2);
		int r3=Integer.parseInt(result3);
		if(r1>0&&r2>0&&r3>0){ 
			mv.addObject("message","the update is repeat");
			 Menu m=menuService.queryMenuById(menu.getMenuId());
				if(m!=null){
					mv.addObject("menuInfo", m);
					mv.setViewName("sm/menu_edit");
				}else{
					mv.addObject("message","the update is repeat");
				}
		}else{
			menu.setMenuUpdatedDatetime(new Timestamp(new Date().getTime()));
			String loginName = (String) session.getAttribute("loginName");
			menu.setMenuUpdatedName(loginName);
			String result = menuService.updateMenu(menu);
			int r = Integer.parseInt(result);

			if (r > 0) {
				mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
			} else {
				mv.addObject("message", "the input is null");
				mv.setViewName("sm/menu_edit");
			}
		}

		return mv;
	}

	/**
	 * change menu's isvariable
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月8日 下午11:03:51
	 * @param mv
	 * @param request
	 * @param session
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/changeMenuState")
	public ModelAndView changeMenuState(ModelAndView mv, HttpServletRequest request, HttpSession session) {

		String id = request.getParameter("menuId");
		if (id == null) {
			mv.addObject("message", "change the menu state fail");
		} else {
			
			List<Menu> list = menuService.queryAllMenu();
			int menuId = Integer.parseInt(id);
			menuId--;
			Menu menu = list.get(menuId);

			String result = menuService.updateMenuState(menu);
			int r = Integer.parseInt(result);
			if (r > 0) {
				mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
			} else {
				mv.addObject("message", "the input is null");

			}
		}

		return mv;

	}

	/**
	 * query all menu or query menu by condition
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月8日 下午11:04:21
	 * @param model
	 * @param request
	 * @param session
	 * @return String
	 */
	@RequestMapping(value = "/menu_list")
	public String queryMenuByCondition(Model model, HttpServletRequest request, HttpSession session) {

		String key = request.getParameter("keyWord");
		String date = request.getParameter("date");

		List<Menu> list = new ArrayList<>();
		if (key == null) {
			if (date == null) {
				list = menuService.queryMenuByCondition(null, 0);
			} else {
				int d = Integer.parseInt(date);
				list = menuService.queryMenuByCondition(null, d);
			}

		} else {
			if (date == null) {
				list = menuService.queryMenuByCondition(key, 0);
			} else {
				int d = Integer.parseInt(date);
				list = menuService.queryMenuByCondition(key, d);
			}

		}
		model.addAttribute("listMenu", list);
		session.setAttribute("listMenu", list);
		return "sm/menu_list";
	}

	/**
	 * 
	 * @desc:query menu nav
	 * @author: lilian
	 * @createTime: 2018年5月28日 下午4:07:52
	 * @param model
	 * @param session
	 * @return String
	 */
	@RequestMapping(value="/queryNav",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String queryMenuNav(Model model){

		List<Menu> menuList=menuService.queryAllMenu();
		List<TreeNode> tree=new ArrayList<>();
		for(Menu m:menuList){
			TreeNode node =new TreeNode();
			node.setNodeId(m.getMenuId());
			node.setParentId(m.getMenuParentid());
			node.setLevel(m.getMenuLevel());
			node.setText(m.getMenuName());
			node.setUrl(m.getMenuUrl());
			tree.add(node);
		}
		List<Object> list=new ArrayList<>();
		list=new TreeUtil().createTree(tree);
		ObjectMapper objectMapper = new ObjectMapper();
		 StringWriter stringWriter = new StringWriter();
		 try {
			objectMapper.writeValue(stringWriter, list);
		} catch (JsonGenerationException e) {
			
					e.printStackTrace();	
					
		} catch (JsonMappingException e) {	
			
					e.printStackTrace();
					
		} catch (IOException e) {
	
					e.printStackTrace();		
		}
		  
		 String jsonStr = stringWriter.toString();
		 return jsonStr;

	}


	 /** go to menu_add
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月14日 上午11:28:10
	 * @return String
	 */
	@RequestMapping(value = "/menu_add")
	public String menuAdd() {


		return "sm/menu_add";
	}
	

	 /** go to nav.jsp
	 * 
	 * @author: lxj
	 * @createTime: 2018年5月14日 上午11:28:10
	 * @return String
	 */
	@RequestMapping(value = "/nav")
	public String menuNav() {


		return "sm/nav";
	}
	
	

}
