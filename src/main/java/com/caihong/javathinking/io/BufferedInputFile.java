package com.caihong.javathinking.io;

import java.io.*;

public class BufferedInputFile {
    public static void main(String[] args) throws IOException {
        String content = read("D:\\DirFilterTest.java");
//        System.out.println(content);

/*
        StringReader reader = new StringReader(content);
        int c;
        while ((c=reader.read())!=-1){
            System.out.println((char) c);
        }
*/

/*
        DataInputStream in = new DataInputStream(new ByteArrayInputStream(content.getBytes()));
        while (in.available()!=0){
            System.out.println((char) in.readByte());
        }
*/
//        testPrintWriter(content);
//        testData();
//        testSystemIn();
        testSystemOut();
    }

    public static String read(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line).append("\n");
        }
        reader.close();
        return builder.toString();
    }

    public static void testPrintWriter(String content) throws IOException {
        String filePath = "D:\\DirFilterTest_copy.java";
        BufferedReader reader = new BufferedReader(new StringReader(content));

        PrintWriter printWriter = new PrintWriter(filePath);
        int lineCount = 1;
        String line;
        while ((line = reader.readLine()) != null) {
            printWriter.println(lineCount++ + ": " + line); // 写入到BufferedWriter中
        }
        printWriter.close();
    }

    public static void testData() throws IOException {
        String filePath = "D:\\data.txt";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filePath)));
        out.write(100);
        out.writeBoolean(true);
        out.writeByte(62);
        out.writeDouble(3.14);
        out.close();

        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
        System.out.println(in.readBoolean()); //会跳过非布尔值
        System.out.println(in.readBoolean());
    }

    public static void testSystemIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null && line.length() > 0) {
            System.out.println(line); // nothing
        }
    }

    public static void testSystemOut() throws IOException {
        PrintWriter writer = new PrintWriter(System.out, true);
        writer.println("hello");
        writer.close();
    }
}