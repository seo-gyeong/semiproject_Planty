package com.planty.jsp.user.controller;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
 
/**
 * @author viper9
 *
 */
public class SMTPAuthenticator extends Authenticator {
    public SMTPAuthenticator() {
        super();
    }
 
    public PasswordAuthentication getPasswordAuthentication() {
        String username = "planty089@gmail.com";
        String password = "Plantyof089";
        return new PasswordAuthentication(username, password);
    }
}
