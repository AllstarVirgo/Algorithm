package com.potato.chapter_1_practice;


/**
 * Created by allstarvirgo on 17-3-29.
 */
public class Ex1_1_20 {
    /**
     * 用递归计算N的阶乘
     * @param N
     * @return
     */
    public static double lnN(int N){
        int result=N;
        if(N==1)return Math.log(result);
        result=result*(N-1);
        return lnN(N--);
    }

    public static void main(String[] args) {
        System.out.println(lnN(5));
    }
}
