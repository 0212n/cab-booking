package com.demo.cabbooking.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "phoneNo"))
public class Driver {
	
	@Id
	//@GeneratedValue(generator = "driver-id-gen", strategy = GenerationType.SEQUENCE)
	//@SequenceGenerator(name = "driver-id-gen", allocationSize = 100)
	@GeneratedValue(generator = "driver-id-gen")
	@GenericGenerator(name = "driver-id-gen", 
		parameters = @Parameter(name = "prefix", value = "DR"), 
		strategy = "com.demo.cabbooking.util.StringSequenceIdGenerator")
	private String id;
	
	private String name;
	@Column
	private String phoneNo;
	
	@Column
	private String cabId;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 8)
	private DriverStatus status;
	
	@OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
	Set<RideBooking> bookedRides;
	
	public Driver( ) {
		super();
	}
	public Driver(String id, String name, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.status = DriverStatus.LOGGEDIN;
	}
	public String getCabId() {
		return this.cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public String toString( ) {
		return "Driver [id=" + id + ", name =" + name + ", phone number=" + phoneNo + "]";
	}
}
