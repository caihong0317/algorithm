package com.caihong.easyexcel.write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

// 想的复杂了
public class ExcelWriteUtil2 {
    public static final String PATH = "D://excel//";
    public Map<Integer, Thread> threadMap = new ConcurrentHashMap<>(8);
    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);
    public final ArrayBlockingQueue<List<DemoData>> QUEUE = new ArrayBlockingQueue<>(3);
    public volatile boolean finish = false;
    public volatile boolean hasNext = true;
    public int count;
    public volatile AtomicInteger pageAtomic = new AtomicInteger(1);

    public ExcelWriteUtil2(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        ExcelWriteUtil2 excelWriteUtil = new ExcelWriteUtil2(10);
        long start = System.currentTimeMillis();
        excelWriteUtil.asyncWrite();
        System.out.println("耗时:" + (System.currentTimeMillis() - start) / 1000);
        EXECUTOR_SERVICE.shutdown();
    }

    public void asyncWrite() {
        Thread main = Thread.currentThread();
        for (int i = 0; i < count; i++) {
            EXECUTOR_SERVICE.execute(() -> {
                task(main);
            });
        }

        String fileName = PATH + "repeatedWrite" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            LockSupport.park();
            LockSupport.unpark(threadMap.get(1));
            while (!(finish && QUEUE.isEmpty())) {
                List<DemoData> data = QUEUE.take();
                excelWriter.write(data, writeSheet);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void task(Thread main) {
        int page = pageAtomic.getAndIncrement();
        System.out.println("page:"+page);
        if (page <= count) {
            Thread thread = Thread.currentThread();
            threadMap.put(page, thread);
            if (page == 1) {
                LockSupport.unpark(main);
            }
            List<DemoData> data = data(page);
            try {
                LockSupport.park();
                QUEUE.put(data);
                if (page < count) {
                    Thread next;
                    while ((next = threadMap.get(page + 1)) != null) {
                        LockSupport.unpark(next);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            finish = true;
        }
    }


    private List<DemoData> data(int index) {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            data.setPage(index);
            list.add(data);
        }
        return list;
    }
}
