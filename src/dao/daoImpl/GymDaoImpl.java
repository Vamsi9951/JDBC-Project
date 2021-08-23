package dao.daoImpl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.GymDao;
import entity.Gym;
import entity.Member;
import exception.FemaleNotFoundException;
import utility.DbUtil;

public class GymDaoImpl implements GymDao {

	@SuppressWarnings("resource")
	@Override
	public boolean addGymDetailsIntoDb(Gym gym) {
		boolean isInserted=false;
		Connection con=null;
		PreparedStatement preparedStatement=null;
		String insertDetetailsIntoGym="insert into trinadhgym.gym values(?,?,?)";
		try {
			con=DbUtil.getConnection();
			preparedStatement=con.prepareStatement(insertDetetailsIntoGym);
			preparedStatement.setInt(1, gym.getGymId());
			preparedStatement.setString(2, gym.getGymName());
			preparedStatement.setString(3, gym.getGymLocation());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			String insertMemberDetails="insert into trinadhgym.member values(?,?,?,?,?,?,?)";
			preparedStatement=con.prepareStatement(insertMemberDetails);
			
			List<Member> memberList=gym.getMember();
			for(Member mem:memberList)
			{
				preparedStatement.setInt(1, mem.getId());
				preparedStatement.setString(2, mem.getName());
				preparedStatement.setInt(3, mem.getAge());
				preparedStatement.setDouble(4, mem.getWeight());
				preparedStatement.setDouble(5, mem.getHeight());
				preparedStatement.setString(6, mem.getGender());
				preparedStatement.setInt(7, gym.getGymId());
				preparedStatement.executeUpdate();
				
				isInserted=true;
				System.out.println("members inserted");
				
			}
			
		}catch (Exception e) {
			System.out.println("Details are not inserted..");
		}
		finally {
			
			DbUtil.closeResource(preparedStatement);
			DbUtil.closeResource(con);
		}
		return isInserted;
	}

	@Override
	public List<Member> getFemaleBygymName(String gymName) throws FemaleNotFoundException{
		Member member=null;
		List<Member> memberList=new ArrayList<Member>();
		Connection con=null;
		PreparedStatement preparedStatement=null;
		String getFemale="select * from trinadhgym.gym A inner join trinadhgym.member B on A.gymId=B.gymId where B.gender=\"female\" and B.age>20;";
		
		try {
			
			con=DbUtil.getConnection();
			preparedStatement=con.prepareStatement(getFemale);
			preparedStatement.setString(1, gymName);
			preparedStatement.execute();
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
				member=new Member(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
				memberList.add(member);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			DbUtil.closeResource(preparedStatement);
			DbUtil.closeResource(con);
		}
		
		if(memberList.size()==0)
		{
			throw new FemaleNotFoundException("female not found");
		}
		return memberList;
	}

	@Override
	public List<Gym> getDetialsInAscendingOrder() {
		Gym gym=new Gym();
		Connection con=null;
		PreparedStatement statement=null;
		List<Gym> gymList=new ArrayList<Gym>();
		String query="select * from gymdata1.gym order by name asc";
		try
		{
			con=DbUtil.getConnection();
			statement=con.prepareStatement(query);
			ResultSet rs=statement.executeQuery();
			
			while(rs.next())
			{
				gym=new Gym(rs.getInt(1), rs.getString(2), rs.getString(3));
				gymList.add(gym);
			}
			
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		finally {
			DbUtil.closeResource(statement);
			DbUtil.closeResource(con);
		}
		return gymList;
	}

}
