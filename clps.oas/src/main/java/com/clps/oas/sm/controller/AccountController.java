package com.clps.oas.sm.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.pojo.Role;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.service.IPositionService;
import com.clps.oas.sm.service.IRoleService;
import com.clps.oas.sm.vo.AccountVo;
import com.clps.oas.util.paging.PagingVO;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月28日 上午10:47:36
 * @version: v1.0
 */
@Controller
@RequestMapping(value = "/sm")
public class AccountController implements Serializable {

	private static final long serialVersionUID = -947655096266349816L;

	@Autowired
	@Qualifier("accountService")
	private IAccountService ias;

	@Autowired
	@Qualifier("RoleServiceImpl")
	private IRoleService irs;

	@Autowired
	@Qualifier("positionService")
	private IPositionService ips;

	// @Autowired
	// @Qualifier("departmentService")
	// private IDepartmentService ids;

	@RequestMapping(value = "/accountList")
	public String showAccountList(Model model, Integer page) {
		List<AccountVo> accounts = null;
		// 页码对象
		PagingVO pagingVO = new PagingVO();
		// 设置总页数
		pagingVO.setTotalCountPage(ias.countAccounts());
		if (page == null || page == 0) {
			pagingVO.setToPage(1);
			accounts = ias.queryAllAccountsByPaging(1);
		} else {
			pagingVO.setToPage(page);
			accounts = ias.queryAllAccountsByPaging(page);
		}
		model.addAttribute("accounts", accounts);
		model.addAttribute("pagingVO", pagingVO);

		return "sm/account_list";
	}

	@RequestMapping(value = "/selectAccount", method = { RequestMethod.POST })
	private String findAccount(String accountName, Model model) {

		List<AccountVo> findaccounts = ias.queryAccountVoBySimilarName(accountName);
		model.addAttribute("accounts", findaccounts);
		return "sm/account_list";
	}

	@RequestMapping("/account_addView")
	public String addView(Model model) {
		List<Role> roles = irs.showRoles();
		model.addAttribute("roleList", roles);
		List<Position> positions = ips.queryAllPosition();
		model.addAttribute("positionList", positions);
		// List<Department> departments =ids.showDepartment();
		// model.addAttribute("departmentList", departments);
		return "sm/account_add";
	}

	@RequestMapping(value = "/addAccount")
	public String addAccount(HttpServletRequest request, HttpSession session, Account account) {

		String loginName = (String) session.getAttribute("loginName");
		account.setAccountName(request.getParameter("accountName"));
		account.setAccountPass(request.getParameter("accountPwd"));
		account.setAccountRealName(request.getParameter("accountRealName"));
		account.setAccountMail(request.getParameter("accountMail"));
		account.setAccountAddress(request.getParameter("accountAddress"));
		account.setAccountRoleId(Integer.parseInt(request.getParameter("accountRoleId")));
		account.setAccountPositionId(Integer.parseInt(request.getParameter("accountPositionId")));
		account.setAccountCompanyId(Integer.parseInt(request.getParameter("accountCompanyId")));
		account.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account.setAccountCreatedName(loginName);
		account.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account.setAccountUpdatedName(loginName);
		account.setAccountIsvalid(true);

		if (ias.insertAccountInfo(account) == 1) {
			return "redirect:/sm/accountList";
		} else {
			return "redirect:/sm/account_addView";
		}

	}

	@RequestMapping(value = "/logicDelAccount")
	public String logicDelAccount(int accountId) {

		if (ias.logicDeleteAccountById(accountId) == 1) {
			return "redirect:/sm/accountList";
		} else {
			return "redirect:/sm/accountList";
		}
	}

	@RequestMapping("/account_updateView")
	public String updateView(HttpServletRequest request, Model model, Model model1, Model model2) {

		Integer accountId = Integer.parseInt(request.getParameter("accountId"));
		Account account = new Account();
		AccountVo accountVo = new AccountVo();
		account = ias.queryAccountById(accountId);
		accountVo = ias.queryAccountVoById(accountId);
		List<Role> roles = irs.showRoles();
		model.addAttribute("roleList", roles);
		List<Position> positions = ips.queryAllPosition();
		model.addAttribute("positionList", positions);
		model1.addAttribute("account", account);
		model2.addAttribute("accountVo", accountVo);
		return "sm/account_update";
	}

	@RequestMapping(value = "/updateAccount")
	public String updateAccount(HttpServletRequest request, HttpSession session, Account account) {
		
		String loginName = (String) session.getAttribute("loginName");
		account.setAccountName(request.getParameter("accountName"));
		account.setAccountPass(request.getParameter("accountPwd"));
		account.setAccountRealName(request.getParameter("accountRealName"));
		account.setAccountMail(request.getParameter("accountMail"));
		account.setAccountAddress(request.getParameter("accountAddress"));
		account.setAccountRoleId(Integer.parseInt(request.getParameter("accountRoleId")));
		account.setAccountPositionId(Integer.parseInt(request.getParameter("accountPositionId")));
		account.setAccountCompanyId(Integer.parseInt(request.getParameter("accountCompanyId")));
		account.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account.setAccountUpdatedName(loginName);
		account.setAccountIsvalid(true);
		if (ias.updateAccountInfo(account) == 1) {
			return "redirect:/sm/accountList";
		} else {
			return "redirect:/sm/account_updateView";
		}

	}
}
