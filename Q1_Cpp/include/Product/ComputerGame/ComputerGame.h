#ifndef COMPUTERGAME_H
#define COMPUTERGAME_H

#include "../Product.h"
#include <string>

class ComputerGame : public Product {
private:
    std::string developer; // Developer of the computer game
    int ageRating; // Age rating for the game

public:
    // Constructor for ComputerGame
    ComputerGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating);

    // Inherited abstract methods from Product class are to be implemented in derived classes

    // Getter and setter for developer
    std::string getDeveloper() const;
    void setDeveloper(const std::string& developer);

    // Getter and setter for ageRating
    int getAgeRating() const;
    void setAgeRating(int ageRating);
};

#endif // COMPUTERGAME_H
