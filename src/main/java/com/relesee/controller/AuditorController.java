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

        System.out.println("文件"+file.getFile());
        System.out.println("文件名"+file.getFile().getName());
        /*try {
            logger.info("开始审核excel");
            result = auditorService.handleExcel(file.getFile(), request);
        } catch (IOException e) {
            logger.error("上传Excel出错，详情下一条error");
            logger.error(e);
            e.printStackTrace();
        }*/
        result = auditorService.handleExcel(file.getFile(), request);

        try{
            logger.info("Excel审核完成，开始返回结果给前端");
            response.getWriter().write(JSON.toJSONString(result));
        } catch (Exception e){
            logger.error("返回结果出错，详情下一条error");
            logger.error(e);
        }



    }

}
