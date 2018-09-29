package com.relesee.excel.rules.GeneralRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.CRules.RuleC1;
import com.relesee.excel.rules.DRules.RuleD1;
import com.relesee.excel.rules.FRules.RuleF1;

/**
 * 付款人名称一定是(JN)或(JW)
 * @author HanLin
 *
 */

public class RuleGen7 extends Handler{

	@Override
	public void doHandle() {
		String draweeName = record.getDraweeName();
		draweeName = draweeName.trim();
		
		
		if(draweeName.startsWith("(JN)")){
			
		} else if (draweeName.startsWith("(JW)")){
			
		} else {
			stackTrace.add("（总规则7）付款人名称的开头不是“(JN)”或“(JW)”");
		}
		
		/**
		 * 跳转至下一类规则层
		 */
		String lineClass = "";
		try{
			lineClass = record.getPayeeType();
			if(StringUtils.isNotBlank(lineClass)){
				switch (lineClass) {
					case "C":
						nextHandler = new RuleC1();
						break;
					case "D":
						nextHandler = new RuleD1();
						break;
					case "F":
						nextHandler = new RuleF1();
						break;
				}
				nextHandler.doHandle();
			}else{
				stackTrace.add("（总规则-7）收款人类型为空，无法决定使用哪一类规则");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			stackTrace.add("（总规则-7）总规则之后的规则层出现了问题，无法根据收款人类型继续验证，详细错误："+e.getMessage());
		}
		
	}//end of doHandle


}
