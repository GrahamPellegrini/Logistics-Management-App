#ifndef PACKAGECOLLECTION_H
#define PACKAGECOLLECTION_H

#include "PackagedProduct.h"
#include <vector>
#include <memory>

class PackageCollection {
private:
    std::vector<std::shared_ptr<PackagedProduct>> packagedProducts; // List to store packaged products

public:
    // Constructor for PackageCollection
    PackageCollection();

    // Add a packaged product to the collection
    void addPackagedProduct(const std::shared_ptr<PackagedProduct>& packagedProduct);

    // Get all packaged products in the collection
    std::vector<std::shared_ptr<PackagedProduct>> getAllPackagedProducts() const;

    // Find a packaged product by its product ID
    std::shared_ptr<PackagedProduct> getPackagedProductByProductId(const std::string& productId) const;
};

#endif // PACKAGECOLLECTION_H
