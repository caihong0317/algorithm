package com.caihong.algorithm.hashtable;

// 选取哈希函数
public class HashFaction {

    // hash1
    public static int hash1(String key, int size) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal += key.charAt(i);
        }
        return hashVal % size;
    }

    // 好的hash2
    public static int hash2(String key, int size) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }
        hashVal %= size;
        if (hashVal < 0) {
            hashVal += size;
        }
        return hashVal;
    }
}
