package com.darks.config;

public class MockWrapper<T> {
    private String message;
    private T data;
    private int statusCode;

    public MockWrapper(String message, T data) {
        this.message = message;
        this.data = data;
    }
    
    public MockWrapper(String message, T data, int statusCode) {
        this.message = message;
        this.data = data;
        this.statusCode = statusCode;
    }
    
    public MockWrapper(int statusCode, T data) {
    	this.statusCode = statusCode;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
    
}
