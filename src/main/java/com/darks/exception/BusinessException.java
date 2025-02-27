package com.darks.exception;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }
}
