package com.caihong.jianzhioffer;

import java.util.Collections;
import java.util.PriorityQueue;

// 数据流中找中位数
public class Question41 {
    public static void main(String[] args) {
        MiddleNumber middleNumber = new MiddleNumber();
        for (int i = 1; i <= 10; i++) {
            middleNumber.offer(i);
            System.out.println(middleNumber.getMiddleNumber());
        }
    }

    // 用Integer不合适
    public static class MiddleNumber {
        private int capacity;
        private static final int INIT_SIZE = 10;
        private int size = 0;
        private PriorityQueue<Double> minHeap = new PriorityQueue<>(INIT_SIZE);
        private PriorityQueue<Double> maxHeap = new PriorityQueue<>(INIT_SIZE, Collections.reverseOrder());

        public MiddleNumber() {
        }

        // 读入一个数
        public void offer(double num) {
            // 插入minHeap
            if (size % 2 == 0) {
                if (maxHeap.size() > 0 && maxHeap.peek() > num) {
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
            } else {
                if (minHeap.size() > 0 && minHeap.peek() < num) {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                } else {
                    maxHeap.offer(num);
                }
            }
            size++;
        }

        // 1.使用最大堆和最小堆，O(logn)
        public Double getMiddleNumber() {
            if (size == 0) {
                return null;
            }
            if (size % 2 == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2;
            } else {
                return minHeap.peek();
            }
        }

        public void clear() {
            size = 0;
            minHeap.clear();
            maxHeap.clear();
        }
    }
}