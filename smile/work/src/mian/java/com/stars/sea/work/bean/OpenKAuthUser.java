package com.stars.sea.work.bean;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class OpenKAuthUser {

    private static final long serialVersionUID = 1L;
    private Long id;
    /**
     * 租户
     */
    private String tenantCode;

    /**
     * 账号
     */
    private String account;

    /**
     * 姓名
     */
    private String name;

    /**
     * 组织ID
     *
     *
     */

    private Long orgId;


    /**
     * 岗位ID
     */

    private Long stationId;
    /**
     * 是否内置
     */
    private Boolean readonly;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;
    /**
     * 性别
     * #Sex{W:女;M:男;N:未知}
     */
    private String sex;
    /**
     * 是否上课教师
     * 0:非上课教师
     * 1：上课教师
     */
    private Boolean postType;







    /**
     * 状态
     * 1启用 0禁用
     */
    private int status;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 民族
     *
     */

    private String nation;

    /**
     * 学历
     *
     */
    private  String education;

    /**
     * 职位状态
     *
     */
    private String positionStatus;

    /**
     * 工作描述
     * 比如：  市长、管理员、局长等等   用于登陆展示
     */
    private String workDescribe;

    /**
     * 最后一次输错密码时间
     */
    private LocalDateTime passwordErrorLastTime;

    /**
     * 密码错误次数
     */
    private Integer passwordErrorNum;

    /**
     * 密码过期时间
     */
    private LocalDateTime passwordExpireTime;

    /**
     * 密码
     */
    private String password;



    /**
     * openId
     */

    private String openId;

    /**
     * openId
     */

    private String clientId;


    /**
     * 管辖校区ID,以逗号分割
     */
    private String governCampusId;

    /**
     * 默认管辖校区Id
     */
    private Long defaultGovernCampusId;

    /**
     * 可跨校区上课，以逗号分割
     */
    private String acrossCampusId;

    /**
     * 授课类型，逗号分割
     */
    private String teachingType;

    /**
     * 身份证号码
     */
    private String identityCard;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 地址
     */
    private String address;

    /**
     * 婚姻状况 0:未婚 1:未婚 2:离异
     */
    private  String maritalStatus;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 毕业院校
     */
    private String graduatedCollege;

    /**
     * 入职日期
     */
    private LocalDate hiredate;

    /**
     * 离职日期
     */
    private LocalDate departureTime;

    /**
     * 备注
     */

    private String remark;

    /**
     * 个人证书
     */
    private String certificate;


    /**
     * 职级
     */

    private String positionLevel;
    private int deleted;
}
