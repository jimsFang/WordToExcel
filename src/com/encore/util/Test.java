package com.encore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] titlArr = {"信息项编号","信息项中文名称","信息项英文名称","信息项业务含","值域","标准依据","相关信息项","与相关信息项关系"
				,"数据类型","数据长度","标准类别","创建时间","更新时间","更新人员","标准定义部门","标准管理部门","标准使用部门","标准应用系统","权威系统"};
//		System.out.println(titlArr[1]);
		
		String str ="基础类-客户主题-对私客户信息-基本信息-归属信息";
//		String str ="基础类-客户主题-对私客户信息";
		String[] areaStr=str.split("\\-",5);
		System.out.println(areaStr[1]);
		System.out.println(areaStr[2]);
		System.out.println(areaStr[3]);
		System.out.println(areaStr[4]);
		System.out.println(areaStr.length);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
		System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		System.out.println();
		
		
		String aa ="aaa.bb";
		String[] bb = aa.split("\\.");
		System.out.println(bb[0]);
		System.out.println(bb[1]);
	}

}
