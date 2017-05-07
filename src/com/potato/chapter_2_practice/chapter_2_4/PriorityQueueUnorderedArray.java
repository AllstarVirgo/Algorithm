package com.potato.chapter_2_practice.chapter_2_4;

/**
 * Created by AllstarVirgo on 2017/4/27.
 */
public class PriorityQueueUnorderedArray<T extends Comparable<T>> {
    private StackArray<T>stackArray;

    public PriorityQueueUnorderedArray(StackArray<T> stackArray) {
        this.stackArray = stackArray;
    }

    public void insert(T item){
        stackArray.push(item);
    }

    public T delMax(){
        int n=stackArray.size();

        stackArray.exchBoundaryAndMax();

        return stackArray.pop();
    }

    public static void main(String[] args) {
        StackArray<String>stringStackArray=new StackArray<>();

        PriorityQueueUnorderedArray<String> priorityQueueUnorderedArray = new PriorityQueueUnorderedArray<>(stringStackArray);


    }


}
