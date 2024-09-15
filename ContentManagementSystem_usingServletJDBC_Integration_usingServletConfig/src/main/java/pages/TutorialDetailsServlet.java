package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

/**
 * Servlet implementation class TutorialDetailsServlet
 */
@WebServlet("/tutorialDetails")
public class TutorialDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String tutorialName=request.getParameter("tutorialName");
			HttpSession session=request.getSession();
			System.out.println("In TutorialDetailsServlet:"+session.isNew());
			System.out.println("JSessionID:"+session.getId());
			TutorialDaoImpl tutdao=(TutorialDaoImpl)session.getAttribute("tut_dao");
			if(tutdao!=null) {
				pw.print("<h1>In Tutorial Details Page</h1>");
				System.out.println(tutdao.getUpdatedVisits(tutorialName));
				Tutorial tutorial=tutdao.getTutorialDetailsByTutorialName(tutorialName);
				pw.print("<h2>TutorialDetails:TutorialID:"+tutorial.getTutorialId()+"<br/>TutorialName"+tutorial.getTutorialName()+"<br/>Author:"+tutorial.getAuthor()+"<br/>Visits:"+tutorial.getVisits()+"<br/>PublishDate:"+tutorial.getPublishDate()+"<br/>Contents:"+tutorial.getContents()+"<br/>TopicId:"+tutorial.getTopicId()+"<br/></h2>");
				pw.print("<h3><a href='tutorials?tid="+tutorial.getTopicId()+"'>Back</a></h3>");
				pw.print("<h3><a href='logout'>LogOut</a></h3>");
			}else
				pw.print("<h2>Cookies Diabled!!!,please Kindly Enable it....OR SESSION EXPIRED!!!</h2>");
		}catch(Exception e) {
			throw new ServletException("got exception in doGet of "+getClass(), e);
		}
	}

}
