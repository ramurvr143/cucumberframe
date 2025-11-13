package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelreader {
	
	    public static List<Map<String, String>> getData(String filePath, String sheetName) throws IOException {
	        List<Map<String, String>> dataList = new ArrayList<>();

	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        // Get header row (first row)
	        Row headerRow = sheet.getRow(0);
	        int totalColumns = headerRow.getPhysicalNumberOfCells();
	        int totalRows = sheet.getPhysicalNumberOfRows();
	        
	        DataFormatter formatter = new DataFormatter();
	        for (int i = 1; i < totalRows; i++) {
	            Row currentRow = sheet.getRow(i);
	            Map<String, String> dataMap = new HashMap<>();

	            for (int j = 0; j < totalColumns; j++) {
	                String header = formatter.formatCellValue(headerRow.getCell(j));
	                String value = formatter.formatCellValue(currentRow.getCell(j));
	                dataMap.put(header, value);
	            }
	            dataList.add(dataMap);
	        }

	        workbook.close();
	        fis.close();
	        return dataList;
	    }
	}

	
