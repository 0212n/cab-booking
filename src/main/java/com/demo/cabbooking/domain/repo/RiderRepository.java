package com.demo.cabbooking.domain.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cabbooking.domain.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider, String>{

}
