#include "../../include/Transport/Ship.h"
#include <sstream>
#include <algorithm>
#include <iterator>

// Constructor for initializing Ship
Ship::Ship(std::string id, double speed, double costPerKm, const std::vector<std::string>& seaRoutes)
    : Transport(id, speed, costPerKm), seaRoutes(seaRoutes) {
}

// Overriding getRoutePlan from the Transport class
std::string Ship::getRoutePlan() {
    std::ostringstream oss;
    if (!seaRoutes.empty()) {
        std::copy(seaRoutes.begin(), seaRoutes.end() - 1, std::ostream_iterator<std::string>(oss, ", "));
        oss << seaRoutes.back();
    }
    return "Ship Route: " + oss.str(); // Concatenating sea routes
}

// Getter and setter for seaRoutes
std::vector<std::string> Ship::getSeaRoutes() const {
    return seaRoutes;
}

void Ship::setSeaRoutes(const std::vector<std::string>& seaRoutes) {
    this->seaRoutes = seaRoutes;
}
