package com.potato.chapterone;

import java.util.Iterator;


/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class ReverseArrayIterator<T> implements Iterator<T>,Iterable<T> {
    private T[] a;

    private int size;

    private int n;


    public ReverseArrayIterator(int size) {
        this.size = size;
        a= (T[]) new Object[size];
    }

    @Override
    public Iterator<T> iterator() {
//        return new ArrayIterator();
        return this;
    }

    @Override
    public boolean hasNext() {
        return n>0;
    }

    @Override
    public T next() {
        return a[--n];
    }


    public void push(T item){
        if(n==size)resize(2*size);
        a[n++]=item;
    }

    public void resize(int max){
        T[] temp= (T[]) new Object[max];
        for(int i=0;i<temp.length;i++){
            temp[i]=a[i];
        }
    }

    public T pop(){
        if(n==(1/4*size))resize(1/2*size);
        T item=a[--n];
        return item;
    }

    private class ArrayIterator implements Iterator<T>{
        private int i=n;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        ReverseArrayIterator<Integer>demo=new ReverseArrayIterator<>(5);
        for(int i=0;i<5;i++){
            demo.push(i);
//            System.out.println(demo.pop());
        }
        for(Integer integer:demo) System.out.println(integer.toString());
    }
}
