package com.planty.jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planty.jsp.member.model.dto.UserDTO;
import com.planty.jsp.member.model.service.MemberService;

/**
 * Servlet implementation class changeSerlvet
 */
@WebServlet("/member/change")
public class changeSerlvet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/login/change.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDTO findpwd = (UserDTO) request.getSession().getAttribute("changePwd");
		String checkPwd = request.getParameter("checkPwd"); 
	
		
		UserDTO requestMember = new UserDTO();
		requestMember.setPwd(checkPwd);
		
		
		String memberPwd = request.getParameter("memberPwd"); 

		int result = new MemberService().modifyPassword(requestMember, memberPwd);

		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "updateMemberPassword");
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "회원 비밀번호 정보 수정 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
