package com.relesee.excel.reader.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.relesee.excel.domain.LoanApplicationDO;
import com.relesee.excel.reader.ExcelReader;

/**
 * 注意下面的注解“存在问题”，如果这些“存在问题”的注解依然存在，
 * 肯会出现错误
 * @author HanLin
 *
 */
public class ExcelReaderImpl implements ExcelReader {
	private static String path = "";
	private static InputStream fileInputStream = null;
	private static Workbook wb = null;
	
	/*
	 * 构造方法取得文档对象Workbook
	 * */
	
	public ExcelReaderImpl(MultipartFile file) throws IOException{
		fileInputStream = file.getInputStream();
		try {
			wb = WorkbookFactory.create(fileInputStream);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public ExcelReaderImpl(String path){
		this.path = path;
		try {
			fileInputStream = new FileInputStream(path);
			wb = WorkbookFactory.create(fileInputStream);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	@Override
	public List<LoanApplicationDO> getDoList() {
		List<LoanApplicationDO> sheetList = new ArrayList<LoanApplicationDO>();
		

		Sheet foreignIncomeSheet = wb.getSheet("涉外收入");
		BigDecimal bd = null;
		
		try{
		for(Row row : foreignIncomeSheet){
			if(row.getRowNum() == 0){continue;}//跳过第一行元数据
			LoanApplicationDO mapperDO = new LoanApplicationDO();
			mapperDO.setLineNumberInExcel(row.getRowNum()+1);//row.getRowNum()的值从1开始计数，1实际上是excel中的第二行
			for(int currentColumnNumber = 0;currentColumnNumber <= row.getLastCellNum();currentColumnNumber++ ){
				
				Cell cell = row.getCell(currentColumnNumber);

				//金钱，乘100
				if(currentColumnNumber == LoanApplicationDO.AMOUNT_IN_FX){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setAmountInFx(bd.longValue());
					continue;
				}
				//金钱，乘100
				if(currentColumnNumber == LoanApplicationDO.AMOUNT_IN_USD){
					bd = new BigDecimal(getStringCellValue(cell));
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setAmountInUSD(bd.longValue());
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.APPLICATION_NUMBER){
					
					String s = getStringCellValue(cell);
					mapperDO.setApplicationNumber(s);
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.BONDED_GOODS_EXCHANGE){
					//s为空时值为：""
					String s = getStringCellValue(cell);
					mapperDO.setBondedGoodsExchange(s);
					continue;
				}				
				if(currentColumnNumber == LoanApplicationDO.BRANCH){
					String s = getStringCellValue(cell);
					mapperDO.setBranch(s);
					continue;
				}	
				if(currentColumnNumber == LoanApplicationDO.BUSSINESS_NUMBER){
					mapperDO.setBussinessNumber(getStringCellValue(cell));
					continue;
				}	
				if(currentColumnNumber == LoanApplicationDO.CAUSE_OF_MODIFICATION_OR_DELETION){
					mapperDO.setCauseOfModificationOrDeletion(getStringCellValue(cell));;
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.CNY_ACCOUNT){

					mapperDO.setCnyAccount(getStringCellValue(cell));
					continue;
				}	
				if(currentColumnNumber == LoanApplicationDO.COLUMN_AF){

					mapperDO.setColumnAF(getStringCellValue(cell));
					continue;
				}
				//金钱，乘100
				if(currentColumnNumber == LoanApplicationDO.CORRESPONDING_AMOUNT_1){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setCorrespondingAmount1(bd.longValue());
					continue;
				}
				//金钱，乘100
				//存在问题，值为null/0可能存在异常，还有，上面一条可能存在问题
				if(currentColumnNumber == LoanApplicationDO.CORRESPONDING_AMOUNT_2){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setCorrespondingAmount2(bd.longValue());
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.DECLARATION_DATE){
					String s = getStringCellValue(cell);

					try{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						s = format.format(cell.getDateCellValue());
						
					}catch(Exception e){
						s = cell.getStringCellValue();
					}
					
					
					mapperDO.setDeclarationDate(s);
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.DOMESTIC_BANK_DEDUCTED_CURRENCY){
					
					mapperDO.setDomesticBankDeductedCurrency(getStringCellValue(cell));
					continue;
				}	
				//金钱，乘100
				if(currentColumnNumber == LoanApplicationDO.DOMESTIC_BANK_DEDUCTION_AMOUNT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setDomesticBankDeductionAmount(bd.longValue());
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.DRAWEE_NAME){

					mapperDO.setDraweeName(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.DRAWEE_RESIDENT_PLACE_CODE){

					mapperDO.setDraweeResidentPlaceCode(getStringCellValue(cell));
					continue;
				}
				//金钱，乘100
				if(currentColumnNumber == LoanApplicationDO.EXCHANGE_AMOUNT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd= bd.multiply(new BigDecimal("100"));
					mapperDO.setExchangeAmount(bd.longValue());
					continue;
				}
				//存在问题，汇率的值有哪些情况，保留几位小数？
				if(currentColumnNumber == LoanApplicationDO.EXRT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setExrt(bd.longValue());
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.FOREIGN_ACCOUNT){

					mapperDO.setForeignAccount(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.FOREIGN_BANK_DEDUCTED_CURRENCY){

					mapperDO.setForeignBankDeductedCurrency(getStringCellValue(cell));
					continue;
				}	
				//金额，乘100
				if(currentColumnNumber == LoanApplicationDO.FOREIGN_BANK_DEDUCTION_AMOUNT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setForeignBankDeductionAmount(bd.longValue());
					continue;
				}	
				//金额，乘100
				if(currentColumnNumber == LoanApplicationDO.INCOME_AMOUNT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setIncomeAmount(bd.longValue());
					continue;
				}	
				if(currentColumnNumber == LoanApplicationDO.INCOME_CURRENCY){

					mapperDO.setIncomeCurrency(getStringCellValue(cell));
					continue;
				}	
				if(currentColumnNumber == LoanApplicationDO.INCOME_TYPE){

					mapperDO.setIncomeType(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.INFORMANT){

					mapperDO.setInformant(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.INFORMANT_PHONE){

					mapperDO.setInformantPhone(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.ORGANIZATION_CODE){

					mapperDO.setOrganizationCode(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.OTHER_ACCOUNT){

					mapperDO.setOtherAccount(getStringCellValue(cell));
					continue;
				}
				//金额，乘100
				if(currentColumnNumber == LoanApplicationDO.OTHER_AMOUNT){
					bd = new BigDecimal(cell.getNumericCellValue());
					bd = bd.multiply(new BigDecimal("100"));
					mapperDO.setOtherAmount(bd.longValue());
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.PAYEE_NAME){

					mapperDO.setPayeeName(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.PAYEE_TYPE){

					mapperDO.setPayeeType(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.PERSONAL_IDENTITY_NUMBER){

					mapperDO.setPersonalIdentityNumber(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.PROPERTY_OF_RECEIVABLES){

					mapperDO.setPropertyOfReceivables(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.SETTLEMENT_METHOD){

					mapperDO.setSettlementMethod(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.TRADING_CODE_1){
					
					mapperDO.setTradingCode1(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.TRADING_CODE_2){
					
					mapperDO.setTradingCode2(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.TRADING_POST_SCRIPT_1){
					
					mapperDO.setTradingPostScript1(getStringCellValue(cell));
					continue;
				}
				if(currentColumnNumber == LoanApplicationDO.TRADING_POST_SCRIPT_2){
					
					mapperDO.setTradingPostScript2(getStringCellValue(cell));
					continue;
				}

			}
			sheetList.add(mapperDO);
			
		}
		
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(IllegalStateException illegale){
			illegale.printStackTrace();
			
		}
		
		
		
		
		
		return sheetList;
	}
	
	/**
	 * 取出已通知sheet中的组织机构代码和国别代码为Map
	 */
	public Map<String,String> countryMap(){
		Map<String,String> map = new HashMap<String,String>();
		Sheet informed = wb.getSheet("已通知");

		
		for(Row row:informed){
			
			Cell orgCode = row.getCell(1);
			Cell countryCode = row.getCell(23);

			if(orgCode.getRowIndex() == 0){
				continue;
			}
			String orgCodeS = "";
			String countryCodeS = "";

			if(orgCode.getCellType() == Cell.CELL_TYPE_STRING){
				orgCodeS = orgCode.getStringCellValue();
			}
			if(orgCode.getCellType() == Cell.CELL_TYPE_NUMERIC){
				
				orgCodeS = String.valueOf((long)orgCode.getNumericCellValue());
			}
			try{
				countryCodeS = countryCode.getStringCellValue();
			}catch(Exception e){
				countryCodeS = "CELL_VALUE_ERROR";
			}
				
			if(orgCode.getCellType() == Cell.CELL_TYPE_BLANK || countryCode.getCellType() == Cell.CELL_TYPE_BLANK){
				continue;
			}
			
			
			map.put(orgCodeS, countryCodeS);
			
			
		}
		

		
		return map;
	}
	
	/**
	 * 得到cell的String值支持CELL_TYPE_NUMERIC和CELL_TYPE_STRING
	 * 即使是numeric的也转为String
	 * @return
	 */
	private String getStringCellValue(Cell cell){
		String s = "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING){
			s = cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
			try{
				s = String.valueOf((long)cell.getNumericCellValue());
		
			} catch (Exception e){
				e.printStackTrace();
				s = "";
			}
		}
		
		return s;
	}
}
