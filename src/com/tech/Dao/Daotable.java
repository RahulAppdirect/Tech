package com.tech.Dao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Daotable {
	public static  void  Creator()

	{

	try

	{

	Connection con= (Connection)DbConnection.getConnection();

	    String sql= "CREATE TABLE userinfo(firstName varchar(20) ,lastName varchar(20),email varchar(20),AccountIdentifier varchar(20) PRIMARY KEY not null,Userid varchar(20))";

	    PreparedStatement prpstmt= (PreparedStatement) con.prepareStatement(sql);

	    prpstmt.execute();



	}

	catch(Exception e)

	{

	e.printStackTrace();

	}

	}



	public static void Company()

	{

	try

	{

	Connection con= (Connection)DbConnection.getConnection();

	String sql= "CREATE TABLE company(name varchar(20) ,email varchar(20),phoneNumber varchar(20),AccoountIdentifier varchar(20) PRIMARY KEY not null,uuid varchar(20),website varchar(20),country varchar(20))";

	PreparedStatement prpstmt= (PreparedStatement) con.prepareStatement(sql);

	prpstmt.execute();

	}

	catch(Exception e)

	{

	e.printStackTrace();

	}

	}





	public static void Order()



	{



	try



	{

	Connection con= (Connection)DbConnection.getConnection();

	String sql= "CREATE TABLE order1(EditionCode varchar(225) ,PricingDuration varchar(200),Quantity varchar(200),Unit varchar(200),AccoountIdentifier varchar(200) PRIMARY KEY not null)";

	PreparedStatement prpstmt= (PreparedStatement) con.prepareStatement(sql);

	prpstmt.execute();

	}

	catch(Exception e)

	{

	e.printStackTrace();

	}

	}





	public static void Account()



	{



	try



	{



	Connection con= (Connection)DbConnection.getConnection();

	String sql= "CREATE TABLE account(AccountIdentifier varchar(200) PRIMARY KEY not null)";

	PreparedStatement prpstmt= (PreparedStatement) con.prepareStatement(sql);

	prpstmt.execute();

	}

	catch(Exception e)

	{

	e.printStackTrace();

	}

	}






	}

