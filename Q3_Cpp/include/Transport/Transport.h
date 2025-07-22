#ifndef TRANSPORT_H
#define TRANSPORT_H

#include <string>
#include <chrono>

class Transport {
private:
    std::string id; // Unique identifier for each transport mode
    double speed; // Speed of transport in km/h
    double costPerKm; // Cost per km for using this transport

public:
    // Constructor to set up a new transport method
    Transport(std::string id, double speed, double costPerKm);

    // Abstract method for getting route plan, to be implemented in subclasses
    virtual std::string getRoutePlan() = 0;

    // Calculates time taken for delivery based on distance
    std::chrono::duration<long> calculateDeliveryTime(double distance);

    // Calculates cost of delivery based on distance
    double calculateDeliveryCost(double distance);

    // Getters and setters
    double getSpeed() const;
    void setSpeed(double speed);
    double getCostPerKm() const;
    void setCostPerKm(double costPerKm);
    std::string getId() const;
    void setId(const std::string& id);
};

#endif // TRANSPORT_H
