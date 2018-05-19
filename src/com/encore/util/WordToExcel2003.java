package com.encore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WordToExcel2003 {
	
	static List tablist = new ArrayList();
	static HashMap tabMap = new HashMap();
	
	public static void main(String[] args) throws Exception {
		loadTabInfo();
		loadDataToExcel();
	}

	public static void loadDataToExcel() throws Exception {
		FileInputStream in;

//		in = new FileInputStream("C:\\wordToExcel\\陕西信合_互联网数字银行服务应用系统_账户限额_数据库设计说明书_1.1.doc");
		in = new FileInputStream("/Users/fangdl/tmp/统一支付.docx");

		POIFSFileSystem pfs = new POIFSFileSystem(in);
		HWPFDocument hwpf = new HWPFDocument(pfs);
		
		FileOutputStream fs = new FileOutputStream(new File("/Users/fangdl/tmp/88.txt"));
		PrintStream p = new PrintStream(fs);
		
		FileOutputStream fos = new FileOutputStream(new File("/Users/fangdl/tmp/统一支付.xlsx"));
		//创建工作簿
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    //新建工作表
	    XSSFSheet sheet = workbook.createSheet("结果汇总");
	    //创建行,0表示第一行
	    XSSFRow row = null;

		StringBuffer stringbuffer = new StringBuffer();
		//
		Range range = hwpf.getRange();
		
		TableIterator it = new TableIterator(range);
		Cell outcell = null;
		int t = 0;
		int tab_num =0;
		// 迭代文档中的表格
		boolean title_no_Show = false;
		while (it.hasNext()) {
			Table tb = (Table) it.next();
			
			//第四个单元格 条件 Dic_data
			if(tb.getRow(1).numCells()>=4&&(tb.getRow(1).getCell(2).getParagraph(0).text().trim().equals("长度"))){
//			if(tb.getRow(0).numCells()>=4&&(tb.getRow(0).getCell(1).getParagraph(0).text().trim().equals("数据类型")||tb.getRow(0).getCell(1).getParagraph(0).text().trim().equals("字段名"))){

				tab_num=tab_num+1;
				for (int i = 0; i < tb.numRows(); i++) {
					TableRow tr = tb.getRow(i);
					//只输出第一个表格的标题
					if(i==0&&title_no_Show){
						continue;
					}
					//创建excel行数
					
					row = sheet.createRow(++t);
					outcell =row.createCell(0);
					outcell.setCellValue("Tab"+tab_num);
					outcell =row.createCell(1);
					String tab_en_nm ="";
					String tab_ch_nm="";
					if(tablist.size()>0){
						tab_en_nm = tablist.get(tab_num-1).toString();
						tab_ch_nm = tabMap.get(tab_en_nm).toString();
					}
					outcell.setCellValue(tab_en_nm);
					outcell =row.createCell(2);
					outcell.setCellValue(tab_ch_nm);
					
					// 迭代列，默认从0开始
					for (int j = 0; j < tr.numCells(); j++) {
						TableCell td = tr.getCell(j);// 取得单元格
						Paragraph para = td.getParagraph(0);
						String s = para.text();
						outcell =row.createCell(j+3);
						outcell.setCellValue(s.trim());
						
					}
					title_no_Show= true;

				}
			}
			
		
			
		}
		System.out.println("文档表总数"+tab_num);
		p.close();
		fs.close();
		in.close();
		  workbook.write(fos);
		    fos.close();
	}
	
	public static void loadTabInfo() throws Exception{
		InputStreamReader read = null;
		File file = new File("/Users/fangdl/tmp/88.txt");
		read = new InputStreamReader(new FileInputStream(file),"gbk");
		BufferedReader bufferedReader = new BufferedReader(read);
		
		String lineTxt = null;//按照行读文件
		int i =0;
		while((lineTxt = bufferedReader.readLine()) != null){
			if("".equals(lineTxt)){
				continue;
			}
			String[] tab_info =lineTxt.split("\\s+");
			System.out.println(tab_info[0]+"-----"+tab_info[1]);
			i =i+1;
			tablist.add(tab_info[0].trim());
			tabMap.put(tab_info[0].trim(), tab_info[1]);
		}
		
		System.out.println("表总数:"+i);
		read.close();
		
	}

}
