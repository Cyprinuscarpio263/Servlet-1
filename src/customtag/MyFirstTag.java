package customtag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class MyFirstTag implements SimpleTag {
	JspContext jspContext;
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Do Tag");
		this.jspContext.getOut().print("This is my first tag.");
	}

	@Override
	public JspTag getParent() {
		System.out.println("Get Parent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("Set Jsp Body");
	}

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("Set Jsp Context");
		this.jspContext = arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("Set Parent");
	}

}
