package com.relesee.excel.rules.CRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 	当外汇账号/银行卡号（M）以NRA开头时，申报信息不为空
 * @author HanLin
 *
 */

public class RuleC5 extends Handler{

	@Override
	public void doHandle() {
		String foreignAccount = record.getForeignAccount();foreignAccount = foreignAccount.trim();
		
		/**
		 * 申报信息
		 */
		String tradingCode1 = record.getTradingCode1();
		String script = record.getTradingPostScript1();
		long amount = record.getCorrespondingAmount1();
		//String tradingCode2 = record.getTradingCode2();
		//String script2 = record.getTradingPostScript2();
		//long amount2  = record.getCorrespondingAmount2();
		String informant = record.getInformant();
		String informantPhone = record.getInformantPhone();
		String decDate = record.getDeclarationDate();
		
		if(foreignAccount.startsWith("NRA")){
			if(StringUtils.isBlank(tradingCode1)){
				stackTrace.add("(C类规则-5)外汇账号/银行卡号以NRA开头，交易编码1为空");
			}
			if(StringUtils.isBlank(script)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，交易附言1为空");
			}
			if(amount == 0L){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，相应金额1为0");
			}
			/*
			if(StringUtils.isBlank(tradingCode2)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，交易编码2为空");
			}
			if(StringUtils.isBlank(script2)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，交易附言2为空");
			}
			if(amount2 == 0L){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，相应金额2为0");
			}
			*/
			if(StringUtils.isBlank(informant)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，填报人为空");
			}
			if(StringUtils.isBlank(informantPhone)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，填报人电话为空");
			}
			if(StringUtils.isBlank(decDate)){
				stackTrace.add("（C类规则-5）外汇账号/银行卡号以NRA开头，填报日期为空");
			}
		}
		
	}
}
