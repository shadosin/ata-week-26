package com.kenzie.trees.participants;

/**
 * Participant class representing a single ATA participant.
 */
public class Participant {
    /** Unique ID number for each participant. */
    public int idNumber;
    /** Unique username for each participant. */
    public String username;
    /** Full name for each participant. */
    public String fullname;

    /**
     * Constructs a Participant with the given
     * idNumber, username, and fullname.
     *
     * @param idNumber This Participant's unique ID number.
     * @param username This Participant's unique username.
     * @param fullname This Participant's fullname.
     */
    public Participant(Integer idNumber, String username, String fullname) {
        this.idNumber = idNumber;
        this.username = username;
        this.fullname = fullname;
    }

    /**
     * Builds and returns a String representation of this Participant.
     *
     * @return A String representation of this Participant.
     */
    @Override
    public String toString() {
        return String.format("ID: %d, username: %s, name: %s",
            this.idNumber, this.username, this.fullname);
    }
}
