package com.planty.jsp.product.model.dto;

import java.util.List;

import com.planty.jsp.user.model.dto.UserDTO;

public class ProductDTO implements java.io.Serializable{
	
	private int pro_no;
	private int cate_no;
	private CategoryDTO category;
	private String id;
	private UserDTO userDTO;
	private String pro_name;
	private String pro_price;
	private String pro_content;
	private List<AttachmentDTO> attachmentList;
	
	public ProductDTO() {
	}

	public ProductDTO(int pro_no, int cate_no, CategoryDTO category, String id, UserDTO userDTO, String pro_name,
			String pro_price, String pro_content, List<AttachmentDTO> attachmentList) {
		super();
		this.pro_no = pro_no;
		this.cate_no = cate_no;
		this.category = category;
		this.id = id;
		this.userDTO = userDTO;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_content = pro_content;
		this.attachmentList = attachmentList;
	}

	public int getPro_no() {
		return pro_no;
	}

	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}

	public int getCate_no() {
		return cate_no;
	}

	public void setCate_no(int cate_no) {
		this.cate_no = cate_no;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_price() {
		return pro_price;
	}

	public void setPro_price(String pro_price) {
		this.pro_price = pro_price;
	}

	public String getPro_content() {
		return pro_content;
	}

	public void setPro_content(String pro_content) {
		this.pro_content = pro_content;
	}

	public List<AttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<AttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "ProductDTO [pro_no=" + pro_no + ", cate_no=" + cate_no + ", category=" + category + ", id=" + id
				+ ", userDTO=" + userDTO + ", pro_name=" + pro_name + ", pro_price=" + pro_price + ", pro_content="
				+ pro_content + ", attachmentList=" + attachmentList + "]";
	}

	



	

	

	

	
	
	
	

}