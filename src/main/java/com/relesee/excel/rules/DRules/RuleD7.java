package com.relesee.excel.rules.DRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 申报信息不为空
 * @author HanLin
 *
 */
public class RuleD7 extends Handler{

	@Override
	public void doHandle() {
		String tradingCode1 = record.getTradingCode1();
		String script = record.getTradingPostScript1();
		long amount = record.getCorrespondingAmount1();
		String informant = record.getInformant();
		String informantPhone = record.getInformantPhone();
		String decDate = record.getDeclarationDate();
		if(StringUtils.isBlank(tradingCode1)){
			stackTrace.add("（D类规则-7）交易编码1为空");
		}
		if(StringUtils.isBlank(script)){
			stackTrace.add("（D类规则-7）交易附言1为空");
		}
		if(amount == 0L){
			stackTrace.add("（D类规则-7）交易金额（相应金额）1为0");
		}
		if(StringUtils.isBlank(informant)){
			stackTrace.add("（D类规则-7）填报人为空");
		}
		if(StringUtils.isBlank(informantPhone)){
			stackTrace.add("（D类规则-7）填报人电话为空");
		}
		if(StringUtils.isBlank(decDate)){
			stackTrace.add("（D类规则-7）申报日期为空");
		}
		
		nextHandler = new RuleD8();
		nextHandler.doHandle();
	}
}
