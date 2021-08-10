package com.stars.sea.work.bean;


import lombok.Data;

@Data
public class PersonnelData {
    /**
     * 用户姓名（*必填）
     */
    private String  name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 联系电话（*必填）
     */
    private Long telNumber;
    /**
     * 出生日期 20XX年XX月XX日  yyyy年MM月dd日
     */
    private String idCard;
    /**
     * 学历  小学、初中、高中、专科、本科、研究生、其他
     */
    private String education;

    /**
     * 民族
     */
    private String nation;
    /**
     * 婚姻状况 已婚、未婚、离异、丧偶
     */
    private String maritalStatus;
    /**
     * 籍贯
     */
    private String nativePlace;
    /**
     * 家庭地址
     */
    private String familyAddress;
    /**
     * 联系人
     */
    private String relation;
    /**
     * 联系电话2
     */
    private Long telNumber2;

    /**
     * 毕业院校
     */
    private String school;

}
