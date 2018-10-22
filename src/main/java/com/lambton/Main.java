package com.lambton;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.lambton.models.*;
import com.lambton.utils.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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

        ShoppingCart shoppingCart2 = new ShoppingCart(customer1);
        shoppingCart2.addProduct(macbook, 1);
        shoppingCart2.addProduct(headphones, 10);
        Order order2 = shoppingCart1.checkOut();

        order2.setShippingType("Courier");
        order2.setDateShipped(new GregorianCalendar().getTime());
        order2.setStatus("Shipped");
        order2.placeOrder();


        StringBuilder builder = new StringBuilder();
        builder.append(order1.display())
                .append(order2.display());
        System.out.println(builder.toString());
        FileUtils.writeToPdf(builder.toString());


    }
}
