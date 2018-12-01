package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 原规则：如果交易附言1（AA）为“一般贸易货款”，则付款人名称（F）前缀为“(JW)”英文括号
 * 此规则已作废，被并入D8规则
 * @author HanLin
 *
 */
public class RuleD10 extends Rule {

	public static void doHandle() {
		String script = record.getTradingPostScript1();
		script = script.trim();
		String drawee = record.getDraweeName();
		drawee = drawee.trim();
		if("一般贸易货款".equals(script)){
			if(!drawee.startsWith("(JW)")){
				stackTrace.add("（D类规则-10）交易附言为：一般贸易货款，但付款人名称前缀不为(JW)");
			}
		}
		
	}


}
