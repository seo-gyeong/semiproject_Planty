package com.planty.jsp.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;
import com.planty.jsp.review.model.dto.ReviewDTO;

/**
 * Servlet implementation class ProductReviewServlet
 */
@WebServlet("/product/review")
public class ProductReviewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ProductDTO product = new ProductService().selectOneProduct(pro_no);
		System.out.println(product);
		
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		review = new ProductService().selectProductReviewList(pro_no); 
		System.out.println(review);
		
		String path = "";
		if(product != null && review != null) {
			path = "/WEB-INF/views/product/productReview.jsp";
			request.setAttribute("product", product);
			request.setAttribute("reviewList", review);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}



}
