#ifndef BOOK_H
#define BOOK_H

#include "../Product.h"
#include <string>

class Book : public Product {
private:
    std::string author; // Author of the book
    int pages; // Number of pages in the book

public:
    // Constructor for Book, includes properties from Product and new ones
    Book(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages);

    // Inherited abstract methods from Product class are to be implemented in derived classes

    // Getter and setter methods for author and pages
    std::string getAuthor() const;
    void setAuthor(const std::string& author);
    int getPages() const;
    void setPages(int pages);
};

#endif // BOOK_H

