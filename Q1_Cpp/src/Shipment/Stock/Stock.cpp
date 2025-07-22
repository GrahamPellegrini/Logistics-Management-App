#include "../../../include/Shipment/Stock/Stock.h"

// Constructor for Stock
Stock::Stock(std::shared_ptr<Product> product, int quantity)
    : product(product), quantity(quantity) {
}

// Getter and setter for product
std::shared_ptr<Product> Stock::getProduct() const {
    return product;
}

void Stock::setProduct(std::shared_ptr<Product> product) {
    this->product = product;
}

// Getter and setter for quantity
int Stock::getQuantity() const {
    return quantity;
}

void Stock::setQuantity(int quantity) {
    this->quantity = quantity;
}
