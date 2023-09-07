package com.sena.adso2499719.adso2499719.dtos;

public class ApiResponseDto<T> {
	
	
	public ApiResponseDto() {
		
	}
	
	public ApiResponseDto(String message, Boolean status, T data) {
		this.message = message;
		Status = status;
		this.data = data;
	}



	private String message;
	
	private Boolean Status;
	
	private T data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return Status;
	}

	public void setStatus(Boolean status) {
		Status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
