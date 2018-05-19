package com.encore.util;

import java.io.File;  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * 递归读取某个目录下的所有文件 
 *  
 * @author 超越 
 * @Date 2016年12月5日,下午4:04:59 
 * @motto 人在一起叫聚会，心在一起叫团队 
 * @Version 1.0 
 */  
public class ReadDirFileList {  
    private static void test(String fileDir) {  
        List<File> fileList = new ArrayList<File>();  
        File file = new File(fileDir);  
        File[] files = file.listFiles();// 获取目录下的所有文件或文件夹  
        if (files == null) {// 如果目录为空，直接退出  
            return;  
        }  
        // 遍历，目录下的所有文件  
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