package com.stars.sea.work.dao;

import com.stars.sea.work.bean.OpenKAuthUser;
import com.stars.sea.work.bean.OpenKTgTarget;
import com.stars.sea.work.bean.OpenKTgTatgetDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface AuthUserMapper extends BaseMapper<OpenKAuthUser> {
    /**
     * 根据角色名字查询有多少用户
     *
     * @param name
     * @return
     */
    List<OpenKAuthUser> selectUserByRoleName(String name);

}
