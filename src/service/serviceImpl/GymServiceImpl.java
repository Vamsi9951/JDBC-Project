package service.serviceImpl;

import java.util.List;

import dao.GymDao;
import dao.daoImpl.GymDaoImpl;
import entity.Gym;
import entity.Member;
import exception.FemaleNotFoundException;
import service.GymService;

public class GymServiceImpl implements GymService {
	static GymDao gymDao=new GymDaoImpl();
	@Override
	public boolean addDetailsIntoDb(Gym gym) {
		
		return gymDao.addGymDetailsIntoDb(gym);
	}
	@Override
	public List<Member> getFemaleByGymName(String gymName) throws FemaleNotFoundException {
		
		return gymDao.getFemaleBygymName(gymName);
	}
	@Override
	public List<Gym> getGymDetailsInAscendingOrder() {
		
		return gymDao.getDetialsInAscendingOrder();
	}
	

}
