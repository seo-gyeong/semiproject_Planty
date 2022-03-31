package com.planty.jsp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;
import com.planty.jsp.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class ProductReviewDetailServlet
 */
@WebServlet("/product/reviewDetail")
public class ProductReviewDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ProductDTO product = new ProductService().selectOneProduct(pro_no);
		System.out.println(product);
		
		ProductService productService = new ProductService();
		ReviewDTO reviewDetail = productService.selectReviewDetail(reviewNo);
		
		System.out.println("reviewDetail : " + reviewDetail);
		
		String path = "";
		if(product != null && reviewDetail != null) {
			path = "/WEB-INF/views/product/productReviewDetail.jsp";
			request.setAttribute("product", product);
			request.setAttribute("review", reviewDetail);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "공지사항 상세 보기 조회에 실패하였습니다.");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
