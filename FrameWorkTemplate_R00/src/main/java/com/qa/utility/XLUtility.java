package com.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.pageLayer.TestBase.TestBase;


public class XLUtility extends TestBase{
	
public FileInputStream fis;
public FileOutputStream fos;
public XSSFWorkbook wb;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
public CellStyle style;
String path=null;

public XLUtility(String path)
{
	this.path=path;
}


//this is for row count here we pass sheet name
public int getRow(String  Sheetname) throws IOException
{
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet( Sheetname);
	int rowcount=sheet.getLastRowNum();
	wb.close();
	fis.close();
	return rowcount;
}
//this is for cell count here we pass sheet name and rownum
public int getCell(String  Sheetname, int rownum) throws IOException
{
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet( Sheetname);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	wb.close();
	fis.close();
	return cellcount;
}
//here we read the data
public String readCellData(String Sheetname, int rownum ,int colnum) throws IOException
{
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet( Sheetname);
	row=sheet.getRow(rownum);
	cell=row.getCell(colnum);
	DataFormatter formatter=new DataFormatter();
	String data;
	try {
		data=formatter.formatCellValue(cell);//this convert to string
	}
	catch(Exception e)
	{
		data="";
	}
	wb.close();
	fis.close();
	return data;
}
//here we write the data
public void writeCellData(String Sheetname, int rownum ,int colnum, String data) throws IOException
{
	fis=new FileInputStream(path);
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet( Sheetname);
	row=sheet.getRow(rownum);
	cell=row.createCell(colnum);
	cell.setCellValue(data);
	fos=new FileOutputStream(path);
	wb.write(fos);
	wb.close();
	fis.close();
	fos.close();
	DataFormatter formatter=new DataFormatter();
	
}
				
}


	

