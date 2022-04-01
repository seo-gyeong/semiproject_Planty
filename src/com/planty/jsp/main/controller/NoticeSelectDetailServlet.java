package com.planty.jsp.main.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.customercare.notice.model.dto.NoticeDTO;
import com.planty.jsp.customercare.notice.model.service.NoticeService;

@WebServlet("/main/notice/detail") 
public class NoticeSelectDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeService noticeService = new NoticeService();
		NoticeDTO noticeDetail = noticeService.selectNoticeDetail(no);
		
		System.out.println("noticeDetail : " + noticeDetail);
		
		String path = "";
		if(noticeDetail != null) {
			path = "/WEB-INF/views/main/noticeDetail.jsp";
			request.setAttribute("notice", noticeDetail);
		} 
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
