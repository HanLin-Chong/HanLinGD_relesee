package com.relesee.excel.rules.FRules;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 外汇局编码（AF）为“N/A”
 * @author HanLin
 *
 */
public class RuleF6 extends Rule {

	public static void doHandle() {
		String af = record.getColumnAF();

		if( !"N/A".equals(af) ){
			stackTrace.add("（F类规则-6）");
		}
	}

	

}
