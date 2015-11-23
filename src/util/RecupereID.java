package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import metier.SingletonConnection;

public class RecupereID {
	
	public static int getNewId(String nomCol,String nomTable,Set<Integer> s1)
	{
		int res=0;
		Set<Integer> s2 = new HashSet<Integer>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select "+nomCol+" from "+nomTable);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				s2.add(rs.getInt(nomCol));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s2.removeAll(s1);
		res=(int) s2.toArray()[0];
		return res;
	}
	
	public static Set<Integer> getListID(String nomCol, String nomTable)
	{
		Set<Integer> res = new HashSet<Integer>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("select "+nomCol+" from "+nomTable);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				res.add(rs.getInt(nomCol));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
}
