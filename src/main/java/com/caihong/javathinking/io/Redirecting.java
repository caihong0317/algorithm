package com.caihong.javathinking.io;

import java.io.*;

public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\DirFilterTest.java"));
        PrintStream out = new PrintStream(new FileOutputStream("D:\\out.txt"));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line); // 并不打印在控制台，而是out.txt
        }
        out.close();
        in.close();
        System.setOut(console);
    }
}