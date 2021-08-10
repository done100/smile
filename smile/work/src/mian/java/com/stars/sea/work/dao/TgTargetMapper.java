package com.stars.sea.work.dao;

import com.stars.sea.work.bean.OpenKTgTarget;
import com.stars.sea.work.bean.OpenKTgTatgetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;
@Mapper
public interface TgTargetMapper extends BaseMapper<OpenKTgTarget> {
    /**
     * 根据目标名称精确查询该目标的结构
     * （若存在多个，则说明有同名目标）
     * @param name
     * @return
     */
    List<OpenKTgTarget> getCategoryByName(String name);

    /***
     * 可多个条件查询目标结构
     * @param openKTgTatgetDTO
     * @return
     */
    List<OpenKTgTarget> getCategoryByTatget(@Param("target") OpenKTgTatgetDTO openKTgTatgetDTO);
}
