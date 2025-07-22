#ifndef TELEVISION_H
#define TELEVISION_H

#include "Electronic.h"

class Television : public Electronic {
private:
    int screenSize; // Screen size in inches

public:
    // Constructor for Television
    Television(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model, int screenSize);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for screenSize
    int getScreenSize() const;
    void setScreenSize(int screenSize);
};

#endif // TELEVISION_H
