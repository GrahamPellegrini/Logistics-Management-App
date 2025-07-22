#include "../include/Shipment/Customer/CustomerCollection.h"
#include <algorithm>

// Constructor for CustomerCollection
CustomerCollection::CustomerCollection( std::vector<std::shared_ptr<Customer>> customers)
:customers(customers) {
    // The vector 'customers' is automatically initialized
}

void CustomerCollection::addCustomer(const std::shared_ptr<Customer>& customer) {
    customers.push_back(customer);
}

std::shared_ptr<Customer> CustomerCollection::getCustomerById(const std::string& customerId) const {
    auto it = std::find_if(customers.begin(), customers.end(),
        [&customerId](const std::shared_ptr<Customer>& customer) {
            return customer->getId() == customerId;
        });

    if (it != customers.end()) {
        return *it;
    }
    return nullptr; // If customer is not found
}

std::vector<std::shared_ptr<Customer>> CustomerCollection::getAllCustomers() const {
    return customers; // Returning a copy of the customers vector
}

bool CustomerCollection::deleteCustomer(const std::string& customerId) {
    auto it = std::remove_if(customers.begin(), customers.end(),
        [&customerId](const std::shared_ptr<Customer>& customer) {
            return customer->getId() == customerId;
        });

    if (it != customers.end()) {
        customers.erase(it, customers.end());
        return true;
    }
    return false; // If no customer was removed
}
