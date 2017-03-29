package com.potato.chapter_1_practice;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class ResizingArrayQueueOfStrings<T> implements Iterable<T> {
    private T[] queue;

    private int N;
    //point to the head
    private int first;

    private int last;

    private int size;

    public ResizingArrayQueueOfStrings(int size) {
        this.size=size;
        queue= (T[]) new Object[size];
    }

    private T[] resize(int max){
        T[] newArray= (T[]) new Object[max];
        for(int i=0;i<last;i++){
            newArray[i]=queue[(first+i)];
        }
        queue=newArray;
        first=0;
        last=N;
        return queue;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorQueue();
    }

    class IteratorQueue implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return N>0;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return queue[first++];
        }
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(T item){
        if(last==size-1){
            size=2*size;
            resize(size);
        }
        queue[last++]=item;
        N++;
    }

    public T popWithPointer(){
        if (isEmpty())throw new NoSuchElementException("stack overflow");
        T item=queue[first++];
        queue[first-1]=null;
        N--;
        if(N==(1/4*size))resize(1/2*size);
        return item;
    }

    public T pop(){
        T item=null;
       if(N==1){
           item=queue[0];
           queue[0]=null;
           N=0;
       }else if(N>1){
           item=queue[0];
           for(int i=0;i<N-1;i++){
               queue[i]=queue[i+1];
               --N;
               if(N==(1/4*size))resize(1/2*size);
           }
       }else return null;
       return item;
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<String>(2);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.push(item);
            else if (!queue.isEmpty()) StdOut.print(queue.popWithPointer() + " ");
        }
        StdOut.println("(" + queue.size + " left on queue)");
    }
    }



