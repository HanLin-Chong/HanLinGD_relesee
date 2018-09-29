package com.relesee.excel.rules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.relesee.excel.domain.LoanApplicationDO;

public abstract class Handler {
	protected static Handler nextHandler;
	protected static List<String> stackTrace = new ArrayList<String>();
	protected static LoanApplicationDO record;
	protected static Map<String,String> orgCodeAndCountryCodeMap;
	protected static String inputDate;
	
	public void setInputDate(String dateString){
		this.inputDate = dateString;
	}
	public String getInputDate(){
		return this.inputDate;
	}
	public void setLoanApplicationDO(LoanApplicationDO loanDO){
		this.record = loanDO;
	}
	public void setNextHandler(Handler handler){
		this.nextHandler = handler;
	}
	public List<String> getStackTrace(){
		return stackTrace;
	}
	
	public void clearStackTrace(){
		this.stackTrace.clear();
	}
	
	public LoanApplicationDO getLoanApplicationDO(){
		return record;
	}
	public void setOrgCodeAndCopuntryCodeMap(Map<String,String> map){
		this.orgCodeAndCountryCodeMap = map;
	}
	public abstract void doHandle();
	
}
