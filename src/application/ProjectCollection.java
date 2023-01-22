package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class ProjectCollection {

private HashMap<String, project> projcollection ;

project[] projectArray;
public ProjectCollection() {
	projcollection=new HashMap<String, project>();
}

public void addProj(String nodeID, String customerProjectID, String stage, String startDate, String endDate, String customer,String currency, String createdOn, String changedOn) {
	project proj=new project(nodeID,customerProjectID,stage,startDate,endDate,customer,currency,createdOn,changedOn);
	projcollection.put(nodeID, proj);

	
}
public project findProject(String ObjValue) {
	
	return projcollection.get(ObjValue);
	
}
public void tostring() {
	for (project i : projcollection.values()) {
		  System.out.println(i.toString());
		}

	
}
public project[] projectArray() {
	
	project[] values = new project[projcollection.size()];
	int index = 0;
	for (Entry<String, project> mapEntry : projcollection.entrySet()) {
	    values[index] = mapEntry.getValue();
	    index++;
	}
	return values;
	
}
public project findProjectById(String customerProjectID) {
	
	 for (project p1 : projectArray()) {
         if(p1.getCustomerProjectID().equals(customerProjectID))
        	 return p1;

             }
	return null;
}
}
