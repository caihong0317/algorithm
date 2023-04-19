package com.caihong.java8action.part3.chapter8;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleLambda {
    private static final Logger LOGGER = Logger.getLogger("aaa");

    public static void main(String[] args) {
/*
        doSomething((Task) () -> System.out.println("hello"));
        example2();
*/
//        System.out.println(handleWork("Lambda     is really      terse and efficient!     ")); // 白写了
        testProcessing();

        System.out.println(lamdbaLink("Lambda     is really      terse and efficient!   "));
    }

    private static void testProcessing() {
        FirstProcessing firstProcessing = new FirstProcessing();
        SecondProcessing secondProcessing = new SecondProcessing();
        firstProcessing.setSuccessor(secondProcessing);
        String str = firstProcessing.handle("Lambda     is really      terse and efficient!"); // 不是调用handleWork
        System.out.println(str);
    }

    private static void example1() {
        int a = 10;
/*
        // a已经存在，不能屏蔽包含类的变量
        Runnable runnable1 = () -> {
            int a = 2;
            System.out.println(a);
        };
*/

        new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };
    }

    private static void example2() {
        String oneLine = processFile(br -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        });

        String twoLine = processFile(br -> {
            try {
                return br.readLine() + br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        });

        System.out.println(oneLine);
        System.out.println(twoLine);
    }

    public static void doSomething(Runnable runnable) {
        runnable.run();
    }

    public static void doSomething(Task task) {
        task.execute();
    }

    public void log(Level level, Supplier<String> msgSupplier) {
        if (LOGGER.isLoggable(level)) {
            LOGGER.log(level, msgSupplier.get());
        }
    }

    public static String processFile(BufferedReaderProcessor p){
        try (BufferedReader br = new BufferedReader(new FileReader("d:/words.txt"))) {
            return p.process(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected static String handleWork(String input) {
        return input.replaceAll("\\s+", " ").trim();
    }

    // 使用lamdba实现责任链
    protected static String lamdbaLink(String input) {
        UnaryOperator<String> headerProcessing =
            (String text) -> "            Fantastic! " + text;
        UnaryOperator<String> spellCheckerProcessing =
            (String text) -> text.replaceAll("\\s+", " ").trim();
        Function<String, String> pipeline =
            headerProcessing.andThen(spellCheckerProcessing);
        return pipeline.apply(input);
    }
}