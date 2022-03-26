package com.planty.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.user.model.dto.UserDTO;
import com.planty.jsp.user.model.service.UserService;

/**
 * Servlet implementation class findPwdMemberServlet
 */
@WebServlet("/member/findpwdmember")
public class findPwdMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/findPwd-member.jsp").forward(request, response);
	}	
 		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int memberRegNo = request.getParameter("memberRegNo");
		String memberEmail = request.getParameter("memberEmail");
		int EmailCheck = request.getParameter("EmailCheck");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberRegNo : " + memberRegNo);
		System.out.println("memberEmail : " + memberEmail);
		System.out.println("EmailCheck : " + EmailCheck);
		
		
		UserDTO requestMember = new UserDTO();
		requestMember.setId(memberId);
		requestMember.setRegNo(memberRegNo);
		requestMember.setEmail(memberEmail);
		requestMember.setEmailCheck(EmailCheck);
	    
		UserService memberService = new UserService();
		
		UserDTO findPwd = memberService.findPwd(requestMember);
		System.out.println(findPwd);
		
		if(findPwd!= null) {
			request.setAttribute("findPwd", findPwd);
			request.getRequestDispatcher("/WEB-INF/views/login/change.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "실패ㅠ");
			request.getRequestDispatcher("/WEB-INF/views/login/findId-member.jsp").forward(request, response);
		}
		
	}

}
