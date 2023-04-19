package com.caihong.designpattern.simplefactory;

import com.caihong.designpattern.util.XMLUtil;

public class Client {
    private static final ClassLoader LOADER = Client.class.getClassLoader();
    public static void main(String[] args) {
        String path = LOADER.getResource("product.xml").getPath();
        String name = XMLUtil.getProductName(path);
        AbstractProduct product=Factory.getProduct(name);
        product.diff();
    }
}
