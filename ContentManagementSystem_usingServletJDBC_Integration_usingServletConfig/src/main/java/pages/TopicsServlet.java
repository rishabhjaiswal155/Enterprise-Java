package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import pojos.Topic;
import pojos.User;

/**
 * Servlet implementation class TopicsServlet
 */
@WebServlet("/topics")
public class TopicsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h1>In Topics Page</h1>");

			// get a cookie

			// Technique 1:using plain Cookie based

			// API of HttpServletRequest public Cookie[] getCookies()
			// Cookie[] cookies=request.getCookies();
			// if(cookies!=null) {
			// iterate
//				for(Cookie c:cookies)
//					if(c.getName().equals("authenticated_user_dtls"))
//			            pw.print("<h2>Your Details:"+c.getValue()+"</h2>");
//			}else
//				pw.print("<h2>Your Cookies are Disabled!!!!Kindly Enabled It.....</h2>");

			// Technique 2: using HttpSession Management Technique
			// get the Session
			// API of HttpServeltRequest
			// HttpSession getSession();
			HttpSession hs = request.getSession();
			System.out.println("TopicsServlet:" + hs.isNew());
			System.out.println("JSessionID:" + hs.getId());

			// get the attributes from session scope
			// API of HttpSession
			// Object getAttribute();

			User authenticatedUser = (User) hs.getAttribute("client_dtls");
			if (authenticatedUser != null) {
				TopicDaoImpl topicdao=(TopicDaoImpl)hs.getAttribute("topic_dao");
				pw.print("<h2>Your Details:" + authenticatedUser + "</h2>");
				List<Topic> topics=topicdao.getAllTopics();
				pw.print("<form action='tutorials'>");
				for(Topic t:topics)
				pw.print("<h3><input type='radio' name='tid' value='"+t.getTopicId()+"'/>"+t.getTopicName()+"</h3>");
				pw.print("<h3><input type='submit' value='Choose A Topic'/></h3>");
				pw.print("</form>");		
			} else
				pw.print("<h2>Your Cookies are Disabled!!!!Kindly Enabled It.....OR SESSION EXPIRED!!!</h2>");
		}catch(Exception e) {
			throw new ServletException("got Exception in doGet of "+getClass(), e);
		}
	}
}
