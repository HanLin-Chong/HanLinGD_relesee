package com.relesee.excel.rules.FRules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 付款人名称（F）后缀为“[acc:  String   ]”,String要求同3（4）
 * @author HanLin
 *
 */
public class RuleF4 extends Handler{
	
	@Override
	public void doHandle() {
		String draweeName = record.getDraweeName();
		draweeName = draweeName.trim();
		StringBuffer buffer = new StringBuffer(draweeName);
		if(buffer.indexOf("[acc:")>=0){
			buffer.deleteCharAt(buffer.length()-1);//去尾
			buffer.delete(0, buffer.indexOf("[acc:")+5);//去头
			if(buffer.indexOf("24301")>=0){
				stackTrace.add("（F类规则-4）付款人名称后缀包含：24301");
			}
			
			if(StringUtils.isBlank(buffer.toString())){
				stackTrace.add("（F类规则-4）付款人名称后缀为空");
			}
			/**
			 * 特殊字符
			 */
	        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
	        Pattern p = Pattern.compile(regEx);
	        Matcher m = p.matcher(buffer.toString());
	        while(m.find()){
	        	int i = 0;
	        	stackTrace.add("（F类规则4）付款人名称后缀包含特殊字符："+m.group(i));
	        	i++;
	        }
	        
	        /**
	         * 不全为0
	         */
	        String[] array = buffer.toString().split("");
	        boolean isAllZero = true;
	        for(String s:array){
	        	if(!"0".equals(s)){
	        		isAllZero = false;
	        		break;
	        	}
	        }
	        if(isAllZero){
	        	stackTrace.add("（F类规则4）付款人名称后缀全为0");
	        }
			
		}else{
			stackTrace.add("（F类规则-4）没有后缀：[acc:.....]");
		}
		
		nextHandler = new RuleF5();
		nextHandler.doHandle();
	}


}