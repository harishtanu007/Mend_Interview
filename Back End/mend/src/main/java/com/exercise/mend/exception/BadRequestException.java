package com.exercise.mend.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RestServiceException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestException(String error) {
        super(error, HttpStatus.OK);
    }

}
