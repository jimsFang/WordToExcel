package com.encore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TxtToExcel {

	public static void main(String[] args) {

		 File file = new File("/Users/fangdl/tmp/88.txt");
	     System.out.println(txt2String(file));
	}

	public static void switchTxtToExcel() {
		String[] strings = " ".toString().split("\\s+");

		System.out.println(strings.length);
	}
	
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            	String strArr[]=s.split("\\s+");
            	System.out.println(strArr[1]+"---"+strArr[0]);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
