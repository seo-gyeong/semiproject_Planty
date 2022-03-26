package com.planty.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.member.model.dto.MemberDTO;
import com.planty.jsp.member.model.service.MemberService;


@WebServlet("/member/findidmember")
public class findIdMemberServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberName = request.getParameter("name");
		String memberEmail = request.getParameter("email");
		
		MemberService service = new MemberService();
		MemberDTO member = service.findId(memberName,memberEmail);
		
		System.out.println("member : " + member);
		
	}
}