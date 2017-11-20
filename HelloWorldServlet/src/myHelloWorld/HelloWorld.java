package myHelloWorld;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld.html")
public class HelloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String title = "Hello World";
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\""
						+ "xmlns:h=\"http://java.sun.com/jsf/html\">");
			out.println("<h:head>");
				out.println("<title" + title 
					+ "</title>");
				out.println("<style>"	
								+ "*{ font-family: serif; }"
								+ "#search-panel{ "
										+ "border: 1px solid #ddd; "
										+ "width: 600px; "
										+ "margin: 50px auto;"
								+ "}" 
							+ "</style>");
			out.println("</h:head>");
			
			out.println("<h:body>");
				out.println("<h1>" + title + "</h1>");
				out.println("<h:form>");
					out.println("<div id=\"search-panel\"");
						out.println("<h:inputText id=\"name\" styleClass=\"text-input\">"
								+ "</h:inputText>");
						out.println("Das sollte unter dem Suchfeld stehen.");
					out.println("</div>");
				out.println("</h:form>");
			out.println("</h:body>");
		out.println("</html>");
	}

}
