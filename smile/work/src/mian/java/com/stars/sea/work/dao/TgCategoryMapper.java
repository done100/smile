package com.stars.sea.work.dao;

import com.stars.sea.work.bean.OpenKTgCategory;
import com.stars.sea.work.bean.OpenKTgTarget;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface TgCategoryMapper extends BaseMapper<OpenKTgTarget> {
    OpenKTgCategory selectCategoryById(Long id);
}
