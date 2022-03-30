package com.planty.jsp.user.controller;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
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
		requestUser.setName(id);
		requestUser.setEmail(email);
		
		UserService userService = new UserService();
		
		String findPwd = userService.findPwd(requestUser);
		System.out.println(findPwd);
	        
	       
		if(findPwd!= null) {
			request.setAttribute("findPwd", findPwd);
			request.getRequestDispatcher("/WEB-INF/views/login/change.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "실패ㅠ");
			request.getRequestDispatcher("/WEB-INF/views/login/findPwd-member.jsp").forward(request, response);
		}
		
	}

}