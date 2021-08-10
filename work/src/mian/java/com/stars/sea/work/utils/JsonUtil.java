package com.stars.sea.work.utils;

import com.alibaba.fastjson.JSONObject;
import com.stars.sea.work.bean.OpenKTgCategory;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {
    public static String map2JsonStr(Map<String,Object> map){
        return new JSONObject(map).toJSONString();
    }

    public static void main(String[] args) {
        test532();
    }

    public static void test531(){
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", "4ae74df719f249e4876ec02036ab1ea7");
        map.put("invoiceClass", "2");
        map.put("invoiceType", "1");
        map.put("invoiceState", "3");
        // map.put("invoiceCode", "4ae74df719f249e4876ec02036ab1ea7");
        // map.put("invoiceNumber", "4ae74df719f249e4876ec02036ab1ea7");
        // map.put("invoiceCheckCode", "4ae74df719f249e4876ec02036ab1ea7");
        // map.put("accountNumber", "4ae74df719f249e4876ec02036ab1ea7");
        map.put("batchNo", "0");
        System.out.println(map2JsonStr(map));
    }
    public static void test532(){
        List<OpenKTgCategory> invoiceList = new ArrayList<>();
        OpenKTgCategory info1 = new OpenKTgCategory();
        info1.setName("医疗测试0221");//开票单位名称
        info1.setTenantCode("张三");
        info1.setId(222233l);
        invoiceList.add(info1);
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", "4ae74df719f249e4876ec02036ab1ea7");
        map.put("insuranceOrgId", "222232");//机构编码
        map.put("invoiceList", invoiceList);
        System.out.println(map2JsonStr(map));
    }


}
