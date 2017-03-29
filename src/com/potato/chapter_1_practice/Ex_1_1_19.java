package com.potato.chapter_1_practice;

/**
 * Created by allstarvirgo on 17-3-29.
 */
public class Ex_1_1_19 {
    public static long f(int N){
        if(N==0)return 0;
        if(N==1)return 1;
        return f(N-1)+f(N-2);
    }

    public static long Fib(int N)
    {
        long[] f = new long[N+1];
        return Fib(N, f);
    }

    public static long Fib(int N,long[] f){
        if (f(N) == 0)
        {
            if (N == 1)
                f[N] = 1;
            else if (N > 1)
                f[N] = Fib(N-1, f) + Fib(N-2,f);
        }

        return f[N];
    }

    public static void main(String[] args) {
        for(int N=0;N<100;N++)
            System.out.println(N+" "+Fib(N));
    }
}
