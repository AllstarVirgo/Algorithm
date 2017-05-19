package com.potato.chapter_2_practice;

/**
 * Created by AllstarVirgo on 2017/5/6.
 * 基于有序数组的二分查找
 *
 * Modified by potato on 2017/5/19
 * 修改二叉树BST,允许在树中保存重复的键。对于get()方法，返回给定键所关联的任意值，对于delete()
 * 方法，删除树种所有和给定键相等的节点
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

/*    public void put(Key key,Value val){
        *//*resize array is  to do...*//*
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
    }*/

    public void put(Key key,Value val){
        /*resize array is  to do...*/
        assert N<keys.length;
        int j=rank(key);
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

    public void delete(Key key){
        assert !isEmpty();
        int j=rank(key);
        if(j<N&&keys[j]==key){
            for(;j<N-1;j++){
                keys[j]=keys[j+1];
                values[j]=values[j+1];
            }
            keys[N-1]=null;
            values[N-1]=null;
            N--;
        }
    }

    /**
     * 小于等于key的最大键
     * @param key
     * @return
     */
    public Key floor(Key key){
        int j=rank(key);
        if (keys[j]==key)return key;
        if(j==0)return null;
        else return keys[j-1];
    }

}
