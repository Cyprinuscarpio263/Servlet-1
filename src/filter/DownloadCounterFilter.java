package filter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class DownloadCounterFilter implements Filter {
	ExecutorService exeSvc = Executors.newSingleThreadExecutor();
	Properties downloadLog;
	File logFile;
	
	@Override
	public void destroy() {
		exeSvc.shutdown();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		final String uri = httpReq.getRequestURI();
		this.exeSvc.execute(new Runnable() {
			@Override
			public void run() {
				String property = downloadLog.getProperty(uri);
				if (property == null) {
					downloadLog.setProperty(uri, "1");
				} else {
					int count = 0;
					try {
						count = Integer.parseInt(property);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					count++;
					downloadLog.setProperty(uri, Integer.toString(count));
				}
				try {
					downloadLog.store(new FileWriter(logFile), "");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ServletContext servletContext = config.getServletContext();
		String appPath = servletContext.getRealPath("/");
		logFile = new File(appPath, "downloadLog.txt");
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		downloadLog = new Properties();
		try {
			downloadLog.load(new FileReader(logFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
