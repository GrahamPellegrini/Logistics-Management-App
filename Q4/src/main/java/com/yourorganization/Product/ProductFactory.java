package com.yourorganization.Product;

import com.yourorganization.Product.Book.BookFactory;
import com.yourorganization.Product.Clothing.ClothingFactory;
import com.yourorganization.Product.ComputerGame.ComputerGameFactory;
import com.yourorganization.Product.Electronic.ElectronicFactory;
import com.yourorganization.Product.Food.FoodFactory;
import com.yourorganization.Product.Furniture.FurnitureFactory;

public class ProductFactory {

    // Factory method to create products of different categories
    public static Product createProduct(int type, int subtype, String id, String name, Supplier supplier, 
                                        int packagingUnits, double price, String additionalInfo1, String additionalInfo2, String additionalInfo3) {
        switch (type) {
            case 1:
                String author = additionalInfo1;
                int pages = Integer.parseInt(additionalInfo2);
                return BookFactory.createBook(subtype, id, name, supplier, packagingUnits, price, author, pages, additionalInfo3);

            case 2:
                String materialC = additionalInfo1;
                String color = additionalInfo2;
                return ClothingFactory.createClothing(subtype, id, name, supplier, packagingUnits, price, materialC, color, additionalInfo3);

            case 3:
                String developer = additionalInfo1;
                int ageRating = Integer.parseInt(additionalInfo2);
                return ComputerGameFactory.createComputerGame(subtype, id, name, supplier, packagingUnits, price, developer, ageRating, additionalInfo3);

            case 4:
                String manufacturer = additionalInfo1;
                String model = additionalInfo2;
                return ElectronicFactory.createElectronic(subtype, id, name, supplier, packagingUnits, price, manufacturer, model, additionalInfo3);

            case 5:
                String expirationDate = additionalInfo1;
                boolean isOrganic = Boolean.parseBoolean(additionalInfo2);
                return FoodFactory.createFood(subtype, id, name, supplier, packagingUnits, price, expirationDate, isOrganic, additionalInfo3);

            case 6:
                String materialF = additionalInfo1;
                String dimensions = additionalInfo2;
                return FurnitureFactory.createFurniture(subtype, id, name, supplier, packagingUnits, price, materialF, dimensions, additionalInfo3);

            default:
                System.out.println("Unknown product type: " + type);
                return null;
        }
    }
}
