package com.caihong.easyexcel.read;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoDataListener implements ReadListener<DemoData> {
    /**
     * 每隔5消费，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 4;
    private final List<DemoData> cacheList = new ArrayList<>(BATCH_COUNT);
    private DataService dataService;

    private int emptyLineCount;

    public DemoDataListener(DataService dataService) {
        this.dataService = dataService;
        this.emptyLineCount = 0;
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return emptyLineCount <= 5;
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        throw exception;
    }

    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
        cacheList.add(demoData);
        if (isEmpty(demoData)) {
            emptyLineCount++;
        } else {
            emptyLineCount = 0;
        }
        if (cacheList.size() >= BATCH_COUNT) {
            boolean flag = dataService.consume(new ArrayList<>(cacheList));
            cacheList.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        boolean flag = dataService.consume(cacheList);
        cacheList.clear();
        System.out.println("完成");
    }

    private boolean isEmpty(DemoData demoData) {
        return demoData.getString() == null && demoData.getDate() == null && demoData.getDoubleData() == null;
    }

    @Override
    public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext context) {
        System.out.println("表头" + JSON.toJSONString(headMap));
    }
}
