package Shipment.Customer; // Package for shipment and customer management

import java.util.ArrayList;
import java.util.List; // Importing list utilities


public class CustomerCollection {
    private List<Customer> customers; // List to store customers

    // Constructor for CustomerCollection
    public CustomerCollection() {
        customers = new ArrayList<>(); // Initializing the customer list
    }

    // Adds a customer to the collection
    public void addCustomer(Customer customer) {
        customers.add(customer); // Appending new customer
    }

    // Retrieves a customer by their ID
    public Customer getCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getId().equals(customerId)) {
                return customer; // Found the customer
            }
        }
        return null; // No customer found
    }

    // Returns all customers in the collection
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers); // Making a copy of customers list
    }

    
    // Deletes a customer by ID
    public boolean deleteCustomer(String customerId) {
        return customers.removeIf(customer -> customer.getId().equals(customerId)); // Removing customer by ID
        // removeIf method is part of List utilities and removes all elements in a list that satisfy the condition
    }

}
