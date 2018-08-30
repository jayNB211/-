package com.clps.oas.sm.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.clps.oas.sm.pojo.Permission;
import com.clps.oas.sm.vo.PermissionVO;
import com.clps.oas.util.mybatis.MyBatisUtil;



/** 
* @description this is PermissionMapperTest
* @author  noah.zhou 
* @date 创建时间：2018年5月11日 上午10:40:00 
* @version 1.0 
*/
public class PermissionMapperTest {

	private SqlSessionFactory sf = null;
	private SqlSession session = null;
	private PermissionMapper permissionDao = null;
	private List<Permission> permissions = null;
	private List<PermissionVO> permissionvos = null;
	private Logger logger = Logger.getLogger(PermissionMapperTest.class);
	
	
	//初始化
	@Before
	public void setUp() throws Exception {
		this.sf = MyBatisUtil.getSqlSessionFactory();
		this.session = sf.openSession();
		this.permissionDao = session.getMapper(PermissionMapper.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//测试Dao层查询所有权限信息的方法
	@Test
	public void testQueryAllPermissions() {
		try {
			this.permissions = this.permissionDao.queryAllPermissions();
			logger.info("查询成功");
			Iterator<Permission> its = permissions.iterator();
			while(its.hasNext()){
				logger.info(its.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询失败");
			session.rollback();
		}finally{
			session.commit();
			if(session !=null){
				session.close();
			}
		}
	}

	
	//测试Dao层插入权限的方法
	@Test
	public void testAddPermission() {
		Permission permission = new Permission();
		permission.setPermissionId(7);
		permission.setPermissionName("update");
		permission.setPermissionCode("permission_4");
		permission.setPermissionComment("...");
		permission.setPermissionCreatedDateTime(null);
		permission.setPermissionCreatedName(1);
		permission.setPermissionUpdatedDateTime(null);
		permission.setPermissionUpdatedName(1);
		permission.setIsVisible(1);
		logger.info("插入开始");
		try {
			int i = this.permissionDao.addPermission(permission);
			logger.info(i+"       ");
			if (i > 0) {
				logger.info("插入成功");
			}
		} catch (Exception e) {
			logger.error("插入失败");
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
	}
	
	//测试Dao层插入VO权限的方法
		@Test
		public void testAddPermissionVO() {
			PermissionVO permissionVO = new PermissionVO();
			permissionVO.setPermissionName("insert");
			permissionVO.setPermissionCode("permission_2");
			permissionVO.setPermissionComment("...");
			permissionVO.setPermissionCreatedDateTime(null);
			permissionVO.setPermissionCreatedName(1);
			permissionVO.setPermissionUpdatedDateTime(null);
			permissionVO.setPermissionUpdatedName(1);
			logger.info("插入VO开始");
			try {
				int i = this.permissionDao.addPermissionVO(permissionVO);
				logger.info(i+"       ");
				if (i > 0) {
					logger.info("插入成功");
				}
			} catch (Exception e) {
				logger.error("插入失败");
				e.printStackTrace();
				session.rollback();
			} finally {
				session.commit();
				if (session != null) {
					session.close();
				}
			}
		}
		
		//测试Dao层查询所有VO权限信息的方法
		@Test
		public void testQueryAllPermissionVO() {
			try {
				this.permissionvos = this.permissionDao.queryAllPermissionVO();
				logger.info("查询成功");
				Iterator<PermissionVO> its = permissionvos.iterator();
				while(its.hasNext()){
					logger.info(its.next());
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("查询失败");
				session.rollback();
			}finally{
				session.commit();
				if(session !=null){
					session.close();
				}
			}
		}
	
	//测试Dao层根据ID删除权限的方法
	@Test
	public void testDeletePermissionById() {
			try {
				int i = this.permissionDao.deletePermissionById(7);
				if (i > 0) {
					logger.info("逻辑删除成功");
				}
			} catch (Exception e) {
				logger.error("逻辑删除失败");
				e.printStackTrace();
				session.rollback();
			} finally {
				session.commit();
				if (session != null) {
					session.close();
				}
			}
	}
	
	//测试Dao层根据ID删除权限的方法
		@Test
		public void testDeletePermissionVOById() {
				try {
					int i = this.permissionDao.deletePermissionVOById(5);
					if (i > 0) {
						logger.info("逻辑删除VO成功");
					}
				} catch (Exception e) {
					logger.error("逻辑删除VO失败");
					e.printStackTrace();
					session.rollback();
				} finally {
					session.commit();
					if (session != null) {
						session.close();
					}
				}
		}
	
	//测试Dao层更新权限信息的方法
	@Test
	public void testUpdatePermission() {
		Permission permission = new Permission();
		permission.setPermissionId(1);
		permission.setPermissionName("select");
		permission.setPermissionCode("permission_1");
		permission.setPermissionComment("...");
		permission.setPermissionCreatedDateTime(null);
		permission.setPermissionCreatedName(1);
		permission.setPermissionUpdatedDateTime(null);
		permission.setPermissionUpdatedName(1);
		permission.setIsVisible(1);
		try {
			int i = this.permissionDao.updatePermission(permission);
			if (i > 0) {
				logger.info("更新成功");
			} else {
				logger.error("更新失败");
			}
			
		} catch (Exception e) {
			logger.error("更新失败");
			e.printStackTrace();
			session.rollback();
		} finally {
			session.commit();
			if (session != null) {
				session.close();
			}
		}
	}
	
	//测试Dao层更新VO权限信息的方法
		@Test
		public void testUpdatePermissionVO() {
			PermissionVO permissionvo = new PermissionVO();
			permissionvo.setPermissionId(5);
			permissionvo.setPermissionName("select");
			permissionvo.setPermissionCode("permission_2");
			permissionvo.setPermissionComment("...");
			permissionvo.setPermissionCreatedDateTime(null);
			permissionvo.setPermissionCreatedName(1);
			permissionvo.setPermissionUpdatedDateTime(null);
			permissionvo.setPermissionUpdatedName(1);
			try {
				int i = this.permissionDao.updatePermissionVO(permissionvo);
				if (i > 0) {
					logger.info("更新成功");
				} else {
					logger.error("更新失败");
				}
				
			} catch (Exception e) {
				logger.error("更新失败");
				e.printStackTrace();
				session.rollback();
			} finally {
				session.commit();
				if (session != null) {
					session.close();
				}
			}
		}
	
	//测试Dao层查询单条用户信息的方法
	@Test
	public void testQueryPermissionById() {
			try {
				this.permissions = this.permissionDao.queryPermissionById(1);
				logger.info("查询单条数据成功");
				Iterator<Permission> its = permissions.iterator();
				while(its.hasNext()){
					System.out.println(its.next());
				}
			} catch (Exception e) {
				logger.error("查询单条数据失败");
				e.printStackTrace();
				session.rollback();
			} finally {
				session.commit();
				if (session != null) {
					session.close();
				}
			}
	}
}
