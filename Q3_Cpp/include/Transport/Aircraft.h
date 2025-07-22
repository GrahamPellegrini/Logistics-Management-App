#ifndef AIRCRAFT_H
#define AIRCRAFT_H

#include "Transport.h"
#include <vector>
#include <string>

class Aircraft : public Transport {
private:
    std::vector<std::string> airSpaces; // Tracks air spaces the aircraft travels through

public:
    // Constructor to set up an Aircraft
    Aircraft(std::string id, double speed, double costPerKm, const std::vector<std::string>& airSpaces);

    // Overriding getRoutePlan from Transport
    std::string getRoutePlan() override;

    // Getters and setters for airSpaces
    std::vector<std::string> getAirSpaces() const;
    void setAirSpaces(const std::vector<std::string>& airSpaces);
};

#endif // AIRCRAFT_H
