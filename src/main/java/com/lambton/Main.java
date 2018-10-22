package com.lambton;

import com.lambton.models.*;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {

        Administrator admin = new Administrator("abc#123", "Daian", "daian@lambton.com");
        Product macbook = admin.addProductToCatalog("MacBook", 1200.0);
        Product bag  = admin.addProductToCatalog("Bag for note", 100.0);
        Product mouse = admin.addProductToCatalog("Magic mouse", 120.0);
        Product headphones = admin.addProductToCatalog("AirPods", 220.0);

        ShippingInfo shippingInfo1 = new ShippingInfo("Toronto", "ON");
        Customer customer1 = new Customer("123#abc", "Tasneem", "tasneem@lambton.com", "1234 5678", shippingInfo1);
        ShoppingCart shoppingCart1 = new ShoppingCart(customer1);
        shoppingCart1.addProduct(macbook, 1);
        shoppingCart1.addProduct(headphones, 10);
        Order order1 = shoppingCart1.checkOut();

        order1.setShippingType("Courier");
        order1.setDateShipped(new GregorianCalendar().getTime());
        order1.setStatus("Shipped");
        order1.placeOrder();

        System.out.println(order1.display());


    }
}
