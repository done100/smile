package com.stars.sea.work.bean;

import lombok.Data;

//目标数据传输对象
@Data
public class OpenKTgTatgetDTO {
    private String name;
    private Long categoryId;
    private Long syllabusId;
    private Integer enabled;
    //删除（0正常，1删除）
    private Integer deleted;
}
