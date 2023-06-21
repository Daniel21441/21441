package org.example.database;

public class Building {
    private String street;
    private String address;
    private int numberOfFloors;
    private boolean hasBasement;

    public Building(String street, String address, int numberOfFloors, boolean hasBasement) {
        this.street = street;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.hasBasement = hasBasement;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean hasBasement() {
        return hasBasement;
    }
}
