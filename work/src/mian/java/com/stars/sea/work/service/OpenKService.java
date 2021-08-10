package com.stars.sea.work.service;

import com.stars.sea.work.bean.OpenKAuthUser;
import com.stars.sea.work.bean.OpenKTgTarget;
import com.stars.sea.work.bean.OpenKTgTatgetDTO;

import java.util.List;

public interface OpenKService {
    /**
     * 根据目标名称精确查询该目标的结构
     * （若存在多个，则说明有同名目标）
     * @param name
     * @return
     */
    List<OpenKTgTarget> getCategoryByName(String name);

    /**
     * 获取vb的vbplan文件在数据库中是否都存在该目标分类
     * @param filePath
     */
    void getCategoryPlanResult(String filePath);

    /***
     * 可多个条件查询目标结构
     * @param openKTgTatgetDTO
     * @return
     */
    List<OpenKTgTarget> getCategoryByTatget(OpenKTgTatgetDTO openKTgTatgetDTO);

    /***
     * 可多个条件查询目标对应的视频
     * @param openKTgTatgetDTO
     * @return
     */
    List<OpenKTgTarget> getVideoByTatget(OpenKTgTatgetDTO openKTgTatgetDTO);

    /**
     * 根据权限名称查询有哪些用户
     * @param roleName
     * @return
     */
    List<OpenKAuthUser> selectUserByRoleName(String roleName);

}
