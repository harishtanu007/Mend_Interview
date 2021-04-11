package com.exercise.mend.models;

import java.util.List;

public class AircraftResponse {
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private List<Aircraft> aircrafts;

	public List<Aircraft> getAircrafts() {
		return this.aircrafts;
	}

	public void setAircraftResponse(List<Aircraft> aircrafts) {
		this.aircrafts = aircrafts;
	}
	

}
