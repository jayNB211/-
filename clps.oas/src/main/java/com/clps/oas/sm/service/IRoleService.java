package com.clps.oas.sm.service;

import java.util.List;

import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.pojo.Role;

/**  
* @Title: IRoleService.java  
* @Package com.clps.oas.sm.service  
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/

/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午2:28:33
* @history:
* @version: v1.0
*/

public interface IRoleService {

	public String addRole(Role role);              //添加角色
	
	public List<Role> showRoles();                 //查询所有橘色
	
	public String  deleteRoleById(Integer roleId); //通过id删除橘色
	
	public String updateRole(Role role);           //更新角色
	
	public List<Role> showRolesByRoleId(Integer roleId);  //通过id查找
	
	public List<Role> showRolesByRoleName(String roleName);  //通过名字查找
	
	int countRoles();
	
	List<Role> findByPaging(Integer toPage) throws Exception;
	
}
