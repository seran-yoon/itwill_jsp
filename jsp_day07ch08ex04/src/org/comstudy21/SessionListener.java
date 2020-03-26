package org.comstudy21;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener{
	
	static int activeSessions;

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated");
		activeSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed");
		activeSessions--;
	}

	
	
	

}
