package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/hello",loadOnStartup=2)//default loading policy of servlet is lazy i.e loadOnStartup=0
//class level annotation,meant for WebContainer,processed @dep time
//purpose:To create mapping between URL pattern and servlet 
//key:/hello
//value:fully qualified className pages.WelcomeServlet
public class WelcomeServlet extends HttpServlet {
//life cycle methods of Servlet
	//init(),service(),destroy()
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in doGet of "+getClass()+" invoked by "+Thread.currentThread());
		//set the content type
		//Method of HttpServletResponse inherited from ServletResponse i/f:void setContentType()
		resp.setContentType("text/html");
		//send the response in char,buffered way by using PrintWriter
		//by using getWriter() of servletResponse
		try(PrintWriter pw=resp.getWriter()){
			//generate the dynamic response by using write()/print() of PrintWritter class
			pw.print("<h1>Welcome to Servlet,at Server timestamp of "+LocalDateTime.now()+"</h1>");			
		}//pw.close()	
	}

	@Override
	public void destroy() {
		System.out.println("in destroy of "+getClass()+" invoked by "+Thread.currentThread());
		}

	@Override
	public void init() throws ServletException {
	System.out.println("in init of "+getClass()+" invoked by "+Thread.currentThread());	
	}

}
