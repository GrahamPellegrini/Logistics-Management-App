package com.yourorganization.Product.Book; // Package for NonFictionBook

import com.yourorganization.Product.Supplier;

// NonFictionBook class, derived from Book
public class NonFictionBook extends Book {
    private String subject; // Subject of the non-fiction book

    // Constructor for NonFictionBook
    public NonFictionBook(String id, String name, Supplier supplier,  int packagingUnits, double price, String author, int pages, String subject) {
        super(id, name, supplier, packagingUnits, price, author, pages); // Calling Book's constructor
        this.subject = subject; // Setting the subject
    }

    // Overriding calculateDiscount method from Product class
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.15; // Base discount of 15%
        if (month == 6) { // Additional discount in June
            discountRate += 0.1; // 10% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method from Product class
    @Override
    public String displayProductInfo() {
        // Returns string representation of NonFictionBook
        return "NonFictionBook{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Author='" + getAuthor() + '\'' +
               ", Pages=" + getPages() +
               ", Subject='" + subject + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for subject
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
