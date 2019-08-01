package kr.yi.project.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ControllerUsingURI extends HttpServlet {

	
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");///WEB-INF/commandHandler.properties경로
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);//상대주소를 절대주소로 바꾸는거
		
		try(FileReader fis = new FileReader(configFilePath)){
			prop.load(fis);//읽은 내용 집어넣음
		}catch(Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		///simple.do=mvc.simple.SimpleHandler
		while(keyIter.hasNext()) {//다음꺼 있을때마다 체크 
			String command = (String) keyIter.next();// key 추출 /simple.do
			String handlerClassName = prop.getProperty(command);//key에 해당하는 값 : mvc.simple.SimpleHandler
			Class<?> handlerClass;
			try {
				handlerClass = Class.forName(handlerClassName);//string되어있는 클래스를 class화 시킴
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();//new : 메모리에 올림
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	private void process(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		String command = req.getRequestURI();//주소가넘어옴 : /MVCProject/simple.do
		if(command.indexOf(req.getContextPath())==0) {// /MVCProject
			command = command.substring(req.getContextPath().length());// /simple.do
		}
		
		CommandHandler handler = commandHandlerMap.get(command); //command에 해당하는 클래스 받아옴
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		
		try {
			viewPage = handler.process(req,res); //simpleForm.jsp
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);//simpleForm.jsp로 포워드
			dispatcher.forward(req, res);
		}
	}
}
