package com.demo.cabbooking.domain.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Location {
	private Double x;
	private Double y;
	
	public Location(int x, int y) {
		this.x = (double) x;
		this.y = (double) y;
	}
	public double getDistance(Location l) {
		return Math.sqrt(Math.pow(this.x - l.x, 2) + Math.pow(y - l.y,2)) ;
	}
}
