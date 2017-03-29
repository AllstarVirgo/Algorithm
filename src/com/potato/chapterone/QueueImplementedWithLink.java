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

    /*
    删除尾部节点
     */
    public void deleteLastNode(){
        Node nodeBeforeLast=null;
        for (Node x=first;x!=null;x=x.next){
            if(x.next.equals(last))nodeBeforeLast=x;
        }
        if(nodeBeforeLast!=null)nodeBeforeLast.next=null;
        last=nodeBeforeLast;
    }

    /**
     * 删除链表的第K个元素
     * 找到链表中第k个元素的前一个元素
     * @return
     */
    public void delete(int k){
        assert (k<=N);
        if(N==1){
            first=null;
        }
        Node x=first;
        Node nodeBeforeK=null;
        for(int i=0;i<k-1;i++){
            nodeBeforeK=x;
            x=x.next;
        }
        nodeBeforeK.next=nodeBeforeK.next.next;
    }

    /**
     * 检索给定链表中是否包含特定关键词`
     * @param link
     * @param key
     * @return
     */
    public boolean find(QueueImplementedWithLink link,String key){
        for(Node x=first;x!=null;x=x.next){
            String content= (String) x.item;
            if(content.equals(key))return true;
        }
        return false;
    }

    public void removeAfter(Node node){
        /*无指向的一串链表会被回收吗？*/
        if(node.next!=null)node.next=null;
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

    public int max(Node first){
        if(isEmpty())return 0;
        int max= (Integer) first.item;
        if(first.next==null)return max;
        max=Math.max(max,max(first.next));
        return max;
    }



    public static void main(String[] args) {
        QueueImplementedWithLink<Integer>demo=new QueueImplementedWithLink<>();
        for(int i=0;i<5;i++)demo.push(i);
        for (int i=10;i>0;i--)demo.push(i);
        System.out.println(demo.max(demo.first));
    }
}
