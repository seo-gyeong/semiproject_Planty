package com.planty.jsp.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.user.model.dto.UserDTO;
import com.planty.jsp.user.model.service.UserService;



@WebServlet("/member/findidmember")
public class findIdMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/findId-member.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/views/login/findId-partner.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("name");
		String memberEmail = request.getParameter("email");
		
		System.out.println("memberName : " + memberName);
		System.out.println("memberEmail : " + memberEmail);
		
		UserDTO requestMember = new UserDTO();
		requestMember.setName(memberName);
		requestMember.setEmail(memberEmail);
	
		UserService memberService = new UserService();
		
		UserDTO findId = memberService.findId(requestMember);
		System.out.println(findId);
		
		if(findId!= null) {
			request.setAttribute("findId", findId);
			request.getRequestDispatcher("/WEB-INF/views/login/result-Id.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "실패ㅠ");
			request.getRequestDispatcher("/WEB-INF/views/login/findId-member.jsp").forward(request, response);
		}
		
	}

}