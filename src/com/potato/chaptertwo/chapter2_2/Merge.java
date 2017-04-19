package com.potato.chaptertwo.chapter2_2;

import com.potato.chaptertwo.chapter2_1.Example;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class Merge extends Example {

    private Comparable[] aux;

    /**
     * 把两段各自有序的元素归并成一组有序的元素
     * @param a
     * @param lo
     * @param mid
     * @param hi
     * @return
     */
    private void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo,j=mid+1;

        //将a[lo...hi]复制到aux[lo...hi]
        for(int k=lo;k<=hi;k++)aux[k]=a[k];

        for (int k=lo;k<=hi;k++) {
            if (less(a[i], a[j])) aux[k] = a[i++];
            else if (i > mid) aux[k] = a[j++];
            else if (j > hi) aux[k] = a[i++];
            else a[k] = a[j++];
        }
    }

    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private void sort(Comparable[] a,int lo,int hi){
        if(lo>=hi)return;
        int mid=(lo+hi)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
}
