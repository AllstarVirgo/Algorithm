package com.potato.chaptertwo.chapter2_1;

/**
 * Created by AllstarVirgo on 2017/4/18.
 */
public class Insertion extends Example {
    @Override
    public void sort(Comparable[] a) {
      /*  //比较次数1+2+...+N-1
        //交换次数：至少0次 至多1+2+...+N-1
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0;j--){
                if (less(a[j],a[j-1]))exch(a,j,j-1);
            }
        }*/

      //比较次数：至少为N次 至多为1+2+...+N-1
        //交换次数：至少为0次，至多为1+2+...+N-1
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
}
