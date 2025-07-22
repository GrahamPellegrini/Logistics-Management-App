#include "../../include/Transport/Aircraft.h"
#include <sstream>
#include <algorithm>
#include <iterator>

// Constructor to set up an Aircraft
Aircraft::Aircraft(std::string id, double speed, double costPerKm, const std::vector<std::string>& airSpaces)
    : Transport(id, speed, costPerKm), airSpaces(airSpaces) {
}

// Overriding getRoutePlan from Transport
std::string Aircraft::getRoutePlan() {
    std::ostringstream oss;
    if (!airSpaces.empty()) {
        std::copy(airSpaces.begin(), airSpaces.end() - 1, std::ostream_iterator<std::string>(oss, ", "));
        oss << airSpaces.back();
    }
    return "Aircraft Route: " + oss.str(); // Combining air spaces into a string
}

// Getters and setters for airSpaces
std::vector<std::string> Aircraft::getAirSpaces() const {
    return airSpaces;
}

void Aircraft::setAirSpaces(const std::vector<std::string>& airSpaces) {
    this->airSpaces = airSpaces;
}
