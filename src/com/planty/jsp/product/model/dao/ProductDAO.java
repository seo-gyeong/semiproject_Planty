package com.planty.jsp.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.planty.jsp.product.model.dto.ProductDTO;
import com.planty.jsp.product.model.dto.ProductImgDTO;


public class ProductDAO {
	
		// 상품 조회(판매자) 메소드
//		public List<ProductDTO> selectAllUserList(SqlSession session) {
//			
//			return session.selectList("ProcuctDAO.selectAllProductList");
//						
//		}
		
		
		/* 썸네일 제목과 내용 insert용 메소드 */
		public int insertThumbnailContent(SqlSession session, ProductDTO thumbnail) {
			
			return session.insert("ProductDAO.insertProductContent", thumbnail);
		}
	

		/* Attachment 테이블에 insert */
		public int insertAttachment(SqlSession session, ProductImgDTO file) {
			
			return session.insert("ProductDAO.insertAttachment", file);
		}
		
		public int incrementBoardCount(SqlSession session, int no) {
			
			return session.update("ProductDAO.incrementBoardCount", no);
		}

		public ProductDTO selectOneThumbnailBoard(SqlSession session, int no) {
			
			return session.selectOne("ProductDAO.selectOneThumbnailBoard", no);
		}


		public int insertProductContent(SqlSession session, ProductDTO thumbnail) {
			// TODO Auto-generated method stub
			return 0;
		}
	
}
