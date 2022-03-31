package com.planty.jsp.user.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planty.jsp.user.model.dto.UserDTO;
import com.planty.jsp.user.model.service.UserService;

/**
 * Servlet implementation class findPwdMemberServlet
 */
@WebServlet("/user/findpwduser")
public class FindPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/findPwd-member.jsp").forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		
		System.out.println("id : " + id);
		System.out.println("email : " + email);
		
		UserDTO requestUser = new UserDTO();
		requestUser.setId(id);
		requestUser.setEmail(email);
		
		UserService userService = new UserService();
		
		UserDTO user = userService.findUser(requestUser);
		System.out.println(user);
	        
    
		if(user != null) {
			
		 try {
	            String mail_from =  "planty089@gmail.com";
	            String mail_to =    email;
	            String title =      "Plan                                                                                                      ty 임시비밀번호 발송";
	            String contents =   "임시번호:";
	 
	            mail_from = new String(mail_from.getBytes("UTF-8"), "UTF-8");
	            mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");
	 
	            Properties props = new Properties();
	            props.put("mail.transport.protocol", "smtp");
	            props.put("mail.smtp.host", "smtp.gmail.com");
	            props.put("mail.smtp.port", "465");
	            props.put("mail.smtp.starttls.enable", "true");
	            props.put("mail.smtp.socketFactory.port", "465");
	            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	            props.put("mail.smtp.socketFactory.fallback", "false");
	            props.put("mail.smtp.auth", "true");
	 
	   
	            
	            Authenticator auth = new SMTPAuthenticator();
	 
	            Session sess = Session.getDefaultInstance(props, auth);
	 
	            MimeMessage msg = new MimeMessage(sess);
	 
	            msg.setFrom(new InternetAddress(mail_from));
	            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
	            msg.setSubject(title, "UTF-8");
	            msg.setContent(contents, "text/html; charset=UTF-8");
	            msg.setHeader("Content-type", "text/html; charset=UTF-8");
	 
	            Transport.send(msg);

				
				request.setAttribute("successCode", "findUser");
				request.getRequestDispatcher("/WEB-INF/views/common/success.jsp").forward(request, response);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	request.setAttribute("message", "이메일 발송 실패");
				request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
	        } 

		}else {
			request.setAttribute("message", "입력하신 id, email와 일치하는 게정이 없습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}

}