package com.potato.chapter_1_practice;

import java.util.NoSuchElementException;

/**
 * Created by AllstarVirgo on 2017/3/31.
 */
 class Josephus {
    public static void main(String[] args) {
        CirQueue<Integer>cirQueue=new CirQueue<>();
        for(int i=0;i<7;i++)cirQueue.append(i);
        cirQueue.takeUntilOne(2);
    }
}

/**
 * 实现对任意链表的删除 需要用到双向链表
 *
 * @param <T>
 */
public class CirQueue<T> {
    private Node first;

    private Node last;

    private int N;

    class Node {
        Node next;

        Node prev;

        T item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void append(T item) {
        Node x = new Node();
        x.item = item;
        if (isEmpty()) {
            first = x;
        } else {
            //使x的下一个节点指向首节点
            x.next = first;
            first.prev = x;
            last.next = x;
            x.prev = last;
        }
        last = x;
        N++;
    }

    public void takeUntilOne(int offset) {
        if (isEmpty()) throw new NoSuchElementException("queue is empty!");
        Node start = first;
        Node result = start;
        while (N != 1) {
            if (offset > N) offset = offset % N;
            //找到相应偏移量的元素
            for (int i = 0; i < offset; i++) {
                result = start;
                start = start.next;
            }
            System.out.print(result.item.toString()+" ");
            take(result);
        }
        System.out.print(first.item.toString());
    }

    public T take(Node node) {
        if (isEmpty()) throw new NoSuchElementException("queue is empty!");
        //维护头尾指针
        if (node == first) return removeFirst();

        else if (node == last) return removeLast();
        else {
            T item = node.item;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = node.next = null;
            N--;
            return item;
        }
    }

    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty!");
        T item = first.item;
        if (N == 1) {
            last = first = null;
        } else {
            Node afterFirst = first.next;

            afterFirst.prev = last;

            last.next = afterFirst;

            first.next = first.prev = null;
            //改变头指针
            first = afterFirst;
        }
        N--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("queue is empty!");
        T item = last.item;
        if (N == 1) last = null;
        else {
            Node beforeLast = last.prev;
            beforeLast.next = first;
            first.prev = beforeLast;
            last.next = last.prev = null;
            //前移尾指针
            last = beforeLast;
        }
        N--;
        return item;
    }



}

