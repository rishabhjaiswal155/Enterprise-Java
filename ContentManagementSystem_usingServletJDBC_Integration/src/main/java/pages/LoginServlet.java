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

import dao.UserDaoImpl;
import pojos.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/authenticate",loadOnStartup =1)
public class LoginServlet extends HttpServlet {
	UserDaoImpl userDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of "+getClass()+" invoked by "+Thread.currentThread());
	try {
		openConnection();
		userDao=new UserDaoImpl();
	} catch (Exception e) {
		throw new ServletException("got exception in init of "+getClass(), e);
	}	
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("text/html");
       try(PrintWriter pw=response.getWriter()){
    	   String email=request.getParameter("em");
    	   String password=request.getParameter("pass");
    	  User authenticatedUser= userDao.authenticateUser(email, password);
    	  if(authenticatedUser==null)
    		  pw.print("<h1>Invalid login!!!!,Please <a href='login.html'>Retry</a></h1>");
    	  else {
    		  pw.print("<h1>Login Successfull!!<br> User Details are: "+authenticatedUser+"</h1>");
    	  }
       }catch(Exception e) {
    	   throw new ServletException("got exception in doPost of "+getClass(), e);
       }
	}



	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
		    throw new RuntimeException("got exception in destroy of "+getClass(), e);
		}
		}

}