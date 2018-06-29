package com.swiggy.groupcart.app;

import com.swiggy.groupcart.entity.Item;
import com.swiggy.groupcart.entity.User;


public class ApplicationMain {
    public static void main(String[] args){
        User user1 = new User("1");
        User user2 = new User("2");
        User user3 = new User("3");
        User user4 = new User("4");
        User user5 = new User("5");

        Item item1 = new Item("item1", 100);
        Item item2 = new Item("item2", 110);
        Item item3 = new Item("item3", 120);
        Item item4 = new Item("item4", 130);

        user1.createCart();
        user1.inviteUser(user2);
        user1.inviteUser(user3);
        user1.inviteUser(user4);
        user1.inviteUser(user5);

        user1.addItem(item1, 2);
        user2.addItem(item1,1);
        user2.addItem(item2, 3);
        user3.addItem(item3,3);
        user4.addItem(item4,1);
        user5.addItem(item3,4);
        user3.addItem(item3, 1);

        user1.checkOut();

    }
}
