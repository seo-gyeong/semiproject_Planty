package com.planty.jsp.review.model.service;

import static com.planty.jsp.common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.review.model.dao.ReviewDAO;
import com.planty.jsp.review.model.dto.ReviewDTO;

public class ReviewService {

	private final ReviewDAO reviewDAO;
		
	public ReviewService() {
		reviewDAO = new ReviewDAO();
	}
	
	public List<ReviewDTO> selectReviewList() {
		/* Connection 생성 */
		SqlSession session = getSqlSession();
		
		/* List 조회 */
		List<ReviewDTO> reviewList = reviewDAO.selectReviewList(session);
		
		/* Connection 닫기 */
		session.close();
		
		/* 조회 결과 반환 */
		return reviewList;
	}

	public int insertReview(ReviewDTO review) {
		// TODO Auto-generated method stub
		return 0;
	}

}
