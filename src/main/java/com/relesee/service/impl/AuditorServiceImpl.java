package com.relesee.service.impl;

import com.relesee.excel.domain.IllegalLoanApplicationDO;
import com.relesee.excel.domain.LoanApplicationDO;
import com.relesee.excel.reader.ExcelReader;
import com.relesee.excel.reader.impl.ExcelReaderImpl;
import com.relesee.excel.rules.GeneralRules.RuleGen1;
import com.relesee.excel.rules.Handler;
import com.relesee.service.AuditorService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuditorServiceImpl implements AuditorService {


    @Override
    public List<IllegalLoanApplicationDO> handleExcel(MultipartFile file, HttpServletRequest request) {
        System.out.println("开始使用审核员服务");
        System.out.println("文件名："+file.getName());
        List<IllegalLoanApplicationDO> result = new ArrayList<IllegalLoanApplicationDO>();
        ExcelReader reader = null;
        try {
            reader = new ExcelReaderImpl(file);
        } catch (Exception e){
            e.printStackTrace();
        }
        List<LoanApplicationDO> workSheet = reader.getDoList();
        Map<String,String> countryMap = reader.countryMap();
        for(LoanApplicationDO tempDO:workSheet){
            Handler handler = new RuleGen1();

            handler.setInputDate(request.getParameter("date"));

            handler.setOrgCodeAndCopuntryCodeMap(countryMap);
            handler.setLoanApplicationDO(tempDO);
            handler.clearStackTrace();
            handler.doHandle();
            List<String> list = handler.getStackTrace();
            if(list.size()>0){
                IllegalLoanApplicationDO illegalDO = new IllegalLoanApplicationDO();

                illegalDO.setStackTrace(new ArrayList<String>(list));//在测试类中发现的错误在这里给参数list套一个new ArrayList<String>(list)解决，详细解释请看测试类：RulesRunner.java
                illegalDO.setLoanApplication(tempDO);
                result.add(illegalDO);
            }

        }

        return result;
    }
}
