
package com.clps.oas.sm.service;

import java.util.List;

import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.vo.AccountVo;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月17日 上午10:36:53
 * @version: v1.0
 */
public interface IAccountService {

	/**
	 * 物理删除账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:00
	 * @param accountId
	 * @return int
	 */
	int deleteAccountById(Integer accountId);

	/**
	 * 逻辑删除账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:17
	 * @param accountId
	 * @return int
	 */
	int logicDeleteAccountById(Integer accountId);

	/**
	 * 新增账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:48
	 * @param record
	 * @return int
	 */
	int insertAccountInfo(Account record);

	/**
	 * 查询所有账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:12:42
	 * @history:
	 * @return List<AccountVo>
	 */
	List<AccountVo> queryAllAccounts();

	/**
	 * 分页查询账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月31日 上午10:22:27
	 * @history:
	 * @param pagingVO
	 * @throws Exception
	 *             List<StudentCustom>
	 */
	List<AccountVo> queryAllAccountsByPaging(Integer toPageNo);

	/**
	 * 根据账户id查询账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:12
	 * @return Account
	 */
	Account queryAccountById(Integer accountId);

	/**
	 * 根据账户id查询accountVo
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:12
	 * @return AccountVo
	 */
	AccountVo queryAccountVoById(Integer accountId);

	/**
	 * 根据账户name查询账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:12
	 * @return Account
	 */
	Account queryAccountByName(String accountName);

	/**
	 * 根据账户name查询账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:12
	 * @return List<AccountVo>
	 */
	List<AccountVo> queryAccountVoBySimilarName(String accountName);

	/**
	 * 更新账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:26
	 * @param record
	 * @return int
	 */
	int updateAccountInfo(Account record);

	/**
	 * 获取账号总数
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月31日 上午10:35:26
	 * @return int
	 */
	int countAccounts();
}
