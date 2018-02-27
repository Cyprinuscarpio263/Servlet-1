package app08a.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PerfStatListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		ServletRequest request = event.getServletRequest();
		Long end = System.nanoTime();
		Long elapsed = end - (Long) request.getAttribute("start");
		System.out.println("Elapsed Time: " + elapsed.longValue());
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		ServletRequest request = event.getServletRequest();
		request.setAttribute("start", System.nanoTime());
	}

}
