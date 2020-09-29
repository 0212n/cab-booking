package com.demo.cabbooking.service.drivers;

import com.demo.cabbooking.system.ResourceAlreadyExistException;

public class DriverAlreadyRegisteredException extends ResourceAlreadyExistException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1682494534751338019L;

	public DriverAlreadyRegisteredException(String phoneNo) {
		super("Driver", "Phone No",  phoneNo);
	}
}
