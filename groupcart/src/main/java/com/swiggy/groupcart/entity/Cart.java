package com.swiggy.groupcart.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Cart {
    private final static ConcurrentHashMap<User, ConcurrentHashMap<Item, Integer>> userItemMap =
            new ConcurrentHashMap();
    private final List<User> userList;
    private User adminUser;


    public Cart(User user) {
        adminUser = user;
        userList = new ArrayList<User>();
    }


    public boolean addUsers(User user) {
        if (this.userList.contains(user)) {
            System.out.println("User is already added");
            return false;
        } else {
            this.userList.add(user);
            return true;
        }
    }


    public User getAdminUser() {
        return adminUser;
    }


    public Map<User, ConcurrentHashMap<Item, Integer>> getUserItemMap() {
        return userItemMap;
    }
}
