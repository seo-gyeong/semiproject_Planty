package com.planty.jsp.common.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.planty.jsp.member.model.dto.MemberDTO;

@WebFilter(urlPatterns = {"/notice/*", "/member/*", "/board/*", "/thumbnail/*"})
public class AuthenticationFilter implements Filter {
	
	Map<String, List<String>> permitURIList;
	
	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String uri = hrequest.getRequestURI();
		String intent = uri.replace(hrequest.getContextPath(), "");
		
		System.out.println("intent : " + intent);
		
		/* 세션에 권한이 있는지 확인하여 허용된 url에만 접근 가능하도록 설정한다. */
		HttpSession requestSession = hrequest.getSession();
		MemberDTO loginMember = (MemberDTO) requestSession.getAttribute("loginMember");
		
		boolean isAuthorized = false;
        if(loginMember != null) {

            boolean isPermitAdmin = permitURIList.get("adminPermitList").contains(intent);
            boolean isPermitMember = permitURIList.get("memberPermitList").contains(intent);
            boolean isPermitPartner = permitURIList.get("partnerPermitList").contains(intent);

            boolean isPermitAll = permitURIList.get("allPermitList").contains(intent);
            if(loginMember.getAuthNo() == 3) {

                if(isPermitAdmin  isPermitMember  isPermitPartner  isPermitAll) {
                    isAuthorized = true;
                }

            } else if(loginMember.getAuthNo() == 1) {

                if((isPermitMember  isPermitAll) && !isPermitAdmin  && !isPermitPartner) {
                    isAuthorized = true;
                }

            } else if(loginMember.getAuthNo() == 2) {
                if((isPermitPartner || isPermitAll) && !isPermitAdmin && !isPermitMember) {
                    isAuthorized = true;
                }
            }

	public void init(FilterConfig fConfig) throws ServletException {
		
		permitURIList = new HashMap<>();
		List<String> adminPermitList = new ArrayList<>();
		List<String> memberPermitList = new ArrayList<>();
		List<String> allPermitList = new ArrayList<>();
		
		adminPermitList.add("/notice/insert");
		adminPermitList.add("/notice/update");
		adminPermitList.add("/notice/delete");
		
		memberPermitList.add("/member/modify");
		memberPermitList.add("/member/modifyPassword");
		memberPermitList.add("/member/remove");
		memberPermitList.add("/notice/list");
		memberPermitList.add("/notice/detail");
		memberPermitList.add("/board/list");
		memberPermitList.add("/board/insert");
		memberPermitList.add("/board/search");
		memberPermitList.add("/thumbnail/list");
		memberPermitList.add("/thumbnail/insert");
		memberPermitList.add("/thumbnail/detail");

		allPermitList.add("/member/idCheck");
		allPermitList.add("/member/regist");
		allPermitList.add("/member/login");
		allPermitList.add("/member/logout");
		
		permitURIList.put("adminPermitList", adminPermitList);
		permitURIList.put("memberPermitList", memberPermitList);
		permitURIList.put("allPermitList", allPermitList);
		
	}

}
