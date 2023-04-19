package com.caihong;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(11, 1);
        map.put(3, 3);
        map.put(6, 6);
        map.put(20, 20);
        map.put(55, 55);
        map.put(23, 23);
        map.put(17, 17);
        System.out.println("TreeMap:" + map.firstKey());

        SortedMap<Integer, Integer> tailMap = map.tailMap(60);
        System.out.println("tailMap:" + tailMap.firstKey());
        System.out.println("----");
        for (Map.Entry<Integer, Integer> entry : tailMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
