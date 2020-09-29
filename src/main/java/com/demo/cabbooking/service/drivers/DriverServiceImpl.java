package com.demo.cabbooking.service.drivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.cabbooking.domain.entity.Driver;
import com.demo.cabbooking.domain.repo.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepository driverRepo;

	@Override
	public List<Driver> getAllDrivers() {
		// TODO Auto-generated method stub
		return driverRepo.findAll();
	}

	@Override
	public Driver registerDriver(Driver driver) {
		// TODO Auto-generated method stub
		Driver existingDriver = driverRepo.findByPhoneNo(driver.getPhoneNo());
		if(existingDriver == null) {
			return driverRepo.save(driver);
		} else {
			throw new DriverAlreadyRegisteredException(driver.getPhoneNo());
		}
	}

	@Override
	public Driver getDriver(String driverId) {
		// TODO Auto-generated method stub
		return driverRepo.findById(driverId).orElseThrow(() -> new DriverNotFoundException(driverId));
	}

}
