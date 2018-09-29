package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Handler;
/**
 * 收款性质（X）为字母O
 * @author HanLin
 *
 */
public class RuleD5 extends Handler{

	@Override
	public void doHandle() {
		String por = record.getPropertyOfReceivables();
		por = por.trim();
		if(!"O".equals(por)){
			stackTrace.add("（D类规则-5）收款性质不为O");
		}

		nextHandler = new RuleD6();
		nextHandler.doHandle();
	}
	
}
