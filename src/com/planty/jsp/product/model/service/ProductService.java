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
import com.planty.jsp.product.model.dto.ProductImgDTO;

public class ProductService {
	
	private final ProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	
	/* 게시물 전체 조회용 메소드 */
//	public Map<String, Object> selectProductList(int pageNo, Map<String, String> searchMap) {
//		
//		SqlSession session = getSqlSession();
//		
//		int totalCount = productDAO.selectTotalCount(session, searchMap);
//		System.out.println("totalProductCount : " + totalCount);
//		
//		/* 한 페이지에 보여 줄 게시물 수 */
//		int limit = 10;		
//		/* 한 번에 보여질 페이징 버튼의 갯수 */
//		int buttonAmount = 5;
//		
//		/* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
//		SelectCriteria selectCriteria = null;
//		
//		if(searchMap.get("searchCondition") != null && !"".equals(searchMap.get("searchCondition"))) {
//			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchMap.get("searchCondition"), searchMap.get("searchValue"));
//		} else {
//			selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
//		}
//		
//		System.out.println(selectCriteria);
//		
//		List<ProductDTO> productList = productDAO.selectProductList(session, selectCriteria);
//		
//		Map<String, Object> returnMap = new HashMap<>();
//		returnMap.put("productList", productList);
//		returnMap.put("selectCriteria", selectCriteria);
//		
//		session.close();
//		
//		return returnMap;
//	}
	
	/* 신규 게시물 등록용 메소드 */
	public int insertProduct(ProductDTO newProduct) {
		
		SqlSession session = getSqlSession();
		
		int result = ProductDAO.insertProduct(session, newProduct);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}
	
	/* 썸네일 게시판 조회용 메소드 */
	public List<ProductDTO> selectProductlList() {
		
		/* Connection 생성 */
		SqlSession session = getSqlSession();
		
		/* List 조회 */
		List<ProductDTO> productList = productDAO.selectAllProductlList(session);
		
		/* Connection 닫기 */
		session.close();
		
		/* 조회 결과 반환 */
		return productList;
	}
	
	public int insertThumbnail(ProductDTO thumbnail) {
		
		/* Connection 생성 */
		SqlSession session = getSqlSession();
		
		/* 최종적으로 반환할 result 선언 */
		int result = 0;
		
		//* 먼저 product 테이블부터 thumbnail 내용부터 insert 한다. */
		int productResult = productDAO.insertProductContent(session, thumbnail);
		
		System.out.println("productResult : " + thumbnail);
	
		//* img 리스트를 불러온다. */
		List<ProductImgDTO> fileList = thumbnail.getImgList();
		
		/* fileList에 productNo값을 넣는다. */
		for(int i = 0; i < fileList.size(); i++) {
			fileList.get(i).setProNo(thumbnail.getProNo());
		}
		
		/* Attachment 테이블에 list size만큼 insert 한다. */
		int attachmentResult = 0;
		for(int i = 0; i < fileList.size(); i++) {
			attachmentResult += productDAO.insertProductImg(session, fileList.get(i));
		}
		
		/* 모든 결과가 성공이면 트랜젝션을 완료한다. */
		if(productResult > 0 && attachmentResult == fileList.size()) {
			session.commit();
			result = 1;
		} else {
			session.rollback();
		}
		
		/* Connection을 닫는다. */
		session.close();
		
		/* 수행 결과를 리턴한다. */
		return result;
	}

	public ProductDTO selectOneThumbnailProduct(int no) {
		
		SqlSession session = getSqlSession();
		
		ProductDTO thumbnail= null;
		
		int result = productDAO.incrementProductCount(session, no);
		
		if(result > 0) {
			thumbnail = productDAO.selectOneThumbnailProduct(session, no);
			
			if(thumbnail != null) {
				session.commit();
			} else {
				session.rollback();
			}
		} else {
			session.rollback();
		}
		
		session.close();
		
		return thumbnail;
		
	}

}
