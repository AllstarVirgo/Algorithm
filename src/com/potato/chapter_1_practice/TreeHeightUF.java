package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/4/17.
 */
public class TreeHeightUF implements Union_API {
    private int[] id;

    private int[] hi;

    private int count;

    public TreeHeightUF(int N) {
        count = N;
        id = new int[N];
        hi = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            hi[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot=find(p);

        int qRoot=find(q);

        if(pRoot==qRoot)return;

        if(hi[pRoot]<hi[qRoot]){
            id[pRoot]=qRoot;
        }else if(hi[pRoot]>hi[qRoot]){
            id[qRoot]=pRoot;
        }else {
            id[pRoot]=qRoot;
            hi[qRoot]++;
        }
        count--;
    }

    @Override
    public int find(int p) {
        int pCopy=p;

        while (p!=id[p])p=id[p];

        while (pCopy!=p){
            int pValue=id[pCopy];
            id[pCopy]=p;
            pCopy=pValue;
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}
