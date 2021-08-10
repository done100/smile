package com.stars.sea.work.bean;

import lombok.Data;

@Data
//目标层级关系
public class OpenKTgCategory {
    private Long id;
    private String name;
    private int type;
    private Long syllabusId;
    private Long parentId;
    private String tenantCode;
    private int deleted;


}
