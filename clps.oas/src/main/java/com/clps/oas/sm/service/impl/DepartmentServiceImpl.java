/**    
* @Title: DepartmentServiceImpl.java  
* @Package com.clps.oas.service.impl  

* @author ft   
* @date 2018年5月7日 下午2:18:43  
* @version V1.0    
*/
package com.clps.oas.sm.service.impl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.DepartmentMapper;
import com.clps.oas.sm.pojo.Department;

import com.clps.oas.sm.service.IDepartmentService;
import com.clps.oas.util.paging.PagingVO;


/**  
* @ClassName: DepartmentServiceImpl  
 
* @author Aiden
* @date 2018年5月7日 下午2:18:43  
*    
*/
@Service("departmentService")
public class DepartmentServiceImpl implements IDepartmentService{
	 
	@Autowired
	private DepartmentMapper departmentDao;
	public void init(){
		
	}

	@Override
	public List<Department> showDepartment() {
		
		
		return this.departmentDao.queryAllDepartments();
	}

	
	@Override
	public  Department queryDepartmentsById(Integer depaNumber) {
		
		return  this.departmentDao.queryDepartmentsById(depaNumber);
	}

	
	@Override
	public List<Department> queryDepartmentsByName(String depaName) {
		
		return this.departmentDao.queryDepartmentsByName(depaName);
	}

	
	@Override
	public String updateByPrimaryKeySelective(Department record) {
		if(departmentDao.updateByPrimaryKeySelective(record)>0)
		{
			
			return ParamCommon.UPDATE_SUCCESS;
		}
		
		return ParamCommon.UPDATE_FAILURE;
	}

	
	@Override
	public String deleteByPrimaryKey(Integer depaNumber) {
		if(departmentDao.deleteByPrimaryKey(depaNumber)>0)
		{
			
			return ParamCommon.DELETE_SUCCESS;
		}
		   
			return ParamCommon.DELETE_FAILURE;
		
		
	}

	
	@Override
	public String insertSelective(Department record) {
		if(departmentDao.insertSelective(record)>0)
		{
			
			return ParamCommon.ADD_SUCCESS;
		}
	
		return ParamCommon.ADD_FAILURE;
	}

	@Override
	public int getCountDepartment() {
		
		return departmentDao.countDepartments();
	}

	@Override
	public List<Department> findDepartmentPages(Integer toPage) {
		PagingVO pagingVO = new PagingVO();
		pagingVO.setToPage(toPage);
		return departmentDao.queryDepartmentByPaging(pagingVO);
		
	}

	@Override
	public List<Department> queryDepartmentsByIdlist(Integer depaNumber) {
		
		return departmentDao.queryDepartmentsByIdlist(depaNumber);
	}

	


	
}
