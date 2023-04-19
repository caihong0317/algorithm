package com.caihong.javathinking.enumtype;

import java.util.EnumSet;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> alarmPoints = EnumSet.noneOf(AlarmPoints.class);
        alarmPoints.add(AlarmPoints.OFFICE);
        alarmPoints.addAll(EnumSet.of(AlarmPoints.BATHROOM, AlarmPoints.LOBBY));
        System.out.println(alarmPoints);
        EnumSet<AlarmPoints> points = EnumSet.complementOf(alarmPoints); // 补集
        System.out.println(points);
    }
}
