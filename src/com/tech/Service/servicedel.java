package com.tech.Service;

import com.tech.Dao.delete;
import com.tech.domain.UserDetails;

public class servicedel {
public static void deleteTable(UserDetails ud)
{
	delete.deleteDao(ud);
}
}
