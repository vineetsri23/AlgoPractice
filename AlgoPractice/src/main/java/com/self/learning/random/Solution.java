package com.self.learning.random;

class Solution {
    public static final long ONE_MILLION = 1000000;
    public static final int LIMIT = 1000000000;

    public int solution(int[] A, int[] B) {
        if (A.length < 2) { return 0;}
        int numberOfMP = 0;
        int lowIndex = 0;
        int highIndex = A.length-1;

        if (A[0] == 0 && B [0] == 0) {
            int index = 1;
            int increaseAmount = 1;
            while (A[index] == 0 && B[index] == 0) {
                numberOfMP += increaseAmount;
                increaseAmount++;
            }

        }

        while(lowIndex < highIndex){
            //don't convert to double to avoid precision errors
            long C_low = convertValue(A[lowIndex], B[lowIndex]);
            long C_high;
            //avoid useless calculations for values we already know will fail
            if(C_low >= ONE_MILLION) {
                C_low = convertValue(A[lowIndex], B[lowIndex]);
                C_high = convertValue(A[highIndex], B[highIndex]);
                //note that since both inputs to the product were scaled, we need to scale the sum twice
                //not a scaleable solution...
                if( C_low * C_high >= (C_low + C_high) * ONE_MILLION) {
                    numberOfMP += highIndex - lowIndex;
                    highIndex--;
                }else{
                    lowIndex++;
                }
            }else{
                lowIndex++;
            }
        }

        if (numberOfMP > LIMIT) {
            return LIMIT;
        }
        return numberOfMP;
    }

    private long convertValue(int a, int b) {
        return (long) a * ONE_MILLION + (long) b;
    }
    public static void main(String[] args) {
        int[] A = {
                0,
                1,
                2,
                3,
                4,
                5
        };
        int[] B = {
                500000,
                500000,
                0,
                0,
                0,
                20000
        };
        Solution solution = new Solution();
        solution.solution(A,B);
    }
}
    /*public int solution(int[] A) {
        // write your code in Java SE 8
        int minTillHere = A[0];
        int absMinTillHere = A[0];
        int misSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            absMinTillHere = Math.min(Math.abs(A[i]), Math.abs(minTillHere + A[i]));
            minTillHere = Math.min(A[i], minTillHere + A[i]);
            misSoFar = Math.min(Math.abs(misSoFar), absMinTillHere);
        }
        return misSoFar;
    }


    public static void main(String[] args) {
        int[] A = {
                2,
                -4,
                6,
                -3,
                9
        };
        Solution solution = new Solution();
        solution.solution(A);
    }
}*/
    /*public int solution(IntList L) {
        // write your code in Java SE 8
        if(null == L){
            return 0;
        }

        return 1 + solution(L.next);
    }
    public static void main(String[] args){
        IntList node = new IntList();
        node.value = 0;
        node.next = null;
        IntList prevNode = node;
        for(int i=1;i<1000;i++){
            IntList node1 = new IntList();
            node1.value =i;
            node1.next=null;
            prevNode.next=node1;
            prevNode = node1;
        }
        Solution solution = new Solution();
        System.out.println(solution.solution(node));
    }
}

class IntList {
    public int value;
    public IntList next;
}
*/