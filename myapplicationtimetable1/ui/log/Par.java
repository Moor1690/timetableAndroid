package com.example.myapplicationtimetable1.ui.log;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;




public class Par {
    public int indexX;
    public int indexY;
    public  int test = 0;
    public String gotovo = " ";
    public StringBuilder otvet = new  StringBuilder();

    public String find (String group) throws IOException {
        group = "ИКБО-27-20";
        File myFolder = new File("/storage/emulated/0/Download/my");
        File[] files = myFolder.listFiles();
        for (int i = 0; files.length > i; i++){
            if (SearchGroup(group,files[i].toString())==1){
                gotovo = printExel(files[i].toString());
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
        System.out.println(puti);
        FileInputStream fileInputStream = new FileInputStream(puti);
        Workbook wb = new XSSFWorkbook(fileInputStream);
        for (Row row : wb.getSheetAt(0)) {
            for (Cell cell : row){
                Cell r = cell;

                if (getCellText(cell).equals(group)){
                    indexY = r.getRowIndex();
                    indexX = r.getColumnIndex();
                    test = 1;
                    break;
                }
            }
        }
        return test;
    }

    public String printExel(String puti) throws IOException{
        FileInputStream fis = new FileInputStream(puti);
        Workbook wb1 = new XSSFWorkbook(fis);
        int newDay = 0;
        //System.out.println(indexY + "\tindexY");
        int indexRowPredmet = indexY + 2;
        //System.out.println(indexRowPredmet + "\tindexRowPredmet");
        for (int i = 0; i < 6; i++){
            for (int i2 = 0; i2 < 12; i2++){
                String predmet = getCellText(wb1.getSheetAt(0).getRow(indexRowPredmet + i2 + newDay).getCell(indexX)) + "\t";
                //System.out.println(indexRowPredmet+ "\t");
                String type = getCellText(wb1.getSheetAt(0).getRow(indexRowPredmet + i2 + newDay).getCell(indexX+1)) + "\t";
                String taech = getCellText(wb1.getSheetAt(0).getRow(indexRowPredmet + i2 + newDay).getCell(indexX+2)) + "\t";
                String location = getCellText(wb1.getSheetAt(0).getRow(indexRowPredmet + i2 + newDay).getCell(indexX+3)) + "\n";

                otvet.append(indexRowPredmet + "\t");
                otvet.append(i2 + "\t");
                otvet.append(newDay + "\t");


                otvet.append(predmet);
                otvet.append(type);
                otvet.append(taech);
                otvet.append(location);
            }
            newDay += 12;
        }
        return otvet.toString();

    }

    public String getCellText(Cell cell){



        String res="";
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_STRING:
                res = cell.getRichStringCellValue().getString();
                //System.out.println("тест " + cell.getStringCellValue());
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










/////////////////////////////////////////////////NE RABOTAET////////////
//public class Par {
//    public  int test = 0;
//    public String gotovo = " ";
//
//    public String find(String group) throws IOException {
//        group = "ИВБО-13-21";
//        File myFolder = new File("/storage/emulated/0/Download/my");
//        File[] files = myFolder.listFiles();
//        for (int i = 0; files.length > i; i++){
//            if (SearchGroup(group,files[i].toString())==1){
//                gotovo = "группа найдена";
//                break;
//            }
//        }
//        if (gotovo.equals(" ")){
//            gotovo = "группа не найдена";
//        }
//        return  gotovo;
//    }
//
//    public int SearchGroup(String group, String puti) throws IOException {
//        test = 0;
//        FileInputStream fileInputStream = new FileInputStream(puti);
//        Workbook wb = new XSSFWorkbook(fileInputStream);
//        for (Row row : wb.getSheetAt(0)) {
//            for (Cell cell : row){
//                if (getCellText(cell).equals(group)){
//                    System.out.println("getCellText(cell)\t" + getCellText(cell));
//                    test = 1;
//                    break;
//                }
//            }
//        }
//        return test;
//    }
//
//    public String getCellText(Cell cell){
//        String res="";
//        switch (cell.getCellType()){
//            case Cell.CELL_TYPE_STRING:
//                res = cell.getRichStringCellValue().getString();
//                break;
//            case Cell.CELL_TYPE_NUMERIC:
//                if (DateUtil.isCellDateFormatted(cell)){
//                    res = cell.getDateCellValue().toString();
//                }
//                else {
//                    res = Double.toString(cell.getNumericCellValue());
//                }
//                break;
//            case Cell.CELL_TYPE_BOOLEAN:
//                res = Boolean.toString(cell.getBooleanCellValue());
//                break;
//            case Cell.CELL_TYPE_FORMULA:
//                res = cell.getCellFormula().toString();
//                break;
//            default:
//                break;
//        }
//        return res;
//    }
//
//}