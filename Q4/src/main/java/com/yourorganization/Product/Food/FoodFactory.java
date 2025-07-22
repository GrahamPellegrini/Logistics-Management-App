package com.yourorganization.Product.Food;

import com.yourorganization.Product.Supplier;

public class FoodFactory {

    // Factory method for creating different types of food items based on the subtype
    public static Food createFood(int subtype, String id, String name, Supplier supplier, 
                                  int packagingUnits, double price, String expirationDate, boolean isOrganic, String additionalInfo) {
        switch (subtype) {
            case 1:
                String contents = additionalInfo; // additionalInfo is contents for CannedFood
                return new CannedFood(id, name, supplier, packagingUnits, price, expirationDate, isOrganic, contents);
            case 2:
                String type = additionalInfo; // additionalInfo is type for Fruit
                return new Fruit(id, name, supplier, packagingUnits, price, expirationDate, isOrganic, type);
        
            default:
                System.out.println("Unknown food subtype: " + subtype);
                return null;
        }
    }
}
