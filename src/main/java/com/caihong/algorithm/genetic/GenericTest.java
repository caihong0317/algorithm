package com.caihong.algorithm.genetic;

public class GenericTest {
    public static void main(String[] args) {
        //testMemoryCell();
        testGenericMemoryCell();
    }

    public static void testMemoryCell(){
        MemoryCell memoryCell = new MemoryCell();
        memoryCell.write("hello");
        String value = (String) memoryCell.read();

        System.out.println(value);
        String[] array= {"a","b","c"};
        String str="c";
        //此处指定contains()方法的泛型为String
        boolean flag = memoryCell.contains(array, str);
        System.out.println(flag);
    }

    public static void testGenericMemoryCell(){
        GenericMemoryCell<Integer> cell = new GenericMemoryCell<>();
        //cell.write("123");会报错
        cell.write(123);

        String[] array= {"a","b","c"};
        String str="c";
        //不受<Integer>限制
        boolean flag = cell.contains(array, str);
        System.out.println(flag);

        //cell.contains2(array,str) 报错
        Integer[] intArray={1,2,3};
        Integer num = Integer.valueOf(3);
        boolean flag2 = cell.contains2(intArray, num);
        System.out.println(flag2);
    }
}
