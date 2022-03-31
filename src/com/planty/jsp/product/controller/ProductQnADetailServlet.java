package com.planty.jsp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.QnaDTO;
import com.planty.jsp.product.model.service.ProductService;
import com.planty.jsp.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class ProductQnADetailServlet
 */
@WebServlet("/product/qnaDetail")
public class ProductQnADetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ProductDTO product = new ProductService().selectOneProduct(pro_no);
		System.out.println(product);
		
		ProductService productService = new ProductService();
		QnaDTO qnaDetail = productService.selectQnaDetail(q_no);
		
		System.out.println("qnaDetail : " + qnaDetail);
		System.out.println(qnaDetail.getCategory());
		
		String path = "";
		if(product != null && qnaDetail != null) {
			path = "/WEB-INF/views/product/productQnaDetail.jsp";
			request.setAttribute("product", product);
			request.setAttribute("qna", qnaDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
