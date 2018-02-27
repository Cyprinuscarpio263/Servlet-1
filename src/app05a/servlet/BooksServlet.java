package app05a.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app05a.model.Book;

@WebServlet("/books")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list = new ArrayList<Book>();
		
		Book book1 = new Book("978-9788791234", "Red", 39.00);
		Book book2 = new Book("978-9788791235", "Blue Book", 89.00);
		Book book3 = new Book("978-9788791236", "Triple", 105.50);
		
		list.add(book1);
		list.add(book2);
		list.add(book3);
		
		request.setAttribute("books", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/books.jsp");
		rd.forward(request, response);
	}

}
