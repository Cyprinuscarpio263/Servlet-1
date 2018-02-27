package customtag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SelectElementTag extends SimpleTagSupport {
	private String[] countries = {"Australia", "Brazil", "China"};

	@Override
	public void doTag() throws JspException, IOException {
		JspContext jc = this.getJspContext();
		JspWriter out = jc.getOut();
		
		JspFragment jf = this.getJspBody();
		
		out.print("<select>\n");
		for (String str : countries) {
			jf.getJspContext().setAttribute("value", str);
			jf.getJspContext().setAttribute("text", str);
			jf.invoke(null);
		}
		out.print("</select>\n");
		System.out.println("Complete");
	}
}
