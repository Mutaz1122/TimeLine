package application;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
public class stage implements Comparable<stage>  {
	private String ObjectValue;
	private String DocumentNumber;
	private String FieldName;
	private String ChangeIndicator;
	private String Textflag;
	private String Newvalue;
	private String Oldvalue;
	private String Date;
	private String Time;
	private Date dateObj;
	private Date timeObj;
	private String LanguageKey;
	private Boolean duplicat=false; 
	public stage(String objectValue, String documentNumber, String fieldName, String changeIndicator, String textflag,String newvalue, String oldvalue, String date, String time, String languageKey) throws ParseException {
		ObjectValue = objectValue;
		DocumentNumber = documentNumber;
		FieldName = fieldName;
		ChangeIndicator = changeIndicator;
		Textflag = textflag;
		Newvalue = newvalue;
		Oldvalue = oldvalue;
		Date = date;
		Time = time;
		LanguageKey = languageKey;
//		LocalDate datePart = LocalDate.parse(Date);
//	    LocalTime timePart = LocalTime.parse(Time);
//	    LocalDateTime dateWitheTime = LocalDateTime.of(datePart, timePart);
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 dateObj = sdf.parse(Date);
		 DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
		 timeObj = (Date)formatter.parse(Time);
	}
	public Date getDateObj() {
		return dateObj;
	}
	public void setDateObj(Date dateObj) {
		this.dateObj = dateObj;
	}
	
	public Date getTimeObj() {
		return timeObj;
	}
	public void setTimeObj(Date timeObj) {
		this.timeObj = timeObj;
	}
	public Boolean getDuplicat() {
		return duplicat;
	}
	public void setDuplicat(Boolean duplicat) {
		this.duplicat = duplicat;
	}
	public String getObjectValue() {
		return ObjectValue;
	}
	public void setObjectValue(String objectValue) {
		ObjectValue = objectValue;
	}
	public String getDocumentNumber() {
		return DocumentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		DocumentNumber = documentNumber;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String fieldName) {
		FieldName = fieldName;
	}
	public String getChangeIndicator() {
		return ChangeIndicator;
	}
	public void setChangeIndicator(String changeIndicator) {
		ChangeIndicator = changeIndicator;
	}
	public String getTextflag() {
		return Textflag;
	}
	public void setTextflag(String textflag) {
		Textflag = textflag;
	}
	public String getNewvalue() {
		return Newvalue;
	}
	public void setNewvalue(String newvalue) {
		Newvalue = newvalue;
	}
	public String getOldvalue() {
		return Oldvalue;
	}
	public void setOldvalue(String oldvalue) {
		Oldvalue = oldvalue;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getLanguageKey() {
		return LanguageKey;
	}
	public void setLanguageKey(String languageKey) {
		LanguageKey = languageKey;
	}
	@Override
	public int compareTo(stage o) {
		if(this.dateObj.compareTo(o.dateObj)==1)
			return 1;
		else if(this.dateObj.compareTo(o.dateObj)==-1)
			return -1;
		else if(this.dateObj.compareTo(o.dateObj)==0) {
			if(this.timeObj.compareTo(o.timeObj)==1) {
				this.setDuplicat(true);
				return 1;}
			else if(this.timeObj.compareTo(o.timeObj)==-1) {
				o.setDuplicat(true);
				return -1;} 
			
	}
		return 0;
	}
	
	

}
