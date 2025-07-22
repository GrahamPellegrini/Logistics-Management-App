#ifndef CANNEDFOOD_H
#define CANNEDFOOD_H

#include "Food.h"
#include <string>

class CannedFood : public Food {
private:
    std::string contents; // Type of food inside the can (e.g., "Tomato Soup", "Baked Beans")

public:
    // Constructor for CannedFood
    CannedFood(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic, std::string contents);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for contents
    std::string getContents() const;
    void setContents(const std::string& contents);
};

#endif // CANNEDFOOD_H
