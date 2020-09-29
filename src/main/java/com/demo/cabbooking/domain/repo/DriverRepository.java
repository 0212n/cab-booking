package com.demo.cabbooking.domain.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cabbooking.domain.entity.Driver;

@Transactional
public interface DriverRepository extends JpaRepository<Driver, String> {

	Driver findByPhoneNo(String phoneNo);

}
