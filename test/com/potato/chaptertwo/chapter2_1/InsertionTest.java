package com.potato.chaptertwo.chapter2_1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class InsertionTest {
    @Test
    public void sort() throws Exception {
        Integer[] a=new Integer[]{4,6,7,4,1,3,2};
        Insertion insertion=new Insertion();
        insertion.sort(a);
        assert insertion.isSorted(a);
        insertion.show(a);
    }

}