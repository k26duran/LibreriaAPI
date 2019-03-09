package edu.eci.library.Persistence;

public class LibreriaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LibreriaException(String message){
		super(message);
		
	}
	
	public LibreriaException(String message, Throwable cause){
		super(message, cause);
		
	}
	

}
