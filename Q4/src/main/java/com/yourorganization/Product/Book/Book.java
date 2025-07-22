package com.yourorganization.Product.Book; // Package for the Book class

import com.yourorganization.Product.Product;
import com.yourorganization.Product.Supplier;

// Book class extends Product, meaning it's a type of Product
public abstract class Book extends Product {
    private String author; // Author of the book
    private int pages; // Number of pages in the book

    // Constructor for Book, includes properties from Product and new ones
    public Book(String id, String name, Supplier supplier, int packagingUnits, double price, String author, int pages) {
        super(id, name, supplier, packagingUnits, price); // Call to Product's constructor
        this.author = author; // Setting the author of the book
        this.pages = pages; // Setting the number of pages
    }

    // Abstract methods from Product class are inherited here

    // Getter and setter methods for author and pages
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }
}
