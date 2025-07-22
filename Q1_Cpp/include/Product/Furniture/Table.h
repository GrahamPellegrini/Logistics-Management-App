#ifndef TABLE_H
#define TABLE_H

#include "Furniture.h"
#include <string>

class Table : public Furniture {
private:
    std::string shape; // Shape of the table (e.g., "Round", "Square", "Rectangle")

public:
    // Constructor for Table
    Table(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions, std::string shape);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for shape
    std::string getShape() const;
    void setShape(const std::string& shape);
};

#endif // TABLE_H
