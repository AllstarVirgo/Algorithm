package com.potato.chapter_2_practice.chapter_2_4;

/**
 * Created by AllstarVirgo on 2017/4/27.
 */
public class priorityQueueOrderArray<T extends Comparable<T>> {
    private T[] a;

    private int N;

    public priorityQueueOrderArray(int capacity) {
        a= (T[]) new Comparable[capacity];
        N=0;
    }

    public void insert(T item) {
        int index=N-1;
        for(int i=N-1;i>=0&&item.compareTo(a[i])<0;i--){
            a[i+1]=a[i];
            index=i;
        }
        a[index+1]=item;
        N++;
    }

    public T pop(){
        return a[--N];
    }

    private void exch(int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public static void main(String[] args) {
        priorityQueueOrderArray<String> priorityQueueOrderArray=new priorityQueueOrderArray(10);

        priorityQueueOrderArray.insert("a");
        priorityQueueOrderArray.insert("b");
        priorityQueueOrderArray.insert("c");
        priorityQueueOrderArray.insert("d");

        while (!priorityQueueOrderArray.isEmpty()) System.out.println(priorityQueueOrderArray.pop());

    }
}
