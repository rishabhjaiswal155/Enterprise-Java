package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	try(PrintWriter pw=response.getWriter()){
		HttpSession session=request.getSession();
		System.out.println("StatusServlet:"+session.isNew());
		System.out.println("JSessionId:"+session.getId());
		User authenticatedUser=(User)session.getAttribute("user_dtls");
		UserDaoImpl userDao=(UserDaoImpl)session.getAttribute("user_dao");
		CandidateDaoImpl candidateDao=(CandidateDaoImpl)session.getAttribute("candidate_dao");
		if(authenticatedUser!=null) {
			pw.print("<h1>Hello "+authenticatedUser.getFirstName()+"</h1>");
			if(authenticatedUser.isStatus()) {
				pw.print("<h2>You have Voted earlier!!!</h2>");
			}else {
				int candidateId=Integer.parseInt(request.getParameter("candidateId"));
		        System.out.println(userDao.updateVotingStatus(authenticatedUser.getId()));
		        System.out.println(candidateDao.incrementVoteCount(candidateId));
				pw.print("<h2>You have Successfully voted!!!</h2>");
				session.invalidate();
			}
		}else
			pw.print("<h1>Cookies are Disabled!Please kindly enable it....OR Session Expire....</h1>");
	} catch (Exception e) {
		throw new ServletException("got Exception in doGet of "+getClass(), e);
	}
	}

}
