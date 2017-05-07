package com.potato.chapter_2_practice;

/**
 * Created by AllstarVirgo on 2017/5/6.
 * 基于有序数组的二分查找
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;

    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys= (Key[]) new Object[capacity];
        values= (Value[]) new Object[capacity];
    }

    private int rank(Key key){
        int lo=0,hi=N-1;
        while (lo<=hi){
            int mid=(lo+hi)/2;
            int result=key.compareTo(keys[mid]);
            if(result<0)hi=mid-1;
            else if(result>0)lo=mid+1;
            else return mid;
        }
        return lo;
    }

    public int size(){return N;}

    public boolean isEmpty(){return N==0;}

    public void put(Key key,Value val){
        /*resize array is  to do...*/
        assert N<keys.length;
        int j=rank(key);
        if(j<N&&keys[j]==key){
            values[j]=val;
            return;
        }
        for(int i=N;i>j;i--){
            keys[i]=keys[i-1];
            values[i]=values[i-1];
        }
        values[j]=val;
        keys[j]=key;
        N++;
    }

    public boolean contains(Key key){
        int j=rank(key);
        return keys[j]==key;
    }

}
