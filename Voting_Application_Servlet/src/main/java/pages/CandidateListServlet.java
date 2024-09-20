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
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			HttpSession session=request.getSession();
			User authenticatedUser=(User)session.getAttribute("user_dtls");
			if(authenticatedUser!=null) {
				pw.print("<h1>Hello "+authenticatedUser.getFirstName()+"</h1>");
				pw.print("<h2>Candidates list</h2>");
				CandidateDaoImpl candidateDao=(CandidateDaoImpl)session.getAttribute("candidate_dao");
				List<Candidate> names=candidateDao.getCandidateList();
					pw.print("<form action='status'>");
					for(Candidate c:names) 
					pw.print("<h2><input type='radio' name='candidateId' value='"+c.getCandidateId()+"'/>"+c.getName()+"   "+c.getParty()+"</h2>");
					pw.print("<h2><input type='submit' value='Vote'/></h2>");
					pw.print("</form>");
			}else {
				pw.print("<h1>Cookies are disabled!Please kindly enable it....OR Session expire...</h1>");
			}
			
		} catch (Exception e) {
			throw new ServletException("got Exception in doGet of "+getClass(), e);
		}
	}

}
