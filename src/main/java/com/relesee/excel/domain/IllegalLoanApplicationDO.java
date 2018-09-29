package com.relesee.excel.domain;

import java.util.List;
/**
 * 用于存储出错行的数据及错误信息的对象
 * @author HanLin
 *
 */
public class IllegalLoanApplicationDO {
	/**
	 * 出错行对象
	 */
	private LoanApplicationDO loanApplication;
	/**
	 * 错误信息列表
	 */
	private List<String> stackTrace;
	public LoanApplicationDO getLoanApplication() {
		return loanApplication;
	}
	public void setLoanApplication(LoanApplicationDO loanApplication) {
		this.loanApplication = loanApplication;
	}
	public List<String> getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(List<String> stackTrace) {
		this.stackTrace = stackTrace;
	}
	
}
