package org.comstudy21.login;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Login  implements HttpSessionBindingListener {

	String userID;
	String pass;
	static int total;
	
	public Login(String id, String pass) {
		userID = id;
		this.pass = pass;
	}

	public String getUserID() {
		return userID;
	}

	public String getPass() {
		return pass;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("valueBound");
		total++;
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("valueUnbound");
	}
	
	
	
}
