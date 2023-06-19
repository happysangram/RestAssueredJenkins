package Utils;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelUtils {

    @Test
    public static List<HashMap<String,String>> ReadFromExcelItems(String ExcelFileName,String sheet) throws IOException {


        List<HashMap<String,String>> readExcelData=new ArrayList<>();
       // InputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/ExcelFiles/"+ ExcelFileName+".xlsx");
        Workbook workbook= WorkbookFactory.create(new File(System.getProperty("user.dir")+"/src/test/resources/ExcelFiles/"+ ExcelFileName+".xlsx"));
        Sheet sheet1= workbook.getSheet(sheet);

        int rows= sheet1.getPhysicalNumberOfRows();
        List<String> ColumnHeaderList=new ArrayList<>();
        HashMap<String,String> celldata;
        DataFormatter dataFormatter=new DataFormatter();
        for(int i=0;i< rows;i++){
            celldata=new HashMap<>();
            if(i==0) {
                int columnHeader = sheet1.getRow(0).getPhysicalNumberOfCells();
                for(int j=0;j<columnHeader;j++){
                    ColumnHeaderList.add(sheet1.getRow(0).getCell(j).getStringCellValue());
                }
            }
            else{
                int columnHeader = sheet1.getRow(i).getPhysicalNumberOfCells();
                for(int j=0;j<columnHeader;j++) {

                    String value= dataFormatter.formatCellValue(sheet1.getRow(i).getCell(j));
                    if(value.contains("Random")){
                        value= String.valueOf(new Faker().number().numberBetween(111111111,999999999));
                    }
                    celldata.put(ColumnHeaderList.get(j),value);
                }

                readExcelData.add(celldata);
            }
        }

        return readExcelData;

    }


}
