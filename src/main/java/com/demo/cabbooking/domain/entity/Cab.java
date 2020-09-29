package com.demo.cabbooking.domain.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "regNo"))
public class Cab {
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "x", column = @Column(name = "cab_location_x")),
		@AttributeOverride(name = "y", column = @Column(name = "cab_location_y"))
	})
	Location cabLocation ;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cab-id-gen")
    //@SequenceGenerator(name="cab-id-gen", sequenceName="cab-id-gen", allocationSize=100)
	@GeneratedValue(generator = "cab-id-gen")
	@GenericGenerator(name = "cab-id-gen", 
		parameters = @Parameter(name = "prefix", value = "C"), 
		strategy = "com.demo.cabbooking.util.StringSequenceIdGenerator")
	private String id;
	private String modelName;
	private String regNo ;
	
	public Cab(String modelName, String regNo) {
		// TODO Auto-generated constructor stub
		super();
		this.modelName = modelName ;
		this.regNo = regNo ;
		
	}
	
	public Location getCabLocation() {
		return cabLocation;
	}

	public void setCabLocation(Location cabLocation) {
		this.cabLocation = cabLocation;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
}
