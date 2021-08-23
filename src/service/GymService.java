package service;

import java.util.List;

import entity.Gym;
import entity.Member;
import exception.FemaleNotFoundException;

public interface GymService {

	boolean addDetailsIntoDb(Gym gym);

	List<Member> getFemaleByGymName(String gymName) throws FemaleNotFoundException;

	List<Gym> getGymDetailsInAscendingOrder();

	

}
