package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class readExcel {
	private static ProjectCollection projCollection;
	public static ProjectCollection getProjects() throws IOException, ParseException {
		projCollection=new ProjectCollection();
		excel1();
		excel2();
		return projCollection;
		
		
		        }
	
	
	
	private static void excel1() throws IOException{
		File fiss=new File("Projects.xlsx");
		FileInputStream fis=new FileInputStream(fiss);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		    XSSFSheet sheet = wb.getSheetAt(0);	
	        Iterator rows = sheet.rowIterator();
	        Row row=(Row)rows.next();
	        while(rows.hasNext()) {
	        	row=(Row)rows.next();
	        	
	        	String NodeID=row.getCell(0).toString();
	        	String CustomerProjectID=row.getCell(1).toString();
	        	String Stage=row.getCell(2).toString();
	        	String StartDate;
	        	if(row.getCell(3)==null)
	        		 StartDate="" ;
	        	else
	        	 StartDate=row.getCell(3).toString() ;
	        	 String EndDate;
		        	if(row.getCell(4)==null)
		        		EndDate="" ;
		        	else
		        	EndDate=row.getCell(4).toString() ;
	        	String Customer;
	        	if(row.getCell(5)==null)
	        		Customer="" ;
	        	else
	        	Customer=row.getCell(5).toString() ;
	        	String Currency=row.getCell(6).toString();
	        	String CreatedOn =row.getCell(7).toString();
	        	String ChangedOn=row.getCell(8).toString() ;
	        	projCollection.addProj(NodeID, CustomerProjectID, Stage, StartDate, EndDate, Customer, Currency, CreatedOn, ChangedOn);
		    	}

	}
	
	private static void excel2() throws IOException, ParseException{
		
		File fiss1=new File("Stages.xlsx");
		File fiss2=new File("Stages_Detailed.xlsx");
		FileInputStream fis1=new FileInputStream(fiss1);
		FileInputStream fis2=new FileInputStream(fiss2);
		XSSFWorkbook wb1=new XSSFWorkbook(fis1);
		XSSFWorkbook wb2=new XSSFWorkbook(fis2);
		 XSSFSheet sheet1 = wb1.getSheetAt(0);	
		 XSSFSheet sheet2 = wb2.getSheetAt(0);	
		 Iterator rows1 = sheet1.rowIterator();
		 Iterator rows2 = sheet2.rowIterator();
		  Row row1=(Row)rows1.next();
		  Row row2=(Row)rows2.next();
		  
		  while(rows1.hasNext()&& rows2.hasNext() ) {
	        	row1=(Row)rows1.next();
	        	row2=(Row)rows2.next();
	        	if(row1.getCell(1).toString().equals(row2.getCell(1).toString())) {
	        		String ObjectValue=row1.getCell(0).toString();
	        		String DocumentNumber=row1.getCell(1).toString();
	        		String FieldName=row1.getCell(2).toString();
	        		String ChangeIndicator=row1.getCell(3).toString();
	        		String Textflag=row1.getCell(4).toString();
	        		String Newvalue=row1.getCell(5).toString();
	        		String Oldvalue;
	        		if(row1.getCell(6)==null)
	        			Oldvalue="";
	        		else
	        		 Oldvalue=row1.getCell(6).toString();
	        		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	 		        String  Date =  sdf.format(row2.getCell(2).getDateCellValue());
//	 		       Date Date = sdf.parse(date);
	 		       //Date Date=date;
	        		//String Date=row2.getCell(2).toString();
	 		       String Time = new DataFormatter().formatCellValue(row2.getCell(3));
	        		//String Time=row2.getCell(3).toString();
	        		String LanguageKey=row2.getCell(4).toString();
	        		projCollection.findProject(ObjectValue).addStageToProject(ObjectValue, DocumentNumber, FieldName, ChangeIndicator, Textflag, Newvalue, Oldvalue, Date, Time, LanguageKey);
	        	}

		
		
	}
	
	}
	}


