package app05a.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bigCities")
public class BigCitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("China", "Beijing");
		capitals.put("Japan", "Tokyo");
		request.setAttribute("capitals", capitals);
		
		Map<String, String[]> bigCities = new HashMap<String, String[]>();
		bigCities.put("Indonesia", new String[] {"Jakarta", "Surabaya", "Medan"});
		bigCities.put("China", new String[] {"Beijing", "Shanghai", "Guangzhou"});
		request.setAttribute("bigCities", bigCities);
		
		RequestDispatcher rd = request.getRequestDispatcher("/bigCities.jsp");
		rd.forward(request, response);
	}

}
