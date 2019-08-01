package kr.yi.project.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.yi.project.controller.CommandHandler;
import kr.yi.project.dao.ProjectDao;
import kr.yi.project.model.Project;
import kr.yi.project.util.MySqlSessionFactory;

public class ProjectUpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("get")) {
			String sNo = req.getParameter("p_no");
			int no = Integer.parseInt(sNo);
			
			SqlSession sqlSession = null;
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				
				Project project = dao.selectByNo(no);
				
				req.setAttribute("project", project);
				System.out.println(project);
				
				return "WEB-INF/view/UpdateForm.jsp";
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			String sNo = req.getParameter("p_no");
			int no = Integer.parseInt(sNo);
			String p_name = req.getParameter("p_name");
			String p_txt = req.getParameter("p_txt");
			String p_start = req.getParameter("p_start");
			String p_end = req.getParameter("p_end");
			String p_ing = req.getParameter("p_ing");
			Project project = new Project();
			project.setP_no(no);	
			project.setP_name(p_name);
			project.setP_txt(p_txt);
			project.setP_start(new Date());
			project.setP_end(new Date());
			project.setP_ing(p_ing);
			SqlSession sqlSession = null;
			System.out.println(project);
			try {
				sqlSession = MySqlSessionFactory.openSession();
				ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
				int result=dao.update(project);
				System.out.println(result);
				return "list.do";
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				sqlSession.close();
			}
		}
		return null;
	}

}
