package com.exercise.mend.models;

import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.exercise.mend.utils.AircraftSize;
import com.exercise.mend.utils.AircraftType;

// TODO: Auto-generated Javadoc
/**
 * The Class Aircraft.
 */

public class Aircraft {
	
	public Aircraft(AircraftType type, AircraftSize size) {
		super();
		this.type = type;
		this.size = size;
	}

	/** The logger. */
	private static Logger logger=Logger.getLogger(Aircraft.class.getName());
	
	
	
	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		Aircraft.logger = logger;
	}

	/** The type. */
	@NotBlank(message="Type must be provided")
	@NotEmpty(message="Type must not empty")
	AircraftType type;
	
	/** The size. */
	@NotBlank(message="Size must be provided")
	@NotEmpty(message="Size must not empty")
	AircraftSize size;
	
	/**
	 * Instantiates a new aircraft.
	 *
	 * @param id the id
	 * @param type the type
	 * @param size the size
	 */
	public Aircraft(String id, AircraftType type, AircraftSize size) {
		super();
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Instantiates a new aircraft.
	 */
	public Aircraft() {
		super();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Aircraft [ type=" + type + ", size=" + size + "]";
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public AircraftType getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(AircraftType type) {
		this.type = type;
	}
	

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public AircraftSize getSize() {
		return size;
	}
	
	/**
	 * Sets the size.
	 *
	 * @param size the new size
	 */
	public void setSize(AircraftSize size) {
		this.size = size;
	}
	
	
}
