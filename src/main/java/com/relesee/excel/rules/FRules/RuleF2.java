package com.relesee.excel.rules.FRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 组织机构号（D）为空
 * @author HanLin
 *
 */
public class RuleF2 extends Handler{

	@Override
	public void doHandle() {
		String orgCode = record.getOrganizationCode();
		if(StringUtils.isNotBlank(orgCode)){
			stackTrace.add("（F类规则-2）组织机构代码不为空");
		}
		nextHandler = new RuleF3();
		nextHandler.doHandle();
	}
}
