
package com.clps.oas.sm.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.vo.AccountVo;
import com.clps.oas.util.mybatis.MyBatisUtil;
import com.clps.oas.util.paging.PagingVO;
import com.clps.oas.util.spring.SpringTestBase;

public class AccountServiceImplTest extends SpringTestBase {
	@Autowired
	private IAccountService ias;

	private SqlSessionFactory sf = null;
	private SqlSession session = null;

	private Account account1 = new Account();
	private Account account2 = new Account();
	private Account account3 = new Account();
	private Account account = new Account();

	@Before
	public void setUp() throws Exception {

		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();

		account1.setAccountName("jhx1");
		account1.setAccountRealName("金宏潇");
		account1.setAccountPass("123123");
		account1.setAccountMail("2602419977@qq.com");
		account1.setAccountAddress("金陵科技学院");
		account1.setAccountPhone("13913836275");
		account1.setAccountRoleId(1);
		account1.setAccountPositionId(1);
		account1.setAccountCompanyId(1);
		account1.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account1.setAccountCreatedName("jhx1");
		account1.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account1.setAccountUpdatedName("jhx1");
		account1.setAccountIsvalid(true);

		account2.setAccountName("jhx2");
		account2.setAccountRealName("金宏潇2");
		account2.setAccountPass("123");
		account2.setAccountMail("969863331@qq.com");
		account2.setAccountAddress("金陵科技学院");
		account2.setAccountPhone("13913836275");
		account2.setAccountRoleId(2);
		account2.setAccountPositionId(2);
		account2.setAccountCompanyId(2);
		account2.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account2.setAccountCreatedName("jhx2");
		account2.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account2.setAccountUpdatedName("jhx2");
		account2.setAccountIsvalid(true);

		account3.setAccountName("jhx3");
		account3.setAccountRealName("金宏潇3");
		account3.setAccountPass("1234");
		account3.setAccountMail("2602419977@qq.com");
		account3.setAccountAddress("金陵科技学院");
		account3.setAccountPhone("13913836275");
		account3.setAccountRoleId(3);
		account3.setAccountPositionId(3);
		account3.setAccountCompanyId(3);
		account3.setAccountCreatedDatetime(new Timestamp(new Date().getTime()));
		account3.setAccountCreatedName("jhx3");
		account3.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account3.setAccountUpdatedName("jhx3");
		account3.setAccountIsvalid(true);

		account.setAccountId(2);
		account.setAccountMail("jin_hx@163.com");
		account.setAccountUpdatedDatetime(new Timestamp(new Date().getTime()));
		account.setAccountUpdatedName("jhx3");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeleteById() {
		try {
			int i = this.ias.deleteAccountById(4);
			if (i > 0) {
				logger.info(ParamCommon.DELETE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.DELETE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testLogicDeleteById() {
		try {
			int i = this.ias.logicDeleteAccountById(2);
			if (i > 0) {
				logger.info(ParamCommon.DELETE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.DELETE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testInsertAccountInfo() {
		try {
			int i = this.ias.insertAccountInfo(account1);
			if (i > 0) {
				logger.info(ParamCommon.ADD_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.ADD_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testQueryAllAccounts() {
		try {
			Iterator<AccountVo> its = ias.queryAllAccounts().iterator();
			while (its.hasNext()) {
				System.out.println(its.next());
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testQueryAllAccountssByPaging() {
		try {
			PagingVO pagingVo = new PagingVO();
			pagingVo.setTotalCountPage(1);
			pagingVo.setToPage(1);
			Iterator<AccountVo> its = ias.queryAllAccountsByPaging(1).iterator();
			while (its.hasNext()) {
				System.out.println(its.next());
			}
			session.commit();
		} catch (Exception e) {
			logger.error(e);
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testQueryAccountById() {
		logger.info(ias.queryAccountById(1));
	}

	@Test
	public void testQueryAccountVoById() {
		logger.info(ias.queryAccountVoById(1));
	}

	@Test
	public void testQueryAccountByName() {
		if (ias.queryAccountByName("jhx1") != null) {
			logger.info(ias.queryAccountByName("jhx1"));
		} else {
			logger.error(ParamCommon.QUERY_FAILURE);
		}

	}

	@Test
	public void testQueryAccountVoBySimilarName() {
		try {
			Iterator<AccountVo> its = ias.queryAccountVoBySimilarName("jhx").iterator();
			while (its.hasNext()) {
				System.out.println(its.next());
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Test
	public void testUpdateAccountInfo() {
		try {
			int i = this.ias.updateAccountInfo(account);
			if (i > 0) {
				logger.info(ParamCommon.UPDATE_SUCCESS);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.UPDATE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Test
	public void testCountAccounts() {
		try {
			int i = this.ias.countAccounts();
			if (i > 0) {
				logger.info(i);
				session.commit();
			}
		} catch (Exception e) {
			logger.error(ParamCommon.UPDATE_FAILURE);
			e.printStackTrace();
			session.rollback();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
