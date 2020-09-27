package com.sincrodigital.factory;

import com.sincrodigital.models.enums.CustomerTypes;

public class CustomerFactory {

    public static Customer getCustomer(String customerType){

        if(customerType==null){
            return null;
        }

        if(customerType.equalsIgnoreCase(CustomerTypes.REGULAR.name())){
            return new RegularCustomer();
        }

        if(customerType.equalsIgnoreCase(CustomerTypes.PREMIUM.name())){
            return new PremiumCustomer();
        }

        return null;
    }
}
