package com.planty.jsp.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;

@WebServlet("/product/search")
public class productSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService productService = new ProductService();
		
		List<ProductDTO> productList = productService.selectProductlList();
		
		for(ProductDTO product : productList) {
			System.out.println(product);
		}
		
		String path = "";
		if(productList != null) {
			path = "/WEB-INF/views/common/success.jsp";
			request.setAttribute("successCode", "insertProduct");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
