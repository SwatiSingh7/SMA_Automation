package com.morrisons.sma.pojo.service.CountPostPOJO;

import java.util.ArrayList;
import java.util.List;

public class CountPO_CountImplements {
public static Integer depart;
	public List <CountPO_DepartmentList> departList(){
		List <CountPO_DepartmentList> departName = new ArrayList();
		CountPO_DepartmentList departValue = new CountPO_DepartmentList();
		departValue.setDepartment(depart);
		departName.add(departValue);
		return departName;
	}
	
	public static void departValue(String deps){
		
		depart = Integer.valueOf(deps);
		
	}
 }
