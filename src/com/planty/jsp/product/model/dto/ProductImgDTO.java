package com.planty.jsp.product.model.dto;

public class ProductImgDTO {
//	IMG_NO	NUMBER
//	PRO_NO	NUMBER
//	P_PATH	VARCHAR2(300 BYTE)
//	FILE_NAME	VARCHAR2(300 BYTE)
//	SER_FILE	VARCHAR2(300 BYTE)
//	THUM_FILE	VARCHAR2(300 BYTE)
	
	private int imgNo;
	private int proNo;
	private String proPath;
	private String fileName;
	private String serFile;
	private String thumFile;
	
	public ProductImgDTO() {
		super();
	}
			
	public ProductImgDTO(int imgNo, int proNo, String proPath, String fileName, String serFile, String thumFile) {
		super();
		this.imgNo = imgNo;
		this.proNo = proNo;
		this.proPath = proPath;
		this.fileName = fileName;
		this.serFile = serFile;
		this.thumFile = thumFile;
	}


	public int getImgNo() {
		return imgNo;
	}
	public void setImgNo(int imgNo) {
		this.imgNo = imgNo;
	}
	public int getProNo() {
		return proNo;
	}
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProPath() {
		return proPath;
	}
	public void setProPath(String proPath) {
		this.proPath = proPath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSerFile() {
		return serFile;
	}
	public void setSerFile(String serFile) {
		this.serFile = serFile;
	}
	public String getThumFile() {
		return thumFile;
	}
	public void setThumFile(String thumFile) {
		this.thumFile = thumFile;
	}

	@Override
	public String toString() {
		return "ProductImgDTO [imgNo=" + imgNo + ", proNo=" + proNo + ", proPath=" + proPath + ", fileName=" + fileName
				+ ", serFile=" + serFile + ", thumFile=" + thumFile + "]";
	}
	
	
	
}
