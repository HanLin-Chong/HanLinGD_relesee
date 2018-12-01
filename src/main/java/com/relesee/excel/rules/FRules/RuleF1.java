package com.relesee.excel.rules.FRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 个人身份证号（C）不为空，不为18位（是护照号）
 * @author HanLin
 *
 */
public class RuleF1 extends Rule {

	public static void doHandle() {
		String passPort = record.getPersonalIdentityNumber();
		if(StringUtils.isBlank(passPort)){
			stackTrace.add("（F类规则-1）个人身份证号（护照号）为空");
		}
		if(passPort.length()>=18){
			stackTrace.add("（F类规则-1）个人身份证号（护照号）大于等于18位");
		}
		RuleF2.doHandle();

	}



}
