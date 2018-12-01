package com.relesee.excel.rules.GeneralRules;

import com.relesee.excel.rules.Rule;
import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;


/**
 * 银行业务编号（Q）如果包含“HNHH”，结算方式（P）为“O”
 * @author HanLin
 *
 */
public class RuleGen5 extends Rule {

	public static void doHandle() {
		String bussinessNumber = record.getBussinessNumber();
		String settlementMethod = record.getSettlementMethod();
		if(StringUtils.isNotBlank(bussinessNumber) || StringUtils.isNotBlank(settlementMethod)){
			if(bussinessNumber.contains("HNHH")){
				if(!settlementMethod.equals("O")){
					stackTrace.add("（总规则-5）银行业务包含“HNHH”，但是结算方式不为“O”");
				}
			}
		}else{
			stackTrace.add("（总规则-5）银行业务编号或结算方式为空，无法验证此条记录");
		}

		
		RuleGen6.doHandle();
	}

	

}
