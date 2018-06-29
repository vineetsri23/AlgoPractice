package com.self.learning.random;

public class QuickUnionUF {
    private int[] id;


    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    private int root(int i ){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p , int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public static void main(String [] args){
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(4,3);
        quickUnionUF.union(3,8);
        quickUnionUF.union(6,5);
        quickUnionUF.union(9,4);
        quickUnionUF.union(2,1);
        System.out.println(quickUnionUF.connected(8,9));
        System.out.println(quickUnionUF.connected(5,4));
        quickUnionUF.union(5,0);
        quickUnionUF.union(7,2);
        quickUnionUF.union(6,1);

    }
}
