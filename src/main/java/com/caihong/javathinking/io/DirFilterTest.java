package com.caihong.javathinking.io;

import java.io.File;

public class DirFilterTest {
    public static void main(String[] args) {
        File file = new File("d:");
        if (file.isDirectory()) {
            file.list();
        }
    }
}
