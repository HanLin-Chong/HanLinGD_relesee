package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 组织机构代码（D）为空
 * @author HanLin
 *
 */
public class RuleD2 extends Rule {

	public static void doHandle() {
		String code = record.getOrganizationCode();
		if(StringUtils.isNoneBlank(code)){
			stackTrace.add("（D类规则-2）组织机构代码不为空");
		}
		RuleD3.doHandle();

	}
}
