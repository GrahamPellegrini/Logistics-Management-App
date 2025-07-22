#ifndef STOCKCOLLECTION_H
#define STOCKCOLLECTION_H

#include "Stock.h"
#include <vector>
#include <memory>

class StockCollection {
private:
    std::vector<std::shared_ptr<Stock>> items; // Stores the list of stock items

public:
    // Constructor for StockCollection
    StockCollection(std::vector<std::shared_ptr<Stock>> items);

    // Adds a product and its quantity to the stock
    void addProduct(std::shared_ptr<Product> product, int quantity);

    // Removes a specified quantity of a product from the stock
    void removeProduct(std::shared_ptr<Product> product, int quantity);

    // Retrieves a stock item for a specific product
    std::shared_ptr<Stock> getStockItem(std::shared_ptr<Product> product) const;

    // Gets a list of all stock items
    std::vector<std::shared_ptr<Stock>> getAllStockItems() const;

    // Removes a product from the stock based on its ID
    bool removeProductById(const std::string& productId);

    // Adds additional stock for a specific product
    bool addAdditionalStock(const std::string& productId, int additionalQuantity);
};

#endif // STOCKCOLLECTION_H
