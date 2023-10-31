package com.kenzie.trees.tollroad;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TollRoadTest {
    private static final TollRoad tollRoad = new TollRoad();

    @BeforeAll
    public static void addTolls() {
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
        tollRoad.addToll("TIA765QRS");
        tollRoad.addToll("CCO123ABC");
        tollRoad.addToll("SFL456DEF");
        tollRoad.addToll("CIA432LMN");
        tollRoad.addToll("TCO789XYZ");
    }

    @Test
    public void getVehicleReportByDescription_multipleVehicles_returnsSortedVehicles() {
        // GIVEN
        // Vehicles added to TollRoad @BeforeAll.

        // WHEN
        String actualVehicles = tollRoad.getVehicleReportByDescription();
        String expectedVehicles =
            "Description: CCO123ABC, Toll Count: 2\n" +
            "Description: CIA432LMN, Toll Count: 3\n" +
            "Description: SFL456DEF, Toll Count: 2\n" +
            "Description: TCO789XYZ, Toll Count: 4\n" +
            "Description: TIA765QRS, Toll Count: 1\n";

        // THEN
        assertEquals(expectedVehicles, actualVehicles,
            "Vehicles sorted by description not as expected.");
    }

    @Test
    public void getVehicleReportByState_multipleVehicles_returnsSortedVehicles() {
        // GIVEN
        // Vehicles added to TollRoad @BeforeAll.

        // WHEN
        String actualVehicles = tollRoad.getVehicleReportByState();
        String expectedVehicles =
            "Description: CCO123ABC, Toll Count: 2\n" +
            "Description: TCO789XYZ, Toll Count: 4\n" +
            "Description: SFL456DEF, Toll Count: 2\n" +
            "Description: CIA432LMN, Toll Count: 3\n" +
            "Description: TIA765QRS, Toll Count: 1\n";

        // THEN
        assertEquals(expectedVehicles, actualVehicles,
            "Vehicles sorted by state not as expected.");
    }
}
