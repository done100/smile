package com.stars.sea.work.utils;


import com.stars.sea.work.bean.ChildrenData;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

//学员excel
public class XueyuanExcelUtil {
    public static void main(String[] args) {

        String fileName = "E:\\test\\ingcareTempFile\\xueyuan.xlsx";

         writeXueyuanExcel(10, fileName);
        writeOtherXueyuanExcel(fileName);


    }

    /**
     * 生成学员信息Excel
     *
     * @param fileName
     */
    public static void writeXueyuanExcel(int count, String fileName) {
        String outFileName = "E:\\test\\xueyuan" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<ChildrenData> list = new ArrayList<>();
        int nameCount = count;
        List<String> nameList = NameUtil.getName(nameCount);
        for (int i = 0; i < nameCount; i++) {
            ChildrenData childrenData = new ChildrenData();
            childrenData.setName(nameList.get(i));
            List<String> contact = RandomUtil.getContact(2);
            childrenData.setRelation(contact.get(0));
            childrenData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);

            childrenData.setSex(i % 2 == 1 ? "男" : "女");
            childrenData.setBirthday(DateUtil.getHistoryDay("yyyy年MM月dd日"));
            childrenData.setInsertDate(DateUtil.getHistoryDay(childrenData.getInsertDate(), "yyyy年MM月dd日"));
            String nickName = childrenData.getName().substring(childrenData.getName().length() - 1);
            childrenData.setNickName(nickName + nickName);
            childrenData.setRelation2(contact.get(1));
            childrenData.setTelNumber2(3000306000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            childrenData.setFamilyAddress("北京市朝阳区孙河");

            list.add(childrenData);
        }
        writeXueyuanExcel(fileName, outFileName, list);

    }

    public static void writeOtherXueyuanExcel(String fileName) {
        String outFileName = "E:\\test\\xueyuan" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<ChildrenData> list = new ArrayList<>();
        int nameCount = 14;
        List<String> nameList = NameUtil.getName(nameCount);
        for (int i = 0; i < nameCount; i++) {
            ChildrenData childrenData = new ChildrenData();
            childrenData.setName(nameList.get(i));
            List<String> contact = RandomUtil.getContact(2);
            childrenData.setRelation(contact.get(0));
            childrenData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            if (i > 0 && i < 8) {
                childrenData.setSex(i % 2 == 1 ? "男" : "女");
            }
            if (i > 1 && i < 9) {
                childrenData.setBirthday(DateUtil.getHistoryDay("yyyy年MM月dd日"));
            }
            if (i > 2 && i < 10) {
                childrenData.setInsertDate(DateUtil.getHistoryDay(childrenData.getInsertDate(), "yyyy年MM月dd日"));
            }
            if (i > 3 && i < 11) {
                String nickName = childrenData.getName().substring(childrenData.getName().length() - 1);
                childrenData.setNickName(nickName + nickName);
            }
            if (i > 4 && i < 12) {
                childrenData.setRelation2(contact.get(1));
            }
            if (i > 5 && i < 13) {
                childrenData.setTelNumber2(3000306000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            }
            if (i > 6) {
                childrenData.setFamilyAddress("北京市朝阳区孙河");
            }

            list.add(childrenData);
        }

        writeXueyuanExcel(fileName, outFileName, list);

    }

    /**
     * 生成学员Excel文件
     *
     * @param fileName
     * @param outfileName
     * @param list
     */
    public static void writeXueyuanExcel(String fileName, String outfileName, List<ChildrenData> list) {
        InputStream io;
        try {
            io = new FileInputStream(new File(fileName));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(io);
            SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 100);
            SXSSFSheet sheet = workbook.getSheetAt(0);
            sheet.setColumnWidth(2, 4500);
            sheet.setColumnWidth(4, 4000);
            sheet.setColumnWidth(5, 4500);
            sheet.setColumnWidth(8, 4000);
            sheet.setColumnWidth(9, 4500);
            sheet.setRandomAccessWindowSize(-1);
            for (int i = 0; i < list.size(); i++) {
                SXSSFRow row = null;
                if (sheet.getRow(i + 3) == null) {
                    row = sheet.createRow(i + 3);
                } else {
                    row = sheet.getRow(i + 3);
                }
                row.createCell(0).setCellValue(list.get(i).getName());

                row.createCell(1).setCellValue(list.get(i).getSex());
                row.createCell(2).setCellValue(list.get(i).getBirthday());


                row.createCell(3).setCellValue(list.get(i).getRelation());
                row.createCell(4).setCellValue(list.get(i).getTelNumber());

                row.createCell(5).setCellValue(list.get(i).getInsertDate());
                row.createCell(6).setCellValue(list.get(i).getNickName());
                row.createCell(7).setCellValue(list.get(i).getRelation2());
                if (list.get(i).getTelNumber2() != null) {
                    row.createCell(8).setCellValue(list.get(i).getTelNumber2());
                }
                row.createCell(9).setCellValue(list.get(i).getFamilyAddress());
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
