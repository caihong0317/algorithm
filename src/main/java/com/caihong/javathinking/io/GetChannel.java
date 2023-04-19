package com.caihong.javathinking.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class GetChannel {
    private static final int BUFFER_SIZE = 1024;
    private static final int LENGTH = 0x8FFFFFF;

    public static void main(String[] args) throws IOException, BackingStoreException {
//        testChannel("D:\\Channel.txt");
//        channelCopy("D:\\ListTest.java", "D:\\ListTest_copy.java");
//        asChar("D:\\data.txt");

/*        Properties properties = System.getProperties();
        System.out.println(properties);*/
//        endian();
//        testScramble("helloWorld");
//        largeMap("D:\\large.txt");
        prefe("a");
        prefe("b");
        prefe("c");
    }

    public static void testChannel(String filePath) throws IOException {
        FileChannel channel = new FileOutputStream(filePath).getChannel();
        channel.write(ByteBuffer.wrap("hello".getBytes()));
        channel.close();

        channel = new RandomAccessFile(filePath, "rw").getChannel();
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap("world".getBytes()));
        channel.close();

        channel = new FileInputStream(filePath).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        channel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.println((char) buffer.get());
        }
    }

    public static void channelCopy(String srcFile, String targetFile) throws IOException {
        FileChannel in = new FileInputStream(srcFile).getChannel();
        FileChannel out = new FileOutputStream(targetFile).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        while (in.read(buffer) != -1) {
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }

    public static void transfer(String srcFile, String targetFile) throws IOException {
        FileChannel in = new FileInputStream(srcFile).getChannel();
        FileChannel out = new FileOutputStream(targetFile).getChannel();
        in.transferTo(0, in.size(), out);
//        out.transferFrom(in, 0, in.size());
    }

    public static void asChar(String filePath) throws IOException {
        FileChannel out = new FileOutputStream(filePath).getChannel();
        out.write(ByteBuffer.wrap("some text".getBytes()));
//        out.write(ByteBuffer.wrap("some text".getBytes(StandardCharsets.UTF_16BE)));
        out.close();

        FileChannel in = new FileInputStream(filePath).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        in.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer()); //乱码

        buffer.rewind();
        String charSet = System.getProperty("file.encoding");
        System.out.println(Charset.forName(charSet).decode(buffer));
    }

    public static void endian() throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[12]);
        buffer.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(buffer.array()));

        buffer.rewind();
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.asCharBuffer().put("abcdef");
//        buffer.put("abcdef".getBytes()); // 只会覆盖前6位
        System.out.println(Arrays.toString(buffer.array()));
    }

    private static void scramble(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            buffer.mark();
            char first = buffer.get();
            char second = buffer.get();
            buffer.reset();
            buffer.put(second);
            buffer.put(first);
        }
    }

    public static void testScramble(String context) {
        char[] array = context.toCharArray();
        CharBuffer buffer = ByteBuffer.allocate(array.length * 2).asCharBuffer();
        buffer.put(array);
        System.out.println(buffer.rewind());
        scramble(buffer);
        System.out.println(buffer.rewind());
        scramble(buffer);
        System.out.println(buffer.rewind());
    }

    public static void largeMap(String filePath) throws IOException {
        MappedByteBuffer map = new RandomAccessFile(filePath, "rw").getChannel()
            .map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            map.put((byte) 'x');
        }
        for (int i = (int) (0.501 * LENGTH); i < 0.502 * LENGTH; i++) {
            System.out.print((char) map.get(i));
        }
    }

    public static void prefe(String tag) throws BackingStoreException {
        Preferences preferences = Preferences.userNodeForPackage(ChannelCopy.class);
        preferences.put("tag", tag);
        preferences.put("data", LocalDate.now().toString());
        preferences.putBoolean("happy", true);
        preferences.putInt("size", 100);
        int usage = preferences.getInt("usage", 0);
        usage++;
        preferences.putInt("usage", usage);
        for (String key : preferences.keys()) {
            System.out.println(preferences.get(key, null));
        }
    }
}
