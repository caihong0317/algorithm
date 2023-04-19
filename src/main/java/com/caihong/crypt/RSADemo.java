package com.caihong.crypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

/**
 * 可将秘钥写入文件
 */
public class RSADemo {
    public static final String content = "彩虹";

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        String algorithm = "RSA";
        KeyPairGenerator instance = KeyPairGenerator.getInstance(algorithm);
        KeyPair keyPair = instance.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        PublicKey aPublic = keyPair.getPublic();
        byte[] privateEncoded = aPrivate.getEncoded();
        byte[] publicEncoded = aPublic.getEncoded();
        System.out.println(new String(Base64.getEncoder().encode(privateEncoded)));
        System.out.println(new String(Base64.getEncoder().encode(publicEncoded)));

        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, aPrivate);
        byte[] bytes = cipher.doFinal(content.getBytes());
        System.out.println(new String(Base64.getEncoder().encode(bytes)));
        cipher.init(Cipher.DECRYPT_MODE, aPublic);
        byte[] bytes2 = cipher.doFinal(bytes);
        System.out.println(new String(bytes2));
    }
}
