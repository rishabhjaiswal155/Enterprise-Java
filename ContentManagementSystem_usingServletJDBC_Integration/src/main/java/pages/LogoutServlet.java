package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojos.User;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	try(PrintWriter pw=response.getWriter()){
		HttpSession session=request.getSession();
		System.out.println("In LogoutServlet:"+session.isNew());
		System.out.println("JSessionId:"+session.getId());
		User authenticateduser=(User)session.getAttribute("client_dtls");
		if(authenticateduser!=null) {
			pw.print("<h2>Hii "+authenticateduser.getName()+"</h2>");
			pw.print("<h2>You are SuccessFully LogOut...</h2>");
		}else
			pw.print("<h2>Cookies Disabled!!please Kindly Enable it....</h2>");
		session.invalidate();
		pw.print("<h2><a href='login.html'>Visit Again</a></h2>");
	}
	}

}
