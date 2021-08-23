package client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Gym;
import entity.Member;
import exception.FemaleNotFoundException;
import service.GymService;
import service.serviceImpl.GymServiceImpl;

public class GymApp {
	static Scanner scanner=new Scanner(System.in);
	static GymService gymService=new GymServiceImpl();
	
	
	public static void main(String[] args) {
		boolean exit=true;
		do {
			menu();
			int option=getOption();
			switch(option)
			{
			case 1:
				Gym gym=addDetailsToGym();
				System.out.println(gym);
				System.out.println(gym.getMember());
				boolean isInserted=gymService.addDetailsIntoDb(gym);
				if(isInserted)
				{
					System.out.println("Details added succes fully");
				}
				
				break;
			case 2:
				System.out.println("Enter gym name to get female members in that gym");
				String gymName=scanner.next();
				
				List<Member> memberList=new ArrayList<Member>();
				try {
					memberList=gymService.getFemaleByGymName(gymName);
				} catch (FemaleNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				displayFemaleMembersInGivenGym(memberList);
				
				break;
			case 3:
				
				List<Gym> gymList=new ArrayList<Gym>();
				gymList=gymService.getGymDetailsInAscendingOrder();
				displayFemaleDetails(gymList);
				
				break;
			
			case 4:exit=false;
				break;
			}
		

	}while(exit);
	}
	private static void displayFemaleDetails(List<Gym> gymList) {
		for(Gym gym:gymList)
		{
			System.out.println(gym);
		}
		
	}
	private static void displayFemaleMembersInGivenGym(List<Member> memberList) {
		
		for(Member mem:memberList)
		{
			System.out.println(mem);
		}
		
	}
	
	private static Gym addDetailsToGym() {
		List<Member> memberList=new ArrayList<Member>();
		
		System.out.println("Enter Gym details..");
		System.out.println();
		
		System.out.println("Enter gym Id:");
		int gymId=scanner.nextInt();
		
		System.out.println("Enter gym Name:");
		String gymName=scanner.next();
		
		System.out.println("Enter gym Location:");
		String gymLocation=scanner.next();
		
		System.out.println("enter how many members you want to add into gym..");
		int numberofmembers=scanner.nextInt();
		
		for (int i = 0; i <numberofmembers; i++) {
			
			System.out.println("Add Members Details..");
			System.out.println();
			
			System.out.println("Enter new member Id:");
			int memberId=scanner.nextInt();
			
			System.out.println("Enter new member Name:");
			String memberName=scanner.next();
			
			System.out.println("Enter new member age:");
			int memberAge=scanner.nextInt();
			
			System.out.println("Enter new member Weight:");
			double memberWeight=scanner.nextDouble();
			
			System.out.println("Enter new member height:");
			double memberHeight=scanner.nextDouble();
			
			System.out.println("Enter new member Gender:");
			String gender=scanner.next();
			
			Member member=new Member(memberId, memberName, memberAge, memberWeight, memberHeight, gender);
			memberList.add(member);
			
		}
		Gym gym=new Gym(gymId, gymName, gymLocation, memberList);
		return gym;
	}
	
	private static int getOption() {
		System.out.println("Enter your Option..");
		int option=scanner.nextInt();
		
		return option;
	}
	private static void menu() {
		System.out.println("1.add members to gym");
		   System.out.println("2.search a gym and show all female members associated with that gym age >50 in sorted order by name");
		   System.out.println("3.sorted all gym as per location if location same then sort by name");
		   System.out.println("4.exit");
		
	}

}
