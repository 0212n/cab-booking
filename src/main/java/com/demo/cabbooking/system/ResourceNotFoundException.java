package com.demo.cabbooking.system;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727435174039841669L;
	
	public ResourceNotFoundException(String resourceType, String keyName, String keyValue) {
		super(resourceType + " with " + keyName + "[" + keyValue + "] not found in the system!");
	}
}
