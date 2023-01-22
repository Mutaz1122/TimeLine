package application;


import java.text.ParseException;
import java.util.Date;
import java.util.Map.Entry;

public class project extends GenericProject {
private StageCollection stages;
private String NodeID;
private String CustomerProjectID;
private String Stage;
private String StartDate ;
private String EndDate;
private String Customer ;
private String Currency;
private String CreatedOn ;
private String ChangedOn ;
private String numberofStage ;

public project(String nodeID, String customerProjectID, String stage, String startDate, String endDate, String customer,String currency, String createdOn, String changedOn) {
	NodeID = nodeID;
	CustomerProjectID = customerProjectID;
	Stage = stage;
	StartDate = startDate;
	EndDate = endDate;
	Customer = customer;
	Currency = currency;
	CreatedOn = createdOn;
	ChangedOn = changedOn;
	stages=new StageCollection();
}
public String getNodeID() {
	return NodeID;
}
public void setNodeID(String nodeID) {
	NodeID = nodeID;
}
public String getStage() {
	return Stage;
}
public void setStage(String stage) {
	Stage = stage;
}
public void addStageToProject(String objectValue, String documentNumber, String fieldName, String changeIndicator, String textflag,String newvalue, String oldvalue, String date, String time, String languageKey) throws ParseException {
	
	stages.addStage(objectValue,  documentNumber,  fieldName,  changeIndicator,  textflag, newvalue,  oldvalue,  date,  time,  languageKey);
	
}

public String getCustomerProjectID() {
	return CustomerProjectID;
}
public void setCustomerProjectID(String customerProjectID) {
	CustomerProjectID = customerProjectID;
}
public String getStartDate() {
	return StartDate;
}
public void setStartDate(String startDate) {
	StartDate = startDate;
}
public String getEndDate() {
	return EndDate;
}
public void setEndDate(String endDate) {
	EndDate = endDate;
}
public String getCustomer() {
	return Customer;
}
public void setCustomer(String customer) {
	Customer = customer;
}
public String getCurrency() {
	return Currency;
}
public void setCurrency(String currency) {
	Currency = currency;
}
public String getCreatedOn() {
	return CreatedOn;
}
public void setCreatedOn(String createdOn) {
	CreatedOn = createdOn;
}
public String getChangedOn() {
	return ChangedOn;
}
public void setChangedOn(String changedOn) {
	ChangedOn = changedOn;
}
public String getNumberofStage() {
	numberofStage=stages.NumberOfStages();
	return numberofStage;
}
public void setNumberofStage(String numberofStage) {
	this.numberofStage = numberofStage;
}
public String toString() {
	//return NodeID + CustomerProjectID+Stage+StartDate+EndDate+Customer+Currency+CreatedOn+ChangedOn;
	return NodeID+ "   "+stages.getNumberOfStages();
	
	
}
public stage[] stageArray() {
	
	return stages.stageArray();
	
}
public int getBefor() {
	return stages.Before();
}
public int getAfter() {
	return stages.After();
}
}
