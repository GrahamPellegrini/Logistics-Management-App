package com.yourorganization.Product.Furniture;

import com.yourorganization.Product.Supplier;
public class FurnitureFactory {

    // Factory method for creating different types of furniture items based on the subtype
    public static Furniture createFurniture(int subtype, String id, String name, Supplier supplier, 
                                            int packagingUnits, double price, String material, String dimensions, String additionalInfo) {
        switch (subtype) {
            case 1:
                boolean hasArmrests = Boolean.parseBoolean(additionalInfo); // additionalInfo is hasArmrests for Chair
                // Use of Boolean.parseBoolean(): not null and is equal to the string "true" {ignoring case}, then the method returns true. Otherwise, it returns false.
                return new Chair(id, name, supplier, packagingUnits, price, material, dimensions, hasArmrests);
            case 2:
                String shape = additionalInfo; // additionalInfo is shape for Table
                return new Table(id, name, supplier, packagingUnits, price, material, dimensions, shape);
            
            default:
                System.out.println("Unknown furniture subtype: " + subtype);
                return null;
        }
    }
}
