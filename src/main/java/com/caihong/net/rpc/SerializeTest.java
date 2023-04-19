package com.caihong.net.rpc;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Collections;

public class SerializeTest {

    public static void main(String[] args) throws IOException {
/*        User tom = new User(1, "Tom");
        byte[] bytes = HessianUtil.serialize(tom);
        byte[] bytes1 = JavaSerializeUtil.serialize(tom);
        byte[] bytes2 = JSON.toJSONBytes(tom);
        System.out.println(bytes.length);
        System.out.println(bytes1.length);
        System.out.println(bytes2.length);*/

//        User old = HessianUtil.deserialize(bytes, User.class);
//        System.out.println(old);
        rpc();
    }

    private static void rpc() {
        IUserService userService = StubUtil.getProxy(IUserService.class);
        User user = userService.findById(new RpcRequestBody("127.0.0.1", 8099,
            Collections.singletonList(1)));
        System.out.println(user);
    }
}
