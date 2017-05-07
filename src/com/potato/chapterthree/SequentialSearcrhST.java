package com.potato.chapterthree;

import java.util.Iterator;

/**
 * Created by AllstarVirgo on 2017/5/4.
 */
public class SequentialSearcrhST<Key, Value> {
    private Node first;

    private int N;

    class Node {
        Key key;

        Value value;

        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(Key key, Value value) {
        boolean hasKey = false;
        Node t = first;
        for (; t != null; t = t.next) {
            if (t.key.equals(key)) {
                t.value = value;
                hasKey = true;
            }
        }
        if (!hasKey) {
            first = new Node(key, value, first);
        }

    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) return x.value;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void delete(Key key) {
        assert !isEmpty();
        for (Node x = first; x != null && x.next != null; x = x.next) {
            if (x.next.key.equals(key)) {
                x.next = null;
                x.next = x.next.next;
            }
        }
    }

    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            @Override
            public Iterator<Key> iterator() {
                return new Iterator<Key>() {
                    Node current = first;

                    @Override
                    public boolean hasNext() {
                        return current.next != null;
                    }

                    @Override
                    public Key next() {
                        return current.next.key;
                    }
                };
            }
        };
    }
}
