#ifndef NONFICTIONBOOK_H
#define NONFICTIONBOOK_H

#include "Book.h"
#include <string>

class NonFictionBook : public Book {
private:
    std::string subject; // Subject of the non-fiction book

public:
    // Constructor for NonFictionBook
    NonFictionBook(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages, std::string subject);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for subject
    std::string getSubject() const;
    void setSubject(const std::string& subject);
};

#endif // NONFICTIONBOOK_H
