package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/3/30.
 */
public class Ex1_1_22 {
    private static int count=0;

    public static int rank(int key,int[] a,int lo,int hi){
        count++;
        if(lo>hi)return -1;
        int mid=lo+(hi-lo)/2;
        System.out.print(indent(count));
        System.out.printf("lo: %d hi: %d\n",lo,hi);
        if(key<a[mid])return rank(key,a,lo,mid-1);
        else if(key>mid)return rank(key,a,mid+1,hi);
        return mid;
    }

    public static String indent(int n){
        String result=null;
        for(int i=0;i<n;i++)result+=" ";
        return result;
    }

}
