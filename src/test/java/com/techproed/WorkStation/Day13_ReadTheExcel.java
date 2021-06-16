package com.techproed.WorkStation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Day13_ReadTheExcel {
    @Test
    public void readExcel() throws IOException {
//        Store the path of the  file in a string
        String filePath = "./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(filePath);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet = workbook.getSheetAt(0);
//        Go to first row
        Row firstRow = sheet.getRow(0);
//        Go to first cell on that first row and print
        Cell firstCell = firstRow.getCell(0);
        System.out.println(firstCell);

//        Go to second cell on that first row and print
         Cell secondCell = firstRow.getCell(1);
//        Go to 2nd row first cell
        Row secondRow = sheet.getRow(1);
//        Go to 3rd row 2nd cell-chain the row and cell
        Row thirtRow = sheet.getRow(2);
        Cell secondCelll = sheet.getRow(7).getCell(0);
        System.out.println(secondCelll);
//        Find the number of row
        int numRow = sheet.getLastRowNum()+1;
//        Find the number of used row
//        Print country, capitol key value pairs as map object

    }
}