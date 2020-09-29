package com.demo.cabbooking.system;

public class ResourceAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3943115077465819238L;
	
	public ResourceAlreadyExistException(String resourceType, String uniqueName, String value) {
		super(resourceType + " with " + uniqueName + " : " + value + "already exists");
	}

}
