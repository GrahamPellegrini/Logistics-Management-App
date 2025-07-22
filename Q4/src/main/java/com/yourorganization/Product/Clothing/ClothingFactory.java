package com.yourorganization.Product.Clothing;

import com.yourorganization.Product.Supplier;

public class ClothingFactory {

    // Factory method for creating different types of clothing based on the subtype
    public static Clothing createClothing(int subtype, String id, String name, Supplier supplier, 
                                          int packagingUnits, double price, String material, String color, String additionalInfo) {
        switch (subtype) {
            case 1:
                int waistSize = Integer.parseInt(additionalInfo); // Convert additionalInfo to integer for waistSize
                return new Jeans(id, name, supplier, packagingUnits, price, material, color, waistSize);
            case 2:
                String size = additionalInfo; // Use additionalInfo directly for size
                return new TShirt(id, name, supplier, packagingUnits, price, material, color, size);
            // Add more cases for other clothing subtypes if necessary
            default:
                System.out.println("Unknown clothing subtype: " + subtype);
                return null;
        }
    }
}
