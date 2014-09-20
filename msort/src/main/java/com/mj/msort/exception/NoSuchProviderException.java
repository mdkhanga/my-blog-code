package com.mj.msort.exception;

/**
 * Exception is thrown when the requested Sort Provider was not
 * found and not loaded
 * 
 * 
 * @author manoj
 *
 */


public class NoSuchProviderException extends RuntimeException {
	
	/**
	 * Exception is thrown when the requested Sort Provider was not
	 * found and not loaded
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchProviderException(String message) {
		super(message) ;
	}

}
