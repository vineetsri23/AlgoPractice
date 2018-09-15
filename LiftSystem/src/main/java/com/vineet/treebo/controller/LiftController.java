package com.vineet.treebo.controller;

import java.util.HashMap;
import java.util.Map;

import com.vineet.treebo.models.Lift;
import com.vineet.treebo.models.User;


public class LiftController {
    private Lift lift;
    private Map<Integer,User> inTransitUsers = new HashMap<Integer, User>();
    private Map<Integer,User> waitingUsers = new HashMap<Integer, User>();


}
