package com.planty.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planty.jsp.user.model.dto.UserDTO;
import com.planty.jsp.user.model.service.UserService;


@WebServlet("/member/login")
public class loginServlet extends HttpServlet {
	/* 로그인 버튼 클릭 시 get요청이 들어오기 때문에 로그인 하는 form으로 포워딩 해주는 역할 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/login/loginForm.jsp").forward(request, response);
		
	}
	
	/* 로그인 폼을 작성 후 post 요청을 할 경우 처리하는 역할 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("id");
		String memberPwd = request.getParameter("pwd");
		
		System.out.println("id : " + memberId);
		System.out.println("pwd : " + memberPwd);
		
		UserDTO requestMember = new UserDTO();
		requestMember.setId(memberId);
		requestMember.setPwd(memberPwd);
		
		UserService memberService = new UserService();
		
		UserDTO loginMember = memberService.loginCheck(requestMember);
		System.out.println(loginMember);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			
			System.out.println(loginMember.getAuthNo());
			
			if(loginMember.getAuthNo() == 3) {
				response.sendRedirect(request.getContextPath() + "/admin/관리자 주소");
				
				} else if (loginMember.getAuthNo() == 2) {	
				response.sendRedirect(request.getContextPath() + "/partner/판매자 주소");
				}
				
				} else {
				response.sendRedirect(request.getContextPath());
				}
		
			request.setAttribute("message", "로그인 실패!");
			request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
		
	}

