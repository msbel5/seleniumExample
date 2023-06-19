package org.sExample.Util;

public class FileManager {
    private ExcelReader excelReader;
    private TextFileWriter textFileWriter;

    public FileManager() {
        this.excelReader = new ExcelReader();
        this.textFileWriter = new TextFileWriter();
    }

    public String getExcelData(int vRow, int vColumn) {
        return this.excelReader.readCellData(vRow, vColumn);
    }

    public void writeTextData(String productInfo, String price) {
        this.textFileWriter.writeProductInfo(productInfo, price);
    }
}
