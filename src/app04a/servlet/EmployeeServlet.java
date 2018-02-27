package app04a.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app04a.model.Address;
import app04a.model.Employee;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Address address = new Address();
		address.setCity("Xi'an");
		address.setCountry("China");
		address.setState("Shaanxi");
		address.setStreetName("North Street");
		address.setStreetNumber("52");
		address.setZipCode("310000");
		
		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setId(1099);
		employee.setName("John");
		request.setAttribute("employee", employee);
		
		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("China", "Beijing");
		capitals.put("Japan", "Tokyo");
		request.setAttribute("capitals", capitals);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employee.jsp");
		dispatcher.forward(request, response);
	}

}
