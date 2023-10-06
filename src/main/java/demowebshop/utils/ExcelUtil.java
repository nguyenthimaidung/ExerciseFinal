package demowebshop.utils;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {
    public static final String testDataExcelFileName = "assignment.xlsx";
    public static String testDataExcelPath = null; //Location of Test data excel file
    private static XSSFWorkbook excelWBook; //Excel WorkBook
    public static XSSFSheet excelWSheet; //Excel Sheet
    private static XSSFCell cell; //Excel cell
    private static XSSFRow row; //Excel row
    public static int rowNumber; //Row Number
    public static int columnNumber; //Column Number
    private Map<String, Integer> columns = new HashMap<>();

    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.

    public void setExcelFileSheet(String sheetName) throws IOException {

            testDataExcelPath = "src/test/resources/";
            FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
            excelWSheet.getRow(0).forEach(cell -> {
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

    }
    public String getCellData(String sheetName, int RowNum, int ColNum) throws IOException {
        testDataExcelPath = "src/test/resources/";
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    public String getCellData(String sheetName,String columnName, int rownum) throws IOException {
        testDataExcelPath = "src/test/resources/";
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        excelWSheet.getRow(0).forEach(cell -> {
            columns.put(cell.getStringCellValue(), cell.getColumnIndex());
        });
        return getCellData(sheetName,rownum, columns.get(columnName));
    }

    public int getRowCount(String sheetName) throws IOException {

        testDataExcelPath = "src/test/resources/";
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        int rowCount = excelWSheet.getLastRowNum();
        excelWBook.close();
        ExcelFile.close();
        return rowCount;
    }

    public int getCellCount(String sheetName , int rownum) throws IOException {
        testDataExcelPath = "src/test/resources/";
        FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWBook.getSheet(sheetName);
        row = excelWSheet.getRow(rownum);
        int cellRow = row.getLastCellNum();
        excelWBook.close();
        ExcelFile.close();
        return cellRow;
    }


    public void setCellData(String value, int RowNum, int ColNum) throws IOException {
        row = excelWSheet.getRow(RowNum);
        cell = row.getCell(ColNum);
        if (cell == null) {
            cell = row.createCell(ColNum);
            cell.setCellValue(value);
        } else {
            cell.setCellValue(value);
        }
        FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
        excelWBook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }
    public String[][] data(String sheetName) throws EncryptedDocumentException, IOException {
        int rowCount = getRowCount(sheetName);
        System.out.println("Tổng cột" + rowCount);
        int cellCount = getCellCount(sheetName,1);
        System.out.println("Tổng hàng" + cellCount);
        String[][] loginData = new String[rowCount][cellCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 1; j < cellCount; j++) {
                 loginData[i-1][j]= getCellData(sheetName,i,j);
            }

        }
        return loginData;
    }


}
