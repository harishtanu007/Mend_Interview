package com.exercise.mend.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends RestServiceException {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InternalServerException(String error) {
        super(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
