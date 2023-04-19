package com.caihong.java8action.chapter1;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("lia");
        list.add("lae");
        list.add("mie");
        list.add("xie");
        testListSort(list);
    }

    private static void testListSort(List<String> list) {
        // 匿名内部类
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        // lambda
        list.sort((s1, s2) -> s1.compareTo(s2));
        list.sort((s1, s2) -> {return s1.compareTo(s2);});
        // method reference
        list.sort(String::compareTo); // 升序 [lae, lia, mie, xie]
        // 接口static方法
        list.sort(Comparator.comparing(s -> s.charAt(0)));// 升序
        System.out.println(list.toString()); //[lia, lae, mie, xie]
    }

    private static void testHiddenFile(File folder) {
        if (folder.isDirectory()) {
            File[] hiddenFiles = folder.listFiles(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isHidden();
                }
            });
        }
        File[] files = folder.listFiles(File::isHidden);
    }
}