package dao;

import java.util.List;

import entity.Gym;
import entity.Member;
import exception.FemaleNotFoundException;

public interface GymDao {

	boolean addGymDetailsIntoDb(Gym gym);

	
	/**
	 * @param gymName
	 * @return list of female members
	 * @throws FemaleNotFoundException
	 */
	List<Member> getFemaleBygymName(String gymName) throws FemaleNotFoundException;
	

	List<Gym> getDetialsInAscendingOrder();
	

}

