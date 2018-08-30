/**
 * 
 */
package com.clps.oas.sm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.pojo.Department;
import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.service.IDepartmentService;
import com.clps.oas.sm.service.IPositionService;
import com.clps.oas.sm.service.IRoleService;
import com.clps.oas.util.date.DateUtil;
import com.clps.oas.util.paging.PagingVO;

/**
 * 
 * @ClassName: PositionController
 * @Description: position controller
 * @author leonardo.wang
 * @date 2018年5月17日 上午11:23:17
 *
 */
@Controller
@RequestMapping(value = "/sm")
public class PositionController {

	@Autowired
	@Qualifier("accountService")
	private IAccountService ias;

	@Autowired
	@Qualifier("RoleServiceImpl")
	private IRoleService irs;

	@Autowired
	@Qualifier("positionService")
	private IPositionService positionService;

	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;

	/**
	 * 
	 * list页面展示所有数据 date: 2018年5月17日 上午11:24:00.
	 * 
	 * @author WangZJ
	 * @return String
	 * @throws Exception
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionList")
	public String showUser(Model model, Integer page) throws Exception {
		List<Position> positions = null;
		// 页码对象
		PagingVO pagingVO = new PagingVO();
		// 设置总页数
		pagingVO.setTotalCountPage(positionService.countPositions());
		if (page == null || page == 0) {
			pagingVO.setToPage(1);
			positions = positionService.findByPaging(1);
		} else {
			pagingVO.setToPage(page);
			positions = positionService.findByPaging(page);
		}
		model.addAttribute("positions", positions);
		model.addAttribute("pagingVO", pagingVO);
		return "sm/position_list";
	}

	/**
	 * 
	 * 删除操作 date: 2018年5月17日 上午11:24:31.
	 * 
	 * @author WangZJ
	 * @return String
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionDel")
	public String delPosition(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("positionId"));
		if (positionService.deletePositionbyId(id) > 0) {
			return "redirect:/sm/positionList";
		} else {
			return "sm/position_failed";
		}
	}

	/**
	 * 
	 * 跳转到添加页面 date: 2018年5月17日 上午11:24:50.
	 * 
	 * @author WangZJ
	 * @return String
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionAdd")
	public String addPosition(HttpServletRequest request, HttpSession session, Model model) {
		String loginName = (String) session.getAttribute("loginName");
		Account account = new Account();
		List<Department> departmentLists = departmentService.showDepartment();
		account = ias.queryAccountByName(loginName);
		Position position = new Position();
		position.setPositionCreatedName(account.getAccountId());
		model.addAttribute("position", position);
		model.addAttribute("account", account);
		model.addAttribute("departmentLists", departmentLists);
		return "sm/position_add";
	}

	/**
	 * 
	 * 执行添加操作 date: 2018年5月17日 上午11:25:02.
	 * 
	 * @author WangZJ
	 * @return String
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionAddsuccess", method = RequestMethod.POST)
	public String addPosition2(Position position, Model model) {
		DateUtil time = new DateUtil();
		position.setPositionCreatedDatetime(time.getTimestamp());
		position.setPositionUpdatedName(position.getPositionCreatedName());
		position.setPositionUpdatedDatetime(time.getTimestamp());
		if (positionService.savePosition(position).equals(ParamCommon.ADD_SUCCESS)) {
			return "redirect:/sm/positionList";
		} else {
			return "redirect:/sm/positionAdd";
		}
	}

	/**
	 * 
	 * 跳转到更新页面
	 * 
	 * date: 2018年5月21日 上午11:24:19.
	 * 
	 * @author WangZJ
	 * @return String
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionUpdate")
	public String updatePosition(HttpServletRequest request, HttpSession session, Model model) {
		String loginName = (String) session.getAttribute("loginName");
		Account account = new Account();
		List<Department> departmentLists = departmentService.showDepartment();
		account = ias.queryAccountByName(loginName);
		Position position = new Position();
		Integer id = Integer.parseInt(request.getParameter("positionId"));
		position = positionService.queryPositionById(id);
		position.setPositionCreatedName(account.getAccountId());
		model.addAttribute("position", position);
		model.addAttribute("account", account);
		model.addAttribute("departmentLists", departmentLists);
		return "sm/position_update";
	}

	/**
	 * 
	 * 更新并跳转回list date: 2018年5月21日 上午11:24:42.
	 * 
	 * @author WangZJ
	 * @return String
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "/positionUpdateSuccess", method = RequestMethod.POST)
	public String updatePosition2(Position position, Model model) {
		if (positionService.updatePosition(position).equals(ParamCommon.CHANGE_SUCCESS)) {
			return "redirect:/sm/positionList";
		} else {
			return "redirect:/sm/positionUpdate";
		}
	}

	/**
	 * 
	 * selectStudent
	 * 
	 * @author WangZJ
	 * @param findByName
	 * @param model
	 * @return
	 * @throws Exception
	 * @since JDK 1.8
	 */
	@RequestMapping(value = "positionSelectByName", method = { RequestMethod.POST })
	private String selectStudent(String findByName, Model model) throws Exception {

		List<Position> positions = positionService.queryPositionByName(findByName);

		model.addAttribute("positions", positions);
		return "sm/position_list";
	}
}
