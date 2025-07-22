#include "../include/Shipment/Stock/StockCollection.h"
#include <algorithm>

// Constructor for StockCollection
StockCollection::StockCollection(std::vector<std::shared_ptr<Stock>> items)
    : items(items) {
}


void StockCollection::addProduct(std::shared_ptr<Product> product, int quantity) {
    auto it = std::find_if(items.begin(), items.end(), 
        [&product](const std::shared_ptr<Stock>& stockItem) {
            return stockItem->getProduct()->getId() == product->getId();
        });

    if (it != items.end()) {
        (*it)->setQuantity((*it)->getQuantity() + quantity);
    } else {
        items.push_back(std::make_shared<Stock>(product, quantity));
    }
}

void StockCollection::removeProduct(std::shared_ptr<Product> product, int quantity) {
    auto it = std::find_if(items.begin(), items.end(), 
        [&product](const std::shared_ptr<Stock>& stockItem) {
            return stockItem->getProduct()->getId() == product->getId();
        });

    if (it == items.end()) {
        return;
    }

    auto& stockItem = *it;
    int currentQuantity = stockItem->getQuantity();

    if (quantity >= currentQuantity) {
        items.erase(it);
    } else {
        stockItem->setQuantity(currentQuantity - quantity);
    }
}

std::shared_ptr<Stock> StockCollection::getStockItem(std::shared_ptr<Product> product) const {
    auto it = std::find_if(items.begin(), items.end(), 
        [&product](const std::shared_ptr<Stock>& stockItem) {
            return stockItem->getProduct()->getId() == product->getId();
        });

    if (it != items.end()) {
        return *it;
    }
    return nullptr;
}

std::vector<std::shared_ptr<Stock>> StockCollection::getAllStockItems() const {
    return items;
}

bool StockCollection::removeProductById(const std::string& productId) {
    auto it = std::remove_if(items.begin(), items.end(), 
        [&productId](const std::shared_ptr<Stock>& stockItem) {
            return stockItem->getProduct()->getId() == productId;
        });

    if (it != items.end()) {
        items.erase(it, items.end());
        return true;
    }
    return false;
}

bool StockCollection::addAdditionalStock(const std::string& productId, int additionalQuantity) {
    auto it = std::find_if(items.begin(), items.end(), 
        [&productId](const std::shared_ptr<Stock>& stockItem) {
            return stockItem->getProduct()->getId() == productId;
        });

    if (it != items.end()) {
        (*it)->setQuantity((*it)->getQuantity() + additionalQuantity);
        return true;
    }
    return false;
}
