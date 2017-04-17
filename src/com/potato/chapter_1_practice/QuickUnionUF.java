package com.potato.chapter_1_practice;

/**
 * Created by AllstarVirgo on 2017/4/17.
 */
public class QuickUnionUF implements Union_API {
    private int count;

    private int[] id;

    public QuickUnionUF(int N) {
        count=N;
        id=new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IndexOutOfBoundsException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    @Override
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pRoot=find(p);
        int qRoot=find(q);

        if(pRoot==qRoot)return;

        id[pRoot]=qRoot;

        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        int pCopy=p;
        while (p!=id[p])p=id[p];
        //压缩路径，使自P遍历的节点指向根节点
        while (pCopy!=id[pCopy]){
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
}
