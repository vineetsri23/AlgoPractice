package com.vineet.treebo.processors;

import java.util.Scanner;

import com.vineet.treebo.models.Lift;


public class RequestListener implements Runnable {
    public void run() {
        Scanner sc = new Scanner(System.in);
        Lift lift = Lift.getInstance();
        while (true){
            int requestFloor = sc.nextInt();
            lift.addFloor(requestFloor);
        }
    }
}
