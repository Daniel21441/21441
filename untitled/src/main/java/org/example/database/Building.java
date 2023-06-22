package org.example.database;

/**
 * Klasa reprezentuje informacje o budynku.
 */
public class Building {
    private String street;
    private String address;
    private int numberOfFloors;
    private boolean hasBasement;

    /**
     * Konstruktor inicjalizuje obiekt Building z podanymi parametrami.
     *
     * @param street         nazwa ulicy
     * @param address        adres budynku
     * @param numberOfFloors liczba kondygnacji budynku
     * @param hasBasement    informacja czy budynek posiada piwnicę
     */
    public Building(String street, String address, int numberOfFloors, boolean hasBasement) {
        this.street = street;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
        this.hasBasement = hasBasement;
    }

    /**
     * Zwraca nazwę ulicy, na której znajduje się budynek.
     *
     * @return nazwa ulicy
     */
    public String getStreet() {
        return street;
    }

    /**
     * Zwraca adres budynku.
     *
     * @return adres budynku
     */
    public String getAddress() {
        return address;
    }

    /**
     * Zwraca liczbę pieter budynku.
     *
     * @return liczba pieter
     */
    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    /**
     * Sprawdza, czy budynek posiada piwnicę.
     *
     * @return true, jeśli budynek posiada piwnicę; false w jeśli nie
     */
    public boolean hasBasement() {
        return hasBasement;
    }
}
