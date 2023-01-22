package application;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class StageCollection {
	private HashMap<String, stage> stagecollection ;
	

	
	public StageCollection() {
		stagecollection=new HashMap<String, stage>();
	}
	public void addStage(String objectValue, String documentNumber, String fieldName, String changeIndicator, String textflag,String newvalue, String oldvalue, String date, String time, String languageKey) throws ParseException {
		
		stagecollection.put(documentNumber, new stage( objectValue,  documentNumber,  fieldName,  changeIndicator,  textflag, newvalue,  oldvalue,  date,  time,  languageKey));
		
		
	}
	int getNumberOfStages(){
		return stagecollection.size();
	}
	public stage[] stageArray() {
		
		stage[] values = new stage[stagecollection.size()];
		int index = 0;
		for (Entry<String, stage> mapEntry : stagecollection.entrySet()) {
		    values[index] = mapEntry.getValue();
		    index++;
		}
		Arrays.sort(values, stage::compareTo);
		return values;
		
	}
	public String NumberOfStages() {
		int i=0;
		for(stage s: stageArray() )
			if(!s.getDuplicat())
				i++;
		return i+"";

	
		
		
	}
	public int Before() {
		int before=0;
		for (stage s:stageArray() ) {
			if(s.getNewvalue().equals("5.0")) {
				return before;
			}
			if(s.getOldvalue().compareTo(s.getNewvalue())==1)
				before++;}
		
		
		return before;
	} 
	public int After() {
		int b=Before();
		
		int After=0;
		for (stage s:stageArray() )
			if(s.getOldvalue().compareTo(s.getNewvalue())==1)
				After++;
		
		
		return After-b;
	} 
}
