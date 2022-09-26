package com.epicode.licenze.servizi.email;

public interface EmailService {

	String getPassword();

	String getServerName();

	String getUser();

	void setPassword(String password);

	void setServerName(String serverName);

	void setUser(String user);

	void sendEmail(Sendable email);

}