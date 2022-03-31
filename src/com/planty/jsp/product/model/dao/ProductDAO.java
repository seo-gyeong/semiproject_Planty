package com.planty.jsp.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.common.paging.SelectCriteria;
import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.QnaDTO;
import com.planty.jsp.review.model.dto.ReviewDTO;

public class ProductDAO {
	

	public List<ProductDTO> selectProductList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("ProductDAO.selectProductList", selectCriteria);
	}

	public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
		// TODO Auto-generated method stub
		return session.selectOne("ProductDAO.selectTotalCount", searchMap);
	}

	public ProductDTO selectOneProduct(SqlSession session, int pro_no) {
		
		return session.selectOne("ProductDAO.selectOneProduct", pro_no);
	}

	public List<ReviewDTO> selectProductReviewList(SqlSession session, int pro_no) {
		// TODO Auto-generated method stub
		return session.selectList("ProductDAO.selectProductReviewList", pro_no);
	}

	public ReviewDTO selectReviewDetail(SqlSession session, int reviewNo) {
		// TODO Auto-generated method stub
		return session.selectOne("ProductDAO.selectReviewDetail", reviewNo);
	}

	public List<QnaDTO> selectProductQnaList(SqlSession session, int pro_no) {
		// TODO Auto-generated method stub
		return session.selectList("ProductDAO.selectProductQnaList", pro_no);
	}

	public QnaDTO selectQnaDetail(SqlSession session, int q_no) {
		// TODO Auto-generated method stub
		return session.selectOne("ProductDAO.selectQnaDetail", q_no);
	}
}
