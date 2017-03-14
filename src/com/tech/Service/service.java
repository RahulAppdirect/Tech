package com.tech.Service;

import com.tech.Dao.Daotable;
import com.tech.Dao.Inserttable;
import com.tech.domain.UserDetails;

public class service {
public static void Calltable()
{
	Daotable.Creator();
	Daotable.Company();
	Daotable.Account();
	Daotable.Order();
}
public static void Hello(UserDetails ud)
{
	Inserttable.Insert(ud);
}
}
