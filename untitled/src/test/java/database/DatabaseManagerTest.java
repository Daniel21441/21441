package database;

import org.example.database.Building;
import org.example.database.DatabaseManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DatabaseManagerTest {
    private static final String TEST_DATABASE_FILE = "test_building_database.txt";
    private DatabaseManager databaseManager;

    @Before
    public void setUp() {
        databaseManager = new DatabaseManager(TEST_DATABASE_FILE);
    }

    @Test
    public void testSaveAndRetrieveBuilding() {
        Building building = new Building("Street 1", "Address 1", 5, true);
        databaseManager.saveBuilding(building);

        assertEquals(1, databaseManager.getAllBuildings().size());
        Building retrievedBuilding = databaseManager.getAllBuildings().get(0);
        assertEquals("Street 1", retrievedBuilding.getStreet());
        assertEquals("Address 1", retrievedBuilding.getAddress());
        assertEquals(5, retrievedBuilding.getNumberOfFloors());
        assertTrue(retrievedBuilding.hasBasement());
    }


    @After
    public void deleteTestDatabaseFile() {
        File file = new File(TEST_DATABASE_FILE);
        file.delete();
    }
}