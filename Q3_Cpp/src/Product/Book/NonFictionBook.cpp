#include "../../../include/Product/Book/NonFictionBook.h"
#include <sstream>

// Constructor for NonFictionBook
NonFictionBook::NonFictionBook(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string author, int pages, std::string subject)
    : Book(id, name, supplier, packagingUnits, price, author, pages), subject(subject) {
}

// Overriding calculateDiscount method from Product class
double NonFictionBook::calculateDiscount(int quantity, int month) {
    double discountRate = 0.15; // Base discount of 15%
    if (month == 6) { // Additional discount in June
        discountRate += 0.1; // 10% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string NonFictionBook::displayProductInfo() {
    // Returns string representation of NonFictionBook
    std::stringstream ss;
    ss << "NonFictionBook{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Author='" << getAuthor() << '\'' <<
       ", Pages=" << getPages() <<
       ", Subject='" << subject << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for subject
std::string NonFictionBook::getSubject() const {
    return subject;
}

void NonFictionBook::setSubject(const std::string& subject) {
    this->subject = subject;
}
