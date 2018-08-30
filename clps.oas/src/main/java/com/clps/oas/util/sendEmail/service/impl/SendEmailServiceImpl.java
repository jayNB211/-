
package com.clps.oas.util.sendEmail.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.util.paging.PagingVO;
import com.clps.oas.util.sendEmail.dao.SendEmailMapper;
import com.clps.oas.util.sendEmail.pojo.SendEmail;
import com.clps.oas.util.sendEmail.service.ISendEmailService;



@Service("sendEmailService")
public class SendEmailServiceImpl implements ISendEmailService{
	
	@Autowired
    private SendEmailMapper sendemaildao;
	
	public List<SendEmail> queryAllSendEmail() {
		
		return sendemaildao.queryAllSendEmail();
	
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.sendEmail.service.ISendEmailService#insertSendEmail(com.clps.oas.util.sendEmail.pojo.SendEmail)
	 */
	
	public String insertSendEmail(SendEmail record) {
		
		if(sendemaildao.insertSendEmail(record)>0){
			return ParamCommon.ADD_SUCCESS;
		}
		return ParamCommon.ADD_FAILURE;
	}
	/**
	 * 
	 *  
	 * @see com.clps.oas.util.sendEmail.service.ISendEmailService#deleteByEmailId(java.lang.Integer)
	 */
	
	public String deleteByEmailId(Integer emailId) {
		if(sendemaildao.deleteByEmailId(emailId)>0){
			return ParamCommon.DELETE_SUCCESS;
		}
		return ParamCommon.DELETE_FAILURE;
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.sendEmail.service.ISendEmailService#updateSendEmail(com.clps.oas.util.sendEmail.pojo.SendEmail)
	 */

	public String updateSendEmail(SendEmail record) {
		if(sendemaildao.updateSendEmail(record)>0){
			return ParamCommon.UPDATE_SUCCESS;
		}
		return ParamCommon.UPDATE_FAILURE;
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.sendEmail.service.ISendEmailService#querySendEmailByEmailId(java.lang.Integer)
	 */

	public SendEmail querySendEmailByEmailId(Integer emailId) {
		return sendemaildao.querySendEmailByEmailId(emailId);
	
	}
	@Override
	public List<SendEmail> queryAllSendEmailsByPaging(Integer toPage) {
		PagingVO pagingVO = new PagingVO();
		pagingVO.setToPage(toPage);
		return this.sendemaildao.queryAllSendEmailsByPaging(pagingVO);
	}
	@Override
	public int countSendEmails() {
		
		return this.sendemaildao.countSendEmails();
	}

}
