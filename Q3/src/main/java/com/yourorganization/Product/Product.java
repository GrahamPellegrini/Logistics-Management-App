package com.yourorganization.Product; // Package for the class

import com.yourorganization.Product.Book.FictionBook;
import com.yourorganization.Product.Book.NonFictionBook;
import com.yourorganization.Product.Clothing.Jeans;
import com.yourorganization.Product.Clothing.TShirt;
import com.yourorganization.Product.ComputerGame.ActionGame;
import com.yourorganization.Product.ComputerGame.PuzzleGame;
import com.yourorganization.Product.Electronic.Smartphone;
import com.yourorganization.Product.Electronic.Television;
import com.yourorganization.Product.Food.CannedFood;
import com.yourorganization.Product.Food.Fruit;
import com.yourorganization.Product.Furniture.Chair;
import com.yourorganization.Product.Furniture.Table;

import yourorganization.Data;

public abstract class Product {
    private String id; // Product's ID
    private String name; // Product's name
    private Supplier supplier; // Supplier object for the product
    private int packagingUnits; // Packaging units of the product
    private double price; // Product's price

    // Constructor to initialize a Product
    public Product(String id, String name, Supplier supplier, int packagingUnits, double price) {
        this.id = id; // Setting product ID
        this.name = name; // Setting product name
        this.supplier = supplier; // Setting product's supplier
        this.packagingUnits = packagingUnits; // Setting packaging units
        this.price = price; // Setting price
    }

    // Abstract methods to be implemented in subclasses
    public abstract double calculateDiscount(int quantity, int month);
    public abstract String displayProductInfo();

    // Getter and setter methods
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public int getPackagingUnits() { return packagingUnits; }
    public void setPackagingUnits(int packagingUnits) { this.packagingUnits = packagingUnits; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public Data.Product convertToProduct() {
        
        // Convert domain Product to Protobuf Product
 
         return Data.Product.newBuilder()
                     .setId(getId())
                     .setName(getName())
                     .setSupplier(getSupplier().convertToSupplier())
                     .setPackagingUnits(getPackagingUnits())
                     .setPrice(getPrice()
                     )
                     .build();
               
    }

   public static Product convertFromData(Data.Product dataProduct) {
    Supplier supplier = new Supplier(dataProduct.getSupplier().getId(), dataProduct.getSupplier().getName());

    switch (dataProduct.getType()) {
        case "FictionBook":
            // Assuming FictionBook has additional fields like author, pages, genre
            return new FictionBook(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "William",
                124,
                "Romance"
            );

        case "NonFictionBook":
            // Assuming NonFictionBook has additional fields like author, pages, subject
            return new NonFictionBook(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "William",
                245,
                "Counting Sheep"
            );

        case "Jeans":
            // Assuming Jeans has additional fields like material, color, waistSize
            return new Jeans(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Polyster",
                "Blue",
                32
            );

        case "TShirt":
            // Assuming TShirt has additional fields like material, color, size
            return new TShirt(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Wool",
                "Cream",
                "S"
            );

        case "ActionGame":
            // Assuming ActionGame has additional fields like developer, ageRating, genre
            return new ActionGame(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Tyler",
                18,
                "Shooting"
            );

        case "PuzzleGame":
            // Assuming PuzzleGame has additional fields like developer, ageRating, difficultyLevel
            return new PuzzleGame(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Nick",
                6,
                "Hard"
            );

        case "Smartphone":
            // Assuming Smartphone has additional fields like manufacturer, model, storageCapacity
            return new Smartphone(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Apple",
                "11 Pro Max",
                5
            );

        case "Television":
            // Assuming Television has additional fields like manufacturer, model, screenSize
            return new Television(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "LG",
                "U7 Ultra Wide",
                70
            );

        case "CannedFood":
            // Assuming CannedFood has additional fields like expirationDate, isOrganic, contents
            return new CannedFood(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "01/01/2050",
                true,
                "Soup"
            );

        case "Fruit":
            // Assuming Fruit has additional fields like expirationDate, isOrganic, type
            return new Fruit(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "30/06/2024",
                true,
                "Apple"
            );

        case "Chair":
            // Assuming Chair has additional fields like material, dimensions, hasArmrests
            return new Chair(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Plastic",
                "10*5",
                true
            );

        case "Table":
            // Assuming Table has additional fields like material, dimensions, shape
            return new Table(
                dataProduct.getId(),
                dataProduct.getName(),
                supplier,
                dataProduct.getPackagingUnits(),
                dataProduct.getPrice(),
                "Wood",
                "20*80",
                "Square"
            );

        default:
            throw new IllegalArgumentException("Unknown product type: " + dataProduct.getType());
    }
}

}
