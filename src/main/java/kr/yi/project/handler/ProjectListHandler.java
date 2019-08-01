package kr.yi.project.handler;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.project.controller.CommandHandler;
import kr.yi.project.dao.ProjectDao;
import kr.yi.project.model.Project;
import kr.yi.project.util.MySqlSessionFactory;

public class ProjectListHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MySqlSessionFactory.openSession();
			ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
			List<Project> list = dao.selectList();
			req.setAttribute("list", list);
			
			return "/WEB-INF/view/listForm.jsp";
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return null;
	}

}
