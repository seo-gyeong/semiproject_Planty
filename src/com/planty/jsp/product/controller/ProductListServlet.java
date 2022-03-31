package com.planty.jsp.product.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.service.ProductService;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/product/list")
public class ProductListServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<ProductDTO> productList = new ProductService().selectProductList();
//		
//		System.out.println("test" + productList);
//		
//		String path = "";
//		if(productList != null) {
//			path = "/WEB-INF/views/product/product.jsp";
//			request.setAttribute("productList", productList);
//		} else {
//			path = "/WEB-INF/views/common/failed.jsp";
//			request.setAttribute("message", "공지사항 조회 실패!");
//		}
//		
//		request.getRequestDispatcher(path).forward(request, response);
		/* 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
		 * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
		 * */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		
		/* 0보다 작은 숫자값을 입력해도 1페이지를 보여준다 */
		if(pageNo <= 0) {
			pageNo = 1;
		}
		
		String searchCondition = request.getParameter("searchCondition");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("searchCondition", searchCondition);
		searchMap.put("searchValue", searchValue);
		
		
		
		ProductService productService = new ProductService();
		
		Map<String, Object> returnMap = productService.selectProductList(pageNo, searchMap);
		
		System.out.println("productList : " + returnMap.get("productList"));
		System.out.println("selectCriteria : " + returnMap.get("selectCriteria"));
		
		String path = "";
		if(returnMap.get("productList") != null && returnMap.get("selectCriteria") != null) {
			path = "/WEB-INF/views/product/product.jsp";
			request.setAttribute("productList", returnMap.get("productList"));
			request.setAttribute("selectCriteria", returnMap.get("selectCriteria"));
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "게시물 목록 조회 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}