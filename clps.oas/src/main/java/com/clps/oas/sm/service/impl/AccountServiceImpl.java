
package com.clps.oas.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.sm.dao.AccountMapper;
import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.vo.AccountVo;
import com.clps.oas.util.paging.PagingVO;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月28日 上午10:46:18
 * @version: v1.0
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountdao;

	@Override
	public int deleteAccountById(Integer accountId) {
		return this.accountdao.deleteAccountById(accountId);
	}

	@Override
	public int logicDeleteAccountById(Integer accountId) {
		return this.accountdao.logicDeleteAccountById(accountId);
	}

	@Override
	public int insertAccountInfo(Account record) {
		return this.accountdao.insertAccountInfo(record);
	}

	@Override
	public List<AccountVo> queryAllAccounts() {
		return this.accountdao.queryAllAccounts();
	}

	@Override
	public List<AccountVo> queryAllAccountsByPaging(Integer toPage) {

		PagingVO pagingVO = new PagingVO();
		pagingVO.setToPage(toPage);
		return this.accountdao.queryAllAccountsByPaging(pagingVO);
	}

	@Override
	public Account queryAccountById(Integer accountId) {
		return this.accountdao.queryAccountById(accountId);
	}

	@Override
	public AccountVo queryAccountVoById(Integer accountId) {
		return this.accountdao.queryAccountVoById(accountId);

	}

	@Override
	public Account queryAccountByName(String accountName) {
		return this.accountdao.queryAccountByName(accountName);

	}

	@Override
	public List<AccountVo> queryAccountVoBySimilarName(String accountName) {
		return this.accountdao.queryAccountVoBySimilarName(accountName);

	}

	@Override
	public int updateAccountInfo(Account record) {
		return this.accountdao.updateAccountInfo(record);
	}

	@Override
	public int countAccounts() {
		return this.accountdao.countAccounts();
	}

}
