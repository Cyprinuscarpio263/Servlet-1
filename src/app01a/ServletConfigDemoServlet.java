package app01a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ServletConfigDemoServlet
 */
@WebServlet(name = "ServletConfigDemoServlet", 
	urlPatterns = {"/servletConfigDemo"},
	initParams = {
		@WebInitParam(name="admin", value="John"),
		@WebInitParam(name="email", value="aaa@example.com")
	}
)
public class ServletConfigDemoServlet implements Servlet {

	private transient ServletConfig servletConfig;
	
    public ServletConfigDemoServlet() {
    }

	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
	}

	public void destroy() {
	}

	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	public String getServletInfo() {
		return "Servlet Config Demo"; 
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		ServletConfig servletConfig = this.getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head></head><body>Admin: "+admin+"<br/>Email: "+email+"</body></html>");
	}

}
