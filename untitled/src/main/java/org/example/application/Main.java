package org.example.application;

import org.example.database.Building;
import org.example.database.DatabaseManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();

        // Dodawanie budynków do bazy danych
        Building building1 = new Building("Main Street", "123", 5, true);
        Building building2 = new Building("Park Avenue", "456", 10, false);

        databaseManager.saveBuilding(building1);
        databaseManager.saveBuilding(building2);

        // Odczytywanie wszystkich budynków z bazy danych
        List<Building> allBuildings = databaseManager.getAllBuildings();
        for (Building building : allBuildings) {
            System.out.println("Street: " + building.getStreet());
            System.out.println("Address: " + building.getAddress());
            System.out.println("Floors: " + building.getFloors());
            System.out.println("Has basement: " + building.hasBasement());
            System.out.println();
        }

        // Wyszukiwanie budynków na podstawie słowa kluczowego
        String keyword = "Main";
        List<Building> matchedBuildings = databaseManager.searchBuildings(keyword);
        for (Building building : matchedBuildings) {
            System.out.println("Street: " + building.getStreet());
            System.out.println("Address: " + building.getAddress());
            System.out.println("Floors: " + building.getFloors());
            System.out.println("Has basement: " + building.hasBasement());
            System.out.println();
        }
    }
}
