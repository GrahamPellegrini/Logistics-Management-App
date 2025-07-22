#ifndef PACKAGEDPRODUCT_H
#define PACKAGEDPRODUCT_H

#include <memory>
#include "../../Product/Product.h"
#include "Packaging.h"

class PackagedProduct {
private:
    std::shared_ptr<Product> product; // The actual product
    std::shared_ptr<Packaging> packaging; // The packaging for the product
    int quantity; // How many of this product

public:
    // Constructor for PackagedProduct
    PackagedProduct(std::shared_ptr<Product> product, std::shared_ptr<Packaging> packaging, int quantity);

    // Calculates the total cost of the product based on quantity and discounts
    double calculateTotalProductCost();

    // Calculates the total cost of packaging
    double getPackagingCost();

    // Getters for product, packaging, and quantity
    std::shared_ptr<Product> getProduct() const;
    std::shared_ptr<Packaging> getPackaging() const;
    int getQuantity() const;

    // Setters for product, packaging, and quantity
    void setProduct(std::shared_ptr<Product> product);
    void setPackaging(std::shared_ptr<Packaging> packaging);
    void setQuantity(int quantity);
};

#endif // PACKAGEDPRODUCT_H

