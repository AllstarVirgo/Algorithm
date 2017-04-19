package com.potato.chaptertwo.chapter2_1;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class Shell extends Example {
    @Override
    public void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = 0; i < N; i++) {
                for (int j = i; j < N && (j = j + h) < N && less(a[j], a[j - h]); ) exch(a, j, j - h);
            }
            h = (h - 1) / 3;
        }
    }
}
