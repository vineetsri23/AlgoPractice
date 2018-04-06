package com.self.learning.random;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Code to calculate Running Median of an array
class RunningMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RunningMedianHeaps s = new RunningMedianHeaps();
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            printMedian(s,in.nextInt());
        }
        in.close();
    }

    public static void printMedian(RunningMedianHeaps s, int nextNum){
        s.addNumberInHeap(nextNum);
        System.out.printf("%.1f\n",s.getMedian());
    }

}

class RunningMedianHeaps{
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public double getMedian() {

        int size = minHeap.size() + maxHeap.size();
        if(size % 2 == 0)
            return (maxHeap.peek()+minHeap.peek())/2.0;
        return maxHeap.peek()*1.0;
    }

    private void balanceHeaps() {
        if(maxHeap.size() < minHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
        else if(maxHeap.size() > 1+minHeap.size())
        {
            minHeap.add(maxHeap.poll());
        }
    }

    public void addNumberInHeap(int num) {
        if(maxHeap.size()==0 || num <= maxHeap.peek())
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }
        balanceHeaps();
    }
}




