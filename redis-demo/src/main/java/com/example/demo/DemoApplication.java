package com.example.demo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.lang.Runtime;

import com.example.demo.StockDetail;
import com.example.demo.MoreDataSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws JsonProcessingException {

		SpringApplication.run(DemoApplication.class, args);
		//System.out.println(Runtime.getRuntime.totalMemory());
		//System.out.println(Runtime.getRuntime.maxMemory());
		//System.out.println(Runtime.getRuntime.freeMemory());

		System.out.println("Starting Jedis");
		//Jedis jedis = new Jedis("172.16.174.143");
		//Jedis jedis = new Jedis("localhost");
		//jedis.set("anuj","100");
		//System.out.println(jedis.get("anuj"));

		Map<String, MoreDataSet> output = readExcelFile2("/home/ubuntu/javaCode/demo/src/main/java/com/example/demo/creditcard.xlsx");

		
		try(Jedis jedis = new Jedis("localhost")){
			System.out.println(System.currentTimeMillis());
			Pipeline p = jedis.pipelined();
			for(var entry : output.entrySet()){
				p.sadd(entry.getKey(), new ObjectMapper().writeValueAsString(entry.getValue()));
			}
			p.sync();
			System.out.println(System.currentTimeMillis());
		}
		
	}

	private static Map<String,StockDetail> readExcelFile1(String filePath){
   		 try {
		        FileInputStream excelFile = new FileInputStream(new File(filePath));
		        Workbook workbook = new XSSFWorkbook(excelFile);

		        Sheet sheet = workbook.getSheet("in");
		        Iterator rows = sheet.iterator();

		       // List<StockDetail> lstCustomers = new ArrayList();
		       Map<String,StockDetail> lstCustomers = new HashMap<>();

		        int rowNumber = 0;
		        while (rows.hasNext()) {
		            Row currentRow = (Row) rows.next();

            // skip header
		            if(rowNumber == 0) {
		                rowNumber++;
		                continue;
		            }

		            Iterator cellsInRow = currentRow.iterator();

		            StockDetail cust = new StockDetail();

		            int cellIndex = 0;
			    String key = "";
		            while (cellsInRow.hasNext()) {
		                Cell currentCell = (Cell) cellsInRow.next();

				if(cellIndex==0){
					key = "axis:"+currentCell.getStringCellValue();
				}

		                if(cellIndex==1) { // Name
		                    cust.setOpenPrice(currentCell.getNumericCellValue());
		                } else if(cellIndex==2) { // Address
		                    cust.setHighPrice(currentCell.getNumericCellValue());
		                } else if(cellIndex==3) { // Age
		                    cust.setLowPrice(currentCell.getNumericCellValue());
		                } else if(cellIndex==4) { // Age
		                    cust.setClosePrice(currentCell.getNumericCellValue());
		                }else if(cellIndex==5) { // Age
		                    cust.setVolume(currentCell.getNumericCellValue());
		                }

		                cellIndex++;
		            }
			    
			    System.out.println(key+"::::"+cust);
		            lstCustomers.put(key,cust);
		        }

        // Close WorkBook
		        workbook.close();

		        return lstCustomers;
		    } catch (IOException e) {
		        throw new RuntimeException("FAIL! -> message = " + e.getMessage());
		    }
		}

	private static Map<String,MoreDataSet> readExcelFile2(String filePath){
                 try {
                        FileInputStream excelFile = new FileInputStream(new File(filePath));
                        Workbook workbook = new XSSFWorkbook(excelFile);

                        Sheet sheet = workbook.getSheet("creditcard");
                        Iterator rows = sheet.iterator();

                       // List<StockDetail> lstCustomers = new ArrayList();
                       Map<String,MoreDataSet> lstCustomers = new HashMap<>();

                        int rowNumber = 0;
                        while (rows.hasNext()) {
                            Row currentRow = (Row) rows.next();

            // skip header
                            if(rowNumber == 0) {
                                rowNumber++;
                                continue;
                            }

                            Iterator cellsInRow = currentRow.iterator();

                            MoreDataSet cust = new MoreDataSet();

                            int cellIndex = 0;
                            String key = "";
                            while (cellsInRow.hasNext()) {
                                Cell currentCell = (Cell) cellsInRow.next();

                                if(cellIndex==0){
                                        key = "cc:"+currentCell.getNumericCellValue();
                                }

                                if(cellIndex==1) { // Name
                        cust.setVal1(currentCell.getNumericCellValue());
                    } else if(cellIndex==2) { // Address
                        cust.setVal2(currentCell.getNumericCellValue());
                    } else if(cellIndex==3) { // Age
                        cust.setVal3(currentCell.getNumericCellValue());
                    } else if(cellIndex==4) { // Age
                        cust.setVal4(currentCell.getNumericCellValue());
                    }else if(cellIndex==5) { // Age
                        cust.setVal5(currentCell.getNumericCellValue());
                    }else if(cellIndex==6) { // ID
                        cust.setVal6(currentCell.getNumericCellValue());
                    } else if(cellIndex==7) { // Name
                        cust.setVal7(currentCell.getNumericCellValue());
                    } else if(cellIndex==8) { // Address
                        cust.setVal8(currentCell.getNumericCellValue());
                    } else if(cellIndex==9) { // Age
                        cust.setVal9(currentCell.getNumericCellValue());
                    } else if(cellIndex==10) { // Age
                        cust.setVal10(currentCell.getNumericCellValue());
                    }else if(cellIndex==11) { // Age
                        cust.setVal11(currentCell.getNumericCellValue());
                    }else if(cellIndex==12) { // ID
                        cust.setVal12(currentCell.getNumericCellValue());
                    } else if(cellIndex==13) { // Name
                        cust.setVal13(currentCell.getNumericCellValue());
                    } else if(cellIndex==14) { // Address
                        cust.setVal14(currentCell.getNumericCellValue());
                    } else if(cellIndex==15) { // Age
                        cust.setVal15(currentCell.getNumericCellValue());
                    } else if(cellIndex==16) { // Age
                        cust.setVal16(currentCell.getNumericCellValue());
                    }else if(cellIndex==17) { // Age
                        cust.setVal17(currentCell.getNumericCellValue());
                    }else if(cellIndex==18) { // ID
                        cust.setVal18(currentCell.getNumericCellValue());
                    } else if(cellIndex==19) { // Name
                        cust.setVal19(currentCell.getNumericCellValue());
                    } else if(cellIndex==20) { // Address
                        cust.setVal20(currentCell.getNumericCellValue());
                    } else if(cellIndex==21) { // Age
                        cust.setVal21(currentCell.getNumericCellValue());
                    } else if(cellIndex==22) { // Age
                        cust.setVal22(currentCell.getNumericCellValue());
                    }else if(cellIndex==23) { // Age
                        cust.setVal23(currentCell.getNumericCellValue());
                    }else if(cellIndex==24) { // ID
                        cust.setVal24(currentCell.getNumericCellValue());
                    } else if(cellIndex==25) { // Name
                        cust.setVal25(currentCell.getNumericCellValue());
                    } else if(cellIndex==26) { // Address
                        cust.setVal26(currentCell.getNumericCellValue());
                    } else if(cellIndex==27) { // Age
                        cust.setVal27(currentCell.getNumericCellValue());
                    } else if(cellIndex==28) { // Age
                        cust.setVal28(currentCell.getNumericCellValue());
                    }

                                cellIndex++;
                            }
			    System.out.println(key+"::::"+cust);
                            lstCustomers.put(key,cust);
                        }

        // Close WorkBook
                        workbook.close();

                        return lstCustomers;
                    } catch (IOException e) {
                        throw new RuntimeException("FAIL! -> message = " + e.getMessage());
                    }
                }

}
