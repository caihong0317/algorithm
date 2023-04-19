package com.caihong.crypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class DESDemo {
    public static final String cbc = "CBC";
    public static final String des = "DES";
    public static final String desCbc = "DES/CBC/PKCS5Padding";
    public static final String aes = "AES";
    public static final String aesCbc = "AES/CBC";
    public static final String desKey = "12345678";
    public static final String aesKey = "12345678abcdefgh";
    public static final String originText = "尚硅谷";

    public static void main(String[] args) {
        // DES: Lw8VauTNFI/YeXnPdAh/2g==
        desTest(des, des);
        // DES/CBC/PKCS5Padding: F9Z1ZOlxkORBC7K8TjK+PA==
        desTest(des, desCbc);
//        aesTest(aes, aes);
//        aesTest(aes, aesCbc);
    }

    private static void desTest(String algorithm, String transfor) {
        try {
            Cipher cipher = Cipher.getInstance(transfor);
            SecretKeySpec keySpec = new SecretKeySpec(desKey.getBytes(), algorithm);
            if (transfor.contains(cbc)) {
                IvParameterSpec iv = new IvParameterSpec(desKey.getBytes());
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            }
            byte[] encrypts = cipher.doFinal(originText.getBytes());
            System.out.println(transfor + ": " + new String(Base64.getEncoder().encode(encrypts)));

            if (transfor.contains(cbc)) {
                IvParameterSpec iv = new IvParameterSpec(desKey.getBytes());
                cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
            }
            byte[] decrypts = cipher.doFinal(encrypts);
            // 居然没乱码
            System.out.println(new String(decrypts));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void aesTest(String algorithm, String transfor) {
        try {
            Cipher cipher = Cipher.getInstance(transfor);
            SecretKeySpec keySpec = new SecretKeySpec(aesKey.getBytes(), algorithm);
            if (transfor.contains(cbc)) {
                IvParameterSpec iv = new IvParameterSpec(desKey.getBytes());
                cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
            } else {
                cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            }
            byte[] encrypts = cipher.doFinal(originText.getBytes());
            System.out.println(transfor + ": " + new String(Base64.getEncoder().encode(encrypts)));

            if (transfor.contains(cbc)) {
                IvParameterSpec iv = new IvParameterSpec(desKey.getBytes());
                cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, keySpec);
            }
            byte[] decrypts = cipher.doFinal(encrypts);
            // 居然没乱码
            System.out.println(new String(decrypts));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
