package com.exercise.mend.repository.models;

import java.util.logging.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.exercise.mend.utils.AircraftSize;
import com.exercise.mend.utils.AircraftType;

// TODO: Auto-generated Javadoc
/**
 * The Class AircraftDao.
 */
@Entity
@Table(name="Aircraft")
public class AircraftDao implements Comparable<AircraftDao>{
	
	/** The logger. */
	private static Logger logger=Logger.getLogger(AircraftDao.class.getName());

	/** The id. */
	
	
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Id
	String id;
	
	/** The type. */
	AircraftType type;
	
	/** The size. */
	AircraftSize size;
	
	/**
	 * Instantiates a new aircraft dao.
	 *
	 * @param id the id
	 * @param type the type
	 * @param size the size
	 */
	public AircraftDao(String id, AircraftType type, AircraftSize size) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Instantiates a new aircraft dao.
	 */
	public AircraftDao() {
		super();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Aircraft [id=" + id + ", type=" + type + ", size=" + size + "]";
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
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
	
	/**
	 * finds required aircraft to be removed based on type and size
	 * @param Aircraft
	 * @return the int
	 */
	@Override
	public int compareTo(AircraftDao other) {
		logger.info("making priority search based on aircraft's type and size");

		if (this.type.compareTo(other.type) > 0) {
	        return -1;
	    } else if (this.type.compareTo(other.type) < 0) {
	        return 1;
	    } else {
	    	if(this.size.compareTo(other.size)>0) {
	    		return -1;
	    	}
	    	else if(this.size.compareTo(other.size)<0)
	    	{
	    		return 1;
	    	}
	        return 0;
	    }
	}
	
	
}
