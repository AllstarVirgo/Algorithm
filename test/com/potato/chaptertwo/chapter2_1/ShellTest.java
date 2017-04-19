package com.potato.chaptertwo.chapter2_1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class ShellTest {
    @Test
    public void sort() throws Exception {
        Integer[] a=new Integer[]{4,6,7,4,1,3,2};
        Shell shell= new Shell();
        shell.sort(a);
        assert shell.isSorted(a);
        shell.show(a);
    }

}