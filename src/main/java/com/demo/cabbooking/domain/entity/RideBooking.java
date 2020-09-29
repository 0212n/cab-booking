package com.demo.cabbooking.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class RideBooking {
	@Id
	//@GeneratedValue(generator = "ride-booking-id-gen", strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "ride-booking-id-gen", allocationSize = 100)
	@GeneratedValue(generator = "ride-booking-id-gen")
	@GenericGenerator(name = "ride-booking-id-gen", 
		parameters = @Parameter(name = "prefix", value = "RB"), 
		strategy = "com.demo.cabbooking.util.StringSequenceIdGenerator")
	private String id;
	
	private LocalDateTime startTime;
	
	private LocalDateTime endTime;
	
	@OneToOne
	private Rider rider;
	
	@OneToOne
	private Driver driver;
	
	private double tripCost;
	
	@AttributeOverrides({
		@AttributeOverride(name = "x", column = @Column(name = "start_location_x")),
		@AttributeOverride(name = "y", column = @Column(name = "start_location_y"))
	})
	private Location startLocation;
	@AttributeOverrides({
		@AttributeOverride(name = "x", column = @Column(name = "dest_location_x")),
		@AttributeOverride(name = "y", column = @Column(name = "dest_location_y"))
	})
	private Location destination;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private RideStatus status;

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public double getTripCost() {
		return tripCost;
	}

	public void setTripCost(double tripCost) {
		this.tripCost = tripCost;
	}

	public Location getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}
}
