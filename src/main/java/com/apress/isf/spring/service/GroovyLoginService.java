package com.apress.isf.spring.service;

/**
 * @since 11/17/2017
 */
import com.apress.isf.java.service.Login;

public class GroovyLoginService implements Login {
	
	String username;
	String password;

	@Override
	public boolean isAuthorized(String email, String pass) {
		if(username==email && password==pass)
			return true;
		return false;
	}

}
