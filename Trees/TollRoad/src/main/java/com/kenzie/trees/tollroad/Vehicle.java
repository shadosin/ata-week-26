package com.kenzie.trees.tollroad;

/**
 * Vehicle class representing a single Vehicle on a toll road.
 */
public class Vehicle {
    /**
     * This vehicle's description. The first character is a single
     * character code describing the type of vehicle (C = car, T = truck,
     * S = semi-trailer, etc.) The second and third characters indicate
     * the two-letter state code in which the vehicle is registered.
     * The remaining characters are the vehicle's licence plate characters.
     */
    public String description;
    /**
     * This vehicle's current toll count. Initialized to 1 when a new
     * vehicle is created as that happens when the vehicle first passes
     * through an automated toll reader.
     */
    public int tollCount;

    /**
     * Constructs a Vehicle with the given description and
     * initial toll count of 1.
     *
     * @param description This vehicle's description.
     */
    public Vehicle(String description) {
        this.description = description;
        this.tollCount = 1;
    }

    /**
     * Increments the toll count for this Vehicle.
     */
    public void addToll() {
        this.tollCount++;
    }

    /**
     * Builds and returns a String representation of this Vehicle.
     *
     * @return A String representation of this Vehicle.
     */
    public String toString() {
        return String.format("Description: %s, Toll Count: %d",
            this.description, this.tollCount);
    }
}
