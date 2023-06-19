package org.sExample.Util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    private static final String FILE_PATH = "src/test/resources/data.xlsx";

    public String readCellData(int vRow, int vColumn) {
        String value = null;
        Workbook workbook = null;
        try {
            FileInputStream fis = new FileInputStream(new File(FILE_PATH));
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(vRow);
            if (row != null) {
                Cell cell = row.getCell(vColumn);
                if (cell != null) {
                    value = cell.getStringCellValue();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public String readFirstColumnData(int vRow) {
        return readCellData(vRow, 0);  // 0 is the first column
    }

}
