package com.clps.oas.util.sendEmail.dao;

import java.util.List;

import com.clps.oas.util.paging.PagingVO;
import com.clps.oas.util.sendEmail.pojo.SendEmail;

public interface SendEmailMapper {
	 
/**
 * 
 * deleteByEmailId:. <br/> 
 * 
 * @author love.chen
 * @param emailId
 * @return 
 * @since JDK 1.8
 */
    int deleteByEmailId(Integer emailId);
/**
 * 
 * insertSendEmail:. <br/> 
 * 
 * @author love.chen
 * @param record
 * @return 
 * @since JDK 1.8
 */
   
    int insertSendEmail(SendEmail record);
/**
 * 
 * insertSelective:. <br/> 
 * 
 * @author love.chen
 * @param record
 * @return 
 * @since JDK 1.8
 */
   
    int insertSelective(SendEmail record);
/**
 * 
 * querySendEmailByEmailId:. <br/> 
 * 
 * @author love.chen
 * @param emailId
 * @return 
 * @since JDK 1.8
 */
   
    SendEmail querySendEmailByEmailId(Integer emailId);
    /**
     * 
     * queryAllSendEmail:. <br/> 
     * 
     * @author love.chen
     * @return 
     * @since JDK 1.8
     */
    
    List<SendEmail> queryAllSendEmail();
/**
 * 
 * updateSendEmail:. <br/> 
 * 
 * @author love.chen
 * @param record
 * @return 
 * @since JDK 1.8
 */
 
    int updateSendEmail(SendEmail record);
/**
 * 
 * updateByPrimaryKeyWithBLOBs:. <br/> 
 * 
 * @author love.chen
 * @param record
 * @return 
 * @since JDK 1.8
 */
    int updateByPrimaryKeyWithBLOBs(SendEmail record);
    
	/**
	 * @param pagingVO
	 * @return
	 */
	List<SendEmail> queryAllSendEmailsByPaging(PagingVO pagingVO);
/**
 * 
 * updateByPrimaryKey:. <br/> 
 * 
 * @author love.chen
 * @param record
 * @return 
 * @since JDK 1.8
 */

    int updateByPrimaryKey(SendEmail record);
	int countSendEmails();
}
