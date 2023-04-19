package com.caihong.easyexcel.read;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class DataService {
    public boolean consume(List<DemoData> dataList) {
        for (DemoData demoData : dataList) {
            System.out.println(JSON.toJSONString(demoData));
        }
        System.out.println(dataList.size());
        return true;
    }

}
