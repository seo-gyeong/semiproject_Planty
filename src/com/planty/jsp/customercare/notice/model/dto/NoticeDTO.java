package com.planty.jsp.customercare.notice.model.dto;

import java.util.Date;

public class NoticeDTO {

	private int no;
	private String title;
	private String content;
	private Date date;
	private Date editDate;
	
	public NoticeDTO() {}

	public NoticeDTO(int no, String title, String content, Date date, Date editDate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.date = date;
		this.editDate = editDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	@Override
	public String toString() {
		return "NoticeDTO [no=" + no + ", title=" + title + ", content=" + content + ", date=" + date + ", editDate="
				+ editDate + "]";
	}
	
}
