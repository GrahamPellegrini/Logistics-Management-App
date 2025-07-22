#include "../../include/Shipment/ShipmentCollection.h"
#include <algorithm>

// Constructor for ShipmentCollection
ShipmentCollection::ShipmentCollection() {
    // The vector 'shipments' is automatically initialized
}

void ShipmentCollection::addShipment(const std::shared_ptr<Shipment>& shipment) {
    shipments.push_back(shipment);
}

std::vector<std::shared_ptr<Shipment>> ShipmentCollection::getAllShipments() const {
    return shipments; // Returning a copy of the shipments vector
}

std::shared_ptr<Shipment> ShipmentCollection::getShipmentById(const std::string& shipmentId) const {
    auto it = std::find_if(shipments.begin(), shipments.end(), 
        [&shipmentId](const std::shared_ptr<Shipment>& shipment) {
            return shipment->getId() == shipmentId;
        });

    if (it != shipments.end()) {
        return *it;
    }
    return nullptr; // If shipment is not found
}

bool ShipmentCollection::removeShipment(const std::string& shipmentId) {
    auto it = std::remove_if(shipments.begin(), shipments.end(), 
        [&shipmentId](const std::shared_ptr<Shipment>& shipment) {
            return shipment->getId() == shipmentId;
        });

    if (it != shipments.end()) {
        shipments.erase(it, shipments.end());
        return true;
    }
    return false; // If no shipment was removed
}

std::shared_ptr<Shipment> ShipmentCollection::getShipmentByCustomerId(const std::string& customerId) const {
    auto it = std::find_if(shipments.begin(), shipments.end(), 
        [&customerId](const std::shared_ptr<Shipment>& shipment) {
            return shipment->getCustomer()->getId() == customerId;
        });

    if (it != shipments.end()) {
        return *it;
    }
    return nullptr; // If shipment is not found
}
