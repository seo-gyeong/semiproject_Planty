package com.planty.jsp.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planty.jsp.order.model.dto.OrderDTO;
import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;

@WebServlet("/orderedProduct")
public class OrderedProductServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ordNo  = Integer.parseInt(request.getParameter("ordNo"));
		int proNo = Integer.parseInt(request.getParameter("proNo"));
		ProductDTO product = ???;
		int amount = Integer.parseInt(request.getParameter("amount"));

		
		OrderDTO requestOrder = new OrderDTO();
		requestOrder.setOrdNo(ordNo);
		requestOrder.setProNo(proNo);
		requestOrder.setAmount(amount);
		requestOrder.setProduct(product);
		
		String orderedProduct = requestOrder.getProduct().getPro_name();
		
		System.out.println(orderedProduct);
		
		if(product!= null) {
			HttpSession session = request.getSession();
			session.setAttribute("orderedProduct", orderedProduct);
			
			response.sendRedirect(request.getContextPath());
		} else {
		request.setAttribute("message", "주문 상품 목록 조회 실패 ㅠㅠ");
		request.getRequestDispatcher("/WEB-INF/views/common/failed.jsp").forward(request, response);
		}
	}

}
