package org.comstudy21;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncoderFilter implements Filter{

	ServletContext context;
	
	@Override
	public void destroy() {
		System.out.println("destory 호출");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//예제1
//		System.out.println("doFilter 호출");
//		
//		req.setCharacterEncoding("UTF-8");
//		
//		String path = ((HttpServletRequest)req).getContextPath();
//		String pathinfo = ((HttpServletRequest)req).getRequestURI();
//		String realPath = req.getRealPath(pathinfo);
//		String mesg = "Context 정보 : " + path + "URI 정보 : " + pathinfo + "물리적 경로 : " + realPath;
//		
//		context.log(mesg);
//		
//		chain.doFilter(req, resp);
		
		
		//예제2
		System.out.println("doFilter 호출");
		
		req.setCharacterEncoding("UTF-8");
		
		long begin = System.currentTimeMillis();
		
		String path = ((HttpServletRequest)req).getContextPath();
		String pathinfo = ((HttpServletRequest)req).getRequestURI();
		String realPath = req.getRealPath(pathinfo);
		String mesg = "Context 정보 : " + path + "URI 정보 : " + pathinfo + "물리적 경로 : " + realPath;
		
		context.log(mesg);
		
		chain.doFilter(req, resp); //이 코드를 기준으로 위의 코드는 rep, 아래 코드는 resp
		
		long end = System.currentTimeMillis();
		
		StringBuffer logMessage = new StringBuffer();
		
		logMessage = ((HttpServletRequest)req).getRequestURL();
		logMessage.append(":");
		logMessage.append(end-begin);
		logMessage.append("ms");
		
		context.log(logMessage.toString());
		
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("UTF-8");
		context = fc.getServletContext();
	}

}
