package com.relesee.excel.rules.GeneralRules;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.relesee.excel.rules.Handler;

/**
 * 规则说明：
 * 申报日期如果有，则必须是当天
 * @author HanLin
 */
public class RuleGen1 extends Handler {
	public static final String DECLARATION_DATE_NOT_TODAY = "（总规则-1）申报日期不是今天";



	@Override
	public void doHandle() {
		
		Date now = new Date();
		String date = record.getDeclarationDate();
		/*
		try{
			inputDate = ;
		}catch(Exception e){
			now = new Date();
		}*/
		
		if(StringUtils.isNotBlank(date)){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			try{
				now = format.parse(inputDate);
			}catch(Exception e){
				now = new Date();
			}
			Date reportDate = null;
			try {
				reportDate = format.parse(date);
			} catch (ParseException e) {
				stackTrace.add("（总规则-1）错误的日期格式("+record.getDeclarationDate()+")，系统无法转化");
				e.printStackTrace();
			}
			if(!DateUtils.isSameDay(now, reportDate)){
				stackTrace.add(DECLARATION_DATE_NOT_TODAY);
			}
			
			
		}
		
		nextHandler = new RuleGen2();
		nextHandler.doHandle();
		
	}


}
