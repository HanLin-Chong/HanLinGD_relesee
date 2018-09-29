package com.relesee.excel.rules.FRules;

import com.relesee.excel.rules.Handler;
/**
 * 付款人名称（F）前有“(JW)”英文括号
 * @author HanLin
 *
 */
public class RuleF3 extends Handler{

	@Override
	public void doHandle() {
		String draweeName = record.getDraweeName();
		if(!draweeName.startsWith("(JW)")){
			stackTrace.add("（F类规则-3）付款人名称前缀不为(JW)");
		}
		nextHandler = new RuleF4();
		nextHandler.doHandle();
	}

}
