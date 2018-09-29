package com.relesee.excel.rules.CRules;

import org.apache.commons.lang3.StringUtils;

import com.relesee.excel.rules.Handler;

/**
 * 外汇账号/银行卡号（M）以NRA开头时，交易编码（Y）必须为822030，同时交易附言1（AA）一定是“非居民从境外收款”，
 * 对应的外汇局批件号（AF）必须为“N/A”,是否保税货物下收汇（AE）为“N”，付款人名称（F）前缀为“(JW)”(英文括号)，
 * 当前国别（W）和单位基本情况表中的国别匹配（按照组织机构代码匹（D）配，组织机构代码开头可能会相差几个0），
 * 填报人（AH）不能填电话号码，只能用中文英文名字
 * @author HanLin
 *
 */
public class RuleC2 extends Handler{
	
	@Override
	public void doHandle() {
		String M = record.getForeignAccount();M = M.trim();
		String Y = record.getTradingCode1();Y = Y.trim();
		String AA = record.getTradingPostScript1();AA = AA.trim();
		String AF = record.getColumnAF();AF = AF.trim();
		String AE = record.getBondedGoodsExchange();AE = AE.trim();
		String F = record.getDraweeName();F = F.trim();
		String W = record.getDraweeResidentPlaceCode();W = W.trim();
		String D = record.getOrganizationCode();D = D.trim();
		String AH = record.getInformant();AH = AH.trim();
		if(M.startsWith("NRA")){
			if( !"822030".equals(Y) ){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，交易编码不为822030");
			}
			if( !"非居民从境外收款".equals(AA) ){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，交易附言不为“非居民从境外收款”");
			}
			if( !"N/A".equals(AF) ){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，外汇局批件号不为“N/A”");
			}
			if( !"N".equals(AE) ){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，是否保税货物下收汇不为“N”");
			}
			if( !F.startsWith("(JW)") ){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，付款人名称前缀不为“(JW)”");
			}
			
			if( isMobileNO(AH) || isNumeric(AH)){
				stackTrace.add("（C类规则-2）外汇账号/银行卡号以NRA开头时，填报人为电话号码");
			}
		}
		
		
		nextHandler = new RuleC3();
		nextHandler.doHandle();
	}
	private boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";
        // "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (StringUtils.isBlank(mobiles)) {
            return false;
        } else
            return mobiles.matches(telRegex);
    }
	private boolean isNumeric(String str){
	   for (int i = str.length();--i>=0;){  
	       if (!Character.isDigit(str.charAt(i))){
	           return false;
	       }
	   }
	   return true;
	}
}
