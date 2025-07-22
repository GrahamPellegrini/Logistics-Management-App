#ifndef FOOD_H
#define FOOD_H

#include "../Product.h"
#include <string>

class Food : public Product {
private:
    std::string expirationDate; // Expiration date in YYYY-MM-DD format
    bool isOrganic; // Indicates if the food is organic

public:
    // Constructor for Food
    Food(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic);

    // Inherited abstract methods from Product class are to be implemented in derived classes

    // Getter and setter for expirationDate
    std::string getExpirationDate() const;
    void setExpirationDate(const std::string& expirationDate);

    // Getter and setter for isOrganic
    bool getIsOrganic() const;
    void setIsOrganic(bool isOrganic);
};

#endif // FOOD_H
