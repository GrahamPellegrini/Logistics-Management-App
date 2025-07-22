#ifndef SHIPMENTCOLLECTION_H
#define SHIPMENTCOLLECTION_H

#include "Shipment.h"
#include <vector>
#include <memory>

class ShipmentCollection {
private:
    std::vector<std::shared_ptr<Shipment>> shipments; // List to store shipments

public:
    // Constructor for ShipmentCollection
    ShipmentCollection();

    // Add a shipment to the collection
    void addShipment(const std::shared_ptr<Shipment>& shipment);

    // Retrieve all shipments in the collection
    std::vector<std::shared_ptr<Shipment>> getAllShipments() const;

    // Find a shipment by its ID
    std::shared_ptr<Shipment> getShipmentById(const std::string& shipmentId) const;

    // Remove a shipment from the collection by ID
    bool removeShipment(const std::string& shipmentId);

    // Find a shipment by the customer ID
    std::shared_ptr<Shipment> getShipmentByCustomerId(const std::string& customerId) const;
};

#endif // SHIPMENTCOLLECTION_H
