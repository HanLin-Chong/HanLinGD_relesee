package com.relesee.excel.rules;

import com.relesee.excel.domain.LoanApplicationDO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HanLin
 * 规则父类1
 */
public class Rule {

    /**
     * 这些protected属性是规则子类所需要的属性
     */
    public static List<String> stackTrace = new ArrayList<String>();//此条记录的所有错误信息
    public static LoanApplicationDO record;//此条纪录
    public static Map<String,String> orgCodeAndCountryCodeMap;//国别匹配
    public static String inputDate;//输入的日期


    /**
     *
     * @param mobiles
     * 下面的是Rule可能用到的方法，建议以后将这些方法写到工具类中
     */


    /**
     * 判断是否为手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        String telRegex = "[1][3578]\\d{9}";
        // "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (StringUtils.isBlank(mobiles)) {
            return false;
        } else
            return mobiles.matches(telRegex);
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断是否包含数字
     * @param company
     * @return
     */
    public static boolean containsNumber(String company) {

        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(company);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
