package com.relesee.excel.rules.DRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 交易编码1不为空
 * @author HanLin
 *
 */
public class RuleD6 extends Handler{

	@Override
	public void doHandle() {
		String code = record.getTradingCode1();
		if(StringUtils.isBlank(code)){
			stackTrace.add("（D类规则-6）交易编码1为空");
		}
		nextHandler = new RuleD7();
		nextHandler.doHandle();
	}


}
