package com.potato.chapter_1_practice;



/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class Binary {

    //a是升序的
    public int binary(int[] a,int key){
        int lo=0,hi=a.length-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            if(key<a[mid])hi=mid-1;
            else if(key>a[mid])lo=mid+1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a=new int[]{0,1,3,5,7,9};
        int key=1;
        Binary binary=new Binary();
        int result=binary.binary(a,key);
        System.out.println(result);
    }
}
