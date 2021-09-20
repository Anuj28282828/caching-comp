package come.example.demo;

import com.example.demo.MoreDataSet;

import com.fasterxml.jackson.databind.ObjectMapper;
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

public class CreditCard {
    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public String toString() {
        return "SaleEvent{" +
                "id='" + id + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String id;
    private String streetAddress;
    private String city;*/

    /*public static void main(String[] args) {
     *//*SaleEvent saleEvent = new SaleEvent();
        saleEvent.setCity("Bangalore");
        saleEvent.setId("1");
        saleEvent.setStreetAddress("Str1");

        System.out.println(saleEvent);
        JsonDisplay.showJson(saleEvent);*//*

    }*/


    /*public static void main(String[] args) throws Exception {
        File input = new File("D:\\Installers\\Work\\gitP_main\\java-project\\src\\main\\java\\test1.csv");
        File output = new File("D:\\Installers\\Work\\gitP_main\\java-project\\src\\main\\java\\AXIS-50KRecs.json");

        List<Map<?, ?>> data = readObjectsFromCsv(input);
        writeAsJson(data, output);
    }

    public static List<Map<?, ?>> readObjectsFromCsv(File file) throws IOException {
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader(Map.class).with(bootstrap).readValues(file);

        return mappingIterator.readAll();
    }

    public static void writeAsJson(List<Map<?, ?>> data, File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, data);
    }*/

    public static void main(String[] args) throws IOException {
        // Step 1: Read Excel File into Java List Objects
        List customers = readExcelFile("D:\\Installers\\Work\\gitP_main\\java-project\\src\\main\\java\\creditcard.xlsx");

        // Step 2: Convert Java Objects to JSON String
        String jsonString = convertObjects2JsonString(customers);

        System.out.println(jsonString);
    }

    /**
     * Read Excel File into Java List Objects
     *
     * @param filePath
     * @return
     */
    private static List readExcelFile(String filePath){
        try {
            FileInputStream excelFile = new FileInputStream(new File(filePath));
            Workbook workbook = new XSSFWorkbook(excelFile);

            Sheet sheet = workbook.getSheet("creditcard");
            Iterator rows = sheet.iterator();

            List<MoreDataSet> lstCustomers = new ArrayList();

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
                while (cellsInRow.hasNext()) {
                    Cell currentCell = (Cell) cellsInRow.next();

                    if(cellIndex==0) { // ID
                        cust.setId(currentCell.getNumericCellValue());
                    } else if(cellIndex==1) { // Name
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

                lstCustomers.add(cust);
            }

            // Close WorkBook
            workbook.close();

            return lstCustomers;
        } catch (IOException e) {
            throw new RuntimeException("FAIL! -> message = " + e.getMessage());
        }
    }

    /**
     * Convert Java Objects to JSON String
     *
     * @param customers
     */
    private static String convertObjects2JsonString(List<MoreDataSet> customers) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";
        FileWriter fileWriter = new FileWriter("D:\\Installers\\Work\\gitP_main\\java-project\\src\\main\\java\\output.redis");



        for(MoreDataSet stockDetails : customers){
            String save = "JSON.SET stock_detail . '"+mapper.writeValueAsString(stockDetails)+"'\n";
            fileWriter.write(save);
            //System.out.println(save);
        }

        /*try {
            jsonString = mapper.writeValueAsString(customers);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
        fileWriter.close();
        return jsonString;
    }

}
