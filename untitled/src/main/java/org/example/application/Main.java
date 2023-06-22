package org.example.application;

import org.example.database.Building;
import org.example.database.DatabaseManager;

import java.util.List;

/**
 * Klasa Main jest głównym aplikacja progrmau.
 * Wykorzystuje obiekt DatabaseManager do zarządzania bazą danych budynków.
 */
public class Main {
    /**
     * Metoda main jest główną metodą programu, która uruchamia aplikację.
     *
     * @param args argumenty wiersza poleceń (jeśli są wymagane)
     */
    public static void main(String[] args) {
        /**Inicjalizacja obiektu DatabaseManager**/
        String databaseFilePath = "path/to/database.txt";
        DatabaseManager databaseManager = new DatabaseManager(databaseFilePath);

        /**Dodawanie budynków do bazy danych**/
        Building building1 = new Building("Main Street", "123", 5, true);
        Building building2 = new Building("Park Avenue", "456", 10, false);

        databaseManager.saveBuilding(building1);
        databaseManager.saveBuilding(building2);

        /** Odczytywanie wszystkich budynków z bazy danych**/
        List<Building> allBuildings = databaseManager.getAllBuildings();
        for (Building building : allBuildings) {
            System.out.println("Street: " + building.getStreet());
            System.out.println("Address: " + building.getAddress());
            System.out.println("Floors: " + building.getNumberOfFloors());
            System.out.println("Has basement: " + building.hasBasement());
            System.out.println();
        }

        /** Wyszukiwanie budynków na podstawie słowa kluczowego**/
        String keyword = "Main";
        List<Building> matchedBuildings = databaseManager.searchBuildings(keyword);
        for (Building building : matchedBuildings) {
            System.out.println("Street: " + building.getStreet());
            System.out.println("Address: " + building.getAddress());
            System.out.println("Floors: " + building.getNumberOfFloors());
            System.out.println("Has basement: " + building.hasBasement());
            System.out.println();
        }
    }
}
