package com.potato.chaptertwo.chapter2_1;

import org.junit.Test;


/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class SelectionTest {
    @Test
    public void sort() throws Exception {
        Integer[] a=new Integer[]{4,6,7,4,1,3,2};
        Selection selection=new Selection();
        selection.sort(a);
        assert selection.isSorted(a);
        selection.show(a);
    }

}