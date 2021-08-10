package com.stars.sea.work.service.impl;

import com.stars.sea.work.bean.OpenKAuthUser;
import com.stars.sea.work.service.OpenKService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class OpenKServiceImplTest {
    @Autowired
    private OpenKService openKService;
    @org.junit.jupiter.api.Test
    void getCategoryPlanResult() {
        String filePath="E:\\chromeFile\\赵明的推荐教学计划（2021-07-30）.vbplan";
        openKService.getCategoryPlanResult(filePath);

    }

    /**
     * 根据权限名称查询授权了哪些用户
     */
    @org.junit.jupiter.api.Test
    void selectUserByRoleName() {
        String roleName="业务端功能";
        List<OpenKAuthUser> list= openKService.selectUserByRoleName(roleName);
        System.out.println(list.size());
        System.out.println(list);

    }
}