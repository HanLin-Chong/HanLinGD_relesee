package com.relesee.excel.rules.DRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 组织机构代码（D）为空
 * @author HanLin
 *
 */
public class RuleD2 extends Handler{
	@Override
	public void doHandle() {
		String code = record.getOrganizationCode();
		if(StringUtils.isNoneBlank(code)){
			stackTrace.add("（D类规则-2）组织机构代码不为空");
		}
		nextHandler = new RuleD3();
		nextHandler.doHandle();
	}
}
