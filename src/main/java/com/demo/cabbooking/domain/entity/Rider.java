package com.demo.cabbooking.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "phoneNo"))
public class Rider {
	@Id
	//@GeneratedValue(generator = "rider-id-gen", strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "rider-id-gen", allocationSize = 100)
	@GeneratedValue(generator = "rider-id-gen")
	@GenericGenerator(name = "rider-id-gen", 
		parameters = @Parameter(name = "prefix", value = "RB"), 
		strategy = "com.demo.cabbooking.util.StringSequenceIdGenerator")
	private String id;
	
	private String name;
	@Column
	private String phoneNo;
	
	@OneToMany(mappedBy = "rider", fetch = FetchType.LAZY)
	private
	Set<RideBooking> bookedRides;
	
	public Rider(String name, String phoneNo) {
		super();
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Set<RideBooking> getBookedRides() {
		return bookedRides;
	}

	public void setBookedRides(Set<RideBooking> bookedRides) {
		this.bookedRides = bookedRides;
	}
	
	@Override
	public String toString() {
		return "Rider with [id : " + this.id + " name : " + this.name + " ]";
	}
}
