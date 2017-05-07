package com.potato.chaptertwo.chapter2_2;

import com.potato.chaptertwo.chapter2_1.Example;

/**
 * Created by AllstarVirgo on 2017/4/19.
 */
public class MergeBu extends Example {
    private Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public void sort(Comparable[] a,int lo,int hi){
        int N=a.length;
        int k=0;
        for(int i=1;i<(1+N)/2;i=i*2){
            for(int j=lo;j<N-i;j=j+2*i){
                k=j+2*i-1;
                int mid=(j+k)/2;
                merge(a,j,mid,Math.min(j+2*i-1,N-1));
            }
        }
    }

    //遍免检测两个待归并数组中的元素是否取尽
    public void mergeBreif(Comparable[] a,int lo,int mid,int hi){
        int N=a.length;
        for(int k=lo;k<=mid;k++)aux[k]=a[k];
        for(int k=mid+1;k<=hi;k++)aux[k]=a[k];
        int i=lo,j=hi;
        for(int k=lo;k<N;k++){
            if(less(aux[i],aux[j]))a[k]=a[i++];
            else a[k]=a[j--];
        }
    }


    public void merge(Comparable[] a,int lo,int mid,int hi){
        int N=a.length;
        int i=lo,j=mid+1;
        for(int k=lo;k<=hi;k++)aux[k]=a[k];
        for(int k=lo;k<=hi;k++){
            if(i>mid)a[k]=aux[j++];

            else if(j>hi)a[k]=aux[i++];
            else if(less(aux[i],aux[j]))a[k]=aux[i++];
            else a[k]=aux[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] a=new Integer[]{4,6,7,4,1,3,2};
        MergeBu mergeBu=new MergeBu();
        mergeBu.sort(a);
        assert mergeBu.isSorted(a);
        mergeBu.show(a);
    }
}
