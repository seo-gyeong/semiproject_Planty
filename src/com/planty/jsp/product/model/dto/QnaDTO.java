package com.planty.jsp.product.model.dto;

import java.sql.Date;

import com.planty.jsp.user.model.dto.UserDTO;

public class QnaDTO {
	
	private int q_no;
	private String id;
	private UserDTO user;
	private int pro_no;
	private ProductDTO product;
	private int cate_no;
	private CategoryDTO category;
	private String q_title;
	private String q_content;
	private String q_date;
	private String q_edit_date;
	private String del_yn;
	private String answer;
	private String q_yn;
	private Date a_date;
	private Date edit_date;
	private String a_del_yn;
	public QnaDTO() {
	}
	public QnaDTO(int q_no, String id, UserDTO user, int pro_no, ProductDTO product, int cate_no, CategoryDTO category,
			String q_title, String q_content, String q_date, String del_yn, String answer, String q_yn, Date a_date,
			Date edit_date, String a_del_yn) {
		super();
		this.q_no = q_no;
		this.id = id;
		this.user = user;
		this.pro_no = pro_no;
		this.product = product;
		this.cate_no = cate_no;
		this.category = category;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_date = q_date;
		this.del_yn = del_yn;
		this.answer = answer;
		this.q_yn = q_yn;
		this.a_date = a_date;
		this.edit_date = edit_date;
		this.a_del_yn = a_del_yn;
	}
	public int getQ_no() {
		return q_no;
	}
	public void setQ_no(int q_no) {
		this.q_no = q_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public int getPro_no() {
		return pro_no;
	}
	public void setPro_no(int pro_no) {
		this.pro_no = pro_no;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
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
	public String getQ_title() {
		return q_title;
	}
	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}
	public String getQ_content() {
		return q_content;
	}
	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	public String getQ_date() {
		return q_date;
	}
	public void setQ_date(String q_date) {
		this.q_date = q_date;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQ_yn() {
		return q_yn;
	}
	public void setQ_yn(String q_yn) {
		this.q_yn = q_yn;
	}
	public Date getA_date() {
		return a_date;
	}
	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}
	public Date getEdit_date() {
		return edit_date;
	}
	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
	}
	public String getA_del_yn() {
		return a_del_yn;
	}
	public void setA_del_yn(String a_del_yn) {
		this.a_del_yn = a_del_yn;
	}
	@Override
	public String toString() {
		return "QnaDTO [q_no=" + q_no + ", id=" + id + ", user=" + user + ", pro_no=" + pro_no + ", product=" + product
				+ ", cate_no=" + cate_no + ", category=" + category + ", q_title=" + q_title + ", q_content="
				+ q_content + ", q_date=" + q_date + ", q_edit_date=" + q_edit_date + ", del_yn=" + del_yn + ", answer="
				+ answer + ", q_yn=" + q_yn + ", a_date=" + a_date + ", edit_date=" + edit_date + ", a_del_yn="
				+ a_del_yn + "]";
	}
	
	
	
	
	

}
