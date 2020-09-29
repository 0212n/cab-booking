package com.demo.cabbooking.service.drivers;

import com.demo.cabbooking.system.ResourceNotFoundException;

public class DriverNotFoundException extends ResourceNotFoundException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8956084028288691353L;

	public DriverNotFoundException(String driverId) {
		super("Driver", "driver-id", driverId);
	}

}
