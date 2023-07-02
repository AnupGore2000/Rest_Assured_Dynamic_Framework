package Common_API_Methods;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Common_Utility_Methods {
	
	public static void EvidenceCreator(String Filename,String RequestBody,String ResponseBody,int StatusCode) throws IOException {
		
		File TextFile = new File("C:\\Users\\Anup Gore\\OneDrive\\Documents\\API\\Evidence\\" +Filename+".txt");
		System.out.println("New blank text file of name: "+ TextFile.getName());
		
		FileWriter dataWrite = new FileWriter(TextFile);
		
		dataWrite.write("Request Body is :" +RequestBody +"\n\n");
		dataWrite.write("Status Code is : "+StatusCode +"\n\n");
		dataWrite.write("Response Body is : "+ResponseBody);
		
		dataWrite.close();
		System.out.println("Request body and response body written in textfile : "+ TextFile.getName());
		
	}
	public static ArrayList<String> ReadDataExcel(String sheetname,String TestCaseName) throws IOException
	{
	 ArrayList<String> ArrayData=new ArrayList<String>();
	 //Create the object of file input stream to locate the excel file
	 FileInputStream Fis=new FileInputStream("C:\\Users\\Anup Gore\\OneDrive\\Documents\\Selenium\\Aapache_Dependencies.xlsx");
	 try (//Step 2: Open the Excel file by creating the object XSSFWorkBook
	XSSFWorkbook WorkBook = new XSSFWorkbook(Fis)) {
		//Step 3: Open the desired sheet
		 int CountOfSheet =WorkBook.getNumberOfSheets();
		 for(int i=0; i<CountOfSheet; i++) {
			 String SheetName=WorkBook.getSheetName(i);
			 //Step 4:Access the desire sheet
			   if(SheetName.equalsIgnoreCase(SheetName))
					   {
				                //Use XXSFsheet to save the sheet into the variable
				                  XSSFSheet Sheet=WorkBook.getSheetAt(i);
				                  
				                //Create Iterator to iterate through rows and find out in which column the test case names are found
				                  Iterator<Row> Rows=Sheet.iterator();
				                  Row FirstRow=Rows.next();
				                //Create Iterator to iterate through the cell of first row to find out which cell contains test case name
				                  Iterator<Cell> CellsOfFirstRow=FirstRow.cellIterator();
				                  int k=0;
				                  int TC_column=0;
				                  while(CellsOfFirstRow.hasNext())
				                  {
				                	  Cell Cellvalue=CellsOfFirstRow.next();
				                	  if(Cellvalue.getStringCellValue().equalsIgnoreCase("TestCaseName"))
				                	  {
				                		  TC_column=k;
				                		  System .out.println("expectedclonmn for test case name:"+k);
				                		  break;
				                	  }
				                	  k++;
				                  }
				                  //Verify the row where the desire test case is found and fetch the entire Row
				                  while(Rows.hasNext())
				                  {
				                	  Row Datarow =Rows.next();
				                	  String TCName=Datarow.getCell(TC_column).getStringCellValue();
				                	  if(TCName.equalsIgnoreCase(TestCaseName))
				                	  {
				                		  Iterator<Cell> CellValues =Datarow.cellIterator();
				                		  while(CellValues.hasNext())
				                		  {
				                			  String Data=CellValues.next().getStringCellValue();
				                			  ArrayData.add(Data);  
				                		  }
				                		  break;
				                		  }
				                  }
				                  
					   }
					   
			 
		 }
	}
	 return ArrayData;
	 
	 
	}
	
}