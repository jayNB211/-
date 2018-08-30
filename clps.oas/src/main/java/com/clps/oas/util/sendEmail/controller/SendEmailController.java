
package com.clps.oas.util.sendEmail.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.util.paging.PagingVO;
import com.clps.oas.util.sendEmail.pojo.SendEmail;
import com.clps.oas.util.sendEmail.service.ISendEmailService;


/** 
* @ClassName: SendEmailController 
* @Description: 建立控制器
* @author love.chen
* @date 
*  
*/
@Controller
@RequestMapping(value="/sm")
public class SendEmailController {
	
	@Resource
	@Qualifier("sendEmailService")
	private ISendEmailService iss;
	
	
	@RequestMapping(value="/sendemailList")
	public String showSendEmail(Model model, Integer page){
		List<SendEmail> sendemails=iss.queryAllSendEmail();
		model.addAttribute("sendemails", sendemails);
		
		
		// 页码对象
				PagingVO pagingVO = new PagingVO();
				// 设置总页数
				pagingVO.setTotalCountPage(iss.countSendEmails());
				if (page == null || page == 0) {
					pagingVO.setToPage(1);
					sendemails = iss.queryAllSendEmailsByPaging(1);
				} else {
					pagingVO.setToPage(page);
					sendemails = iss.queryAllSendEmailsByPaging(page);
				}
				model.addAttribute("sendemails", sendemails);
				model.addAttribute("pagingVO", pagingVO);
				return "sm/sendemail_list";
	}
	
	@RequestMapping(value="/toAddEmail")
	public String toAddEmail(){
		return "sm/sendemail_add";
	}
	
	@RequestMapping(value="/addEmail")
	public String addSendEmail(SendEmail record,Model model){
		iss.insertSendEmail(record);
		return "sm/sendemail_addResult";
		
	}
	
	@RequestMapping(value="/delEmail")
	public String delSendEmail(int emailId){
		
		iss.deleteByEmailId(emailId);
		
		return "sm/sendemail_delResult";
	}
	
	@RequestMapping(value="/getEmail")
	public String getEmail(int emailId,Model model){
		SendEmail sendemail = iss.querySendEmailByEmailId(emailId);
		model.addAttribute("sendemail",sendemail);
		return "sm/sendemail_update";
	}
	
	@RequestMapping(value="/updateEmail",method=RequestMethod.POST)
	public String updateEmail(SendEmail record,Model model){
		iss.updateSendEmail(record);	
		record = iss.querySendEmailByEmailId(record.getEmailId());
		return "sm/sendemail_updateResult";
	}
	
	
	
	

}
