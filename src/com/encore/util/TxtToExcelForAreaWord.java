package com.encore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 解析标准数据项word文档至excel
 * 
 * @author fangdl
 *
 */
public class TxtToExcelForAreaWord {

	public static void main(String[] args) {
		try {
			txt2String();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchTxtToExcel() {
		String[] strings = " ".toString().split("\\s+");

		System.out.println(strings.length);
	}

	public static String txt2String() throws Exception {
		//待优化成模版信息
		/*TODO  模版信息 信息项编号 主题域名 标准大类 标准子类 标准细则 
		"信息项中文名称","信息项英文名称","信息项业务含义","标准依据","值域","相关信息项","与相关信息项关系"
		 ,"数据类别","数据长度","标准类别","创建时间","更新时间","更新人员","标准定义部门","标准管理部门","标准使用部门","标准应用系统","权威系统" */
		
		StringBuilder result = new StringBuilder();
		String titleName = "";
		String titleValue = "";
		String[] titlArr = {"信息项编号","信息项中文名称","信息项英文名称","信息项业务含义","标准依据","值域","相关信息项","与相关信息项关系"
				,"数据类别","数据长度","标准类别","创建时间","更新时间","更新人员","标准定义部门","标准管理部门","标准使用部门","标准应用系统","权威系统"};
//  技术主题   交易主题   客户主题  渠道主题  协议主题  资产主题   组织主题
		File file = new File("/Users/fangdl/tmp/组织主题.txt");
		FileOutputStream fos = new FileOutputStream(new File("/Users/fangdl/tmp/组织主题.xlsx"));
		// 创建工作簿
		XSSFWorkbook workbook = new XSSFWorkbook();
		// 新建工作表
		XSSFSheet sheet = workbook.createSheet("结果汇总");
		// 创建行,0表示第一行
		XSSFRow rowInfo = null;
		Cell outcell = null;
		
		rowInfo =sheet.createRow(0);
		
		outcell =rowInfo.createCell(0);
		outcell.setCellValue(titlArr[0]);
		outcell =rowInfo.createCell(1);
		outcell.setCellValue(titlArr[1]);
		outcell =rowInfo.createCell(2);
		outcell.setCellValue(titlArr[2]);
		outcell =rowInfo.createCell(3);
		outcell.setCellValue(titlArr[3]);
		outcell =rowInfo.createCell(4);
		outcell.setCellValue(titlArr[4]);
		outcell =rowInfo.createCell(5);
		outcell.setCellValue(titlArr[5]);
		outcell =rowInfo.createCell(6);
		outcell.setCellValue(titlArr[6]);
		outcell =rowInfo.createCell(7);
		outcell.setCellValue(titlArr[7]);
		outcell =rowInfo.createCell(8);
		outcell.setCellValue(titlArr[8]);
		outcell =rowInfo.createCell(9);
		outcell.setCellValue(titlArr[9]);
		outcell =rowInfo.createCell(10);
		outcell.setCellValue(titlArr[10]);
		outcell =rowInfo.createCell(11);
		outcell.setCellValue(titlArr[11]);
		outcell =rowInfo.createCell(12);
		outcell.setCellValue(titlArr[12]);
		outcell =rowInfo.createCell(13);
		outcell.setCellValue(titlArr[13]);
		outcell =rowInfo.createCell(14);
		outcell.setCellValue(titlArr[14]);
		outcell =rowInfo.createCell(15);
		outcell.setCellValue(titlArr[15]);
		outcell =rowInfo.createCell(16);
		outcell.setCellValue(titlArr[16]);
		outcell =rowInfo.createCell(17);
		outcell.setCellValue(titlArr[17]);
		outcell =rowInfo.createCell(18);
		outcell.setCellValue(titlArr[18]);
		

		BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
		String s = null;
		int i =0;
		while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			String strArr[] = s.split("\\：");
			if (strArr.length > 1) {
				System.out.println(strArr[0] + "-----" + strArr[1]);
				titleName = strArr[0];
				titleValue = strArr[1];
				titleValue =titleValue .replaceAll("\\s*", ""); 
			} else {
				System.out.println(strArr[0]);
				titleName = strArr[0];
				titleValue = "";
			}
			if(!"".equals(titleName)&&titleName.startsWith(titlArr[0])) {
				i++;
				rowInfo =sheet.createRow(i);
				outcell =rowInfo.createCell(0);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[1])) {
				outcell =rowInfo.createCell(1);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[2])) {
				outcell =rowInfo.createCell(2);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[3])) {
				outcell =rowInfo.createCell(3);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[4])) {
				outcell =rowInfo.createCell(4);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[5])) {
				outcell =rowInfo.createCell(5);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[6])) {
				outcell =rowInfo.createCell(6);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[7])) {
				outcell =rowInfo.createCell(7);
				outcell.setCellValue(titleValue);
//			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[8])) {
			}else if(!"".equals(titleName)&&(titleName.startsWith(titlArr[8])||titleName.startsWith("数据类型"))) {
				outcell =rowInfo.createCell(8);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[9])) {
				outcell =rowInfo.createCell(9);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[10])) {
				outcell =rowInfo.createCell(10);
				outcell.setCellValue(titleValue);
				
				System.out.println(titleValue);
				String[] areaStr=titleValue.split("\\-",5);
				if(areaStr.length==5) {
					outcell =rowInfo.createCell(titlArr.length);
					outcell.setCellValue(areaStr[1]);
					outcell =rowInfo.createCell(titlArr.length+1);
					outcell.setCellValue(areaStr[2]);
					outcell =rowInfo.createCell(titlArr.length+2);
					outcell.setCellValue(areaStr[3]);
					outcell =rowInfo.createCell(titlArr.length+3);
					outcell.setCellValue(areaStr[4]);
				}else if(areaStr.length==4) {
					outcell =rowInfo.createCell(titlArr.length);
					outcell.setCellValue(areaStr[1]);
					outcell =rowInfo.createCell(titlArr.length+1);
					outcell.setCellValue(areaStr[2]);
					outcell =rowInfo.createCell(titlArr.length+2);
					outcell.setCellValue(areaStr[3]);
				}else if(areaStr.length==3) {
					outcell =rowInfo.createCell(titlArr.length);
					outcell.setCellValue(areaStr[1]);
					outcell =rowInfo.createCell(titlArr.length+1);
					outcell.setCellValue(areaStr[2]);
				}
				
				
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[11])) {
				outcell =rowInfo.createCell(11);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[12])) {
				outcell =rowInfo.createCell(12);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[13])) {
				outcell =rowInfo.createCell(13);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[14])) {
				outcell =rowInfo.createCell(14);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[15])) {
				outcell =rowInfo.createCell(15);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[16])) {
				outcell =rowInfo.createCell(16);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[17])) {
				outcell =rowInfo.createCell(17);
				outcell.setCellValue(titleValue);
			}else if(!"".equals(titleName)&&titleName.startsWith(titlArr[18])) {
				outcell =rowInfo.createCell(18);
				outcell.setCellValue(titleValue);
			}

		}
		br.close();
		workbook.write(fos);
		fos.close();

		return result.toString();
	}

}
