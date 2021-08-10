package com.stars.sea.work.utils;


import com.stars.sea.work.bean.ChildrenData;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//意向学员excel
public class YixiangExcelUtil {
    public static void main(String[] args) {

        String fileName = "E:\\test\\ingcareTempFile\\yixiangyonghu.xlsx";

        //writeExcel(10, fileName);
        writeOtherExcel(fileName);


    }

    /**
     * 生成学员信息Excel
     *
     * @param fileName
     */
    public static void writeExcel(int count, String fileName) {
        String outFileName = "E:\\test\\yixiangyonghu" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<ChildrenData> list = new ArrayList<>();
        int nameCount = count;
        List<String> nameList = NameUtil.getName(nameCount);
        List<String> intentionLevel = RandomUtil.getIntentionLevel(nameCount);
        for (int i = 0; i < nameCount; i++) {
            ChildrenData childrenData = new ChildrenData();
            childrenData.setName(nameList.get(i));
            List<String> contact = RandomUtil.getContact(1);
            childrenData.setRelation(contact.get(0));
            childrenData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            childrenData.setBirthday(DateUtil.getHistoryDay("yyyy年MM月dd日"));
            childrenData.setSex(i % 2 == 1 ? "男" : "女");
            childrenData.setFamilyAddress("北京市朝阳区孙河");
            childrenData.setIntentionLevel(intentionLevel.get(i));

            list.add(childrenData);
        }
        writeExcel(fileName, outFileName, list);

    }

    public static void writeOtherExcel(String fileName) {
        String outFileName = "E:\\test\\yixiangyonghu" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<ChildrenData> list = new ArrayList<>();
        int nameCount = 8;
        List<String> nameList = NameUtil.getName(nameCount);
        List<String> intentionLevel = RandomUtil.getIntentionLevel(nameCount);
        for (int i = 0; i < nameCount; i++) {
            ChildrenData childrenData = new ChildrenData();
            childrenData.setName(nameList.get(i));
            List<String> contact = RandomUtil.getContact(1);
            childrenData.setRelation(contact.get(0));
            childrenData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            if (i > 0 && i < 5) {
                childrenData.setSex(i % 2 == 1 ? "男" : "女");
            }
            if (i > 1 && i < 6) {
                childrenData.setBirthday(DateUtil.getHistoryDay("yyyy年MM月dd日"));
            }
            if (i > 2 && i < 7) {
                childrenData.setFamilyAddress("北京市朝阳区孙河");
            }
            if (i > 3) {
                childrenData.setIntentionLevel(intentionLevel.get(i));
            }

            list.add(childrenData);
        }
        writeExcel(fileName, outFileName, list);

    }

    /**
     * 生成意向学员Excel文件
     *
     * @param fileName
     * @param outfileName
     * @param list
     */
    public static void writeExcel(String fileName, String outfileName, List<ChildrenData> list) {
        InputStream io;
        try {
            io = new FileInputStream(new File(fileName));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(io);
            SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 100);
            SXSSFSheet sheet = workbook.getSheetAt(0);
            sheet.setColumnWidth(2, 4500);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4500);
            sheet.setRandomAccessWindowSize(-1);
            for (int i = 0; i < list.size(); i++) {
                SXSSFRow row = null;
                if (sheet.getRow(i + 1) == null) {
                    row = sheet.createRow(i + 1);
                } else {
                    row = sheet.getRow(i + 1);
                }
                row.createCell(0).setCellValue(list.get(i).getName());
                row.createCell(1).setCellValue(list.get(i).getSex());
                row.createCell(2).setCellValue(list.get(i).getBirthday());
                row.createCell(3).setCellValue(list.get(i).getRelation());
                row.createCell(4).setCellValue(list.get(i).getTelNumber());
                row.createCell(5).setCellValue(list.get(i).getFamilyAddress());
                row.createCell(6).setCellValue(list.get(i).getIntentionLevel());
            }
            FileOutputStream fo = new FileOutputStream(new File(outfileName));
            workbook.write(fo);
            //清空缓冲区数据
            fo.flush();
            fo.close();
            workbook.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
