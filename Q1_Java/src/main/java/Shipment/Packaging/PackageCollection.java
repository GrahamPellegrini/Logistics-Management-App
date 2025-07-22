package Shipment.Packaging; // Package for managing shipments

import java.util.ArrayList;
import java.util.List; // Importing for list operations


public class PackageCollection {
    private List<PackagedProduct> packagedProducts; // List to store packaged products

    // Constructor for PackageCollection
    public PackageCollection() {
        packagedProducts = new ArrayList<>(); // Initializes the list
    }

    // Add a packaged product to the collection
    public void addPackagedProduct(PackagedProduct packagedProduct) {
        packagedProducts.add(packagedProduct); // Adding product to list
    }

    // Get all packaged products in the collection
    public List<PackagedProduct> getAllPackagedProducts() {
        return new ArrayList<>(packagedProducts); // Returns a copy of the packaged products list
        // Note we return a copy of the list so that the integrity of the original remains
    }

    // Find a packaged product by its product ID
    public PackagedProduct getPackagedProductByProductId(String productId) {
        for (PackagedProduct packagedProduct : packagedProducts) {
            if (packagedProduct.getProduct().getId().equals(productId)) {
                return packagedProduct; // Match found
            }
        }
        return null; // No match found
    }
}
