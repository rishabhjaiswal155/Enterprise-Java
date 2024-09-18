package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import static utils.DbUtils.*;
/**
 * Application Lifecycle Listener implementation class CMS_Listener
 *
 */
@WebListener
public class CMS_Listener implements ServletContextListener, HttpSessionListener, ServletRequestListener {

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    System.out.println("Session created....");    
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("Request destroyed....");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("Request created....");}

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("Session destroyed....");
        }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("Context destroyed...");
        try {
			closeConnection();
		} catch (Exception e) {
		     System.out.println("got exception in contextDestroyed of "+getClass()+" "+e);
		}   
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        System.out.println("Context created....");
        try {
			openConnection();
		} catch (Exception e) {
		     System.out.println("got exception in contextInitialized of "+getClass()+" "+e);
		}   
    }
	
}
