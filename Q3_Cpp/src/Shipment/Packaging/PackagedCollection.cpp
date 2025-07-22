#include "../../../include/Shipment/Packaging/PackageCollection.h"
// Constructor for PackageCollection
PackageCollection::PackageCollection() {
    // The vector 'packagedProducts' is automatically initialized
}

void PackageCollection::addPackagedProduct(const std::shared_ptr<PackagedProduct>& packagedProduct) {
    packagedProducts.push_back(packagedProduct);
}

std::vector<std::shared_ptr<PackagedProduct>> PackageCollection::getAllPackagedProducts() const {
    return packagedProducts; // Returning a copy of the packaged products vector
}

std::shared_ptr<PackagedProduct> PackageCollection::getPackagedProductByProductId(const std::string& productId) const {
    for (const auto& packagedProduct : packagedProducts) {
        if (packagedProduct->getProduct()->getId() == productId) {
            return packagedProduct; // Match found
        }
    }
    return nullptr; // No match found
}
