package com.yourorganization.Product.Electronic;

import com.yourorganization.Product.Supplier;

public class ElectronicFactory {

    // Factory method for creating different types of electronic items based on the subtype
    public static Electronic createElectronic(int subtype, String id, String name, Supplier supplier, 
                                              int packagingUnits, double price, String manufacturer, String model, String additionalInfo) {
        switch (subtype) {
            case 1:
                int storageCapacity = Integer.parseInt(additionalInfo); // additionalInfo is storageCapacity
                return new Smartphone(id, name, supplier, packagingUnits, price, manufacturer, model, storageCapacity);
            case 2:
                int screenSize = Integer.parseInt(additionalInfo); // additionalInfo is screenSize
                return new Television(id, name, supplier, packagingUnits, price, manufacturer, model, screenSize);
      
            default:
                System.out.println("Unknown electronic subtype: " + subtype);
                return null;
        }
    }
}
