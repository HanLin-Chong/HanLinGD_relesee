package com.relesee.excel.rules.CRules;


import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 个人省份证号（C）必须为空，组织机构代码（D）必须9位数
 * @author HanLin
 *
 */
public class RuleC1 extends Rule {


	public static void doHandle() {
		String IDCard = record.getPersonalIdentityNumber();
		String orgCode = record.getOrganizationCode();
		orgCode = orgCode.trim();
		if(StringUtils.isNotBlank(IDCard)){
			stackTrace.add("（C类规则-1）个人身份证号不为空");
		}
		if(orgCode.length() != 9){
			stackTrace.add("（C类规则-1）组织机构代码不为9位数");
		}
		
		
		RuleC2.doHandle();
	}
}
