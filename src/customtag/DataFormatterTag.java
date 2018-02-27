package customtag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DataFormatterTag extends SimpleTagSupport {
	private String header;
	private String items;
	
	public void setHeader(String header) {
		this.header = header;
	}
	public void setItems(String items) {
		this.items = items;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		JspContext jspContext = this.getJspContext();
		JspWriter out = jspContext.getOut();
		
		String content = "<table style='border:1px solid green'>\n"
				+ "<tr><td><span style='font-weight:bold'>" 
				+ header + "</span></td></tr>\n"; 
		out.print(content);
		String[] parts = items.split(",");
		for (String part : parts) {
			out.print(
					"<tr><td>" + part + "</td></tr>\n"
			);
		}
		out.print("</table>");
	}
	
}
