package com.exercise.mend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.Validator;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercise.mend.exception.QueueSizeException;
import com.exercise.mend.models.Aircraft;
import com.exercise.mend.models.AircraftResponse;
import com.exercise.mend.repository.AircraftRepository;
import com.exercise.mend.repository.models.AircraftDao;
import com.exercise.mend.utils.AircraftSize;
import com.exercise.mend.utils.AircraftType;

/**
 * The Class AircraftControllerService.
 */
@Service
public class AircraftService {

	/** The aircraft repository. */
	@Autowired
	AircraftRepository aircraftRepository;

	/** The aircraft list. */
	List<Aircraft> aircraftList;

	/** The dozer bean mapper. */
	@Autowired
	DozerBeanMapper dozerBeanMapper;
	
	@Autowired
	AircraftResponse aircraftResponse;

	/** The logger. */
	private static Logger logger=Logger.getLogger(AircraftService.class.getName());

	/** The queue size. */

	public static final int QUEUE_SIZE=100;
	



	/**
	 * Instantiates a new aircraft controller service.
	 */
	AircraftService()
	{
		System.out.println("queue"+ QUEUE_SIZE);
		aircraftList = new ArrayList<Aircraft>();
		aircraftList.add(new Aircraft(AircraftType.CARGO, AircraftSize.LARGE));
		aircraftList.add(new Aircraft(AircraftType.EMERGENCY, AircraftSize.SMALL));
		aircraftList.add(new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL));
		aircraftList.add(new Aircraft( AircraftType.VIP, AircraftSize.SMALL));
		aircraftList.add(new Aircraft(AircraftType.EMERGENCY, AircraftSize.LARGE));
		aircraftList.add(new Aircraft( AircraftType.EMERGENCY, AircraftSize.SMALL));
		aircraftList.add(new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE));
		aircraftList.add(new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE));
		aircraftList.add(new Aircraft(AircraftType.CARGO, AircraftSize.SMALL));

	}

	/**
	 * Gets the aircraft list.
	 *
	 * @return the aircraft list
	 */
	public List<Aircraft> getAircraftList() 
	{
		List<AircraftDao> aircrafts = aircraftRepository.findAll();

		return mapAircraftList(aircraftRepository.findAll());
	}



	/**
	 * Adds the aircraft.
	 *
	 * @param aircraft the aircraft
	 * @return the list
	 */
	public List<Aircraft> addAircraft(@Valid Aircraft aircraft){
		logger.info("Adding aircraft to the database");

		if(aircraftRepository.findAll().size()==QUEUE_SIZE) {
			throw new QueueSizeException("Cannot add to the queue, reached queue limit");
		}
		
		aircraftRepository.save(dozerBeanMapper.map(aircraft, AircraftDao.class));
		return mapAircraftList(aircraftRepository.findAll());
	}


	/**
	 * Deque aircraft.
	 *
	 * @return the list
	 */
	public AircraftResponse dequeAircraft() 
	{
		logger.info("Deleting aircraft from the database");

		
		List<AircraftDao> aircraftList= aircraftRepository.findAll();
		if(aircraftList.size()==0) {
			aircraftResponse.setMessage("No Aircrafts to be removed");
		}
		else {
			aircraftResponse.setMessage("");
			AircraftDao aircraft = prioritySearch(aircraftList);
			aircraftList.remove(aircraft);
			aircraftRepository.delete(aircraft);
			aircraftResponse.setAircraftResponse(mapAircraftList(aircraftList));
		}
		
		
		return aircraftResponse;
	}

	/**
	 * Performs Priority search based on type and size.
	 *
	 * @param aircraftList the aircraft list
	 * @return the aircraft dao
	 */
	private AircraftDao prioritySearch(List<AircraftDao> aircraftList) {
		logger.info("making priority search");
		AircraftDao priority = aircraftList.get(0);
		for (int i = 0; i < aircraftList.size(); i++) {
			if (aircraftList.get(i).compareTo(priority) > 0) {
				priority = aircraftList.get(i);
			}
		}
		return priority;
	}

	/**
	 * Map repository objects to rest objects using dozer mapping.
	 *
	 * @param aircrafts the aircrafts
	 * @return the list
	 */
	private List<Aircraft> mapAircraftList(List<AircraftDao> aircrafts){
		return aircrafts
				.stream()
				.map(from -> this.dozerBeanMapper.map(from, Aircraft.class))
				.collect(Collectors.toList());
	}
}
