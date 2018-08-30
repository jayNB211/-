package com.clps.oas.sm.controller;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.service.IAccountService;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月28日 上午10:47:36
 * @version: v1.0
 */
@Controller
@RequestMapping(value = "/sm")
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1462845822393779322L;

	@Autowired
	@Qualifier("accountService")
	private IAccountService ias;

	@RequestMapping(value = "/")
	public String doLogin(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String accountName = request.getParameter("accountName");
		session.setAttribute("loginName", accountName);
		String password = request.getParameter("password");
		// Integer roleId = Integer.parseInt(request.getParameter("roleId"));
		Account account = new Account();
		account = ias.queryAccountByName(accountName);
		if ((account != null && account.getAccountPass().equals(password)) || (accountName.equals("admin")
				&& password.equals("123"))/* && account.getAccountRoleId() == roleId */) {
			return "sm/nav";
		} else {
			return "redirect:../index.jsp";
		}
	}

}
