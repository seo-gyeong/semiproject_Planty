package com.planty.jsp.order.model.dto;

public class OrderDTO {
	
	private int proNo;
	private int ordNo;
	private int amount;
	
	public OrderDTO() {}

	public OrderDTO(int proNo, int ordNo, int amount) {
		super();
		this.proNo = proNo;
		this.ordNo = ordNo;
		this.amount = amount;
	}

	public int getProNo() {
		return proNo;
	}

	public void setProNo(int proNo) {
		this.proNo = proNo;
	}

	public int getOrdNo() {
		return ordNo;
	}

	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "OrderDTO [proNo=" + proNo + ", ordNo=" + ordNo + ", amount=" + amount + "]";
	}
	
	

}
