package web_study_09.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class LoginCheckFilter implements Filter {

  
	public void destroy() {
		System.out.println("destroy()");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter - doFilter()");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		if(session != null && session.getAttribute("loginUser") != null) {		//로그인 성공햇다는것
			chain.doFilter(request, response);
		}else {
			request.getRequestDispatcher("login.do").forward(request, response);
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
