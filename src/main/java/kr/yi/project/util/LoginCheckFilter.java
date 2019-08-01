package kr.yi.project.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession(false);
		if(session == null || session.getAttribute("Auth") == null) {//logout 상태
			//logout상태이면 login화면으로 이동을 하도록 한다.
			HttpServletResponse response = (HttpServletResponse)res;
			response.sendRedirect(request.getContextPath()+"/login.do");
		}else {//로그인 상태
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
