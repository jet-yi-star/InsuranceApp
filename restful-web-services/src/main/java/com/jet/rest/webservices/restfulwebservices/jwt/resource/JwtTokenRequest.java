package com.jet.rest.webservices.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class JwtTokenRequest implements Serializable {

	private static final long serialVersionUID = -5616176897013108345L;

	private String username;
	private String password;
//	{
//		"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTYwMjI1ODAwOSwiaWF0IjoxNjAxNjUzMjA5fQ.AkbnRPbz0f8VeMNLF3HqYPTpX_lSZtKAV77FThdmo3pCfAAaO0gPPMEvRNZKGg60LcMabGWlUh1w0u8f3Tp9CQ"
//	}
	public JwtTokenRequest() {
		super();
	}

	public JwtTokenRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}