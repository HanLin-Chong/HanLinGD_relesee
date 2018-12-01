package com.relesee.excel.rules.GeneralRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 付款人名称(F)不能包含大写的”EXCHANGE”、”BANK”、”ROOM”、“ADD”、阿拉伯数字（不包含尾缀的数字）、”1/”
 * @author HanLin
 *
 */
public class RuleGen4 extends Rule {
	
	private static final String[] ILLEGAL_STRING = {"EXCHANGE","BANK","ROOM","ADD","1/","exchange","bank","room","add"};

	public static void doHandle() {
		
		String name = record.getDraweeName();
		name = name.trim();
		
		if(StringUtils.isNotBlank(name)){
			String outPutToStackTrace = "";
			//判断是否包含非法字符
			for(String illegal:ILLEGAL_STRING){
				if(name.contains(illegal)){
					outPutToStackTrace += "（"+illegal+"）";
				}
			}

			//检验是否包含数字
			String[] array = name.split("\\[acc:");
			if(array.length > 1){
				for(int i = 0; i<array.length - 1; i++){
					if(containsNumber(array[i])){
						outPutToStackTrace += "（除后缀以外的数字）";
					}
				}
			} else if (array.length == 1){
				if(containsNumber(array[0])){
					outPutToStackTrace += "（除后缀以外的数字）";
				}
			} else {
				stackTrace.add("（总规则-4）付款人名称.split(\"\\[acc:\")方法值小于1，看到此消息，说明总规则4的代码有错");
			}
			
			//如果暂存区存在错误，则输出至结果stackTrace中
			if(StringUtils.isNotBlank(outPutToStackTrace)){
				stackTrace.add("（总规则-4）付款人名称包含非法字符："+outPutToStackTrace);
			}
			
			
			
		}
		
		
		
		
		RuleGen5.doHandle();

	}



}
