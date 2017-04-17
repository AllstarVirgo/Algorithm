package com.potato.chapter_1_practice;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by AllstarVirgo on 2017/3/30.
 */
public class DoubleLinkedList<T> implements Iterable<T> {
    private DoubleNode first;

    private DoubleNode last;

    private int N;

    public DoubleLinkedList(T[] item) {
        for (T t : item)
            insertNodeInTail(t);
    }

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    private class DoubleNode {
        // private DoubleLinkedList<T>parent=list();

        private DoubleNode next;

        private DoubleNode prev;

        private T item;
    }

    private DoubleLinkedList<T> list() {
        return this;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private DoubleNode current = first;

            @Override
            public boolean hasNext() {
                return N != 0;
            }

            @Override
            public T next() {
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertMpdeInHead(T item) {
        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            first.prev = x;
            x.next = first;
            first = x;
        }
    }

    public void insertNodeInTail(T item) {

        DoubleNode x = new DoubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            x.prev = last;
            last = x;
        }
        N++;
    }

    public T deleteNodeFromHead() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        T item = (T) first.item;
        if (N == 1) first = null;
        else first = first.next;
        first.prev = null;
        N--;
        return item;
    }

    public T first() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return (T) first.item;
    }

    public T last() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return (T) last.item;
    }

    public T deleteNodeFromTail() {
        if (isEmpty()) throw new RuntimeException("List is empty");
        T item = (T) last.item;
        if (N == 1) last = null;
        else last = last.prev;
        last.next = null;
        N--;
        return item;
    }

    public void insertBeforeSpecificNode(DoubleNode specificNode, T item) {
        DoubleNode newNode = new DoubleNode();
        newNode.item = item;
        DoubleNode prevOfSpNode = specificNode.prev;
        prevOfSpNode.next = newNode;
        newNode.prev = prevOfSpNode;
        newNode.next = specificNode;
        specificNode.prev = newNode;
    }

    public T deleteSpecificNode(DoubleNode specificNode) {
        if (specificNode == first) return deleteNodeFromHead();

        else if (specificNode == last) return deleteNodeFromTail();

        else {
            DoubleNode nodePrevSpeNode = specificNode.prev;
            DoubleNode nodeAfterSpeNode = specificNode.next;
            nodePrevSpeNode.next = nodeAfterSpeNode;
            nodeAfterSpeNode.prev = nodePrevSpeNode;
            specificNode.prev = null;
            specificNode.next = null;
            N--;
            return (T) specificNode.item;
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this)
            s.append(item + " ");
        return s.toString();
    }

    /**********
     * Unit tests
     *********/
    private static void testPrepend() {
        StdOut.println("prepend:");

        int[] a = {2, 4, 6, 8, 10};
        DoubleLinkedList<Integer> lst = new DoubleLinkedList<>();

        for (int i = 0; i < a.length; i++)
            lst.insertMpdeInHead(a[i]);
//        showList(lst);
        StdOut.println();
    }

    private static void testAppend() {
        StdOut.println("append:");

        int[] a = {2, 4, 6, 8, 10};
        DoubleLinkedList<Integer> lst = new DoubleLinkedList<>();

        for (int i = 0; i < a.length; i++)
            lst.insertNodeInTail(a[i]);
        showList(lst);
        StdOut.println();
    }

    private static void testRemoveFirst() {
        StdOut.println("removeFirst:");
        DoubleLinkedList<Integer> lst = new DoubleLinkedList<>(new Integer[]{6, 8, 12});
        StdOut.println(lst + "[initial]\n");

        while (!lst.isEmpty()) {
            StdOut.println("removeFirst(): " + lst.deleteNodeFromHead());
//            showList(lst);
        }
        StdOut.println();
    }


    /*******************
     * Unit test helpers
     *******************/

    private static void showList(DoubleLinkedList lst) {
        StdOut.println(lst);

        if (!lst.isEmpty())
            StdOut.printf("Size: %d, First: %s, Last: %s\n\n", lst.size(), lst.first(), lst.last());
        else
            StdOut.printf("Size: %d\n\n", lst.size());
    }


    public static void main(String[] args) {
        testAppend();
    }

}
