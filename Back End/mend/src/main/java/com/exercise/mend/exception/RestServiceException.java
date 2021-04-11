package com.exercise.mend.exception;

import org.springframework.http.HttpStatus;

public class RestServiceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private HttpStatus httpStatus;

    RestServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

