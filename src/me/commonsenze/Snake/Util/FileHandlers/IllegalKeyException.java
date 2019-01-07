package me.commonsenze.Snake.Util.FileHandlers;

public class IllegalKeyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826105065743896758L;
	
	public IllegalKeyException() {
		this("Key inputed was not found in file!");
	}
	
	public IllegalKeyException(String message) {
		super(message);
	}

}
