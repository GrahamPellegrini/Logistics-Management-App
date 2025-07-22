#include "../../../include/Product/Book/FictionBook.h"
#include <sstream>

// Constructor for FictionBook
FictionBook::FictionBook(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages, std::string genre)
    : Book(id, name, supplier, packagingUnits, price, author, pages), genre(genre) {
}

// Overriding calculateDiscount method from Product class
double FictionBook::calculateDiscount(int quantity, int month) {
    double discountRate = 0.1; // Base discount rate
    if (month == 12) { // Additional discount in December
        discountRate += 0.05;
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string FictionBook::displayProductInfo() {
    // Returns string representation of NonFictionBook
    std::stringstream ss;
    ss << "NonFictionBook{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Author='" << getAuthor() << '\'' <<
       ", Pages=" << getPages() <<
       ", Subject='" << getGenre() << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for subject
std::string FictionBook::getGenre() const {
    return genre;
}

void FictionBook::setGenre(const std::string& genre) {
    this->genre = genre;
}
