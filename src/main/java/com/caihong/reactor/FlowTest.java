package com.caihong.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

public class FlowTest {
    public static void main(String[] args) {
//        Mono.just("hello").subscribe(System.out::println);
//        Flux.generate(() -> 1, (i, sink) -> {
//            sink.next(i << 1);
//            if (i == 9) {
//                sink.complete();
//            }
//            return i + 1;
//        }).subscribe(System.out::println);
        Mono<Integer> mono = Mono.fromSupplier(FlowTest::doSomething);
    }

    private static Integer doSomething() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
