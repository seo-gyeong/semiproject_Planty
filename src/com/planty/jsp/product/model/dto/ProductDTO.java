package com.planty.jsp.product.model.dto;

import java.util.List;

public class ProductDTO {
	
	
	private int proNo;
	private int cateNo;
	private String id;
	private String proName;
	private int proPrice;
	private List <ProductImgDTO> imgList;
	
	
	
	public ProductDTO() {
		super();
	}


	public ProductDTO(int proNo, int cateNo, String id, String proName, int proPrice, List<ProductImgDTO> imgList) {
		super();
		this.proNo = proNo;
		this.cateNo = cateNo;
		this.id = id;
		this.proName = proName;
		this.proPrice = proPrice;
		this.imgList = imgList;
	}


	public int getProNo() {
		return proNo;
	}


	public void setProNo(int proNo) {
		this.proNo = proNo;
	}


	public int getCateNo() {
		return cateNo;
	}


	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getProName() {
		return proName;
	}


	public void setProName(String proName) {
		this.proName = proName;
	}


	public int getProPrice() {
		return proPrice;
	}


	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}


	public List<ProductImgDTO> getImgList() {
		return imgList;
	}


	public void setImgList(List<ProductImgDTO> imgList) {
		this.imgList = imgList;
	}


	@Override
	public String toString() {
		return "ProductDTO [proNo=" + proNo + ", cateNo=" + cateNo + ", id=" + id + ", proName=" + proName
				+ ", proPrice=" + proPrice + ", imgList=" + imgList + "]";
	}	
	
	
	
	
	
}
