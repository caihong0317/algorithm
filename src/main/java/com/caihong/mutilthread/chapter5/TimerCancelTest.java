package com.caihong.mutilthread.chapter5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerCancelTest {
    private static int count= 0;
    static public class MyTask extends TimerTask{
        @Override
        public void run() {
            System.out.println("正常执行 "+count);
        }
    }

    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();
        MyTask myTask = new MyTask();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2020-09-26 17:11:00";
        Date date = dateFormat.parse(dateStr);
        while (true){
            count++;
            timer.schedule(myTask,date);
            timer.cancel();
        }
    }
}
