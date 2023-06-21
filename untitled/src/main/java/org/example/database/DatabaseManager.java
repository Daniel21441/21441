package org.example.database;
import org.example.database.Building;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String DATABASE_FILE = "building_database.txt";

    public void saveBuilding(Building building) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            writer.write(building.getStreet() + "," + building.getAddress() + "," +
                    building.getFloors() + "," + building.hasBasement());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Building> getAllBuildings() {
        List<Building> buildings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] buildingData = line.split(",");
                String street = buildingData[0];
                String address = buildingData[1];
                int floors = Integer.parseInt(buildingData[2]);
                boolean hasBasement = Boolean.parseBoolean(buildingData[3]);

                Building building = new Building(street, address, floors, hasBasement);
                buildings.add(building);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buildings;
    }

    public List<Building> searchBuildings(String keyword) {
        List<Building> matchedBuildings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    String[] buildingData = line.split(",");
                    String street = buildingData[0];
                    String address = buildingData[1];
                    int floors = Integer.parseInt(buildingData[2]);
                    boolean hasBasement = Boolean.parseBoolean(buildingData[3]);

                    Building building = new Building(street, address, floors, hasBasement);
                    matchedBuildings.add(building);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matchedBuildings;
    }
}
