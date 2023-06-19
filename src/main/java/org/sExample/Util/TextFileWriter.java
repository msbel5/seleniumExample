package org.sExample.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {
    private static final String FILE_PATH = "src/main/resources/info.txt";

    public void writeProductInfo(String productInfo, String price) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
            writer.write("Ürün Bilgisi: " + productInfo + ", Fiyat: " + price);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
