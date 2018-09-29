package com.relesee.excel.reader;

import java.util.List;
import java.util.Map;

import com.relesee.excel.domain.LoanApplicationDO;
/**
 * 读取接口，读取时，实现类跳过了第一行的元数据
 * @author HanLin
 *
 */
public interface ExcelReader {
	/*
	 * 获取excel中对应sheet的所有数据至一个list中
	 * 数据量大时，不建议使用该方法
	*/
	public List<LoanApplicationDO> getDoList();
	
	/**
	 * 查询excel的已完结列，返回国家代码是否匹配
	 * @param foreignAccount
	 * @param CountryCode
	 * @return
	 */
	public Map<String,String> countryMap();
}
