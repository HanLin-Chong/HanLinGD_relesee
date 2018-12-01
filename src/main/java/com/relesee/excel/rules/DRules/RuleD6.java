package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 交易编码1不为空
 * @author HanLin
 *
 */
public class RuleD6 extends Rule {

	public static void doHandle() {
		String code = record.getTradingCode1();
		if(StringUtils.isBlank(code)){
			stackTrace.add("（D类规则-6）交易编码1为空");
		}
		RuleD7.doHandle();
	}


}
