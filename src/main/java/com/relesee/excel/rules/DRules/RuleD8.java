package com.relesee.excel.rules.DRules;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 原规则：交易编码1（Y）为121010时，交易附言1（AA）为“收到境内非居民款项一般贸易货款”或“一般贸易货款”不能有空格要完全匹配
 * 此规则现已被
 * @author HanLin
 *
 */
public class RuleD8 extends Rule {

	public static void doHandle() {
		
		String code = record.getTradingCode1();
		String script = record.getTradingPostScript1();
		String draweeName = record.getDraweeName();
		if("121010".equals(code)){
			if(draweeName.startsWith("(JN)")){
				if(!"收到境内非居民款项一般贸易货款".equals(script)){
					stackTrace.add("（D类规则8）当交易编码为121010且付款人名称以(JN)开头时，交易附言不为:收到境内非居民款项一般贸易货款");
				}
			}
			
			if(draweeName.startsWith("(JW)")){
				if(!"一般贸易货款".equals(script)){
					stackTrace.add("（D类规则8）当交易编码为121010且付款人名称以(JW)开头时，交易附言不为:一般贸易货款");
				}
			}
			
		}
		
		/**
		 * 此处无需再设置下一个Handler，因为D9和D10已经被废弃，且合并至本规则D8中
		 */
	}
}
