package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class ResizingArratQueueOfStrings<T> {
    private T[] queue;

    private int N;

    private int size;

    private T[] resize(int max){
        T[] newArray= (T[]) new Object[max];
        for(int i=0;i<size;i++){
            newArray[i]=queue[i];
        }
        return newArray;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public void push(T item){
        if(N==size)resize(2*size);
        queue[N++]=item;
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


}
