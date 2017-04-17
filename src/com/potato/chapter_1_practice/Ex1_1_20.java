package com.potato.chapter_1_practice;


/**
 * Created by allstarvirgo on 17-3-29.
 */
public class Ex1_1_20 {
    /**
     * 用递归计算N的阶乘
     * 求log(N!)
     * log(!N)=log(N)+log((N-1)!)
     * @param N Ns是正整数
     * @return
     */
    public static double lnN(int N){
       if(N==1)return Math.log(1);
       return Math.log(N)+lnN(--N);
    }

    public static void main(String[] args) {
        System.out.println(lnN(60));
    }
}
