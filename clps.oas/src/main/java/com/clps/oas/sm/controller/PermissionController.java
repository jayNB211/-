package com.clps.oas.sm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.service.IPermissionService;
import com.clps.oas.sm.vo.PermissionVO;

/**
 * @description this is PermissionController
 * @author noah.zhou
 * @date 创建时间：2018年5月14日 下午3:13:14
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/sm") // 控制路径为项目名字加上"/sm"
public class PermissionController {

	@Resource
	private IPermissionService permissionService;// 实例化permissionService

	
	@RequestMapping(value = "/permissionvoList") // 控制路径为项目名字加上"/sm/permissionvoList"
	public String showPermissionVO(Model model) {
		List<PermissionVO> permissionvo = permissionService.queryAllPermissionVO();
		model.addAttribute("permissionvos", permissionvo);
		return "sm/permissionvo_list";// 返回查询VO页面
	}
	
	@RequestMapping(value = "/delPermissionVO", method = RequestMethod.GET)
	public String delPermissionVO(@RequestParam("permissionId") Integer permissionId,Model model) { // 获取到permissionId的值作为此函数的参数值

		if(permissionService.deletePermissionVOById(permissionId)==ParamCommon.DELETE_SUCCESS){
			List<PermissionVO> permissionvo = permissionService.queryAllPermissionVO();
			model.addAttribute("permissionvos", permissionvo);
			return "sm/permissionvo_list";// 返回查询VO页面
		}
		return "sm/fail.jsp";// 返回失败页面

	}

	@RequestMapping(value = "/showAddPermission")
	public String showAddPermission() {
		return "sm/permission_add";// 返回添加权限页面
	}
	
	@RequestMapping(value = "/addPermissionVO", method = RequestMethod.POST)
	public String addPermissionVO(PermissionVO permissionVO,Model model) { 
		permissionVO.setPermissionCreatedDateTime(null);
		permissionVO.setPermissionUpdatedDateTime(null);
		permissionVO.setPermissionUpdatedName(1);
		if (permissionService.addPermissionVO(permissionVO) == ParamCommon.ADD_SUCCESS) {
			List<PermissionVO> permissionvo = permissionService.queryAllPermissionVO();
			model.addAttribute("permissionvos", permissionvo);
			return "sm/permissionvo_list";// 返回查询VO页面
		}
		return "sm/fail.jsp";// 返回失败页面
	}
	
	@RequestMapping(value = "/showUpdatePermission")
	public String showUpdatePermission() {
		return "sm/permission_update";// 返回更新权限页面
	}
	
	@RequestMapping(value = "/updatePermissionVO", method = RequestMethod.POST)
	public String updatePermissionVO(PermissionVO permissionVO,Model model) {
		permissionVO.setPermissionCreatedDateTime(null);
		permissionVO.setPermissionUpdatedDateTime(null);
		if (permissionService.updatePermissionVO(permissionVO)== ParamCommon.UPDATE_SUCCESS) {
			List<PermissionVO> permissionvo = permissionService.queryAllPermissionVO();
			model.addAttribute("permissionvos", permissionvo);
			return "sm/permissionvo_list";// 返回查询VO页面
		}
		return "sm/fail";// 返回失败页面
	}
}
