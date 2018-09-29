package com.relesee.excel.rules.FRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
/**
 * 外汇账号/银行卡号（M）第8位到第13位为“21103”交易附言1必须是“非居民从境外收款（市场采购）”或“非居民从境外收款”
 * @author HanLin
 *
 */
public class RuleF5 extends Handler{

	@Override
	public void doHandle() {
		String facc = record.getForeignAccount();
		facc = facc.trim();
		String script = record.getTradingPostScript1();
		script = script.trim();

		if(StringUtils.isBlank(facc)){
			stackTrace.add("（F类规则-5）外汇账号/银行卡号为空");
		}else{
			if( !"21103".equals(facc.substring(7, 12)) ){
				stackTrace.add("（F类规则-5）外汇账号/银行卡号第8位到第13位不为21103");
			}
		}
		
		if( "非居民从境外收款（市场采购）".equals(script) || "非居民从境外收款".equals(script)){
			
		}else{
			stackTrace.add("（F类规则-5）交易附言不为：非居民从境外收款（市场采购） 或 非居民从境外收款"); 
		}

		
		nextHandler = new RuleF6();
		nextHandler.doHandle();
	}

}
