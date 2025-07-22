#include "../../../include/Product/Book/Book.h"

// Constructor for Book, includes properties from Product and new ones
Book::Book(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages)
    : Product(id, name, supplier, packagingUnits, price), author(author), pages(pages) {
}

// Getter and setter methods for author and pages
std::string Book::getAuthor() const {
    return author;
}

void Book::setAuthor(const std::string& author) {
    this->author = author;
}

int Book::getPages() const {
    return pages;
}

void Book::setPages(int pages) {
    this->pages = pages;
}
