package com.encore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TxtToPrintExcel {

	public static void main(String[] args) {

		 File file = new File("/Users/fangdl/tmp/88.txt");
	     try {
			System.out.println(txt2String(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchTxtToExcel() {
		String[] strings = " ".toString().split("\\s+");

		System.out.println(strings.length);
	}
	
	public static String txt2String(File file) throws Exception{
        StringBuilder result = new StringBuilder();
        FileOutputStream fos = new FileOutputStream(new File("/Users/fangdl/tmp/88.xlsx"));
		//创建工作簿
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    //新建工作表
	    XSSFSheet sheet = workbook.createSheet("结果汇总");
	    //创建行,0表示第一行
	    XSSFRow row = null;
	    Cell outcell = null;
	    int i =0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	String strArr[]=s.split("\\s+");
            	System.out.println(strArr[1]+"---"+strArr[0]);
            	row = sheet.createRow(++i);
            	outcell =row.createCell(0);
			outcell.setCellValue(strArr[0]);
		 	outcell =row.createCell(1);
			outcell.setCellValue(strArr[1]);
            }
            br.close();    
            workbook.write(fos);
		    fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
