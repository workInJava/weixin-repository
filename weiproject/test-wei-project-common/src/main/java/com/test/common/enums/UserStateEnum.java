package com.test.common.enums;

public enum UserStateEnum {

	LOCK("Ëø¶¨")
	,NORM("Õý³£")
	;
	private String dec;

	private UserStateEnum(String dec) {
		this.dec = dec;
	}

	public String getDec() {
		return dec;
	}

	public void setDec(String dec) {
		this.dec = dec;
	}
	
	
}
