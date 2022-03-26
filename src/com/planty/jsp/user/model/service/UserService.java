package com.planty.jsp.user.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.planty.jsp.user.model.dao.UserDAO;
import com.planty.jsp.user.model.dto.UserDTO;
import com.planty.jsp.user.model.service.UserService;
import static com.planty.jsp.common.mybatis.Template.getSqlSession;

public class UserService {
	
	/* 의존 관계에 있는 객체가 불변을 유지할 수 있도록 final 필드로 선언한다. */
	private final UserDAO UserDAO;
	
	/* 생성자를 이용하여 객체를 생성하여 필드에 값을 넣는다. */
	public UserService() {
		UserDAO = new UserDAO();
	}

	public int memberIdCheck(String memberId) {
		SqlSession session = getSqlSession();
		
		int result = UserDAO.memberIdCheck(session, memberId);
		
		session.close();
	
		return result;
	}
	
	public UserDTO loginCheck(UserDTO requestMember) {
		
		SqlSession session = getSqlSession();
		UserDTO loginMember = null;
		
		String encPwd = UserDAO.selectEncryptedPwd(session, requestMember);
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		/* 로그인 요청한 원문 비밀번호화 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. */
		if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
			/* 비밀번호가 일치하는 경우에만 회원 정보를 조회해온다. */
			loginMember = UserDAO.selectLoginMember(session, requestMember);
		}
		
		session.close();
		
		return loginMember;
		
	}

	public UserDTO findId (UserDTO requestMember) {
		SqlSession session = getSqlSession();
		UserDTO findId = null;
		
		findId = UserDAO.findId (session, requestMember);
		
		session.close();
		
		return findId;
		
	}
	

		public UserDTO findPwd(UserDTO requestMember) {
			SqlSession session = getSqlSession();
			UserDTO findPwd = null;
			
			findPwd = UserDAO.findPwd (session, requestMember);
			
			session.close();

			return findPwd;
		}

		public int modifyPassword(UserDTO requestMember, String memberPwd) {
			SqlSession session = getSqlSession();
			int result = 0;
			
			String encPwd = UserDAO.selectEncryptedPwd(session, requestMember);
			
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			/* 비밀번호 수정 요청한 원문 비밀번호와 저장되어있는 암호화된 비밀번호가 일치하는지 확인한다. */
			if(passwordEncoder.matches(requestMember.getPwd(), encPwd)) {
				/* 비밀번호가 일치하는 경우에만 새로 입력 된 비밀번호로 수정한다. */
				requestMember.setPwd(memberPwd);
				result = UserDAO.updateMemberPassword(session, requestMember);
			}
			
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			
			session.close();
			
			return result;
		}


}