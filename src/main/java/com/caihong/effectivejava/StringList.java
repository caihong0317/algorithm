package com.caihong.effectivejava;

import java.io.*;

// 运行报错
public final class StringList implements Serializable {
    private static final long serialVersionUID = 123L;
    private transient int size = 0;
    private transient Entry head = null;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(", ");
        Entry temp = head;
        if (temp == null) {
            return builder.toString();
        }
        while (temp != null) {
            builder.append(temp.data + " ");
            temp = temp.next;
        }
        return builder.toString();
    }

    private static class Entry {
        String data;
        Entry next;
        Entry previous;

        @Override
        public String toString() {
            return data;
        }
    }

    // 添加到末尾
    public final void add(String data) {
        size++;
        Entry newEntry = new Entry();
        newEntry.data = data;
        newEntry.next = null;
        Entry temp = head;
        if (temp == null) {
            newEntry.previous = null;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        newEntry.previous = temp;
    }

    private void readObject(ObjectInputStream oi) throws IOException, ClassNotFoundException {
        oi.defaultReadObject(); // ?
        int number = oi.readInt();
        for (int i = 0; i < number; i++) {
            add((String) oi.readObject());
        }
    }

    private void writeObject(ObjectOutputStream oo) throws IOException {
        oo.defaultWriteObject();
        oo.writeInt(size);
        for (Entry entry = head; entry != null; entry = entry.next) {
            oo.writeObject(entry.data);
        }
    }

    public static void main(String[] args) {
        StringList stringList = new StringList();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        serial(stringList);
        StringList read = read("d://serial.txt");
        System.out.println(read);
    }

    private static void serial(StringList stringList) {
        try (OutputStream out = new FileOutputStream("d://serial.txt")) {
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            stringList.writeObject(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringList read(String filePath) {
        try (InputStream in = new FileInputStream("d://serial.txt")) {
            ObjectInputStream inputStream = new ObjectInputStream(in);
            StringList stringList = new StringList();
            stringList.readObject(inputStream);
            return stringList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
