package com.darks.config;
/**
 * @createdBy Er. Arundeep Randev
 * @since Feb-Mar 2025
 * @return ResponseEntity
 */

public class MockWrapper<T> {
    private String message;
    private String status;
    private T result;
    private int statusCode;
	private Object data;


    public MockWrapper(String message, T result) {
        this.message = message;
        this.result = result;
    }
    
    public MockWrapper(String message, T result, int statusCode) {
        this.message = message;
        this.result = result;
        this.statusCode = statusCode;
    }
    
    public MockWrapper(String message, T result, int statusCode, Object data) {
        this.message = message;
        this.result = result;
        this.statusCode = statusCode;
        this.data = data;
    }
    
    public MockWrapper(String message, T result, int statusCode, String status) {
        this.message = message;
        this.result = result;
        this.statusCode = statusCode;
        this.status = status;
    }
    
    public MockWrapper(int statusCode, T result) {
    	this.statusCode = statusCode;
        this.result = result;
    }


	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
