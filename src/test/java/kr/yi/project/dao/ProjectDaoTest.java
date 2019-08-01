package kr.yi.project.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.yi.project.model.Project;
import kr.yi.project.util.MySqlSessionFactory;

public class ProjectDaoTest {
	@Test
	public void testListPage() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			Map<String, Object> map = new HashMap<>();
			map.put("startRow", 0);
			map.put("size", 10);
			List<Project> list = dao.selectList();
			for(Project project:list) {
				System.out.println(project);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	@Test
	public void testinsert() {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			Project project = new Project();
			project.setP_name("프로그램프로젝트");
			project.setP_txt("블라브라라");
			project.setP_start(new Date());
			project.setP_end(new Date());
			project.setP_ing("진행중");
			
			dao.insert(project);
			sqlSession.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testupdate() {
		SqlSession sqlsession = null;
		
		try {
			sqlsession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlsession.getMapper(ProjectDao.class);
			Map<String, Object> map = new HashMap<>();
			map.put("p_no", 6);
			map.put("p_name", "아아아아앙아");
			map.put("p_txt", "dkdkdkdk");
			map.put("p_start", "2017-08-27");
			dao.update(null);
			sqlsession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
	}
}
