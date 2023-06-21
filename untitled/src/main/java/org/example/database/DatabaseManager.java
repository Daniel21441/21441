package org.example.database;
import org.example.database.Building;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private String databaseFile;

    public DatabaseManager(String databaseFile) {
        this.databaseFile = databaseFile;
    }

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
