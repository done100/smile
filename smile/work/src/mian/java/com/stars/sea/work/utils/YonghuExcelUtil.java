package com.stars.sea.work.utils;


import com.stars.sea.work.bean.PersonnelData;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//用户excel
public class YonghuExcelUtil {
    public static void main(String[] args) {

        String fileName = "E:\\test\\ingcareTempFile\\personnel.xlsx";

        writeExcel(10, fileName);
        writeOtherExcel(fileName);


    }

    /**
     * 生成用户信息Excel
     *
     * @param fileName
     */
    public static void writeExcel(int count, String fileName) {
        String outFileName = "E:\\test\\personnel" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<PersonnelData> list = new ArrayList<>();
        int nameCount = count;
        List<String> nameList = NameUtil.getName(nameCount * 2);
        List<String> educationList = RandomUtil.getEducation(nameCount);
        List<String> nationList = RandomUtil.getNation(nameCount);
        List<String> maritalStatusList = RandomUtil.getMaritalStatus(nameCount);
        for (int i = 0; i < nameCount; i++) {
            PersonnelData personnelData = new PersonnelData();
            personnelData.setName(nameList.get(i));
            personnelData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);

            personnelData.setSex(i % 2 == 1 ? "男" : "女");
            personnelData.setIdCard("120113199303095664");
            personnelData.setEducation(educationList.get(i));
            personnelData.setNation(nationList.get(i));
            personnelData.setMaritalStatus(maritalStatusList.get(i));
            personnelData.setNativePlace("北京市朝阳区");
            personnelData.setFamilyAddress("北京市朝阳区孙河地铁站对面");
            personnelData.setRelation(nameList.get(nameCount + i));
            personnelData.setTelNumber2(3000306000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            personnelData.setSchool("北京清华大学");

            list.add(personnelData);
        }
        writeExcel(fileName, outFileName, list);

    }

    public static void writeOtherExcel(String fileName) {
        String outFileName = "E:\\test\\personnel" + DateUtil.today("YYYY-MM-dd_HH-mm-ss") + ".xlsx";
        List<PersonnelData> list = new ArrayList<>();
        int nameCount = 20;
        List<String> nameList = NameUtil.getName(nameCount * 2);
        List<String> educationList = RandomUtil.getEducation(nameCount);
        List<String> nationList = RandomUtil.getNation(nameCount);
        List<String> maritalStatusList = RandomUtil.getMaritalStatus(nameCount);
        for (int i = 0; i < nameCount; i++) {
            PersonnelData personnelData = new PersonnelData();
            personnelData.setName(nameList.get(i));
            personnelData.setTelNumber(3000000000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);
            if (i > 0 && i < 11) {
                personnelData.setSex(i % 2 == 1 ? "男" : "女");
            }
            if (i > 1 && i < 12) {
                personnelData.setIdCard("120113199303095664");
            }
            if (i > 2 && i < 13) {
                personnelData.setEducation(educationList.get(i));
            }
            if (i > 3 && i < 14) {
                personnelData.setNation(nationList.get(i));
            }
            if (i > 4 && i < 15) {
                personnelData.setMaritalStatus(maritalStatusList.get(i));
            }
            if (i > 5 && i < 16) {
                personnelData.setNativePlace("北京市朝阳区");
            }
            if (i > 6 && i < 17) {
                personnelData.setFamilyAddress("北京市朝阳区孙河地铁站对面");

            }
            if (i > 7 && i < 18) {
                personnelData.setRelation(nameList.get(nameCount + i));

            }
            if (i > 8 && i < 19) {
                personnelData.setTelNumber2(3000306000L + Long.parseLong("1" + DateUtil.today("MMddHHmm") + "00") + i);

            }
            if (i > 9) {
                personnelData.setSchool("北京清华大学");

            }


            list.add(personnelData);
        }

        writeExcel(fileName, outFileName, list);

    }

    /**
     * 生成用户Excel文件
     *
     * @param fileName
     * @param outfileName
     * @param list
     */
    public static void writeExcel(String fileName, String outfileName, List<PersonnelData> list) {
        InputStream io;
        try {
            io = new FileInputStream(new File(fileName));
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(io);
            SXSSFWorkbook workbook = new SXSSFWorkbook(xssfWorkbook, 100);
            SXSSFSheet sheet = workbook.getSheetAt(0);
            sheet.setColumnWidth(2, 4500);
            sheet.setColumnWidth(3, 5500);
            sheet.setColumnWidth(7, 4500);
            sheet.setColumnWidth(8, 4000);
            sheet.setColumnWidth(10, 4500);
            sheet.setColumnWidth(11, 4500);
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
                row.createCell(2).setCellValue(list.get(i).getTelNumber());
                row.createCell(3).setCellValue(list.get(i).getIdCard());
                row.createCell(4).setCellValue(list.get(i).getEducation());
                row.createCell(5).setCellValue(list.get(i).getNation());
                row.createCell(6).setCellValue(list.get(i).getMaritalStatus());
                row.createCell(7).setCellValue(list.get(i).getNativePlace());
                row.createCell(8).setCellValue(list.get(i).getFamilyAddress());
                row.createCell(9).setCellValue(list.get(i).getRelation());
                if (list.get(i).getTelNumber2() != null) {
                    row.createCell(10).setCellValue(list.get(i).getTelNumber2());
                }
                row.createCell(11).setCellValue(list.get(i).getSchool());

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
