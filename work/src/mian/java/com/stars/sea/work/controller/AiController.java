package com.stars.sea.work.controller;

import com.stars.sea.work.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ai")
public class AiController {
    @Autowired
    private AiService aiService;
    @RequestMapping(value = "/getDocterCount",method = RequestMethod.GET)
    public String getDocterCount() {
        return aiService.getDocterCount().toString();
    }
    @RequestMapping(value = "/getDocterCount2",method = RequestMethod.GET)
    public String getDocterCount2() {

        return "2";
    }

}
