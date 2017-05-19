package com.potato.chapterthree.chapter3_5;

import edu.princeton.cs.algs4.ST;

/**
 * Created by potato on 2017/5/19.
 */
public class SET<Key extends Comparable<Key>> {
    private ST<Key,Object> st;

    public SET() {
        st=new ST<>();
    }

    public void add(Key key){
        if(key==null)throw new NullPointerException("键为空");
        else st.put(key,null);
    }

    public void delete(Key key){
        st.delete(key);
    }

}
