#ifndef STOCK_H
#define STOCK_H


#include <memory>
#include "../../Product/Product.h"

class Stock {
private:
    std::shared_ptr<Product> product; // The product itself
    int quantity; // Quantity of the product in stock

public:
    // Constructor for Stock
    Stock(std::shared_ptr<Product> product, int quantity);

    // Getter and setter for product
    std::shared_ptr<Product> getProduct() const;
    void setProduct(std::shared_ptr<Product> product);

    // Getter and setter for quantity
    int getQuantity() const;
    void setQuantity(int quantity);
};

#endif // STOCK_H
