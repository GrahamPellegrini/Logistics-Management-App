#include "../../include/Transport/Transport.h"

// Constructor to set up a new transport method
Transport::Transport(std::string id, double speed, double costPerKm)
    : id(id), speed(speed), costPerKm(costPerKm) {
}

// Calculates time taken for delivery based on distance
std::chrono::duration<long> Transport::calculateDeliveryTime(double distance) {
    return std::chrono::duration<long>((long)((distance / speed) * 60)); // Converting hours to minutes
}

// Calculates cost of delivery based on distance
double Transport::calculateDeliveryCost(double distance) {
    return distance * costPerKm;
}

// Getters and setters
double Transport::getSpeed() const {
    return speed;
}

void Transport::setSpeed(double speed) {
    this->speed = speed;
}

double Transport::getCostPerKm() const {
    return costPerKm;
}

void Transport::setCostPerKm(double costPerKm) {
    this->costPerKm = costPerKm;
}

std::string Transport::getId() const {
    return id;
}

void Transport::setId(const std::string& id) {
    this->id = id;
}
