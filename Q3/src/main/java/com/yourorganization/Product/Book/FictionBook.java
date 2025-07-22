package com.yourorganization.Product.Book; // Package for FictionBook

import com.yourorganization.Product.Supplier;

// FictionBook class, a specific type of Book
public class FictionBook extends Book {
    private String genre; // Genre of the book

    // Constructor for FictionBook
    public FictionBook(String id, String name, Supplier supplier,  int packagingUnits, double price, String author, int pages, String genre) {
        super(id, name, supplier, packagingUnits, price, author, pages); // Calling the Book constructor
        this.genre = genre; // Setting the genre
    }

    // Overriding calculateDiscount method from Product class
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.1; // Base discount rate
        if (month == 12) { // Additional discount in December
            discountRate += 0.05;
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method from Product class
    @Override
    public String displayProductInfo() {
        // Returns a string representation of the FictionBook
        return "FictionBook{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Author='" + getAuthor() + '\'' +
               ", Pages=" + getPages() +
               ", Genre='" + genre + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for genre
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
