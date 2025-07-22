#ifndef ACTIONGAME_H
#define ACTIONGAME_H

#include "ComputerGame.h"
#include <string>

class ActionGame : public ComputerGame {
private:
    std::string genre; // Genre of the action game

public:
    // Constructor for ActionGame
    ActionGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating, std::string genre);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for genre
    std::string getGenre() const;
    void setGenre(const std::string& genre);
};

#endif // ACTIONGAME_H
