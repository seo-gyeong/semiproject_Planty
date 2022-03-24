package com.planty.jsp.customercare.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.customercare.notice.model.dto.NoticeDTO;

public class NoticeDAO {

	public List<NoticeDTO> selectAllNoticeList(SqlSession session) {
		
		return session.selectList("NoticeDAO.selectAllNoticeList");
	}

}
