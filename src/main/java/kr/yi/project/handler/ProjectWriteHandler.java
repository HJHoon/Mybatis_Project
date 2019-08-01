package kr.yi.project.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.ibatis.session.SqlSession;

import kr.yi.project.controller.CommandHandler;
import kr.yi.project.dao.ProjectDao;
import kr.yi.project.model.Project;
import kr.yi.project.util.MySqlSessionFactory;

public class ProjectWriteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/WriteForm.jsp";
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String pName = req.getParameter("pName");
			String pTxT = req.getParameter("pTxT");
			String pIng = req.getParameter("pIng");
			String pStart = req.getParameter("pStart");
			String pEnd = req.getParameter("pEnd");
			System.out.println("tt");
			Project project = new Project();
			project.setP_name(pName);
			project.setP_txt(pTxT);
			project.setP_start(new Date());
			project.setP_end(new Date());
			project.setP_ing(pIng);
			System.out.println("11");
			SqlSession sqlSession = null;
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				dao.insert(project);
				System.out.println("22");
				sqlSession.commit();
				System.out.println();
				res.sendRedirect("list.do");
			}catch (Exception e) {
				sqlSession.rollback();
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}
		
		return null;
	}
	
}
