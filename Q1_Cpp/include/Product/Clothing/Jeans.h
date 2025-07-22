#ifndef JEANS_H
#define JEANS_H

#include "Clothing.h"

class Jeans : public Clothing {
private:
    int waistSize; // Waist size in inches

public:
    // Constructor for Jeans
    Jeans(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string color, int waistSize);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for waistSize
    int getWaistSize() const;
    void setWaistSize(int waistSize);
};

#endif // JEANS_H
