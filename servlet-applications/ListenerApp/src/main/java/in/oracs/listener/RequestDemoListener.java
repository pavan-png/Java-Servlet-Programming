package in.oracs.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class RequestDemoListener implements ServletRequestListener {
	
	public static int count =0;
	
    public void requestInitialized(ServletRequestEvent sre)  { 
    	count++;
    	System.out.println("request object got created"+new java.util.Date());
    	System.out.println("the number of hits on the server is "+count);
    }
    public void requestDestroyed(ServletRequestEvent sre)  { 
    	System.out.println("request object got destroyed");
    }

	
}
