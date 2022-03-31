package com.planty.jsp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/product/detail")
public class ProductDetailServlet extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pro_no = Integer.parseInt(request.getParameter("pro_no"));
		
		ProductDTO product = new ProductService().selectOneProduct(pro_no);
		System.out.println(product);
		
		String path = "";
		if(product != null) {
			path = "/WEB-INF/views/product/productDetail.jsp";
			request.setAttribute("product", product);
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "상품 상세 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}



}
