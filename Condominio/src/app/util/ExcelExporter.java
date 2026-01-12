package app.util;

import javax.swing.JTable;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileOutputStream;

public class ExcelExporter {
    public static void export(JTable table, String filename) {
        try (XSSFWorkbook workbook = new XSSFWorkbook()) {
            XSSFSheet sheet = workbook.createSheet("Datos");
            XSSFRow header = sheet.createRow(0);
            for(int i=0;i<table.getColumnCount();i++)
                header.createCell(i).setCellValue(table.getColumnName(i));
            for(int r=0;r<table.getRowCount();r++){
                XSSFRow row = sheet.createRow(r+1);
                for(int c=0;c<table.getColumnCount();c++)
                    row.createCell(c).setCellValue(String.valueOf(table.getValueAt(r,c)));
            }
            workbook.write(new FileOutputStream(filename));
        } catch(Exception e){ e.printStackTrace(); }
    }
}
