package com.tech.util;


import java.util.Random;

import com.tech.Bean.Main;
import com.tech.domain.UserDetails;

import ravi.model.Parent;

public class container {
	public UserDetails container(Main pm){
        UserDetails user =new UserDetails();
        
        user.setApplicationUuid(pm.getApplicationUuid());
        
        if(pm.getPayload().getCompany()!=null){
        	user.setCompanyCountry(pm.getPayload().getCompany().getCountry());
        	user.setCompanyExternalId(pm.getPayload().getCompany().getExternalId());
        	user.setCompanyName(pm.getPayload().getCompany().getName());
        	user.setCompanyPhnNumber(pm.getPayload().getCompany().getPhoneNumber());
        	user.setCompanyWebsite(pm.getPayload().getCompany().getWebsite());
            
        }
        
        if(pm.getPayload().getOrder()!=null){
        	user.setPricingDuraciton(pm.getPayload().getOrder().getPricingDuration());
        	user.setEditionCode(pm.getPayload().getOrder().getEditionCode());
        }
        
        user.setUuid(pm.getCreator().getUuid());
        
        if(pm.getPayload().getAccount()!=null){
        	user.setAccountIdentifier(pm.getPayload().getAccount().getAccountIdentifier());
        }
        else{
            Random rand = new Random();

            int  n = rand.nextInt(50) + 1;

            user.setAccountIdentifier(""+n);
        }
        

        user.setEmail(pm.getCreator().getEmail());
        user.setAddress(pm.getCreator().getAddress());
        user.setFlag(pm.getFlag());
        user.setLanguage(pm.getCreator().getLanguage());
        user.setFirstName(pm.getCreator().getFirstName());
        user.setLastName(pm.getCreator().getLastName());

        return user;
    }
}