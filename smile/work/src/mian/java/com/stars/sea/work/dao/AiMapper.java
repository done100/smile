package com.stars.sea.work.dao;


import com.stars.sea.work.bean.AiOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface AiMapper extends BaseMapper<AiOrderInfo> {
    Integer getDocterCount();
}
