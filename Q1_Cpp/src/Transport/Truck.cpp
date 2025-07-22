#include "../../include/Transport/Truck.h"
#include <sstream>
#include <algorithm>
#include <iterator>

// Constructor for Truck object
Truck::Truck(std::string id, double speed, double costPerKm, const std::vector<std::string>& motorways)
    : Transport(id, speed, costPerKm), motorways(motorways) {
}

// Overriding the getRoutePlan method from Transport
std::string Truck::getRoutePlan() {
    std::ostringstream oss;
    if (!motorways.empty()) {
        std::copy(motorways.begin(), motorways.end() - 1, std::ostream_iterator<std::string>(oss, ", "));
        oss << motorways.back();
    }
    return "Truck Route: " + oss.str(); // Creating a string of motorway routes
}

// Getter and setter for motorways
std::vector<std::string> Truck::getMotorways() const {
    return motorways;
}

void Truck::setMotorways(const std::vector<std::string>& motorways) {
    this->motorways = motorways;
}
