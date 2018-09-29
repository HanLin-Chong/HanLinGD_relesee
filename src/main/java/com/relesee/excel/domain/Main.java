package com.relesee.excel.domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.filechooser.FileSystemView;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.relesee.excel.reader.ExcelReader;
import com.relesee.excel.reader.impl.ExcelReaderImpl;
/**
 * 测试读取
 * @author HanLin
 *
 */
public class Main {
	public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";
        // "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (StringUtils.isBlank(mobiles)) {
            return false;
        } else
            return mobiles.matches(telRegex);
    }
	//方法一：用JAVA自带的函数
	public static boolean isNumeric(String str){
	   for (int i = str.length();--i>=0;){  
	       if (!Character.isDigit(str.charAt(i))){
	           return false;
	       }
	   }
	   return true;
	}
	public static void main(String args[]){
		
		
		/*
		FileSystemView fsv = FileSystemView.getFileSystemView();
	    String desktop = fsv.getHomeDirectory().getPath();
	    String filePath = desktop + "/＊if(2).xls";
		ExcelReader reader = new ExcelReaderImpl(filePath);
		List<LoanApplicationDO> list = reader.getDoList();

		for(LoanApplicationDO tempDO:list){
			System.out.println(tempDO.getLineNumberInExcel());
		}
		*/
		StringBuffer b = new StringBuffer("666");
		System.out.println(b.length());
		
		
	}
	public boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);

        while(m.find()){
        	int i = 0;
        	System.out.println(m.group(i));
        	i++;
        }
        return m.find();
    }
	
}
