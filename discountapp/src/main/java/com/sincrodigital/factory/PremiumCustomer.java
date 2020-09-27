package com.sincrodigital.factory;

public class PremiumCustomer implements Customer{
    @Override
    public double applyDiscount(double purchaseAmount) {
        {
            double applicableDiscount = 0D;

            if(purchaseAmount>0){
                applicableDiscount = (purchaseAmount>=4000)?(4000*.10):(purchaseAmount*.10);
            }

            if(purchaseAmount>4000D){
                applicableDiscount = applicableDiscount+((purchaseAmount>=8000)?(4000*.15):(purchaseAmount-4000*.15));
            }

            if(purchaseAmount>8000D){
                applicableDiscount = applicableDiscount+((purchaseAmount>=12000)?(4000D*.20):(purchaseAmount-4000D*.20));
            }

            if(purchaseAmount>12000){
                applicableDiscount = applicableDiscount+(purchaseAmount-12000)*.30;
            }

            return applicableDiscount;

        }
    }
}
