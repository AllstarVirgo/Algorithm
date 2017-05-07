package com.potato.chaptertwo.chapter2_3;

import com.potato.chaptertwo.chapter2_1.Example;

/**
 * Created by AllstarVirgo on 2017/4/23.
 */
//基于普通2切分快速排序解决大量主键重复的情况
public class Quick3way extends Example{
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)return;
        int lt=lo,i=lo+1,gt=hi;
        Comparable v=a[lo];
        while (i<=gt){
            int cmp=a[i].compareTo(v);
            if(cmp<0)exch(a,lt++,i++);
            else if(cmp>0)exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }
}
