package com.potato.chapterthree.chapter3_4;

import com.potato.chapterthree.SequentialSearcrhST;

/**
 * Created by potato on 2017/5/18.
 */
public class SeparateChainingHashST<Key,Val> {
    /**
     * 键值对总数
     */
    private int N;
    /**
     * 散列表的大小
     */
    private int M;
    /**
     * 存放链表对象的数组
     */
    private SequentialSearcrhST<Key,Val>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int capacity) {
        M=capacity;
        N=0;
        st=(SequentialSearcrhST<Key,Val>[])new SequentialSearcrhST[capacity];
        for(int i=0;i<capacity;i++){
            st[i]=new SequentialSearcrhST<Key, Val>();
        }

    }

    public int hashCode(Key key) {
        return (key.hashCode()&0x7fffffff)%M;
    }

    public Val get(Key key){
        return (Val)(st[hashCode(key)].get(key));
    }

    public void put(Key key,Val val){
        st[hashCode(key)].put(key,val);
    }


}
