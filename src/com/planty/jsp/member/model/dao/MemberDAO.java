package com.planty.jsp.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.member.model.dto.MemberDTO;

public class MemberDAO {

	public String selectEncryptedPwd(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectEncryptedPwd", requestMember);
	}

	public MemberDTO selectLoginMember(SqlSession session, MemberDTO requestMember) {
		
		return session.selectOne("MemberDAO.selectLoginMember", requestMember);
	}
	
	public int memberIdCheck(SqlSession session, String memberId) {
		return session.selectOne("MemberDAO.memberIdCheck", memberId);
	}
	
	public MemberDTO findId(SqlSession session, MemberDTO requestMember) {
		return session.selectOne("MemberDAO.findId", requestMember );
	}


	public int updateMemberPassword(SqlSession session, MemberDTO requestMember) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberDTO findPwd(SqlSession session, MemberDTO requestMember) {
		return session.selectOne("MemberDAO.findId", requestMember );
		}




}

