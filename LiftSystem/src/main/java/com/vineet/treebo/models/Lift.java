package com.vineet.treebo.models;

import static com.vineet.treebo.utils.Constants.MAX_WEIGHT;

import java.util.TreeSet;

import com.vineet.treebo.utils.Direction;


public class Lift {
    public static Lift INSTANCE = new Lift();
    public static int weightThreshold = MAX_WEIGHT;
    private int currentFloor;
    private int targetFloor;
    private static boolean inTransit = false;
    private Direction direction = Direction.UP;
    private TreeSet<Integer> requestSet = new TreeSet<Integer>();

    private Lift(){
        currentFloor = 0;
    }

    public static Lift getInstance(){
        return INSTANCE;
    }

    public synchronized void addFloor(int floor){
        requestSet.add(floor);
    }

    public int getNextFloor(){
        Integer floor = null;
        if(direction == Direction.UP){
            if(requestSet.ceiling(currentFloor) != null){
                floor = requestSet.ceiling(currentFloor);
            }
            else{
                floor = requestSet.floor(currentFloor);
            }
        }
        else{
            if(requestSet.floor(currentFloor) != null){
                floor = requestSet.floor(currentFloor);
            }
            else{
                floor = requestSet.ceiling(currentFloor);
            }
        }
        if(floor != null)
            return floor;
        else
            return -1;
    }
}
