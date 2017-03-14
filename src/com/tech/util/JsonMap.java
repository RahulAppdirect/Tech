package com.tech.util;

import org.codehaus.jackson.map.ObjectMapper;

import com.tech.Bean.Main;

public class JsonMap {
	public Main jsonmap(String str)

	{
	ObjectMapper om = new ObjectMapper();

	Main p = new Main();


	try

	{

	p=om.readValue(str,Main.class);



	}



	catch(Exception e)



	{



	e.printStackTrace();



	}



	return p;

	}


	}


