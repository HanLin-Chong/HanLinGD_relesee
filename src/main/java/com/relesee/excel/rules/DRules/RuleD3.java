package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 收款人名称为个人名称（自己定义规则）
 * @author HanLin
 *
 */
public class RuleD3 extends Rule {

	public static void doHandle() {
		String payeeName = record.getPayeeName();
		boolean a = payeeName.length() >4;
		boolean b = payeeName.isEmpty();
		if(a || b){
			stackTrace.add("（D类规则-3）收款人名称可能不是个人名称");
		}
		RuleD4.doHandle();

	}
}
