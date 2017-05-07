package com.potato.chaptertwo.chapter2_1;

/**
 * Created by AllstarVirgo on 2017/4/26.
 */
public class ArrayTest {
    public static void main(String[] args) {
        Integer[] test=new Integer[2];
        for(int i=0;i<2;i++)test[i]=i;
        System.out.println(test.length);
        test[1]=null;
        System.out.println(test.length);
    }
}
