
package com.clps.oas.util.sendEmail.service;

import java.util.List;


import com.clps.oas.util.sendEmail.pojo.SendEmail;




public interface ISendEmailService {
	/**
	 * 
	 * queryAllSendEmail:. <br/> 
	 * 查询所有邮件
	 * @author love.chen
	 * @return 
	 * @since JDK 1.8
	 */
	
	List<SendEmail> queryAllSendEmail();
	
	
	/**
	 * @param toPageNo
	 * @return
	 */
	List<SendEmail> queryAllSendEmailsByPaging(Integer toPageNo);
	/**
	 * 
	 * querySendEmailByEmailId:. <br/> 
	 * 根据邮箱id查询邮件
	 * @author love.chen
	 * @param emailId
	 * @return 
	 * @since JDK 1.8
	 */
	
	
	SendEmail querySendEmailByEmailId(Integer emailId);
	/**
	 * 
	 * insertSendEmail:. <br/> 
	 * 插入邮件
	 * @author love.chen
	 * @param record
	 * @return 
	 * @since JDK 1.8
	 */

	String insertSendEmail(SendEmail record);
	/**
	 * 
	 * deleteByEmailId:. <br/> 
	 * 删除邮件
	 * @author love.chen
	 * @param emailId
	 * @return 
	 * @since JDK 1.8
	 */
	
	String deleteByEmailId(Integer emailId);
	/**
	 * 
	 * updateSendEmail:. <br/> 
	 * 更新邮件
	 * @author love.chen
	 * @param record
	 * @return 
	 * @since JDK 1.8
	 */
	
	String updateSendEmail(SendEmail record);
	int countSendEmails();

}
