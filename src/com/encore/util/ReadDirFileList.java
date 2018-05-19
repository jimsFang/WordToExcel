package com.encore.util;

import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * �ݹ��ȡĳ��Ŀ¼�µ������ļ� 
 *  
 * @author ��Խ 
 * @Date 2016��12��5��,����4:04:59 
 * @motto ����һ��оۻᣬ����һ����Ŷ� 
 * @Version 1.0 
 */  
public class ReadDirFileList {  
    private static void test(String fileDir) {  
        List<File> fileList = new ArrayList<File>();  
        File file = new File(fileDir);  
        File[] files = file.listFiles();// ��ȡĿ¼�µ������ļ����ļ���  
        if (files == null) {// ���Ŀ¼Ϊ�գ�ֱ���˳�  
            return;  
        }  
        // ������Ŀ¼�µ������ļ�  
        for (File f : files) {  
            if (f.isFile()) {  
                fileList.add(f);  
            } else if (f.isDirectory()) {  
                System.out.println(f.getAbsolutePath());  
                test(f.getAbsolutePath());  
            }  
        }  
        for (File f1 : fileList) {  
            System.out.println(f1.getName());  
        }  
    }  
  
    public static void main(String[] args) {  
        test("/Users/fangdl/tmp");  
    }  
}  