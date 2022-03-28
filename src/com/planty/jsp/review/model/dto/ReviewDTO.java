package com.planty.jsp.review.model.dto;

import java.sql.Date;

public class ReviewDTO {
	
	private int reviewNo;
	private int ordNo;
	private String id;
	private int score;
	private String title;
	private String content;
	private Date date;
	private Date editDate;
	private String delYn;
	
	public ReviewDTO() {}

	public ReviewDTO(int reviewNo, int ordNo, String id, int score, String title, String content, Date date,
			Date editDate, String delYn) {
		super();
		this.reviewNo = reviewNo;
		this.ordNo = ordNo;
		this.id = id;
		this.score = score;
		this.title = title;
		this.content = content;
		this.date = date;
		this.editDate = editDate;
		this.delYn = delYn;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public String getDelYn() {
		return delYn;
	}

	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}

	@Override
	public String toString() {
		return "ReviewDTO [reviewNo=" + reviewNo + ", ordNo=" + ordNo + ", id=" + id + ", score=" + score + ", title="
				+ title + ", content=" + content + ", date=" + date + ", editDate=" + editDate + ", delYn=" + delYn
				+ "]";
	}
	
	

}
