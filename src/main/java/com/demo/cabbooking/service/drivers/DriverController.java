package com.demo.cabbooking.service.drivers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.cabbooking.domain.entity.Driver;

@RestController
@RequestMapping("drivers")
public class DriverController {
	@Autowired
	private DriverService driverService;
	
	@GetMapping
	public @ResponseBody List<Driver> getAllDrivers() {
		return driverService.getAllDrivers();
	}
	
	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	public Driver registerDriver(@RequestBody Driver driver, HttpServletResponse response) {
		response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath()
			      .path("/findPerson/" + driver.getId()).toUriString());
		
	    HttpHeaders headers = new HttpHeaders();

	    return driverService.registerDriver(driver);
	}
}
