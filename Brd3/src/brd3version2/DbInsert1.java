package brd3version2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInsert1 {

	static Connection connection=null;
	static
	{
		try
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	    connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void insert(Customer customer) throws SQLException
	{
		PreparedStatement ps=connection.prepareStatement("insert into customer_det values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setString(1,customer.getCUSTOMERID( ));  
		ps.setString(2,customer.getCUSTOMERCODE ( ));  
		ps.setString(3,customer.getCUSTOMERNAME ( ));  
		ps.setString(4,customer.getCUSTOMERADDRESS1 (  ));  
		ps.setString(5,customer.getCUSTOMERADDRESS2 (  ));  
		ps.setString(6,customer.getCUSTOMERPINCODE (  ));  
		ps.setString(7,customer.getEMAILADDRESS (  ));  
		ps.setString(8,customer.getCONTACTNUMBER (  ));  
		ps.setString(9,customer.getPRIMARYCONTACTPERSON (  ));  
		ps.setString(10,customer.getRECORDSTATUS (  ));  
		ps.setString(11,customer.getFLAG (  ));  
		ps.setString(12,customer.getCREATEDATE ( ));  
		ps.setString(13,customer.getCREATEDBY (  ));  
		ps.setString(14,customer.getMODIFIEDDATE ( ));  
		ps.setString(15,customer.getMODIFIEDBY ( ));  
		ps.setString(16,customer.getAUTHORIZEDDATE ( ));  
		ps.setString(17,customer.getAUTHORIZEDBY (  ));  
		ps.executeUpdate();  
	}
}
