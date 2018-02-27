package app08a.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext sc = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) sc.getAttribute("userCounter");
		int count = userCounter.incrementAndGet();
		System.out.println("User Counter incremented to: " + count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		ServletContext sc = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) sc.getAttribute("userCounter");
		int count = userCounter.decrementAndGet();
		System.out.println("User Counter decremented to: " + count);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("SessionListener-contextInitialized");
		ServletContext sc = event.getServletContext();
		sc.setAttribute("userCounter", new AtomicInteger());
	}

}
