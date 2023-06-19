package GenericFramework.Tests.Testcases;

import Utils.ExcelUtils;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {

        ExcelUtils.ReadFromExcelItems("AirLine1","Sheet1");
    }
}
