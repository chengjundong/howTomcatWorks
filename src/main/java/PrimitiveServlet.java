
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimitiveServlet implements Servlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("from service");
		PrintWriter out = response.getWriter();
		out.println("HTTP/1.1 200 OK\n" + 
				"Server: Microsoft-IIS/4.0\n" + 
				"Date: Mon, 5 Jan 2004 13:13:33 GMT\n" + 
				"Content-Type: text/html\n" + 
				"Last-Modified: Mon, 5 Jan 2004 13:13:12 GMT\n\n"
				+ "Hello. Roses are red.");
		out.print("Violets are blue.");
	}

	public void destroy() {
		System.out.println("destroy");
	}

	public String getServletInfo() {
		return null;
	}

	public ServletConfig getServletConfig() {
		return null;
	}
}
