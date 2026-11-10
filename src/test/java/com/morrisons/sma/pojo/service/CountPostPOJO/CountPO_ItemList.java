package com.morrisons.sma.pojo.service.CountPostPOJO;

import java.util.ArrayList;
import java.util.List;
public class CountPO_ItemList {


	public class CountImplements {

		public List <CountPO_DepartmentList> departList(){
			List <CountPO_DepartmentList> departName = new ArrayList();
			CountPO_DepartmentList departValue = new CountPO_DepartmentList();
			departValue.setDepartment(12);
			departName.add(departValue);
			return departName;
		}
}
}