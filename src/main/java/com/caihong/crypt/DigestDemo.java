package com.caihong.crypt;

import java.security.MessageDigest;
import java.util.Base64;

public class DigestDemo {
    public static final String text = "我是中国人，我爱中国！";

    public static void main(String[] args) {
        // MD5: zMDy/DT25Vo+B0Pjmn6UXw==
        //SHA-1: Rqqsp+h4b018BdZISyEmyh5SDUA=
        //SHA-256: e2v7VgNalTPjYUJiMsyTkKUrocIeUS/BTu/WzwC3Bhw=
        //SHA-512: igOv11Mjph4SJD/oavVXhhY//Y4lL+rlipg6BkQPE7PuRKgTCWaQ836AGXAjQ8eMei3lBozM7IwvE9XveXyHKg==
        getDigest("MD5");
        getDigest("SHA-1");
        getDigest("SHA-256");
        getDigest("SHA-512");
    }

    private static void getDigest(String algorithm) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            byte[] digest = messageDigest.digest(text.getBytes());
            System.out.println(algorithm + ": " + new String(Base64.getEncoder().encode(digest)));
        } catch (Exception e) {

        }
    }
}
