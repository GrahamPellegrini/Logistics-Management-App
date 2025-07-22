#ifndef TSHIRT_H
#define TSHIRT_H

#include "Clothing.h"
#include <string>

class TShirt : public Clothing {
private:
    std::string size; // Size of the T-shirt (e.g., S, M, L, XL)

public:
    // Constructor for TShirt
    TShirt(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string color, std::string size);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for size
    std::string getSize() const;
    void setSize(const std::string& size);
};

#endif // TSHIRT_H
