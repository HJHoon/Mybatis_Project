package kr.yi.project.model;

import java.util.Date;

public class Project {
	private int p_no;
	private String p_name;
	private String p_txt;
	private Date p_start;
	private Date p_end;
	private String p_ing;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int p_no, String p_name, String p_txt, Date p_start, Date p_end, String p_ing) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_txt = p_txt;
		this.p_start = p_start;
		this.p_end = p_end;
		this.p_ing = p_ing;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_txt() {
		return p_txt;
	}

	public void setP_txt(String p_txt) {
		this.p_txt = p_txt;
	}

	public Date getP_start() {
		return p_start;
	}

	public void setP_start(Date p_start) {
		this.p_start = p_start;
	}

	public Date getP_end() {
		return p_end;
	}

	public void setP_end(Date p_end) {
		this.p_end = p_end;
	}

	public String getP_ing() {
		return p_ing;
	}

	public void setP_ing(String p_ing) {
		this.p_ing = p_ing;
	}

	@Override
	public String toString() {
		return "Project [p_no=" + p_no + ", p_name=" + p_name + ", p_txt=" + p_txt + ", p_start=" + p_start + ", p_end="
				+ p_end + ", p_ing=" + p_ing + "]";
	}

}
