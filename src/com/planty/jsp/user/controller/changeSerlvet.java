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

/**
 * Servlet implementation class changeSerlvet
 */
@WebServlet("/user/change")
public class changeSerlvet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login/change.jsp").forward(request, response);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	        String AuthenticationKey = (String)request.getSession().getAttribute("AuthenticationKey");
	        String AuthenticationUser = request.getParameter("AuthenticationUser");
	        if(!AuthenticationKey.equals(AuthenticationUser))
	        {
	            System.out.println("인증번호 일치하지 않음");
	            request.setAttribute("msg", "인증번호가 일치하지 않습니다");
	            request.setAttribute("loc", "/user/findpwduser");
	            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	            return;
	        }
	    	
	        UserDTO loginUser = (UserDTO) request.getSession().getAttribute("loginUser");
			String email = request.getParameter("email"); 
	        String changePwd = request.getParameter("checknum"); 

			UserDTO requestUser = new UserDTO();
			requestUser.setEmail(email);
			requestUser.setPwd(changePwd);
			
			String changepwd  = request.getParameter("Pwd"); 
			
			int result = new UserService().modifyPassword(requestUser, changePwd);
			
			String page = "";
			
			if(result > 0) {
				page = "/WEB-INF/views/common/result-pwd.jsp";
				request.setAttribute("successCode", "updateUserPassword");
			} else {
				page = "/WEB-INF/views/common/failed.jsp";
				request.setAttribute("message", "회원 비밀번호 정보 수정 실패!");
			}
			
			request.getRequestDispatcher(page).forward(request, response);
		}
}
	