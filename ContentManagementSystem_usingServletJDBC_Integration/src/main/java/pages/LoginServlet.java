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

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/authenticate",loadOnStartup =1)
public class LoginServlet extends HttpServlet {
	UserDaoImpl userDao;
	TopicDaoImpl topicDao;
	TutorialDaoImpl tutDao;
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of "+getClass()+" invoked by "+Thread.currentThread());
	try {
		openConnection();
		userDao=new UserDaoImpl();
		topicDao=new TopicDaoImpl();
		tutDao=new TutorialDaoImpl();
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
    		 // pw.print("<h1>Login Successfull!!<br> User Details are: "+authenticatedUser+"</h1>");
    	      //pw.flush();//causes IllegalStateException when response.sendRedirect() is invoked as printWriter committed. 
    		 
    		  //want to remember the client across request response
    		  
    		  //Technique 1:plain Cookie based Technique
    		  //Create a cookie and add it into response
    		  //Cookie c1=new Cookie("authenticated_user_dtls",authenticatedUser.toString());
    		  //API of HttpServletResponse public void addCookie()
    		  //response.addCookie(c1);
    		  //role based authorization
    		  //API of HttpServletResponse public void sendRedirect()
    		  
    		  //Technique 2:using HttpSession based SesionManagement
    		  //API of HttpServletRequest
    		  //HttpSession getSession()
    		  HttpSession session=request.getSession();
    		  
    		  System.out.println("LoginServlet:"+session.isNew());
    		  System.out.println("JSessionID:"+session.getId());
    		  //add the attributes into session scope
    		  //API of HttpSession
    		  //void setAttribute(String name,Object Value)
    		  session.setAttribute("client_dtls",authenticatedUser);
    		  session.setAttribute("user_dao", userDao);
    		  session.setAttribute("topic_dao",topicDao);
    		  session.setAttribute("tut_dao", tutDao);
    		  if(authenticatedUser.getRole().equals("CUSTOMER")) {
    			  response.sendRedirect("topics");
    		  }else
    		  {
    			  response.sendRedirect("admin");
    		  }
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
			topicDao.cleanUp();
			tutDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
		    throw new RuntimeException("got exception in destroy of "+getClass(), e);
		}
		}

}
