package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/4/5.
 */
public class FourSum {
    public int count(int[] array){
        int N=array.length;
        int conut=0;
        for(int i=0;i<N;i++)
            for(int j=i+1;j<N;j++)
                for(int k=j+1;k<N;k++)
                    for(int m=k+1;m<N;m++){
                        if(array[i]+array[k]+array[k]+array[m]==0)conut++;
                    }
                    return conut;
    }
}
