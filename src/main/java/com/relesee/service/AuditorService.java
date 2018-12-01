package com.relesee.service;

import com.relesee.excel.domain.IllegalLoanApplicationDO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface AuditorService {

    List<IllegalLoanApplicationDO> handleExcel(MultipartFile file, HttpServletRequest request);
}
