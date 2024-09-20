package pages;

import static utils.DbUtils.closeConnection;
import static utils.DbUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/authenticate" ,loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private UserDaoImpl userDao;
private CandidateDaoImpl candidateDao;
/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			openConnection();
			userDao=new UserDaoImpl();
			candidateDao=new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("got exception in init of "+getClass(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			candidateDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("got exception in destroy of "+getClass(),e);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()){
			String email=request.getParameter("em");
			String password=request.getParameter("pass");
			User authenticatedUser=userDao.authenticateUser(email, password);
			if(authenticatedUser==null)
				pw.print("<h1>Invalid Login Credentials!Please<a ref='login.html'>Try again....</a></h1>");
			else {
				HttpSession session=request.getSession();
				System.out.println("LoginServlet "+session.isNew());
				System.out.println("JSessionID:"+session.getId());
				session.setAttribute("user_dtls", authenticatedUser);
				session.setAttribute("user_dao",userDao);
				session.setAttribute("candidate_dao",candidateDao);
				if(authenticatedUser.getRole().equals("admin"))
				  response.sendRedirect("admin");
				else {
				    if(authenticatedUser.isStatus())
				    	response.sendRedirect("status");
				    else
				    	response.sendRedirect("candidate_list");
				}
			}
		}catch(Exception e) {
			throw new ServletException("got Exception in doPost of "+getClass(),e);
		}
	}

}
