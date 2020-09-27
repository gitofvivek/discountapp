package com.sincrodigital.services;

import com.sincrodigital.factory.Customer;
import static com.sincrodigital.factory.CustomerFactory.getCustomer;

import com.sincrodigital.utils.CalculationUtility;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Override
    public Double purchase(String customerType, double purchaseAmount) {

        Customer customer= getCustomer(customerType);
        double applicableDiscount = customer.applyDiscount(purchaseAmount);
        double billAmount = CalculationUtility.calculateBiilingAmount(applicableDiscount, purchaseAmount);
        return billAmount;

    }
}
