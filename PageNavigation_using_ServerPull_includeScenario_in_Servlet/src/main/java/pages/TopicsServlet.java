package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("In doGet of "+getClass()+" got invoked by "+Thread.currentThread());
	   response.setContentType("text/html");
	  PrintWriter pw=response.getWriter();
		   pw.print("<h1>In Topics Page...</h1>"); 
		   pw.print("<h2>Your details:"+request.getAttribute("user_dtls")+"</h2>");
		   pw.print("<h2>Client detail:"+request.getParameter("em")+"</h2>");

}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
