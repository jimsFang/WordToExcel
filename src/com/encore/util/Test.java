package com.encore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] titlArr = {"��Ϣ����","��Ϣ����������","��Ϣ��Ӣ������","��Ϣ��ҵ��","ֵ��","��׼����","�����Ϣ��","�������Ϣ���ϵ"
				,"��������","���ݳ���","��׼���","����ʱ��","����ʱ��","������Ա","��׼���岿��","��׼������","��׼ʹ�ò���","��׼Ӧ��ϵͳ","Ȩ��ϵͳ"};
//		System.out.println(titlArr[1]);
		
		String str ="������-�ͻ�����-��˽�ͻ���Ϣ-������Ϣ-������Ϣ";
//		String str ="������-�ͻ�����-��˽�ͻ���Ϣ";
		String[] areaStr=str.split("\\-",5);
		System.out.println(areaStr[1]);
		System.out.println(areaStr[2]);
		System.out.println(areaStr[3]);
		System.out.println(areaStr[4]);
		System.out.println(areaStr.length);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		System.out.println();
		
		
		String aa ="aaa.bb";
		String[] bb = aa.split("\\.");
		System.out.println(bb[0]);
		System.out.println(bb[1]);
	}

}
