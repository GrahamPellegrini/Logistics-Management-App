#ifndef FRUIT_H
#define FRUIT_H

#include "Food.h"
#include <string>

class Fruit : public Food {
private:
    std::string type; // Type of fruit (e.g., "Apple", "Banana")

public:
    // Constructor for Fruit
    Fruit(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic, std::string type);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for type
    std::string getType() const;
    void setType(const std::string& type);
};

#endif // FRUIT_H
