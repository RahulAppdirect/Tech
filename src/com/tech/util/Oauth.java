package com.tech.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;

import com.tech.Bean.Main;
import com.tech.Bean.Marketplace;

import oauth.signpost.basic.DefaultOAuthConsumer;

public class Oauth {
	 public static Main Sign(String myurl) {

	        String str= "";

	        try {

	            DefaultOAuthConsumer e = new DefaultOAuthConsumer("webstat7-153990", "0ENXQPkQoC3VCjsS");

	                URL url = new URL(myurl);
	                
	                HttpURLConnection request = (HttpURLConnection)url.openConnection();

	                request.setRequestProperty("Accept", "application/json");

	                e.sign(request);


	                System.out.println(myurl);


	                BufferedReader in = new BufferedReader(new InputStreamReader(request.getInputStream()));


	                String line="";


	                while((line = in.readLine())!=null)

	                {

	                

	                str= str+line;

	                }
	                System.out.println("str is "+str);
	                ObjectMapper om = new ObjectMapper();

	                Main p = om.readValue(str,Main.class);

	                Marketplace mp = p.getMarketplace();

	                System.out.println(mp.getBaseUrl());
	                
	              
	                return new JsonMap().jsonmap(str);


	            }

	            catch (Exception e) {

	            e.printStackTrace();

	            }

	            return new JsonMap().jsonmap(str);

	        }

	    }