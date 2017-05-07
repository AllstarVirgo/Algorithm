package com.potato.chaptertwo.chapter2_3;

import com.potato.chaptertwo.chapter2_1.Example;
import edu.princeton.cs.algs4.StdRandom;


/**
 * Created by AllstarVirgo on 2017/4/21.
 */
public class Quick extends Example {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
    }

    public void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)return;
        int j=partition(a,lo,hi);
        sort(a,lo,hi-1);
        sort(a,lo,hi+1);
    }

    private int partition(Comparable[] a, int lo, int hi) {
        int i=lo,j=hi;
        Comparable v=a[lo];
        while (true){
            while (less(a[++i],v))if(i==hi)break;
            while (less(v,a[j--]))if (j==lo)break;
            if(i>=j)break;
            exch(a,i,j);
        }
        exch(a,j,lo);
        return j;
    }
}
