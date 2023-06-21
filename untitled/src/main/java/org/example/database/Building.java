package org.example.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Building {
    private String street;
    private String address;
    private int floors;
    private boolean hasBasement;

    public Building(String street, String address, int floors, boolean hasBasement) {
        this.street = street;
        this.address = address;
        this.floors = floors;
        this.hasBasement = hasBasement;
    }

    public String getStreet() {
        return street;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public boolean hasBasement() {
        return hasBasement;
    }
}

