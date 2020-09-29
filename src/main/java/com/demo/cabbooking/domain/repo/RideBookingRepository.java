package com.demo.cabbooking.domain.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cabbooking.domain.entity.RideBooking;

@Transactional
public interface RideBookingRepository extends JpaRepository<RideBooking, String> {

}
