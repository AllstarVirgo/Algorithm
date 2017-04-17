package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/3/30.
 * 用环形链表实现Queue
 *
 */

/**
 * 重写方法，仅用一个Node节点实现环形链表
 * @param <T>
 */
public class Ex1_3_29<T> extends CircleQueue{
    @Override
    public void enqueue(Object item) {
        Node x=new Node();
        x.item=item;
        if (isEmpty()) {
            last.next = x;
        }else {
            x.next=last.next;
            last.next=x;
        }
        last=x;
        N++;
    }

    @Override
    public Object dequeue() {
        T item= (T) last.next.item;
        if(last.next==last)last=null;
        else
        last.next=last.next.next;
        N--;
        return item;
    }
}

class CircleQueue<T>{
    protected int N;

    protected Node last;

    private Node first;

    class Node{
        Node next;
        T item;
    }

    public boolean isEmpty(){return N==0;}

    public void enqueue(T item){
        Node oldLast=last;
        last=new Node();
        if(isEmpty())first=last;
        else oldLast.next=last;
        last.item=item;
        last.next=first;
        N++;
    }

    public T dequeue(){
        Node oldFirst=first;
        T item=oldFirst.item;
        first=oldFirst.next;
        oldFirst=null;
        last.next=first;
        N--;
        return item;
    }

}
