package org.example.database;

import org.example.database.Building;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa DatabaseManager zarządza bazą danych budynków.
 */
public class DatabaseManager {
    private String databaseFile;

    /**
     * Konstruktor inicjalizuje obiekt DatabaseManager z ścieżką do pliku bazy danych.
     *
     * @param databaseFile ścieżka do pliku bazy danych
     */
    public DatabaseManager(String databaseFile) {
        this.databaseFile = databaseFile;
    }

    /**
     * Metoda saveBuilding zapisuje informacje o budynku do bazy danych.
     *
     * @param building obiekt reprezentujący budynek do zapisania
     */
    public void saveBuilding(Building building) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(databaseFile, true))) {
            String buildingData = building.getStreet() + "," +
                    building.getAddress() + "," +
                    building.getNumberOfFloors() + "," +
                    building.hasBasement();
            writer.write(buildingData);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda getAllBuildings zwraca listę wszystkich budynków z bazy danych.
     *
     * @return lista budynków
     */
    public List<Building> getAllBuildings() {
        List<Building> buildings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buildingData = line.split(",");
                String street = buildingData[0];
                String address = buildingData[1];
                int numberOfFloors = Integer.parseInt(buildingData[2]);
                boolean hasBasement = Boolean.parseBoolean(buildingData[3]);
                Building building = new Building(street, address, numberOfFloors, hasBasement);
                buildings.add(building);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    /**
     * Metoda searchBuildings wyszukuje budynków na podstawie podanego słowa kluczowego.
     *
     * @param keyword słowo kluczowe do wyszukania
     * @return lista budynków spełniających kryteria wyszukiwania
     */
    public List<Building> searchBuildings(String keyword) {
        List<Building> matchedBuildings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(databaseFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buildingData = line.split(",");
                String street = buildingData[0];
                if (street.contains(keyword)) {
                    String address = buildingData[1];
                    int numberOfFloors = Integer.parseInt(buildingData[2]);
                    boolean hasBasement = Boolean.parseBoolean(buildingData[3]);
                    Building building = new Building(street, address, numberOfFloors, hasBasement);
                    matchedBuildings.add(building);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchedBuildings;
    }
}
