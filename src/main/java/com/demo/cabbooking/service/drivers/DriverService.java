package com.demo.cabbooking.service.drivers;

import java.util.List;

import com.demo.cabbooking.domain.entity.Driver;

public interface DriverService {

	List<Driver> getAllDrivers();
	
	Driver getDriver(String driverId);

	Driver registerDriver(Driver driver);
	
}
