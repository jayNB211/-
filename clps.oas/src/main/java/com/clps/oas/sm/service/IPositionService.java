package com.clps.oas.sm.service;

import java.util.List;

import com.clps.oas.sm.pojo.Position;

public interface IPositionService {

	/**
	 * 
	 * 添加position对象
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	public String savePosition(Position position);
	
	/**
	 * 
	 * 更新
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	public String updatePosition(Position position);
	
	
	
	/**
	 * 
	 * 通过id号查询position
	 * @author WangZJ 
	 * @return Position  
	 * @since JDK 1.8
	 */
	public Position queryPositionById (int positionId);
	
	/**
	 * 
	 * 查询所有position对象
	 * @author WangZJ 
	 * @return List<Position>  
	 * @since JDK 1.8
	 */
	public List<Position> queryAllPosition();
	
	/**
	 * 
	 * 通过昵称查询position
	 * @author WangZJ 
	 * @return List<Position>  
	 * @since JDK 1.8
	 */
	public List<Position> queryPositionByName (String positionName);
	
	/**
	 * 逻辑删除position
	 * 
	 * @author WangZJ 
	 * @return int  
	 * @since JDK 1.8
	 */
	public int deletePositionbyId(int positionId);
	
	/**
	 * 
	 * @param toPage
	 * @return
	 * @throws Exception 
	 */
	List<Position> findByPaging(Integer toPage) throws Exception;
	
	/**
	 * 
	 * countPositions:() 
	 * @author WangZJ 
	 * @return 
	 * @since JDK 1.8
	 */
	int countPositions();
	
	/**
	 * 
	 * findAllDepartmentWithPosition:() 
	 * @author WangZJ 
	 * @return 
	 * @since JDK 1.8
	 */
	public List<Position> findAllDepartmentWithPosition();
}
