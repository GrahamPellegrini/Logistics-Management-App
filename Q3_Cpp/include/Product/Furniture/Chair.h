#ifndef CHAIR_H
#define CHAIR_H

#include "Furniture.h"

class Chair : public Furniture {
private:
    bool hasArmrests; // Indicates if the chair has armrests

public:
    // Constructor for Chair
    Chair(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions, bool hasArmrests);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for hasArmrests
    bool getHasArmrests() const;
    void setHasArmrests(bool hasArmrests);
};

#endif // CHAIR_H
