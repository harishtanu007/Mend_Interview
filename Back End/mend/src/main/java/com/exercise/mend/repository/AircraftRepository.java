package com.exercise.mend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercise.mend.repository.models.AircraftDao;

/**
 * The Interface AircraftRepository.
 */
@Repository
public interface AircraftRepository extends JpaRepository<AircraftDao, Integer>{
//	List<Aircraft> aircraftList;
//	public AircraftRepository() {
//		// TODO Auto-generated constructor stub
//		aircraftList = new ArrayList<Aircraft>();
//		aircraftList.add(new Aircraft("1", AircraftType.CARGO, AircraftSize.LARGE));
//		aircraftList.add(new Aircraft("2", AircraftType.EMERGENCY, AircraftSize.SMALL));
//		aircraftList.add(new Aircraft("3", AircraftType.PASSENGER, AircraftSize.SMALL));
//		aircraftList.add(new Aircraft("4", AircraftType.VIP, AircraftSize.SMALL));
//		aircraftList.add(new Aircraft("5", AircraftType.EMERGENCY, AircraftSize.LARGE));
//		aircraftList.add(new Aircraft("6", AircraftType.EMERGENCY, AircraftSize.SMALL));
//		aircraftList.add(new Aircraft("7", AircraftType.PASSENGER, AircraftSize.LARGE));
//		aircraftList.add(new Aircraft("8", AircraftType.PASSENGER, AircraftSize.LARGE));
//		aircraftList.add(new Aircraft("9", AircraftType.CARGO, AircraftSize.SMALL));
//	}
//	
//	public List<Aircraft> getAircraftList(){
//		return aircraftList;
//	}
}
