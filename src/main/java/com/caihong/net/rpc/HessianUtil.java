package com.caihong.net.rpc;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class HessianUtil {
    public static byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Hessian2Output hessian2Output = new Hessian2Output(outputStream);
        hessian2Output.writeObject(object);
        hessian2Output.flush();
        byte[] byteArray = outputStream.toByteArray();
        hessian2Output.close();
        outputStream.close();
        return byteArray;
    }

    public static <T> T deserialize(byte[] bytes, Class<T> clazz) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        Hessian2Input hessian2Input = new Hessian2Input(inputStream);
        Object object = hessian2Input.readObject(clazz);
        hessian2Input.close();
        inputStream.close();
        return (T) object;
    }

    public static <T> T deserialize(InputStream inputStream, Class<T> clazz) throws IOException {
        Hessian2Input hessian2Input = new Hessian2Input(inputStream);
        Object object = hessian2Input.readObject(clazz);
        hessian2Input.close();
         // 这儿会导致socket关闭
//        inputStream.close();
        return (T) object;
    }
}
