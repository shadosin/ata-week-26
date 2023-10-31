package com.kenzie.trees.tollroad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Note: Students do not make any changes to the Vehicle class for this
// exercise; this test is included to ensure they did not do so accidentally.
public class VehicleTest {
    @Test
    public void constructor_toString_equal() {
        // GIVEN
        Vehicle v;

        // WHEN
        v = new Vehicle("CIA432LMN");

        // THEN
        assertEquals("Description: CIA432LMN, Toll Count: 1", v.toString(),
            "Participant fjones not constructed correctly.");
    }

    @Test
    public void addToll_toString_equal() {
        // GIVEN
        Vehicle v;

        // WHEN
        v = new Vehicle("CIA432LMN");
        v.addToll();

        // THEN
        assertEquals("Description: CIA432LMN, Toll Count: 2", v.toString(),
            "Participant fjones not constructed correctly.");
    }
}
