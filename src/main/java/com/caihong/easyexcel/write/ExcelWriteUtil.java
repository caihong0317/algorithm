package com.caihong.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

// 一个Excel不能并发写，EasyExcel自然不支持。性能瓶颈在于查询慢
// 如果查一批写一批如此循环，自然慢。可以多个线程查（读），一个线程写出。找最佳的读线程数
// 把问题想的复杂了，线程池自带阻塞式的任务队列(顺序执行），只需限制池中线程数量，就能控制加载到内存中的数据量;
public class ExcelWriteUtil {
    public static final String PATH = "D://excel//";
    public static final int threadCount = 6;
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(threadCount);
    public final List<Future<List<DemoData>>> futureList;
    public int count;

    public ExcelWriteUtil(int count) {
        this.count = count;
        this.futureList = new ArrayList<>(count);
    }

    public static void main(String[] args) {
        // 查询耗时0.5s时
        // 3线程，50次 -> 9s
        // 4线程，50次 -> 7s
        // 6线程，50次 -> 5s

        // 查询耗时6s时
        // 6线程，50次 -> 5s
        ExcelWriteUtil excelWriteUtil = new ExcelWriteUtil(50);
        long start = System.currentTimeMillis();
        excelWriteUtil.asyncWrite();
        System.out.println("耗时:" + (System.currentTimeMillis() - start) / 1000);
        EXECUTOR_SERVICE.shutdown();
    }

    public void asyncWrite() {
        for (int i = 0; i < count; i++) {
            Future<List<DemoData>> future = EXECUTOR_SERVICE.submit(new QueryCallable(i));
            futureList.add(future);
        }

        String fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            List<DemoData> data;
            for (Future<List<DemoData>> future : futureList) {
                data = future.get();
                excelWriter.write(data, writeSheet);
                data.clear();
            }
        } catch (InterruptedException |
                ExecutionException e) {
            e.printStackTrace();
        }
    }

    private class QueryCallable implements Callable<List<DemoData>> {

        public QueryCallable(int page) {
            this.page = page;
        }

        private int page;

        @Override
        public List<DemoData> call() throws Exception {
            return data(page);
        }
    }

    private List<DemoData> data(int index) throws InterruptedException {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 100; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            data.setPage(index);
            list.add(data);
        }
        Thread.sleep(6);
        return list;
    }
}
