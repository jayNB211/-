package com.clps.oas.sm.dao;

import java.util.List;

import com.clps.oas.sm.pojo.Department;
import com.clps.oas.util.paging.PagingVO;


public interface DepartmentMapper {
	/**
	 * 
	 * @Title: deleteByPrimaryKey @param @param
	 * depaNumber @param @return @return int @throws
	 */
	int deleteByPrimaryKey(Integer depaNumber);

	int insert(Department record);

	/**
	 * 
	 * @Title: insertSelective @param @param record @param @return @return
	 * int @throws
	 */
	int insertSelective(Department record);

	/**
	 * 
	 * @Title: selectByPrimaryKey @param @param
	 * depaNumber @param @return @return Department @throws
	 */
	Department selectByPrimaryKey(Integer depaNumber);

	/**
	 * 
	 * @Title: updateByPrimaryKeySelective @param @param
	 * record @param @return @return int @throws
	 */
	int updateByPrimaryKeySelective(Department record);

	int updateByPrimaryKey(Department record);

	/**
	 * 
	 * @Title: queryAllDepartments @param @return 用于list页面 @return
	 * List<Department> @throws
	 */
	List<Department> queryAllDepartments();

	/**
	 * 
	 * @Title: queryDepartmentsById @param @param depaNumber @param @return
	 * 返回department对象，用于form @return Department @throws
	 */

	Department queryDepartmentsById(Integer depaNumber);

	/**
	 * 
	 * @Title: queryDepartmentsByName @param @param
	 * depaName @param @return @return List<Department> @throws
	 */

	List<Department> queryDepartmentsByIdlist(Integer depaNumber);

	/**
	 * 通过name查询
	 * 
	 * @param depaName
	 * @return
	 */
	List<Department> queryDepartmentsByName(String depaName);

	// 显示数据条数
	int countDepartments();

	// 分页显示
	List<Department> queryDepartmentByPaging(PagingVO pagingVO);

}