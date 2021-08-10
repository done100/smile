package com.stars.sea.work.bean;


import lombok.Data;

@Data
public class ChildrenData {
    /**
     * 学员姓名（*必填）
     */
    private String  name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 出生日期 20XX年XX月XX日  yyyy年MM月dd日
     */
    private String birthday;
    /**
     * 联系人（*必填）
     */
    private String relation;
    /**
     * 联系电话（*必填）
     */
    private Long telNumber;
    /**
     * 入园时间
     */
    private String insertDate;
    /**
     * 昵称
     */
    private String nickName;

    /**
     * 联系人
     */
    private String relation2;
    /**
     * 联系电话
     */
    private Long telNumber2;

    /**
     * 家庭地址
     */
    private String familyAddress;
    /**
     * 意向级别 高中低意向、暂无意向
     */
    private String intentionLevel;

}
