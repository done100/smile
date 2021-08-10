package com.stars.sea.work.dao;

import com.stars.sea.work.bean.OpenkTgVideoCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TgVideoCategoryMapper {
    OpenkTgVideoCategoryDTO selectVideoCodeByIds(String id);
}
