package com.stars.sea.work.service.impl;

import com.alibaba.fastjson.JSON;
import com.stars.sea.work.bean.*;
import com.stars.sea.work.dao.AuthUserMapper;
import com.stars.sea.work.dao.TgCategoryMapper;
import com.stars.sea.work.dao.TgTargetMapper;
import com.stars.sea.work.dao.TgVideoCategoryMapper;
import com.stars.sea.work.service.OpenKService;
import com.stars.sea.work.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenKServiceImpl implements OpenKService {
    @Autowired

    private TgTargetMapper tgTargetMapper;
    @Autowired
    private TgVideoCategoryMapper tgVideoCategoryMapper;
    @Autowired
    private TgCategoryMapper tgCategoryMapper;
    @Autowired
    private AuthUserMapper authUserMapper;

    @Override
    public List<OpenKTgTarget> getCategoryByName(String name) {
        return tgTargetMapper.getCategoryByName(name);
    }

    @Override
    public void getCategoryPlanResult(String filePath) {
        String planJson = FileUtil.decode(FileUtil.readFile(filePath));
        List<VbPlan> vbPlan = JSON.parseArray(planJson, VbPlan.class);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < vbPlan.size(); i++) {
            OpenKTgCategory openKTgTarget = tgCategoryMapper.selectCategoryById(Long.parseLong(vbPlan.get(i).getCategoryId()));
            if (openKTgTarget == null) {
                count++;
                System.out.println(vbPlan.get(i).getCategoryName());
            }
            for (int i1 = 0; i1 < vbPlan.get(i).getCategoryList().size(); i1++) {
                OpenKTgCategory openKTgTarget1 = tgCategoryMapper.selectCategoryById(Long.parseLong(vbPlan.get(i).getCategoryList().get(i1).getCategoryId()));
                System.out.println(vbPlan.get(i).getCategoryList().get(i1).getCategoryName());
                if (openKTgTarget1 == null) {
                    count++;
                }
                sum++;
            }
           // sum++;
        }
        System.out.println("该文件总层级数：" + sum);
        System.out.println("当前目标库不存在的层级数：" + count);

    }

    @Override
    public List<OpenKTgTarget> getCategoryByTatget(OpenKTgTatgetDTO openKTgTatgetDTO) {
        return tgTargetMapper.getCategoryByTatget(openKTgTatgetDTO);
    }

    @Override
    public List<OpenKTgTarget> getVideoByTatget(OpenKTgTatgetDTO openKTgTatgetDTO) {
        List<OpenKTgTarget> list = tgTargetMapper.getCategoryByTatget(openKTgTatgetDTO);
        if (list != null) {
            for (OpenKTgTarget itemTarget : list) {
                Long categoryId = itemTarget.getCategoryId();
                if (categoryId != null) {
                    OpenkTgVideoCategoryDTO openkTgVideoCategoryDTO = tgVideoCategoryMapper.selectVideoCodeByIds(itemTarget.getCategoryId().toString());

                } else {
                    break;
                }
                OpenKTgCategory openKTgTarget = tgCategoryMapper.selectCategoryById(categoryId);
            }
        }
        return null;
    }

    @Override
    public List<OpenKAuthUser> selectUserByRoleName(String roleName) {
        return authUserMapper.selectUserByRoleName(roleName);
    }

}
