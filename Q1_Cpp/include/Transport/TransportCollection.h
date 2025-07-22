#ifndef TRANSPORTCOLLECTION_H
#define TRANSPORTCOLLECTION_H

#include "Transport.h"
#include <vector>
#include <memory>

class TransportCollection {
private:
    std::vector<std::shared_ptr<Transport>> transports; // Stores a collection of Transport objects

public:
    // Constructor for TransportCollection
    TransportCollection();

    // Adds a transport to the collection
    void addTransport(const std::shared_ptr<Transport>& transport);

    // Returns all transports in the collection
    std::vector<std::shared_ptr<Transport>> getAllTransports() const;

    // Retrieves a transport by its ID
    std::shared_ptr<Transport> getTransportById(const std::string& transportId) const;

    // Updates a transport in the collection
    bool updateTransport(const std::string& transportId, const std::shared_ptr<Transport>& updatedTransport);

    // Deletes a transport from the collection
    bool deleteTransport(const std::string& transportId);
};

#endif // TRANSPORTCOLLECTION_H
