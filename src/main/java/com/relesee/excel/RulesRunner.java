package com.relesee.excel;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.relesee.excel.domain.IllegalLoanApplicationDO;
import com.relesee.excel.domain.LoanApplicationDO;
import com.relesee.excel.reader.ExcelReader;
import com.relesee.excel.reader.impl.ExcelReaderImpl;

public class RulesRunner {
	
	public boolean containsNumber(String company) {

        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(company);
        if (m.find()) {
            return true;
        }
        return false;
    }
	private static final String[] ILLEGAL_STRING = {"EXCHANGE","BANK","ROOM","ADD","1/","exchange","bank","room","add"};
	@Test
	public void run(){
		List<IllegalLoanApplicationDO> result = new ArrayList<IllegalLoanApplicationDO>();
		ExcelReader reader = new ExcelReaderImpl("C:/Users/HanLin/Desktop/核对2.xls");
		List<LoanApplicationDO> list = reader.getDoList();
		LoanApplicationDO ldo = list.get(14);//14或581
		String name = ldo.getDraweeName();
		name = name.trim();
		//System.out.println(name);
		String outPutToStackTrace = "";

			
		if(StringUtils.isNotBlank(name)){
			
			//判断是否包含非法字符
			for(String illegal:ILLEGAL_STRING){
				if(name.contains(illegal)){
					outPutToStackTrace += "（"+illegal+"）";
				}
			}
			

			String[] array = name.split("\\[acc:");
			if(array.length > 1){
				for(int i = 0; i<array.length - 1; i++){
					if(containsNumber(array[i])){
						//
					}
				}
			} else if (array.length == 1){
				if(containsNumber(array[0])){
					//
				}
			} else {
				//
			}

			
			
			
			
			
			//如果暂存区存在错误，则输出至结果stackTrace中
			if(StringUtils.isNotBlank(outPutToStackTrace)){
				System.out.println("（总规则-4）付款人名称包含非法字符："+outPutToStackTrace);
			}
			
			
			
		}
		
		/*
		List<LoanApplicationDO> workSheet = reader.getDoList();
		Map<String,String> countryMap = reader.countryMap();
		
		for(LoanApplicationDO tempDO:workSheet){
			Handler handler = new RuleGen1();
			handler.setOrgCodeAndCopuntryCodeMap(countryMap);
			handler.setLoanApplicationDO(tempDO);
			handler.clearStackTrace();
			handler.doHandle();
			List<String> list = new ArrayList<String>();
			list = handler.getStackTrace();
			if(handler.getStackTrace().size()>0)

			if(list.size()>0){
				IllegalLoanApplicationDO illegalDO = new IllegalLoanApplicationDO();
				System.out.println("----------------------------------------------");
				for(String zhl:list){
					//System.out.println(tempDO.getLineNumberInExcel()+"-"+zhl);
				}
				List<String> list2 = new ArrayList<String>(list);//正确的
				//List<String> list2 = list;//方案1，这个是错的,猜测原因：list中的每一个DO都是指向内存中同意空间的
				/**
				 * 正误结果比对：
				 * ----------------------------------------------
				 *	282-（C类规则-4）国别不匹配,Sheet(涉外收入)：HKG,Sheet(已通知)：null
				 *	----------------------------------------------
				 *	342-（C类规则-4）国别不匹配,Sheet(涉外收入)：HKG,Sheet(已通知)：null
				 *	----------------------------------------------
				 *	1076-（总规则-1）申报日期不是今天
				 *	1076-（F类规则-1）个人身份证号（护照号）大于等于18位
				 *	---------     以上输出是正确的  ，下面的输出就有问题了       -------------------------
				 *	------------------------------------------
				 *	282-（总规则-1）申报日期不是今天
				 *	282-（F类规则-1）个人身份证号（护照号）大于等于18位
				 *	------------------------------------------
				 *	342-（总规则-1）申报日期不是今天
				 *	342-（F类规则-1）个人身份证号（护照号）大于等于18位
				 *	------------------------------------------
				 *	1076-（总规则-1）申报日期不是今天
				 *1076-（F类规则-1）个人身份证号（护照号）大于等于18位
				 */
				
						
				/*List<String> list2 = new ArrayList<String>();//方案2，这个是对的
				for(String zhl:list){
					list2.add(zhl);
				}*//*
				illegalDO.setStackTrace(list2);
				illegalDO.setLoanApplication(tempDO);
				result.add(illegalDO);
				illegalDO = null;
			}
		}
		//System.out.println("---------     以上输出是正确的  ，下面的输出就有问题了       -------------------------");
		
		
		for(IllegalLoanApplicationDO fuck:result){
			LoanApplicationDO fuck1 = fuck.getLoanApplication();
			List<String> fuck2 = fuck.getStackTrace();
			//System.out.println("------------------------------------------");
			for(String fuck3:fuck2){
				//System.out.println(fuck1.getLineNumberInExcel()+"-"+fuck3);
			}
		}
		*/
	}
	

}
