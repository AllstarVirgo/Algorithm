package com.potato.chaptertwo.chapter2_1;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public abstract class Example {
    public abstract void sort(Comparable[] a);

    protected boolean less(Comparable v,Comparable w){return v.compareTo(w)<0;}

    protected void exch(Comparable[] a,int i,int j){Comparable t=a[i];a[i]=a[j];a[j]=t;}

    protected void show(Comparable[] a){for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");}

    protected boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++)
            if(less(a[i],a[i-1]))return false;
        return true;
    }

}
