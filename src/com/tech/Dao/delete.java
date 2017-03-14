package com.tech.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.tech.domain.UserDetails;

public class delete {
public static void deleteDao(UserDetails ud)
{
	try
    {
        Connection con = (Connection)DbConnection.getConnection();
        String query = "Delete from userinfo where Userid=?";
        PreparedStatement prpstmt= (PreparedStatement) con.prepareStatement(query);
        System.out.println(ud.getUuid());
        prpstmt.setString(1, ud.getUuid());
        prpstmt.execute();
        String query1 = "Delete from company where Userid=?";
        PreparedStatement prpstmt1= (PreparedStatement) con.prepareStatement(query1);
        prpstmt1.setString(1, ud.getUuid());
        
        prpstmt1.executeUpdate();
        
        String query2 = "Delete from order1 where EditionCode=?";
        PreparedStatement prpstmt2= (PreparedStatement) con.prepareStatement(query2);
        prpstmt2.setString(1, ud.getEditionCode());

        prpstmt2.executeUpdate();
        
        String query3 = "Delete from account where AccoountIdentifier=?";
        PreparedStatement prpstmt3= (PreparedStatement) con.prepareStatement(query3);
        prpstmt3.setString(1, ud.getAccountIdentifier());
        
        prpstmt3.executeUpdate();

        
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}


}

