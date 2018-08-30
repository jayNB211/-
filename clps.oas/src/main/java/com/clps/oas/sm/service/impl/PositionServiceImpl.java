package com.clps.oas.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.PositionMapper;
import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.service.IPositionService;
import com.clps.oas.util.paging.PagingVO;

@Service("positionService")
public class PositionServiceImpl implements IPositionService{

	@Autowired
	private PositionMapper positionDao;
	@Override
	public String savePosition(Position position) {
		if(position!=null)
		{
			if(positionDao.insertPosition(position)>0)
			{
				return ParamCommon.ADD_SUCCESS;
			}else{
				return ParamCommon.ADD_FAILURE;
			}
			
		}
		return ParamCommon.ADD_EMPTY;
	}

	@Override
	public String updatePosition(Position position) {
		if(position!=null)
		{
			if(positionDao.updatePosition(position)>0)
			{
				return ParamCommon.CHANGE_SUCCESS;
			}else{
				return ParamCommon.CHANGE_FAILURE;
			}
			
		}
		return ParamCommon.ADD_EMPTY;
	}

	@Override
	public Position queryPositionById(int positionId) {
		try {
			this.positionDao.queryPositionById(positionId);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryPositionById(positionId);
		}
				

	@Override
	public List<Position> queryAllPosition() {
		try {
			this.positionDao.queryAllPositions();
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryAllPositions();
	}

	@Override
	public List<Position> queryPositionByName(String positionName) {
		try {
			this.positionDao.queryPositionByName(positionName);
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryPositionByName(positionName);
	}

	@Override
	public int deletePositionbyId(int positionId) {
		return positionDao.deletePositionById(positionId);
	}

	@Override
	public List<Position> findByPaging(Integer toPage) throws Exception {
		PagingVO pagingVO = new PagingVO();
        pagingVO.setToPage(toPage);
        List<Position> list = positionDao.findByPaging(pagingVO);
        return list;
	}

	@Override
	public int countPositions() {
		return this.positionDao.countPositions();
	}

	@Override
	public List<Position> findAllDepartmentWithPosition() {
		try {
			this.positionDao.findAllDepartmentWithPosition();
		} catch (Exception e) {
			e.printStackTrace();
			}
		return positionDao.queryAllPositions();
	}

}
