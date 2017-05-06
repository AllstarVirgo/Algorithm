package com.potato.chapter_2_practice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by AllstarVirgo on 2017/5/6.
 */
public class ArrayST <Key,Value>{
    private Key[] keys;

    private Value[] values;

    private int N;

    public ArrayST(int capacity) {
        keys= (Key[]) new Object[capacity];
        values= (Value[]) new Object[capacity];
        N=0;
    }

    public void put(Key key,Value val){
        for(int i=0;i<N;i++)if(key.equals(keys[i])){
            values[i]=val;
            return;
        }
        values[N]=val;
        keys[N]=key;
        N++;
    }

    public Value get(Key key){
        for(int i=0;i<N;i++){
            if (keys[i].equals(key))return values[i];
        }
        return null;
    }

    public void delete(Key key){
        assert !isEmpty();

        int index=-1;

        for(int i=0;i<N;i++){
            if(key.equals(keys[i]))index=i;
        }
        /**
         * 无序数组是否一定要要用
         *  values[j]=values[j+1];
         keys[j]=keys[j+1];
         归位数组元素
         */
        if(index!=-1){
            for (int j=index;j<N-1;j++){
                values[j]=values[j+1];
                keys[j]=keys[j+1];
            }
            N--;
        }
    }

    public boolean contains(Key key){
        for(int i=0;i<N;i++){
            if(keys[i].equals(key))return true;
        }
        return false;
    }

    public boolean isEmpty(){return N==0;}

    public int size(){return N;}

    public Iterable<Key>keys(){
        Queue<Key>q=new LinkedList<Key>();
        for(int i=0;i<N;i++){
            q.add(keys[i]);
        }
        return q;
    }
}
