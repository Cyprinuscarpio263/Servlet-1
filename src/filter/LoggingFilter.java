package filter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 通过web.xml配置文件方式注册
 */
public class LoggingFilter implements Filter {

	private PrintWriter logger;
	private String prefix;
	
	@Override
	public void destroy() {
		System.out.println("Destroy filter");
		if (logger != null) {
			logger.close();
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoggingFilter doFilter");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String uri = httpReq.getRequestURI();
		logger.println(new Date() + " " + prefix + uri);
		logger.flush();
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		prefix = config.getInitParameter("prefix");
		String logFileName = config.getInitParameter("logFileName");
		String appPath = config.getServletContext().getRealPath("/");
		System.out.println("Path: " + appPath + ", file: " + logFileName);
		try {
			logger = new PrintWriter(new File(appPath, logFileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
