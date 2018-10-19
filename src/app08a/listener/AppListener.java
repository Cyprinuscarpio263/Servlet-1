package app08a.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("Listener init");
		ServletContext sc = event.getServletContext();
		String cPath = sc.getContextPath();
		String rPath0 = sc.getRealPath("");
		String rPath1 = sc.getRealPath("/");
		StringBuilder bui = new StringBuilder();
		bui.append("\tContextPath=").append(cPath).append("\n");
		bui.append("\tRealPath()=").append(rPath0).append("\n");
		bui.append("\tRealPath(/)=").append(rPath1);
		System.out.println("app08a.listener.AppListener:\n" + bui.toString());
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
		
		sc.setAttribute("map", map);
	}

}
