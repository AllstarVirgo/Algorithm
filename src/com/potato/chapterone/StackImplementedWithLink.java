package com.potato.chapterone;

import java.util.Iterator;

/**
 * Created by AllstarVirgo on 2017/3/28.
 */
public class StackImplementedWithLink<T> implements Iterable<T> {
    private Node first;

    private int N;


    class Node{
        private T item;
        private Node next;
    }


    public void push(T item){
        Node oldFirst=first;
        /*first的指向始终是最新添加的节点*/
       first=new Node();
       first.item=item;
       first.next=oldFirst;
       N++;
    }

    public T pop(){
        if (isEmpty())return null;
        T item=first.item;
        first=first.next;
        N--;
        return item;
    }

    public Iterator<T> iterator(){
        return new StatckIterator();
    }

    public int size(){return N;}

    public boolean isEmpty(){return first==null;}

    public T peek(){
        return first.item;
    }

    class StatckIterator implements Iterator<T>{
        @Override
        public boolean hasNext() {
           //不能写first.item??
//            return first.item!=null;
            return first!=null;
        }

        @Override
        public T next() {
            T item=first.item;
            first=first.next;
            return item;
        }
    }

    public static void main(String[] args) {
        StackImplementedWithLink<String>demo=new StackImplementedWithLink<>();
        for(int i=0;i<5;i++)demo.push(i+"");
        for (String str:demo) System.out.println(str);
    }
}
