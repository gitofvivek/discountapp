package com.sincrodigital.factory;

public class RegularCustomer implements Customer{

    @Override
    public double applyDiscount(double purchaseAmount){
        double applicableDiscount = 0D;

        if(purchaseAmount>5000D){
            applicableDiscount = (purchaseAmount>=10000)?(5000*.10):(purchaseAmount-5000*.10);
        }

        if(purchaseAmount>10000D){
            applicableDiscount = applicableDiscount+(purchaseAmount-10000)*.20;
        }

        return applicableDiscount;
    }
}
