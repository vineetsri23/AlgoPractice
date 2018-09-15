package com.vineet.treebo.models;

public class User {
    private int id;
    private int weight;
    private int targetFloor;

    private User() {
     //do nothing
    }

    public User(int id, int weight, int targetFloor){
        this.id = id;
        this.weight = weight;
        this.targetFloor = targetFloor;
    }


    private int getTargetFloor() {
        return targetFloor;
    }


    private int getWeight() {
        return weight;
    }


    private int getId() {
        return id;
    }
}
