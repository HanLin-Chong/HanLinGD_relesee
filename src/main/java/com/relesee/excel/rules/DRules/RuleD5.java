package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 收款性质（X）为字母O
 * @author HanLin
 *
 */
public class RuleD5 extends Rule {

	public static void doHandle() {
		String por = record.getPropertyOfReceivables();
		por = por.trim();
		if(!"O".equals(por)){
			stackTrace.add("（D类规则-5）收款性质不为O");
		}

		RuleD6.doHandle();
	}
	
}
