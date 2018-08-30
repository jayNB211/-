package com.clps.oas.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.util.paging.PagingVO;

public interface ParameterMapper {
	
	/**
	 * 
	 * @param parameterId
	 * @return int
	 * 通过ID删除参数
	 */
    int deleteParameterById(Integer parameterId);

    /**
     * 
     * @param record
     * @return int
     * 添加参数
     */
    int insertParameter(Parameter record);

    /**
     * 
     * @param parameterId
     * @return Parameter
     * 通过Id查询参数
     * 
     */
    Parameter queryParameterById(Integer parameterId);

    
    /**
	 * 分页查询参数信息
	 * 
	 * @author: hjq
	 * @createTime: 2018年5月31日 上午10:22:27
	 * @history:
	 * @param pagingVO
	 * @throws Exception
	 *            
	 */
	List<Parameter> queryAllParametersByPaging(PagingVO pagingVO); 
	
	
    /**
     * 
     * @param parameterId
     * @return int
     * 更新参数
     */
    int updateParameter(Parameter record);

    /**
     * @param parameterId
     * @return List<Parameter>
     * 查询全部参数
     */
    List<Parameter> queryAllParameters();

    /**
     * 
     * @param name
     * @return
     * 通过名字模糊查询参数
     */
	List<Parameter> findByName(@Param("name")String name);
	
	/**
	 * 获取参数总数
	 * 
	 * @author: hjq
	 * @createTime: 2018年5月31日 上午10:35:26
	 * @return int
	 */
	int countParameters();
	
	}