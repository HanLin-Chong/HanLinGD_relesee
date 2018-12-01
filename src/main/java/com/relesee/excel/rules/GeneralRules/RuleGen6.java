package com.relesee.excel.rules.GeneralRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.CRules.RuleC1;
import com.relesee.excel.rules.DRules.RuleD1;
import com.relesee.excel.rules.FRules.RuleF1;

/**
 * 修改删除原因（V）不能有内容，否则反馈错误
 * @author HanLin
 *
 */
public class RuleGen6 extends Rule {

	public static void doHandle() {
		
		String v = record.getCauseOfModificationOrDeletion();
		if(StringUtils.isNoneBlank(v)){
			stackTrace.add("（总规则-6）“修改/删除原因”不为空！");
		}
		
		RuleGen7.doHandle();
	}
	

}
