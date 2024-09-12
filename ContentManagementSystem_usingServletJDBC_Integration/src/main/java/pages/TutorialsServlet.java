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

import dao.TutorialDaoImpl;

/**
 * Servlet implementation class TutorialServlet
 */
@WebServlet("/tutorials")
public class TutorialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			int topicId=Integer.parseInt(request.getParameter("tid"));
			HttpSession session=request.getSession();
			System.out.println("In TutorialsServlet: "+session.isNew());
			System.out.println("JSessionID:"+session.getId());
			TutorialDaoImpl tutdao=(TutorialDaoImpl)session.getAttribute("tut_dao");
			if(tutdao!=null) {
				pw.print("<h1>In Tutorials page</h1>");
				List<String> names=tutdao.getTutorialNameByTopicId(topicId);
				for(String s:names)
					pw.print("<h2><a href='tutorialDetails?tutorialName="+s+"'>"+s+"</a></h2>");
			}
			else 
				pw.print("<h2>Cookies Disabled!!!,please Enable it....</h2>");
			
			
		}catch(Exception e) {
			throw new ServletException("got exception in doGet of "+getClass(),e);
		}
	}

}
