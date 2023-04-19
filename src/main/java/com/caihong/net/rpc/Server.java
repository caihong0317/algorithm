package com.caihong.net.rpc;

import com.caihong.net.rpc.HessianUtil;
import com.caihong.net.rpc.RpcRequestBody;
import com.caihong.net.rpc.User;
import com.caucho.hessian.io.Hessian2Output;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

public class Server {
    private static boolean RUNNING = true;
    private static final String NO_IMPL = "没有实现类";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        while (RUNNING) {
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }
        serverSocket.close();
    }

    private static void process(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            RpcRequestBody requestBody = HessianUtil.deserialize(inputStream, RpcRequestBody.class);
            String className = requestBody.getClassName();
            Class<?> aClass = Class.forName(className);
            String methodName = requestBody.getMethodName();
            Method method = aClass.getMethod(methodName, requestBody.getParameterTypes());
/*
            ServiceLoader<?> serviceLoader = ServiceLoader.load(aClass);
            Object impl = serviceLoader.findFirst().orElse(null);
            if (impl == null) {
                hessian2Output.writeBytes(NO_IMPL.getBytes());
                return;
            }
            Object object = method.invoke(impl, requestBody.getParameterList());
*/
            // TODO 假设拿到了实现类
            Object object = new User(1, "Tom");

            byte[] bytes = HessianUtil.serialize(object);
            // 报SocketException: Socket closed；因为HessianUtil.deserialize中关闭了inputStream
            outputStream.write(bytes);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown() {
        RUNNING = false;
    }
}
