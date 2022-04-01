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

@WebServlet("/user/change")
public class ChangeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/views/login/change.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDTO findPwd = (UserDTO) request.getSession().getAttribute("findPwd");
		String id = findPwd.getId();
		String pwd = findPwd.getPwd();
		
		UserDTO requestUser = new UserDTO();
		requestUser.setId (id);
		requestUser.setPwd (pwd);
		
		String changepwd = request.getParameter("changepwd"); 

		int result = new UserService().changePwd(requestUser,changepwd);

		String page = "";
		
		if(result > 0) {
			page = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "changePwd");
		} else {
			page = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "비밀번호 변경 실패!");
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}
}