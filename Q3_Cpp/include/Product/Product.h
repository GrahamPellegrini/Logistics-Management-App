#ifndef PRODUCT_H
#define PRODUCT_H

#include <string>
#include "Supplier.h" 

class Product {
private:
    std::string id; // Product's ID
    std::string name; // Product's name
    Supplier supplier; // Supplier object for the product
    int packagingUnits; // Packaging units of the product
    
protected:    
    double price; // Product's price

public:
    // Constructor to initialize a Product
    Product(std::string id, std::string name, Supplier supplier, int packagingUnits, double price);

    // Abstract methods to be implemented in subclasses
    virtual double calculateDiscount(int quantity, int month) = 0;
    virtual std::string displayProductInfo() = 0;

    // Getter and setter methods
    std::string getId() const;
    void setId(const std::string& id);
    std::string getName() const;
    void setName(const std::string& name);
    Supplier getSupplier() const;
    void setSupplier(const Supplier& supplier);
    int getPackagingUnits() const;
    void setPackagingUnits(int packagingUnits);
    double getPrice() const;
    void setPrice(double price);
};

#endif // PRODUCT_H
