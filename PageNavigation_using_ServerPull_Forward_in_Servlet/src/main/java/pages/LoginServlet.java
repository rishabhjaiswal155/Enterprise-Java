package pages;

import static utils.DbUtils.closeConnection;
import static utils.DbUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDaoImpl;
import dao.UserDaoImpl;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private UserDaoImpl userDao;
	private TopicDaoImpl topicDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of " + getClass() + "invoked by " + Thread.currentThread());
		try {
			openConnection();
			userDao = new UserDaoImpl();
			topicDao=new TopicDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("got Exception in init of " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy of " + getClass() + "invoked by " + Thread.currentThread());
		try {
			userDao.cleanUp();
			topicDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("got Exception in destroy of " + getClass(), e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doPost of " + getClass() + " invoked by " + Thread.currentThread());
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			User authenticatedUser = userDao.authenticateUser(email, password);
			if (authenticatedUser == null) {
				pw.print("<h1>Invalid Login credentials.....Please<a href='login.html'>Try Again</a></h1>");
			} else {
				pw.print("<h1>In LoginServlet...</h1");//This will not displayed on client side
				//pw.flush();//it leads on IllegalSateException on line no. 80  and 85
				request.setAttribute("user_dtls", authenticatedUser);
				RequestDispatcher rd;
				if (authenticatedUser.getRole().equals("CUSTOMER")) {
					rd = request.getRequestDispatcher("topics");
					rd.forward(request, response);
					System.out.println("Back in Login Servlet");
				} else {
					rd = request.getRequestDispatcher("admin");
					rd.forward(request, response);
				}
			}
		} catch (Exception e) {
			throw new ServletException("got Exception in doPost of " + getClass(), e);
		}
	}
}
