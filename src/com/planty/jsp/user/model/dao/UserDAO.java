package com.planty.jsp.user.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.user.model.dto.UserDTO;

public class UserDAO {
	
//	User table 신규 회원 insert용 메소드
	public int insertUser(SqlSession session, UserDTO requestUser) {
		return session.insert("UserDAO.insertUser", requestUser);
	}
	
//	암호화 처리된 비밀번호 조회용 메소드(로그인 확인용)
	public String selectEncryptedPwd(SqlSession session, UserDTO requestUser) {
		return session.selectOne("UserDAO.selectEnryptedPwd", requestUser);
	}
	
//	패스워드 일치시 회원 정보 조회용 메소드
	public UserDTO selectLoginUser(SqlSession session, UserDTO requestUser) {
		return session.selectOne("UserDAO.selectLoginUser", requestUser);
	}

	/* 아이디 중복 확인용 메소드 */
	public int userIdCheck(SqlSession session, String id) {
		return session.selectOne("UserDAO.userIdCheck", id);
	}

	
//	회원 정보 수정용 메소드
	public int updateUser(SqlSession session, UserDTO requestUser) {
		return session.update("UserDAO.updateUser", requestUser);
	}
	
//	회원 정보 수정 후 조회 메소드
	public UserDTO selectChangedInfo(SqlSession session, String id) {
		return session.selectOne("UserDAO.selectChangedUserInfo", id);
	}
//	비밀번호 수정용 메소드
	public int updatePwd(SqlSession session, UserDTO requestUser) {
		return session.update("UserDAO.updatePwd", requestUser);
	}
	
//	회원 탈퇴용 메소드
	public int deleteUser(SqlSession session, String id) {
		return session.delete("UserDAO.deleteUser", id);
	}
	
	
}
