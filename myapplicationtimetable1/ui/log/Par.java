package com.example.myapplicationtimetable1.ui.log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Par {
    public  int test = 0;
    public String gotovo = " ";

    public String find(String group) throws IOException {
        File myFolder = new File("/storage/emulated/0/Download/my");
        File[] files = myFolder.listFiles();
        for (int i = 0; files.length > i; i++){
            if (SearchGroup(group,files[i].toString())==1){
                gotovo = "группа найдена";
                break;
            }
        }
        if (gotovo.equals(" ")){
            gotovo = "группа не найдена";
        }
        return  gotovo;
    }

    public int SearchGroup(String group, String puti) throws IOException {
        test = 0;
        FileInputStream fileInputStream = new FileInputStream(puti);
        Workbook wb = new HSSFWorkbook(fileInputStream);
        for (Row row : wb.getSheetAt(0)) {
            for (Cell cell : row){
                if (getCellText(cell).equals(group)){
                    System.out.println("getCellText(cell)\t" + getCellText(cell));
                    test = 1;
                    break;
                }
            }
        }
        return test;
    }

    public String getCellText(Cell cell){
        String res="";
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                res = cell.getRichStringCellValue().getString();
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)){
                    res = cell.getDateCellValue().toString();
                }
                else {
                    res = Double.toString(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                res = Boolean.toString(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                res = cell.getCellFormula().toString();
                break;
            default:
                break;
        }
        return res;
    }

}