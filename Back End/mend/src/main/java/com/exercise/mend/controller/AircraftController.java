package com.exercise.mend.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.mend.exception.QueueSizeException;
import com.exercise.mend.models.Aircraft;
import com.exercise.mend.models.AircraftResponse;
import com.exercise.mend.service.AircraftService;

/**
 * The Class AircraftController.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AircraftController {
	
	/** The logger. */
	private static Logger logger=Logger.getLogger(AircraftController.class.getName());

	/** The aircraft controller service. */
	@Autowired
	private AircraftService aircraftControllerService;
	
	/**
	 * Gets the aircraft list.
	 *
	 * @return list of aircrafts available in the system
	 */
	@GetMapping("/aircrafts")
	public List<Aircraft> getAircraftList() 
	{
		logger.info("Calling get aircraft api ");
		return aircraftControllerService.getAircraftList();
	}
	
	/**
	 * Adds an aircraft.
	 *
	 * @param aircraft
	 * @return list of aircrafts available in the system
	 */
	@PostMapping("/aircrafts")
	public List<Aircraft> addAircraft(@RequestBody Aircraft aircraft)
	{
		logger.info("Calling add aircraft api");
		return aircraftControllerService.addAircraft(aircraft);
	}
	
	/**
	 * This method dequeues an aircraft based on size and type.
	 *
	 * @return list of aircrafts available in the system
	 */
	@DeleteMapping("/aircrafts")
	public AircraftResponse dequeAircraft()
	{
		logger.info("Calling delete aircraft api");
		return aircraftControllerService.dequeAircraft();
	}

}
