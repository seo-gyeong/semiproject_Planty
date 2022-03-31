package com.planty.jsp.product.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.ProductImgDTO;


public class ProductDAO {
	
//	 상품 조회(판매자) 메소드
//		public int selectTotalCount(SqlSession session, Map<String, String> searchMap) {
//			
//			return session.selectOne("BoardDAO.selectTotalCount", searchMap);
//		}

//		public List<ProductDTO> selectProductList(SqlSession session) {
//			
//			return session.selectList("ProcuctDAO.selectProductList");
//						
//		}
//			
		public static int insertProduct(SqlSession session, ProductDTO newProduct) {
			
			return session.insert("BoardDAO.insertProduct", newProduct);
		}
		
		
		/* 상품 목록 조회용 메소드 */
		public List<ProductDTO> selectAllProductlList(SqlSession session) {
			
			return session.selectList("ProductDAO.selectAllProductlList");
		}
			
		
		/* 상품 제목과 내용 insert용 메소드 */
		public int insertProductContent(SqlSession session, ProductDTO thumbnail) {
			
			return session.insert("ProductDAO.insertProductContent", thumbnail);
		}
		

		/* Attachment 테이블에 insert */
		public int insertProductImg(SqlSession session, ProductImgDTO file) {
			
			return session.insert("ProductDAO.insertProductImg", file);
		}
		
		public int incrementProductCount(SqlSession session, int no) {
			
			return session.update("ProductDAO.incrementProductCount", no);
		}

		public ProductDTO selectOneThumbnailProduct(SqlSession session, int no) {
			
			return session.selectOne("ProductDAO.selectOneThumbnailProduct", no);
		}

		

		


		
	
}
