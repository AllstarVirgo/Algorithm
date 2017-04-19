package com.potato.chaptertwo.chapter2_1;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class Selection extends Example {
    @Override
    public void sort(Comparable[] a) {
        //(N-1)+(N-2)+...+1次比较
        //N次交换
        for (int i = 0; i < a.length; i++) {
            //k总是指向最小的元素
            int k=i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[k]) < 0) k = j;
            }
            exch(a, i, k);
        }
    }
}
