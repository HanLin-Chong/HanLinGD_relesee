package com.relesee.excel.rules.CRules;

import java.util.Set;

import com.relesee.excel.rules.Handler;
import com.relesee.excel.rules.Rule;

/**
 * 当外汇账号/银行卡号（M）以NRA开头时，国别和Sheet（已通知）中的匹配
 * @author HanLin
 *
 */
public class RuleC4 extends Rule {

	public static void doHandle() {
		
		String fac = record.getForeignAccount();fac = fac.trim();
		String countryCode = record.getDraweeResidentPlaceCode();countryCode = countryCode.trim();
		String orgCode = record.getOrganizationCode();orgCode = orgCode.trim();
		if(fac.startsWith("NRA")){

			if( !countryCode.equals(orgCodeAndCountryCodeMap.get(orgCode)) ){
				stackTrace.add("（C类规则-4）国别不匹配,Sheet(涉外收入)："+countryCode+",Sheet(已通知)："+orgCodeAndCountryCodeMap.get(orgCode));
			}
		}
		
		RuleC5.doHandle();
		
	}

	

}
