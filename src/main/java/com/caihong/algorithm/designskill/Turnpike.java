package com.caihong.algorithm.designskill;

import com.caihong.algorithm.priorityQueue.BinaryHeap;

import java.util.ArrayList;
import java.util.List;

//回溯-高速公路
public class Turnpike {
    public boolean turnpike(int[] array, BinaryHeap<Integer> d,int n){
        array[0]=0;
        array[n]=d.deleteMax();
        array[n-1]=d.deleteMax();
        int temp = array[n] - array[n - 1];
        if (d.contains(temp)) {
            d.remove(temp);
            return place(array,d,n,2,n-2);
        }else {
            return false;
        }
    }

    private boolean place(int[] array, BinaryHeap<Integer> d, int n, int left, int right) {
        boolean found=false;
        if (d.isEmpty()) {
            return true;
        }
        int max=d.findMax();

        List<Integer> temp = new ArrayList<>(n);

        found=allContains(array, d, n, left, right, true, max, temp);
        if (found){
            array[right]=max;
            for (Integer x : temp) {
                d.remove(x);
            }
            found=place(array,d,n,left,right-1);
            // backtrack
            if(!found){
                for (Integer x : temp) {
                    d.insert(x);
                }
                array[right]=0;
            }
        }
        // try other choice
        if(!found){
            temp.clear();
            found= allContains(array, d, n, left, right, true, array[n]-max, temp);
            if (found){
                array[left]=array[n]-max;
                for (Integer x : temp) {
                    d.remove(x);
                }
                found=place(array,d,n,left+1,right);
                // 无需再回溯，无解
/*
                if(!found){
                    for (Integer x : temp) {
                        d.insert(x);
                    }
                    array[left]=0;
                }
*/
            }
        }
        return found;
    }

    private boolean allContains(int[] array, BinaryHeap<Integer> d, int n, int left, int right, boolean found, int max, List<Integer> temp) {
        for (int i = 1; i < left; i++) {
            int x = Math.abs(array[i] - max);
            if (!d.contains(x)) {
                found = false;
                break;
            }
            temp.add(x);
        }
        if (found) {
            for (int i = right + 1; i <= n; i++) {
                int x = Math.abs(array[i] - max);
                if (!d.contains(x)) {
                    found = false;
                    break;
                }
                temp.add(x);
            }
        }
        return found;
    }
}
