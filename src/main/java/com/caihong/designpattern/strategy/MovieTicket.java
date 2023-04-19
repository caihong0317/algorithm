package com.caihong.designpattern.strategy;

public class MovieTicket {
    private double price;
    private Discount discount;

    public MovieTicket(double price, Discount discount) {
        this.price = price;
        this.discount = discount;
    }

    public double getPrice() {
        return discount.doDiscount(price);
    }
}
