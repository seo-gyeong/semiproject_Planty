package com.planty.jsp.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.member.model.dto.UserDTO;

public class MemberDAO {

	public String selectEncryptedPwd(SqlSession session, UserDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectEncryptedPwd", requestMember);
	}

	public UserDTO selectLoginMember(SqlSession session, UserDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectLoginMember", requestMember);
	}
	
	public int memberIdCheck(SqlSession session, String memberId) {
		return session.selectOne("MemberDAO.memberIdCheck", memberId);
	}
	
	public UserDTO findId(SqlSession session, UserDTO requestMember) {
		return session.selectOne("MemberDAO.findId", requestMember );
	}


	public int updateMemberPassword(SqlSession session, UserDTO requestMember) {
		return session.update("MemberDAO.updateMemberPassword", requestMember);
	}


	public UserDTO findPwd(SqlSession session, UserDTO requestMember) {
		return session.selectOne("MemberDAO.findId", requestMember );
		}

	public int updateMember(SqlSession session, UserDTO requestMember) {
		return session.update("MemberDAO.updateMember", requestMember);
		}




}

