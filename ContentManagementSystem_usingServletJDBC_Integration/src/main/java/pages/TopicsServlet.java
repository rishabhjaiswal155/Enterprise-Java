package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	 * @see Servlet#init()
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			pw.print("<h1>In Topics Page</h1>");
			//get a cookie
			//API of HttpServletRequest public Cookie[] getCookies()
			Cookie[] cookies=request.getCookies();
			if(cookies!=null) {
				//iterate
				for(Cookie c:cookies)
					if(c.getName().equals("authenticated_user_dtls"))
			            pw.print("<h2>Your Details:"+c.getValue()+"</h2>");
			}else
				pw.print("<h2>Your Cookies are Disabled!!!!Kindly Enabled It.....</h2>");
		}
	}
}
