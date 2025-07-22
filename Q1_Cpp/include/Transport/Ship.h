#ifndef SHIP_H
#define SHIP_H

#include "Transport.h"
#include <vector>
#include <string>

class Ship : public Transport {
private:
    std::vector<std::string> seaRoutes; // List of sea routes the ship travels

public:
    // Constructor for initializing Ship
    Ship(std::string id, double speed, double costPerKm, const std::vector<std::string>& seaRoutes);

    // Overriding getRoutePlan from the Transport class
    std::string getRoutePlan() override;

    // Getter and setter for seaRoutes
    std::vector<std::string> getSeaRoutes() const;
    void setSeaRoutes(const std::vector<std::string>& seaRoutes);
};

#endif // SHIP_H
