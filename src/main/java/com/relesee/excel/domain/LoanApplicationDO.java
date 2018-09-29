package com.relesee.excel.domain;

import java.util.Map;

//贷款申请表映射的对象
public class LoanApplicationDO extends MapperDO{
	//excel中的行号
	private int lineNumberInExcel;
	//申报号码
	private String applicationNumber;
	public static final int APPLICATION_NUMBER = 0;
	//收款人类型
	private String payeeType;
	public static final int PAYEE_TYPE = 1;
	//个人身份证件号码
	private String personalIdentityNumber;
	public static final int PERSONAL_IDENTITY_NUMBER = 2;
	//组织机构代码
	private String organizationCode;
	public static final int ORGANIZATION_CODE = 3;
	//收款人名称
	private String payeeName;
	public static final int PAYEE_NAME = 4;
	//付款人名称
	private String draweeName;
	public static final int DRAWEE_NAME = 5;
	//收入款币种
	private String incomeCurrency;
	public static final int INCOME_CURRENCY = 6;
	//收入款金额，以Long表示实际额度*100,展示时注意除以100
	private Long incomeAmount;
	public static final int INCOME_AMOUNT = 7;
	//结汇汇率
	private Long exrt;
	public static final int EXRT = 8;
	//结汇金额,Long型乘100处理
	private Long exchangeAmount;
	public static final int EXCHANGE_AMOUNT = 9;
	//人民币账号/银行卡号
	private String cnyAccount;
	public static final int CNY_ACCOUNT = 10;
	//现汇金额
	private Long amountInFx;
	public static final int AMOUNT_IN_FX = 11;
	//外汇账号/银行卡号
	private String foreignAccount;
	public static final int FOREIGN_ACCOUNT = 12;
	//其它金额
	private Long otherAmount;
	public static final int OTHER_AMOUNT = 13;
	//其它账号/银行卡号
	private String otherAccount;
	public static final int OTHER_ACCOUNT = 14;
	//结算方式
	private String settlementMethod;
	public static final int SETTLEMENT_METHOD = 15;
	//银行业务编号
	private String bussinessNumber;
	public static final int BUSSINESS_NUMBER = 16;
	//国内银行扣费币种
	private String domesticBankDeductedCurrency;
	public static final int DOMESTIC_BANK_DEDUCTED_CURRENCY = 17;
	//国内银行扣费金额
	private Long domesticBankDeductionAmount;
	public static final int DOMESTIC_BANK_DEDUCTION_AMOUNT = 18;
	//国外银行扣费币种
	private String foreignBankDeductedCurrency;
	public static final int FOREIGN_BANK_DEDUCTED_CURRENCY = 19;
	//国外银行扣费金额
	private Long foreignBankDeductionAmount;
	public static final int FOREIGN_BANK_DEDUCTION_AMOUNT = 20;
	//修改/删除原因
	private String causeOfModificationOrDeletion;
	public static final int CAUSE_OF_MODIFICATION_OR_DELETION = 21;
	//付款人常驻国家/地区代码
	private String draweeResidentPlaceCode;
	public static final int DRAWEE_RESIDENT_PLACE_CODE = 22;
	//收款性质
	private String propertyOfReceivables;
	public static final int PROPERTY_OF_RECEIVABLES = 23;
	//交易编码1
	private String tradingCode1;
	public static final int TRADING_CODE_1 = 24;
	//相应金额1
	private Long correspondingAmount1;
	public static final int CORRESPONDING_AMOUNT_1 = 25;
	//交易附言1
	private String tradingPostScript1;
	public static final int TRADING_POST_SCRIPT_1 = 26;
	//交易编码2
	private String tradingCode2;
	public static final int TRADING_CODE_2 = 27;
	//相应金额2
	private Long correspondingAmount2;
	public static final int CORRESPONDING_AMOUNT_2 = 28;
	//交易附言2
	private String tradingPostScript2;
	public static final int TRADING_POST_SCRIPT_2 = 29;
	//是否保税货物项下收汇
	private String bondedGoodsExchange;
	public static final int BONDED_GOODS_EXCHANGE = 30;
	//外汇局批件号/备案编号/业务编号
	private String columnAF;
	public static final int COLUMN_AF = 31;
	//收入类型
	private String incomeType;
	public static final int INCOME_TYPE = 32;
	//填报人
	private String informant;
	public static final int INFORMANT = 33;
	//填报人电话
	private String informantPhone;
	public static final int INFORMANT_PHONE = 34;
	//申报日期
	private String declarationDate;
	public static final int DECLARATION_DATE = 35;
	//折美元金额
	private Long amountInUSD;
	public static final int AMOUNT_IN_USD = 36;
	//所属分行
	private String branch;
	public static final int BRANCH = 37;
	//-------------------------------------------------------------------
	//sheet 已通知（informed）
	//组织机构代码和国家代码的组合
	private Map<String,String> countryMap;

	public Map<String, String> getCountryMap() {
		return countryMap;
	}
	public void setCountryMap(Map<String, String> countryMap) {
		this.countryMap = countryMap;
	}
	public int getLineNumberInExcel() {
		return lineNumberInExcel;
	}
	public void setLineNumberInExcel(int lineNumberInExcel) {
		this.lineNumberInExcel = lineNumberInExcel;
	}
	public String getApplicationNumber() {
		return applicationNumber;
	}
	public void setApplicationNumber(String applicationNumber) {
		this.applicationNumber = applicationNumber;
	}
	public String getPayeeType() {
		return payeeType;
	}
	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}
	public String getPersonalIdentityNumber() {
		return personalIdentityNumber;
	}
	public void setPersonalIdentityNumber(String personalIdentityNumber) {
		this.personalIdentityNumber = personalIdentityNumber;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getDraweeName() {
		return draweeName;
	}
	public void setDraweeName(String draweeName) {
		this.draweeName = draweeName;
	}
	public String getIncomeCurrency() {
		return incomeCurrency;
	}
	public void setIncomeCurrency(String incomeCurrency) {
		this.incomeCurrency = incomeCurrency;
	}
	public Long getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(Long incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public Long getExrt() {
		return exrt;
	}
	public void setExrt(Long exrt) {
		this.exrt = exrt;
	}
	public Long getExchangeAmount() {
		return exchangeAmount;
	}
	public void setExchangeAmount(Long exchangeAmount) {
		this.exchangeAmount = exchangeAmount;
	}
	public String getCnyAccount() {
		return cnyAccount;
	}
	public void setCnyAccount(String cnyAccount) {
		this.cnyAccount = cnyAccount;
	}
	public Long getAmountInFx() {
		return amountInFx;
	}
	public void setAmountInFx(Long amountInFx) {
		this.amountInFx = amountInFx;
	}
	public String getForeignAccount() {
		return foreignAccount;
	}
	public void setForeignAccount(String foreignAccount) {
		this.foreignAccount = foreignAccount;
	}
	public Long getOtherAmount() {
		return otherAmount;
	}
	public void setOtherAmount(Long otherAmount) {
		this.otherAmount = otherAmount;
	}
	public String getOtherAccount() {
		return otherAccount;
	}
	public void setOtherAccount(String otherAccount) {
		this.otherAccount = otherAccount;
	}
	public String getSettlementMethod() {
		return settlementMethod;
	}
	public void setSettlementMethod(String settlementMethod) {
		this.settlementMethod = settlementMethod;
	}
	public String getBussinessNumber() {
		return bussinessNumber;
	}
	public void setBussinessNumber(String bussinessNumber) {
		this.bussinessNumber = bussinessNumber;
	}
	public String getDomesticBankDeductedCurrency() {
		return domesticBankDeductedCurrency;
	}
	public void setDomesticBankDeductedCurrency(String domesticBankDeductedCurrency) {
		this.domesticBankDeductedCurrency = domesticBankDeductedCurrency;
	}
	public Long getDomesticBankDeductionAmount() {
		return domesticBankDeductionAmount;
	}
	public void setDomesticBankDeductionAmount(Long domesticBankDeductionAmount) {
		this.domesticBankDeductionAmount = domesticBankDeductionAmount;
	}
	public String getForeignBankDeductedCurrency() {
		return foreignBankDeductedCurrency;
	}
	public void setForeignBankDeductedCurrency(String foreignBankDeductedCurrency) {
		this.foreignBankDeductedCurrency = foreignBankDeductedCurrency;
	}
	public Long getForeignBankDeductionAmount() {
		return foreignBankDeductionAmount;
	}
	public void setForeignBankDeductionAmount(Long foreignBankDeductionAmount) {
		this.foreignBankDeductionAmount = foreignBankDeductionAmount;
	}
	public String getCauseOfModificationOrDeletion() {
		return causeOfModificationOrDeletion;
	}
	public void setCauseOfModificationOrDeletion(String causeOfModificationOrDeletion) {
		this.causeOfModificationOrDeletion = causeOfModificationOrDeletion;
	}
	public String getDraweeResidentPlaceCode() {
		return draweeResidentPlaceCode;
	}
	public void setDraweeResidentPlaceCode(String draweeResidentPlaceCode) {
		this.draweeResidentPlaceCode = draweeResidentPlaceCode;
	}
	public String getPropertyOfReceivables() {
		return propertyOfReceivables;
	}
	public void setPropertyOfReceivables(String propertyOfReceivables) {
		this.propertyOfReceivables = propertyOfReceivables;
	}
	public String getTradingCode1() {
		return tradingCode1;
	}
	public void setTradingCode1(String tradingCode1) {
		this.tradingCode1 = tradingCode1;
	}
	public Long getCorrespondingAmount1() {
		return correspondingAmount1;
	}
	public void setCorrespondingAmount1(Long correspondingAmount1) {
		this.correspondingAmount1 = correspondingAmount1;
	}
	public String getTradingPostScript1() {
		return tradingPostScript1;
	}
	public void setTradingPostScript1(String tradingPostScript1) {
		this.tradingPostScript1 = tradingPostScript1;
	}
	public String getTradingCode2() {
		return tradingCode2;
	}
	public void setTradingCode2(String tradingCode2) {
		this.tradingCode2 = tradingCode2;
	}
	public Long getCorrespondingAmount2() {
		return correspondingAmount2;
	}
	public void setCorrespondingAmount2(Long correspondingAmount2) {
		this.correspondingAmount2 = correspondingAmount2;
	}
	public String getTradingPostScript2() {
		return tradingPostScript2;
	}
	public void setTradingPostScript2(String tradingPostScript2) {
		this.tradingPostScript2 = tradingPostScript2;
	}
	public String getBondedGoodsExchange() {
		return bondedGoodsExchange;
	}
	public void setBondedGoodsExchange(String bondedGoodsExchange) {
		this.bondedGoodsExchange = bondedGoodsExchange;
	}
	public String getColumnAF() {
		return columnAF;
	}
	public void setColumnAF(String columnAF) {
		this.columnAF = columnAF;
	}
	public String getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public String getInformant() {
		return informant;
	}
	public void setInformant(String informant) {
		this.informant = informant;
	}
	public String getInformantPhone() {
		return informantPhone;
	}
	public void setInformantPhone(String informantPhone) {
		this.informantPhone = informantPhone;
	}
	public String getDeclarationDate() {
		return declarationDate;
	}
	public void setDeclarationDate(String declarationDate) {
		this.declarationDate = declarationDate;
	}
	public Long getAmountInUSD() {
		return amountInUSD;
	}
	public void setAmountInUSD(Long amountInUSD) {
		this.amountInUSD = amountInUSD;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}

}
