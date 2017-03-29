package com.potato.chapterone;

import java.util.Iterator;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class QueueImplementedWithLink<T> implements Iterable<T> {
    private int N;

    private Node first;

    private Node last;
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<T>{
        @Override
        public boolean hasNext() {
            return first!=null;
        }

        @Override
        public T next() {
           T item=first.item;
           first=first.next;
           return  item;
        }
    }

    public boolean isEmpty() {
        return first==null;
    }

    class Node{
        T item;
        Node next;
    }

    public void push(T item){
        //表尾添加元素
     Node oldLast=last;
     last=new Node();
//     oldLast.next=last;
     last.item=item;
     //last.next=null?
     last.next=null;
     if(isEmpty())first=last;
     else oldLast.next=last;
     N++;
    }

    public T dequeue(){
        //表头删除元素
        T item=null;
        if(!isEmpty()) item=first.item;
        first=first.next;
        N--;
        return item;
    }

    public static void main(String[] args) {
        QueueImplementedWithLink<Integer>demo=new QueueImplementedWithLink<>();
        for(int i=0;i<5;i++)demo.push(i);
        for(Integer integer:demo) System.out.println(integer);
    }
}
