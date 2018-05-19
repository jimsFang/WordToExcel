package com.encore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordToExcel2007 {
	
	static List tablist = new ArrayList();
	static HashMap tabMap = new HashMap();
	
	public static void main(String[] args) throws Exception {
		loadTabInfo();
		loadDataToExcel();
	}
	
	public static void loadDataToExcel() throws Exception {


		XWPFDocument document = new XWPFDocument(
				new FileInputStream("/Users/fangdl/tmp/?????.docx"));

		FileOutputStream fos = new FileOutputStream(new File("/Users/fangdl/tmp/?????.xlsx"));
		// ??????????
		XSSFWorkbook workbook = new XSSFWorkbook();
		// ?????????
		XSSFSheet sheet = workbook.createSheet("???????");
		// ??????,0????????
		XSSFRow rownum = null;
		Cell outcell = null;
		int rowfh =0 ;

		// ??????§Ò??
		List<XWPFTable> tables = document.getTables();
//		System.out.println(tables.size());
		boolean title_no_Show= false;
		int tab_i = 0;
//		for (XWPFTable table : tables) {
		for (int t=0;t<tables.size();t++) {
			
			XWPFTable table= tables.get(t);

			XWPFTableRow row0Info = table.getRows().get(1);
			if (row0Info.getTableICells().size() >= 4 && "????".equals(row0Info.getTableCells().get(2).getText())) {

				tab_i=tab_i+1;
//				System.out.println(table.getRows().get(0).getTableICells().size());
				// ?????????
				List<XWPFTableRow> rows = table.getRows();
//				for (XWPFTableRow row : rows) {
				for (int i=0;i<rows.size();i++) {
					
					if(i==0&&title_no_Show){
//						continue;
					}
					
					rownum =sheet.createRow(++rowfh);
					// ???????????????
					List<XWPFTableCell> tableCells = rows.get(i).getTableCells();
//					for (XWPFTableCell cell : tableCells) {
					
					outcell =rownum.createCell(0);
					outcell.setCellValue("tab"+(tab_i));
					
					outcell =rownum.createCell(1);
					
					String tab_en_nm ="";
					String tab_ch_nm="";
					if(tablist.size()>0){
						tab_en_nm = tablist.get(tab_i-1).toString();
						tab_ch_nm = tabMap.get(tab_en_nm).toString();
					}
					outcell.setCellValue(tab_en_nm);
					outcell =rownum.createCell(2);
					outcell.setCellValue(tab_ch_nm);
					
					
					for (int j=0;j<tableCells.size();j++) {
						// ?????????????
						String text = tableCells.get(j).getText();
						outcell =rownum.createCell(j+3);
						outcell.setCellValue(text);
					}
					title_no_Show= true;
				}
			}
		}
		
		  workbook.write(fos);
		    fos.close();
		    System.out.println("???????????:"+tab_i);
	
		
	}
	
	public static void loadTabInfo() throws Exception{
		InputStreamReader read = null;
		File file = new File("/Users/fangdl/tmp/88.txt");
		read = new InputStreamReader(new FileInputStream(file),"gbk");
		BufferedReader bufferedReader = new BufferedReader(read);
		
		String lineTxt = null;//?????§Ø????
		int i =0;
		while((lineTxt = bufferedReader.readLine()) != null){
			if("".equals(lineTxt)){
				continue;
			}
			String[] tab_info =lineTxt.split("\\s+");
			System.out.println(tab_info[1]);
			i =i++;
			tablist.add(tab_info[0].trim());
			tabMap.put(tab_info[0].trim(), tab_info[1]);
		}
		System.out.println("??????:"+i);
		read.close();
		
	}
	

}
