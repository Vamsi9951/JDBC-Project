package entity;

import java.util.List;

public class Gym {

	private int gymId;
	private String gymName;
	private String gymLocation;
	List<Member> member;
	public Gym() {
		super();
	}
	
	public Gym(int gymId, String gymName, String gymLocation) {
		super();
		this.gymId = gymId;
		this.gymName = gymName;
		this.gymLocation = gymLocation;
	}

	public Gym(int gymId, String gymName, String gymLocation, List<Member> member) {
		super();
		this.gymId = gymId;
		this.gymName = gymName;
		this.gymLocation = gymLocation;
		this.member = member;
	}

	public int getGymId() {
		return gymId;
	}
	public void setGymId(int gymId) {
		this.gymId = gymId;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymLocation() {
		return gymLocation;
	}
	public void setGymLocation(String gymLocation) {
		this.gymLocation = gymLocation;
	}
	
	public List<Member> getMember() {
		return member;
	}
	public void setMember(List<Member> member) {
		this.member = member;
	}
	@Override
	public String toString() {
		return "Gym [gymId=" + gymId + ", gymName=" + gymName + ", gymLocation=" + gymLocation + "]";
	}
	
	
}
