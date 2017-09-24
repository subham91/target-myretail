/**
 * 
 * AppException.java
 * com.gxs.custom.webedi
 * 
 * Copyright (c) 2014, GXS.
 * All rights reserved.
 * 
 */
package com.target.config;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.target.enums.ErrorEnum;

@SuppressWarnings("serial")
public class MyRetailException extends Exception {
	
	
	
	private String errorCode;
	
	public MyRetailException(ErrorEnum errEnum) {
		super(errEnum.getErrorTranslation());
		setErrorCode(errEnum.getErrorKey());
	}
	
	public MyRetailException(String message) {
		super(message);
	}
	
	
	public MyRetailException(ErrorEnum errEnum, String message, Throwable cause, String... values) {
		super(message, cause);
		setErrorCode(errEnum.getErrorKey());
	}
	
	public MyRetailException(ErrorEnum errEnum, Throwable cause) {
		super(errEnum.getErrorTranslation(), cause);
		setErrorCode(errEnum.getErrorKey());
	}
	
	public MyRetailException(ErrorEnum errEnum, String message) {
		super(message);
		setErrorCode(errEnum.getErrorKey());
	}

	public String getMessage() {
		String msg = super.getMessage();
		if(msg != null){
			return msg;
		}
		Throwable cause = ExceptionUtils.getRootCause(this);
		if(cause !=null && cause != this){
			msg = cause.getMessage();
		}
		return msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	@Override
	public String toString() {
		return "SkynetAppException [errorCode=" + errorCode + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result	+ ((errorCode == null) ? 0 : errorCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyRetailException other = (MyRetailException) obj;
		if (errorCode == null) {
			if (other.errorCode != null)
				return false;
		} else if (!errorCode.equals(other.errorCode))
			return false;
		return true;
	}

}
