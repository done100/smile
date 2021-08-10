package com.stars.sea.work.controller;

import com.stars.sea.work.bean.OpenKTgTarget;
import com.stars.sea.work.bean.OpenKTgTatgetDTO;
import com.stars.sea.work.common.ResponseVO;
import com.stars.sea.work.service.OpenKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/openK")
public class OpenKController {
    @Autowired
    private OpenKService openKService;

    @RequestMapping(value = "/getCategoryByName", method = RequestMethod.GET)
    public ResponseVO getCategoryByName(@RequestParam("name") String name) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<OpenKTgTarget> list = openKService.getCategoryByName(name);
            if (list!=null&&list.size() > 0) {
                responseVO.setSize(list.size());
                responseVO.setData(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setMsg(e.getMessage());
        }
       return responseVO;
    }
    @RequestMapping(value = "/getCategoryByTatget", method = RequestMethod.GET)
    public ResponseVO getCategoryByTatget( OpenKTgTatgetDTO openKTgTatgetDTO) {
        ResponseVO responseVO = new ResponseVO();
        try {
            List<OpenKTgTarget> list = openKService.getCategoryByTatget(openKTgTatgetDTO);
            if (list!=null&&list.size() > 0) {
                responseVO.setSize(list.size());
                responseVO.setData(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setMsg(e.getMessage());
        }
        return responseVO;
    }
    @RequestMapping(value = "/getCategoryPlanResult", method = RequestMethod.GET)
    public ResponseVO getCategoryPlanResult(@RequestParam("filePath") String filePath) {
        ResponseVO responseVO = new ResponseVO();
        try {
            filePath="E:\\chromeFile\\赵明的推荐教学计划（2021-07-30）.vbplan";
            openKService.getCategoryPlanResult(filePath);

        } catch (Exception e) {
            e.printStackTrace();
            responseVO.setMsg(e.getMessage());
        }
        return responseVO;
    }
}
