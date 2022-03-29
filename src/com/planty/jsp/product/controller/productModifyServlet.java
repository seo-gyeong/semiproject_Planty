package com.planty.jsp.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/modify")
public class productModifyServlet extends HttpServlet {
	

	/* 정보 수정 버튼 클릭 시 get요청이 들어오기 때문에 정보수정 하는 form으로 포워딩 해주는 역할 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.getRequestDispatcher("/WEB-INF/views/product/productModifyForm.jsp").forward(request, response);
		
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		int no = ((UserDTO)request.getSession().getAttribute("loginMember")).getNo();
//		String nickname = request.getParameter("nickname");
//		/*사용자가 '-'기호를 이용하여 전화번호를 입력하는 경우 통일시키기 위해서 replace 이용함 */
//		String phone = request.getParameter("phone").replace("-", "");
//		String email = request.getParameter("email");
//		/* 우편번호와 주소, 상세주소를 하나의 문자열로 저장하는데 주소에 보통 사용하지 않는 문자를 기준으로 합치기를 해야 나중에 split 할 수 있다. */
//		String address = request.getParameter("zipCode") + "$" + request.getParameter("address1") + "$" + request.getParameter("address2");
//		
//		UserDTO requestMember = new UserDTO();
//		requestMember.setNo(no);
//		requestMember.setNickname(nickname);
//		requestMember.setPhone(phone);
//		requestMember.setEmail(email);
//		requestMember.setAddress(address);
//		
//		System.out.println("memberController requestMember : " + requestMember);
//		
//		UserDTO changedMemberInfo = new MemberService().modifyMember(requestMember);
//		
//		System.out.println("memberController changedMemberInfo : " + changedMemberInfo);
//		
//		String page = "";
//		
//		if(changedMemberInfo != null) {
//			request.getSession().setAttribute("loginMember", changedMemberInfo);
//			page = "/WEB-INF/views/common/success.jsp";
//			request.setAttribute("successCode", "updateMember");
//		} else {
//			page = "/WEB-INF/views/common/failed.jsp";
//			request.setAttribute("message", "회원 비밀번호 수정 실패!");
//		}
//		
//		request.getRequestDispatcher(page).forward(request, response);
//		}
//	
	
	

}


