#include "../../../include/Shipment/Packaging/PackagedProduct.h"
#include <ctime>
#include "../../../include/Product/Product.h"
#include "../../../include/Shipment/Packaging/Packaging.h"

// Constructor for PackagedProduct
PackagedProduct::PackagedProduct(std::shared_ptr<Product> product, std::shared_ptr<Packaging> packaging, int quantity)
    : product(product), packaging(packaging), quantity(quantity) {
}

// Calculates the total cost of the product based on quantity and discounts
double PackagedProduct::calculateTotalProductCost() {
    time_t t = time(0); // Current time
    tm* now = localtime(&t);
    int currentMonth = now->tm_mon + 1; // tm_mon is months since January, so we add 1
    return (product->getPrice() - product->calculateDiscount(quantity, currentMonth)) * quantity;
}

// Calculates the total cost of packaging
double PackagedProduct::getPackagingCost() {
    return packaging->getCost() * quantity;
}

// Getters for product, packaging, and quantity
std::shared_ptr<Product> PackagedProduct::getProduct() const {
    return product;
}

std::shared_ptr<Packaging> PackagedProduct::getPackaging() const {
    return packaging;
}

int PackagedProduct::getQuantity() const {
    return quantity;
}

// Setters for product, packaging, and quantity
void PackagedProduct::setProduct(std::shared_ptr<Product> product) {
    this->product = product;
}

void PackagedProduct::setPackaging(std::shared_ptr<Packaging> packaging) {
    this->packaging = packaging;
}

void PackagedProduct::setQuantity(int quantity) {
    this->quantity = quantity;
}

