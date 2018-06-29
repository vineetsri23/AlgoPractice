package com.swiggy.groupcart.entity;


import lombok.Getter;


@Getter
public class Item {
    private final String name;
    private final int price;


    public Item(final String name, final int price) {
        this.name = name;
        this.price = price;
    }
}
