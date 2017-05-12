package com.potato.chapterthree.chapter3_3;

/**
 * Created by AllstarVirgo on 2017/5/11.
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED=true;

    private static final boolean BLACk=false;

    private class Node{
        Key key;
        Value val;
        Node left,right;
        int N;
        boolean color;

        public Node(Key key, Value val, Node left, Node right, int N,boolean color) {
            this.key = key;
            this.val = val;
            this.left = left;
            this.right = right;
            this.color = color;
            this.N=N;
        }

    }

    private boolean isRed(Node x){
        return x.color==RED;
    }

    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        x.color=h.color;
        x.N=h.N;
        h.N=1+size(h.left)+size(h.right)+1;
        return x;
    }

    private int size(Node x) {
        if(x==null)return 0;
        else return x.N;
    }


}
