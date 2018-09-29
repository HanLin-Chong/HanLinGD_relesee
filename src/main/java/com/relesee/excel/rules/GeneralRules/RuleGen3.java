package com.relesee.excel.rules.GeneralRules;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.relesee.excel.rules.Handler;


/**
 * 	收入款金额（H）=现汇金额（L）+国内扣费(S)+国外扣费(U)
 * @author HanLin
 *
 */
public class RuleGen3 extends Handler{

	@Override
	public void doHandle() {
		
		long incomeAmount = record.getIncomeAmount();

		//用于相加
		BigDecimal a = new BigDecimal(record.getAmountInFx());
		BigDecimal b = new BigDecimal(record.getDomesticBankDeductionAmount());
		BigDecimal c = new BigDecimal(record.getForeignBankDeductionAmount());
		long rightSumValue = a.add(b).add(c).longValue();
		
		if(incomeAmount == rightSumValue){
			
		}else{
			double convertLeft = (double)(incomeAmount/100);
			double convertRight = (double)(rightSumValue/100);
			DecimalFormat df = new DecimalFormat("#.00");
			stackTrace.add("（总规则-3）等式：收入款金额（H）=现汇金额（L）+国内扣费(S)+国外扣费(U)不成立，等式左侧的值为："+df.format(convertLeft)+",等式右侧的值为："+df.format(convertRight));
		}
		
		nextHandler = new RuleGen4();
		nextHandler.doHandle();
	}

	
}
