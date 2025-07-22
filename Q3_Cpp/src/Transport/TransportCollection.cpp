#include "../../include/Transport/TransportCollection.h"
#include <algorithm>

// Constructor for TransportCollection
TransportCollection::TransportCollection() {
    // Transports vector is automatically initialized
}

void TransportCollection::addTransport(const std::shared_ptr<Transport>& transport) {
    transports.push_back(transport);
}

std::vector<std::shared_ptr<Transport>> TransportCollection::getAllTransports() const {
    return transports;
}

std::shared_ptr<Transport> TransportCollection::getTransportById(const std::string& transportId) const {
    auto it = std::find_if(transports.begin(), transports.end(), 
        [&transportId](const std::shared_ptr<Transport>& transport) {
            return transport->getId() == transportId;
        });

    if (it != transports.end()) {
        return *it;
    }
    return nullptr;
}

bool TransportCollection::updateTransport(const std::string& transportId, const std::shared_ptr<Transport>& updatedTransport) {
    auto it = std::find_if(transports.begin(), transports.end(), 
        [&transportId](const std::shared_ptr<Transport>& transport) {
            return transport->getId() == transportId;
        });

    if (it != transports.end()) {
        *it = updatedTransport;
        return true;
    }
    return false;
}

bool TransportCollection::deleteTransport(const std::string& transportId) {
    auto it = std::remove_if(transports.begin(), transports.end(), 
        [&transportId](const std::shared_ptr<Transport>& transport) {
            return transport->getId() == transportId;
        });

    if (it != transports.end()) {
        transports.erase(it, transports.end());
        return true;
    }
    return false;
}
