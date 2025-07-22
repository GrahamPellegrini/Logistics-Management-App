package com.yourorganization.Product.ComputerGame;

import com.yourorganization.Product.Supplier;

public class ComputerGameFactory {

    // Factory method for creating different types of computer games based on the subtype
    public static ComputerGame createComputerGame(int  subtype, String id, String name, Supplier supplier, 
                                                  int packagingUnits, double price, String developer, int ageRating, String additionalInfo) {
        switch (subtype) {
            case 1:
            String genre = additionalInfo;
                return new ActionGame(id, name, supplier, packagingUnits, price, developer, ageRating, genre); // additionalInfo is genre
            case 2:
            String difficultyLevel = additionalInfo;
                return new PuzzleGame(id, name, supplier, packagingUnits, price, developer, ageRating, difficultyLevel); // additionalInfo is difficultyLevel
            
            default:
                System.out.println("Unknown computer game subtype: " + subtype);
                return null;
        }
    }
}
