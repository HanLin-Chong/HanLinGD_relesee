package com.relesee.excel.rules.CRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;


/**
 * 外汇账号/银行卡号（M）不以NRA开头时，申报信息为空
 * @author HanLin
 *
 */
public class RuleC3 extends Rule {

	public static void doHandle() {
		String foreignAccount = record.getForeignAccount();
		foreignAccount = foreignAccount.trim();
		String tradingCode1 = record.getTradingCode1();
		String script = record.getTradingPostScript1();
		long amount = record.getCorrespondingAmount1();
		//String tradingCode2 = record.getTradingCode2();
		//String script2 = record.getTradingPostScript2();
		//long amount2  = record.getCorrespondingAmount2();
		String informant = record.getInformant();
		String informantPhone = record.getInformantPhone();
		String decDate = record.getDeclarationDate();
		
		
		if(!foreignAccount.startsWith("NRA")){//此方法区分大小写
			if(StringUtils.isNotBlank(tradingCode1)){
				stackTrace.add("(C类规则-3)外汇账号/银行卡号不以NRA开头，交易编码1不为空");
			}
			if(StringUtils.isNotBlank(script)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，交易附言1不为空");
			}
			if(amount != 0L){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，相应金额1不为0");
			}
			/*
			if(StringUtils.isNotBlank(tradingCode2)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，交易编码2不为空");
			}
			if(StringUtils.isNotBlank(script2)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，交易附言2不为空");
			}
			if(amount2 != 0L){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，相应金额2不为0");
			}
			*/
			if(StringUtils.isNotBlank(informant)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，填报人不为空");
			}
			if(StringUtils.isNotBlank(informantPhone)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，填报人电话不为空");
			}
			if(StringUtils.isNotBlank(decDate)){
				stackTrace.add("（C类规则-3）外汇账号/银行卡号不以NRA开头，填报日期不为空");
			}
		}
		
		RuleC4.doHandle();

	}

}
