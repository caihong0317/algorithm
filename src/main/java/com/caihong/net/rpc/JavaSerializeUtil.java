package com.caihong.net.rpc;

import java.io.*;

public class JavaSerializeUtil {
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(outputStream);
        stream.writeObject(object);
        stream.flush();
        byte[] byteArray = outputStream.toByteArray();
        outputStream.close();
        return byteArray;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException, ClassNotFoundException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        ObjectInputStream stream = new ObjectInputStream(inputStream);
        T o = (T) stream.readObject();
        stream.close();
        inputStream.close();
        return o;
    }
}
