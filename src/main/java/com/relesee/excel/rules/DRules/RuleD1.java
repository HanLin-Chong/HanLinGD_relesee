package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 个人身份证号（C）是18位
 * @author HanLin
 *
 */

public class RuleD1 extends Rule {

	public static void doHandle() {
		String idCard = record.getPersonalIdentityNumber();
		idCard = idCard.trim();
		if(StringUtils.isNoneBlank(idCard)){
			if(idCard.length() != 18){
				stackTrace.add("（D类规则-1）个人身份证号不为18位");
			}
		}else{
			stackTrace.add("（D类规则-1）个人身份证号为空");
		}
		RuleD2.doHandle();
	}
}
