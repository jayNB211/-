package com.clps.oas.sm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.sm.vo.AccountVo;

@Service
public interface IParameterService {
	
	/**
	 * 
	 * @param parameter
	 * @return String
	 * 添加参数
	 */
	public String addParameter(Parameter parameter);
	
	/**
	 * 
	 * @return List<Parameter>
	 * 查询所有参数
	 */
	public List<Parameter> showParameters();
	
	/**
	 * 分页查询账户信息
	 * 
	 * @author: hjq
	 * @createTime: 2018年5月31日 上午10:22:27
	 * @history:
	 * @param pagingVO
	 * 
	 *            
	 */
	List<Parameter> queryAllParametersByPaging(Integer toPageNo);
	
	
	/**
	 * 
	 * @param parameterId
	 * @return String
	 * 通过参数Id删除参数
	 */
	public String delectParameter(Integer parameterId);
	
	
	/**
	 * 
	 * @param name
	 * @return List<Parameter>
	 * @throws Exception
	 * 根据名字模糊查询
	 */
    List<Parameter> findByName(String name) throws Exception;
	
	/**
	 * 
	 * @param parameter
	 * @return String
	 * 更新参数
	 */
	public String updateParameter(Parameter parameter);
	
	
/**
 * 	
 * queryParameterById:(通过Id查询参数). 
 * (要单独查询某参数时使用).
 *
 * @author hjq
 *
 * @since JDK 1.8
 */
	public Parameter queryParameterById(Integer parameterId);
	
	
	/**
	 * 获取参数总数
	 * 
	 * @author: hjq
	 * @createTime: 2018年5月31日 上午10:35:26
	 * @return int
	 */
	int countParameters();

}
