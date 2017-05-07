package com.potato.chapter_2_practice.chapter_2_2;

import com.potato.chaptertwo.chapter2_1.Example;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by AllstarVirgo on 2017/4/24.
 */
public class Sort2distinct extends Example {
    @Override
    public void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(hi<=lo)return;
        int i=lo+1,lt=lo,gt=hi;
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

    public static void main(String[] args) {
        String s = args[0];
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = s.substring(i, i+1);
        Sort2distinct sort2distinct=new Sort2distinct();
        // sort a print results
        sort2distinct.sort(a);
        for (int i = 0; i < n; i++)
            StdOut.print(a[i]);
        StdOut.println();
    }
}
