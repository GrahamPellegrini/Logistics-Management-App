#ifndef FICTIONBOOK_H
#define FICTIONBOOK_H

#include "Book.h"
#include <string>

class FictionBook : public Book {
private:
    std::string genre; // Genre of the book

public:
    // Constructor for FictionBook
    FictionBook(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages, std::string genre);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for genre
    std::string getGenre() const;
    void setGenre(const std::string& genre);
};

#endif // FICTIONBOOK_H
