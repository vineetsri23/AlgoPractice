package com.swiggy.groupcart.entity;

import java.util.concurrent.ConcurrentHashMap;


public class User {
    private final String id;
    private Cart cart;


    public User(final String id) {this.id = id;}


    public void addItem(final Item item, final int quantity) {
        if (quantity != 0) {
            if (null != cart.getUserItemMap().get(this)) {
                if (cart.getUserItemMap().get(this).containsKey(item)) {
                    Integer userItemMapQuantity = cart.getUserItemMap().get(this).get(item);
                    cart.getUserItemMap().get(this).remove(item);
                    cart.getUserItemMap().get(this).put(item, userItemMapQuantity + quantity);
                } else {
                    cart.getUserItemMap().get(this).put(item, quantity);
                }
            } else {
                ConcurrentHashMap<Item, Integer> itemMap = new ConcurrentHashMap<Item, Integer>();
                itemMap.put(item, quantity);
                cart.getUserItemMap().put(this, itemMap);
            }
        } else {
            System.out.println("Item quantity can't be zero");
        }
    }


    public void removeItem(final Item item) {
        if (null != cart.getUserItemMap().get(this)) {
            Integer userItemMapQuantity = cart.getUserItemMap().get(this).get(item);
            if (userItemMapQuantity != 0) {
                cart.getUserItemMap().get(this).remove(item);
            }
        }
    }


    public void inviteUser(final User user) {
        if (this == cart.getAdminUser()) {
            cart.addUsers(user);
            user.setCart(this.cart);
        } else {
            System.out.println("You can't invite user as you are not admin of this Group Cart");
        }
    }


    public void createCart() {
        if (null == cart) {
            cart = new Cart(this);
        } else {
            System.out.println(
                    "Cart is already present. Either you are part of Group Cart or checkif you own a cart already");
        }
    }


    private void setCart(final Cart cart) {
        this.cart = cart;
    }


    public void checkOut() {
        if (this == cart.getAdminUser()) {
            for (User user : cart.getUserItemMap().keySet()) {
                for (Item item : cart.getUserItemMap().get(user).keySet()) {
                    System.out.print("User:" +user.id + " : ");
                    System.out.println(
                            item.getName() + ":" + item.getPrice() + ":" + cart.getUserItemMap().get(user).get(item));
                }
            }
        } else {
            System.out.println("You can't checkout this cart as you are not Admin User");
        }
    }
}
