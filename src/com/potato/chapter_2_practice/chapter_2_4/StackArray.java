package com.potato.chapter_2_practice.chapter_2_4;

/**
 * Created by AllstarVirgo on 2017/4/27.
 */
public class StackArray <T extends Comparable<T>> {
    private T[] a;

    private int N;

    public boolean isEmpty(){return N==0;}

    public int size(){return N;}

    public T pop(){
        assert !isEmpty();
        /*N是数组元素中的个数而非索引*/
        return a[--N];
    }

    public void push(T item){
        a[N++]=item;
    }

    public T getBoundary(){
        return a[N];
    }

    public void exchBoundaryAndMax(){
        exch(getMax(),N);
    }

    private void exch(int i,int j){
        T temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public int getMax(){
        assert !isEmpty();
        Comparable max=a[0];
        int result=0;
        for(int i=1;i<N;i++){
            if (max.compareTo(a[i])<0){
                max=a[i];
                result=i;
            }
        }
        return result;
    }
}
