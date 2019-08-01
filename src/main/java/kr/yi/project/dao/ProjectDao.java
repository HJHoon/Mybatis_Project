package kr.yi.project.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.yi.project.model.Project;


public interface ProjectDao {
	

	public List<Project> selectList() throws SQLException;

	public void insert(Project project) throws SQLException;
	
	public int update(Project project) throws SQLException;
	

	public Project selectByNo(int no) throws SQLException;
}
