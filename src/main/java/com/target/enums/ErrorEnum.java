package com.target.enums;

public enum ErrorEnum {

	ERR_NO_DATA("ERR_NO_DATA", "No Data exists!!");
	
	
	private String errorKey;
	private String errorTranslation;

	private ErrorEnum(String errKey, String errorTranslation) {
		this.errorKey = errKey;
		this.errorTranslation = errorTranslation;
	}

	public String getErrorKey() {
		return errorKey;
	}

	public void setErrorKey(String errorKey) {
		this.errorKey = errorKey;
	}

	public String getErrorTranslation() {
		return errorTranslation;
	}

	public void setErrorTranslation(String errorTranslation) {
		this.errorTranslation = errorTranslation;
	}
}
