package com.stars.sea.work.bean;

import lombok.Data;
//视频分类与目标分类的关系
@Data
public class OpenkTgVideoCategoryDTO {
    private Long id;
    private String  videoCategoryCode;
    private String targetCategoryIds;
}
