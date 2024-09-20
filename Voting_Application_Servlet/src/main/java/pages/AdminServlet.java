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

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	try(PrintWriter pw=response.getWriter()){
		HttpSession session=request.getSession();
		User authentictedUser=(User)session.getAttribute("user_dtls");
		CandidateDaoImpl candidateDao=(CandidateDaoImpl)session.getAttribute("candidate_dao");
		if(authentictedUser!=null) {
			pw.print("<h1>Hello "+authentictedUser.getFirstName()+"</h1>");
			pw.print("<h2>Top 2 Candidates</h2>");
			List<Candidate> candidates=candidateDao.displayTopTwo();
			for(Candidate c:candidates)
				pw.print("<h2>"+c.getName()+" "+c.getParty()+" "+c.getVotes()+"</h2>");
			session.invalidate();
		}else
			pw.print("<h1>Cookies disabled!Please enable it...OR Session Expire...</h1>");
	} catch (Exception e) {
		throw new ServletException("got exception in doGet of "+getClass(), e);
	}
	}

}
