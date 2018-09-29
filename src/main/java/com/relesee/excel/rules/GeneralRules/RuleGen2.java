package com.relesee.excel.rules.GeneralRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;


/**
 * 收入款币种为CNY，则外汇账号/银行卡号(M)为空，其它账号/银行卡号（O）不为空
 * @author HanLin
 *
 */
public class RuleGen2 extends Handler {
	@Override
	public void doHandle() {
		String incomeCurrency = record.getIncomeCurrency().trim();
		if("CNY".equals(incomeCurrency)){
			if(StringUtils.isNotBlank(record.getForeignAccount())){
				stackTrace.add("（总规则-2）收入款币种为“CNY”时，存在外汇账号/银行卡号");
			}
			if(StringUtils.isBlank(record.getOtherAccount())){
				stackTrace.add("（总规则-2）收入款币种为“CNY”时,没有其它账号/银行卡号");
			}
		}
		
		nextHandler = new RuleGen3();
		nextHandler.doHandle();
	}
	
	
}
