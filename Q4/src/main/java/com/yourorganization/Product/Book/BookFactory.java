package com.yourorganization.Product.Book;

import com.yourorganization.Product.Supplier;

public class BookFactory {

    // Factory method for creating a FictionBook or NonFictionBook based on the type
    public static Book createBook(int subtype, String id, String name, Supplier supplier, int packagingUnits, double price, String author, int pages, String genreOrSubject) {
        switch (subtype) {
            case 1:
                return new FictionBook(id, name, supplier, packagingUnits, price, author, pages, genreOrSubject); // genre for FictionBook
            case 2:
                return new NonFictionBook(id, name, supplier, packagingUnits, price, author, pages, genreOrSubject); // subject for NonFictionBook
            default:
               System.out.println("Unknown book type: " + subtype);
               return null;
        }
    }
}
