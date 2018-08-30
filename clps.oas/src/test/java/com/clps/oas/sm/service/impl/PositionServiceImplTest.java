package com.clps.oas.sm.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.clps.oas.sm.pojo.Position;
import com.clps.oas.sm.service.IPositionService;
import com.clps.oas.util.date.DateUtil;
import com.clps.oas.util.spring.SpringTestBase;

public class PositionServiceImplTest extends SpringTestBase {

	@Autowired
	private IPositionService ips;

	Position position = new Position();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSavePosition() {
		position.setPositionName("leo");
		position.setPositionCreatedName(1);
		DateUtil time = new DateUtil();
		position.setPositionUpdatedDatetime(time.getTimestamp());
		ips.savePosition(position);
	}

	@Test
	public void testUpdatePosition() {
		position.setPositionName("leo");
		position.setPositionCreatedName(1);
		position.setPositionId(13);
		DateUtil time = new DateUtil();
		position.setPositionUpdatedDatetime(time.getTimestamp());
		logger.info(ips.updatePosition(position));
	}

	@Test
	public void testQueryPositionById() {
		ips.queryPositionById(1);
	}

	@Test
	public void testQueryAllPosition() {
		ips.queryAllPosition();
	}

	@Test
	public void testQueryPositionByName() {
		logger.info(ips.queryPositionByName("1"));
	}

	@Test
	public void testDeletePositionbyId() {
		ips.deletePositionbyId(1);
	}

	@Test
	public void testFindByPaging() throws Exception {
		logger.info(ips.findByPaging(1));
	}

	@Test
	public void testCountPositions() {
		logger.info(ips.countPositions());
	}

	@Test
	public void testFindAllDepartmentWithPosition() {
		logger.info(ips.findAllDepartmentWithPosition());
	}

}
