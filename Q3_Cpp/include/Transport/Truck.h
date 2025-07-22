#ifndef TRUCK_H
#define TRUCK_H

#include "Transport.h"
#include <vector>
#include <string>

class Truck : public Transport {
private:
    std::vector<std::string> motorways; // List of motorways the truck uses

public:
    // Constructor for Truck object
    Truck(std::string id, double speed, double costPerKm, const std::vector<std::string>& motorways);

    // Overriding the getRoutePlan method from Transport
    std::string getRoutePlan() override;

    // Getter and setter for motorways
    std::vector<std::string> getMotorways() const;
    void setMotorways(const std::vector<std::string>& motorways);
};

#endif // TRUCK_H
