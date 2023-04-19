package com.caihong.javathinking.enumtype;

import java.util.EnumMap;
import java.util.Map;

public class AlarmMap {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> enumMap = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        enumMap.put(AlarmPoints.OFFICE, new Command() {
            @Override
            public void action() {
                System.out.println("OFFICE is fire");
            }
        });
        enumMap.put(AlarmPoints.BATHROOM, ()-> System.out.println("BATHROOM is fire"));
        for (Map.Entry<AlarmPoints, Command> entry : enumMap.entrySet()) {
            try {
                System.out.print(entry.getKey() +":");
                entry.getValue().action(); // 有异常
            } catch (Exception e){

            }
        }
    }
}
