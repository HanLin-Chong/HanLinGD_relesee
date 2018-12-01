package com.relesee.controller;

import com.alibaba.fastjson.JSON;
import com.relesee.domains.FileDO;
import com.relesee.excel.domain.IllegalLoanApplicationDO;
import com.relesee.service.AuditorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("auditor/")
public class AuditorController {

    @Autowired
    AuditorService auditorService;

    private static final Logger logger = Logger.getLogger(AuditorController.class);

    @RequestMapping("excelHandler")
    public void excelHandler(FileDO file, HttpServletRequest request, HttpServletResponse response){
        List<IllegalLoanApplicationDO> result = null;

        logger.info("接收excel文件:"+file.getFile().getName()+"("+file.getFile().getSize()+"B)");

        result = auditorService.handleExcel(file.getFile(), request);

        try{

            response.getWriter().write(JSON.toJSONString(result));
            logger.info("Excel审核完成，返回结果给前端");
        } catch (Exception e){
            logger.error("返回结果出错",e);

        }

        result.clear();
        result = null;


    }

}
