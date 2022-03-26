package com.planty.jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.member.model.dto.UserDTO;
import com.planty.jsp.member.model.service.MemberService;


@WebServlet("/member/findidmember")
public class findIdMemberServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/findId-member.jsp").forward(request, response);
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberName = request.getParameter("name");
		String memberCeoName = request.getParameter("ceoName");
		String memberEmail = request.getParameter("email");
		
		System.out.println("memberName : " + memberName);
		System.out.println("memberCeoName : " + memberCeoName);
		System.out.println("memberEmail : " + memberEmail);
		
		UserDTO requestMember = new UserDTO();
		requestMember.setName(memberName);
		requestMember.setEmail(memberEmail);
	
		MemberService memberService = new MemberService();
		
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