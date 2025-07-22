package com.yourorganization.Shipment.Customer; // Package for shipment and customer management

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // Importing list utilities

import yourorganization.Data;

public class CustomerCollection {
    private List<CustomerCollection> customers; // List to store customers

    // Constructor for Customer
    public CustomerCollection() {
        customers = new ArrayList<>(); // Initializing the customer list
    }

    // Adds a customer to the collection
    public void addCustomer(CustomerCollection customer) {
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
    public List<CustomerCollection> getAllCustomers() {
        return new ArrayList<>(customers); // Making a copy of customers list
    }

    
    // Deletes a customer by ID
    public boolean deleteCustomer(String customerId) {
        return customers.removeIf(customer -> customer.getId().equals(customerId)); // Removing customer by ID
        // removeIf method is part of List utilities and removes all elements in a list that satisfy the condition
    }

    public void save(String filename) {
    Data.Customer.Builder customerCollectionBuilder = Data.Customer.newBuilder();
    for (CustomerCollection customer : customers) {
        Data.Customer dataCustomer = CustomerCollection.convertToData(customer);
        customerCollectionBuilder.addCustomers(dataCustomer);
    }
    Data.Customer customerCollection = customerCollectionBuilder.build();

    try (FileOutputStream output = new FileOutputStream(filename)) {
            customerCollection.writeTo(output);
        }
    }

    public void load(String filename) {
        try (FileInputStream input = new FileInputStream(filename)) {
            Data.Customer customerCollection = Data.Customer.parseFrom(input);
            this.customers.clear();
            for (Data.Customer dataCustomer : customerCollection.getCustomersList()) {
                Customer customer = Customer.convertFromData(dataCustomer);
                this.customers.add(customer);
            }
        }
    }
    
}

