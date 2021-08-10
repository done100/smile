package com.stars.sea.work.service.impl;

import com.stars.sea.work.dao.AiMapper;
import com.stars.sea.work.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService {
    @Autowired
    private AiMapper aIDocterMapper;
    //查询全部
    public Integer getDocterCount(){
        return this.aIDocterMapper.getDocterCount();
    }
}
