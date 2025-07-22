#ifndef PUZZLEGAME_H
#define PUZZLEGAME_H

#include "ComputerGame.h"
#include <string>

class PuzzleGame : public ComputerGame {
private:
    std::string difficultyLevel; // Difficulty level of the puzzle game

public:
    // Constructor for PuzzleGame
    PuzzleGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating, std::string difficultyLevel);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for difficultyLevel
    std::string getDifficultyLevel() const;
    void setDifficultyLevel(const std::string& difficultyLevel);
};

#endif // PUZZLEGAME_H
