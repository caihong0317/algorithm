package com.caihong.mutilthread.chapter5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static Timer timer = new Timer();
    private static int count = 0;

    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            try {
                System.out.println(count + "begin, " + new Date());
                Thread.sleep(2000);
                System.out.println(count + "end, " + new Date());
                count++;
                if (count == 5) {
                    timer.cancel();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
        MyTask myTask = new MyTask();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2020-09-26 17:40:00";
        Date date = dateFormat.parse(dateStr);
        System.out.println("预定时间"+dateStr +"当前时间"+new Date());
//        timer.schedule(myTask, date,2000);
        timer.scheduleAtFixedRate(myTask, date,4000);
    }
}
