package com.planty.jsp.product.model.service;

import static com.planty.jsp.common.mybatis.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.common.paging.Pagenation;
import com.planty.jsp.common.paging.SelectCriteria;
import com.planty.jsp.product.model.dao.ProductDAO;
import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.QnaDTO;
import com.planty.jsp.review.model.dto.ReviewDTO;

public class ProductService {
	
	private final ProductDAO productDAO;
	
	public ProductService() {
		this.productDAO = new ProductDAO();
	}

	/* 게시물 전체 조회용 메소드 */
//	public List<ProductDTO> selectProductList() {
//		
//		SqlSession session = getSqlSession();
//		
//		List<ProductDTO> productList = productDAO.selectProductList(session);
//		
//		session.close();
//		
//		return productList;
//	}
	
	public Map<String, Object> selectProductList(int pageNo, Map<String, String> searchMap) {
		
		SqlSession session = getSqlSession();
		
		int totalCount = productDAO.selectTotalCount(session, searchMap);
		System.out.println("totalBoardCount : " + totalCount);
		
		/* 한 페이지에 보여 줄 게시물 수 */
		int limit = 10;		
		/* 한 번에 보여질 페이징 버튼의 갯수 */
		int buttonAmount = 5;
		
		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
		SelectCriteria selectCriteria = null;
		
		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
		} else {
			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		}
		
		System.out.println(selectCriteria);
		
		List<ProductDTO> productList = productDAO.selectProductList(session, selectCriteria);

		System.out.println(productList.size());
		
		Map<String, Object> returnMap = new HashMap<>();
		returnMap.put("productList", productList);
		returnMap.put("selectCriteria", selectCriteria);
		
		session.close();
		
		return returnMap;
	}

	public ProductDTO selectOneProduct(int pro_no) {
		SqlSession session = getSqlSession();
		
		ProductDTO product= null;
		
		
		product = productDAO.selectOneProduct(session, pro_no);
			
		
		session.close();
		
		return product;
	}

	public List<ReviewDTO> selectProductReviewList(int pro_no) {
		SqlSession session = getSqlSession();
		
		List<ReviewDTO> reviewList = productDAO.selectProductReviewList(session, pro_no);
		
		session.close();
		
		return reviewList;
	}

	public ReviewDTO selectReviewDetail(int reviewNo) {
		
		SqlSession session = getSqlSession();
		ReviewDTO reviewDetail = null;
		

		reviewDetail = productDAO.selectReviewDetail(session, reviewNo);
			

		session.close();
		
		return reviewDetail;
	}

	public List<QnaDTO> selectProductQnaList(int pro_no) {
		SqlSession session = getSqlSession();
		
		List<QnaDTO> qnaList = productDAO.selectProductQnaList(session, pro_no);
		
		session.close();
		
		return qnaList;

	}

	public QnaDTO selectQnaDetail(int q_no) {
		SqlSession session = getSqlSession();
		QnaDTO qnaDetail = null;
		

		qnaDetail = productDAO.selectQnaDetail(session, q_no);
			

		session.close();
		
		return qnaDetail;
	}
	
}
