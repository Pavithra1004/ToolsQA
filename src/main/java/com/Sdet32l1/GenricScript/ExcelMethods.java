package com.Sdet32l1.GenricScript;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This is used to maintain all the excel specific common methods
 * @author anand
 *
 */
public class ExcelMethods {
	/**
	 * This is used to open the excel 
	 * 
	 */
	static public Workbook wb;
	/**
	 * This method is used to open the excel
	 * @param filePath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(filePath);
		wb = WorkbookFactory.create(fis);	
	}
	/**
	 * This method is used to save the excel file
	 * @param saveFilePath
	 * @throws IOException
	 */
	public static void saveExcelData(String saveFilePath)
	{
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(saveFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		try {
			wb.write(fout);
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	/**
	 * This method is used to fetch the data from the excel sheet
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public static String getDataFromExcel(String sheetName,int rowNumber,int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		return data;
	}
	public static String getDataFromExcelToString(String sheetName,int rowNumber,int cellNumber)
	{
		String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).toString();
		return data;
	}
	/**
	 * This method is used to set the data into excel
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 */
	public static void setDataIntoExcel(String sheetName,int rowNumber,int cellNumber,String data)
	{
		wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(data);

	}
	public static void closeExcel() throws IOException
	{
		wb.close();
	}
}
