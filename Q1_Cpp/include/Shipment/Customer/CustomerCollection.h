#ifndef CUSTOMERCOLLECTION_H
#define CUSTOMERCOLLECTION_H

#include "Customer.h"
#include <vector>
#include <memory>

class CustomerCollection {
private:
    std::vector<std::shared_ptr<Customer>> customers; // List to store customers

public:
    // Constructor for CustomerCollection
    CustomerCollection( std::vector<std::shared_ptr<Customer>> customers);

    // Adds a customer to the collection
    void addCustomer(const std::shared_ptr<Customer>& customer);

    // Retrieves a customer by their ID
    std::shared_ptr<Customer> getCustomerById(const std::string& customerId) const;

    // Returns all customers in the collection
    std::vector<std::shared_ptr<Customer>> getAllCustomers() const;

    // Deletes a customer by ID
    bool deleteCustomer(const std::string& customerId);
};

#endif // CUSTOMERCOLLECTION_H
