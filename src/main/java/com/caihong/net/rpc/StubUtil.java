package com.caihong.net.rpc;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class StubUtil {

    public static final byte[] BUFFER = new byte[1024 * 2];

    public static <T> T getProxy(Class clazz) {
        // 注意，不能用clazz.getInterfaces() 或clazz.getClasses()
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new RpcInvocation());
        return (T) o;
    }

    static class RpcInvocation implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            RpcRequestBody requestBody = (RpcRequestBody) args[0];
            Socket socket = new Socket(requestBody.getIpAddr(), requestBody.getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            String className = method.getDeclaringClass().getName();
            requestBody.setClassName(className);
            requestBody.setMethodName(method.getName());
            requestBody.setParameterTypes(method.getParameterTypes());
            byte[] outArray = HessianUtil.serialize(requestBody);
            out.write(outArray);
            out.flush();

/*
            // Integer.MAX_VALUE 导致Requested array size exceeds VM limit
            byte[] inBytes = new byte[1024 * 10];
            int count = 0;
            int length;
            while ((length = in.read(BUFFER)) != -1) {
                for (int i = 0; i < length; i++) {
                    count++;
                    inBytes[count + i] = BUFFER[i];
                }
            }
            Object o = HessianUtil.deserialize(inBytes, method.getReturnType());
*/
            // TODO 假设BUFFER可容下
            int length = in.read(BUFFER);
            // com.caucho.hessian.io.HessianProtocolException: expected map/object at java.lang.String ();因为BUFFER为空
            Object o = HessianUtil.deserialize(BUFFER, method.getReturnType());
            socket.close();
            return o;
        }
    }
}
