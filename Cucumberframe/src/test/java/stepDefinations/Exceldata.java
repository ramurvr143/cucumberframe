package stepDefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import utils.Excelreader;

public class Exceldata {

@Given("I read product data from Excel file")
public void i_read_product_data_from_excel_file() throws IOException {
    String filePath = "src/test/resources/Testdata/Cucumberdata.xlsx";
    String sheetName = "Sheet1";
    List<Map<String, String>> testData = Excelreader.getData(filePath, sheetName);
    for (Map<String, String> row : testData) {
        System.out.println("Name: " + row.get("Name"));
        System.out.println("Email: " + row.get("Email"));
        System.out.println("Phone number: " + row.get("Phone number"));
        System.out.println("Role: " + row.get("Role"));
        System.out.println("-----------");
    }



}
}