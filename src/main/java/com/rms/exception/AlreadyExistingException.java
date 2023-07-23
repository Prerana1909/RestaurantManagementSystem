package com.rms.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlreadyExistingException extends RuntimeException{
	
	private static final long serialVersionUID=1L;
	private String message;
	
	public AlreadyExistingException(String message)
	{
		super(message);
		this.message=message;
	}

}
