package com.kenzie.trees.participants;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipantDirectoryTest {
    private static final ParticipantDirectory dir = new ParticipantDirectory();

    @BeforeAll
    public static void addParticipants() {
        // Add the four test participants. NOTE: This is done here, once,
        // to ensure the unique participant IDs are as expected.
        dir.addParticipant(1, "fjones", "Fred Jones");
        dir.addParticipant(2, "dblake", "Daphne Blake");
        dir.addParticipant(3, "vdinkley", "Velma Dinkley");
        dir.addParticipant(4, "nroberts", "Norville Rogers");
    }

    @Test
    public void getParticipantByUsername_multipleParticipants_returnsParticipant() {
        // GIVEN
        // Participants added to ParticipantDirectory @BeforeAll.

        // WHEN
        Participant p1 = dir.getParticipantByUsername("fjones");
        Participant p2 = dir.getParticipantByUsername("dblake");
        Participant p3 = dir.getParticipantByUsername("vdinkley");
        Participant p4 = dir.getParticipantByUsername("nroberts");

        // THEN
        assertEquals("ID: 1, username: fjones, name: Fred Jones", p1.toString(),
            "Participant fjones not constructed correctly.");
        assertEquals("ID: 2, username: dblake, name: Daphne Blake", p2.toString(),
            "Participant dblake not constructed correctly.");
        assertEquals("ID: 3, username: vdinkley, name: Velma Dinkley", p3.toString(),
            "Participant vdinkley not constructed correctly.");
        assertEquals("ID: 4, username: nroberts, name: Norville Rogers", p4.toString(),
            "Participant nroberts not constructed correctly.");
    }

    @Test
    public void getParticipantByID_multipleParticipants_returnsParticipant() {
        // GIVEN
        // Participants added to ParticipantDirectory @BeforeAll.

        // WHEN
        Participant p1 = dir.getParticipantByID(1);
        Participant p2 = dir.getParticipantByID(2);
        Participant p3 = dir.getParticipantByID(3);
        Participant p4 = dir.getParticipantByID(4);

        // THEN
        assertEquals("ID: 1, username: fjones, name: Fred Jones", p1.toString(),
            "Participant fjones not constructed correctly.");
        assertEquals("ID: 2, username: dblake, name: Daphne Blake", p2.toString(),
            "Participant dblake not constructed correctly.");
        assertEquals("ID: 3, username: vdinkley, name: Velma Dinkley", p3.toString(),
            "Participant vdinkley not constructed correctly.");
        assertEquals("ID: 4, username: nroberts, name: Norville Rogers", p4.toString(),
            "Participant nroberts not constructed correctly.");
    }

    @Test
    public void getRosterByUsername_multipleParticipants_returnsSortedRoster() {
        // GIVEN
        // Participants added to ParticipantDirectory @BeforeAll.

        // WHEN
        String actualRoster = dir.getRosterByUsername();
        String expectedRoster =
            "ID: 2, username: dblake, name: Daphne Blake\n" +
            "ID: 1, username: fjones, name: Fred Jones\n" +
            "ID: 4, username: nroberts, name: Norville Rogers\n" +
            "ID: 3, username: vdinkley, name: Velma Dinkley\n";

        // THEN
        assertEquals(expectedRoster, actualRoster,
            "Roster sorted by username not as expected.");
    }

    @Test
    public void getRosterByID_multipleParticipants_returnsSortedRoster() {
        // GIVEN
        // Participants added to ParticipantDirectory @BeforeAll.

        // WHEN
        String actualRoster = dir.getRosterByID();
        String expectedRoster =
            "ID: 1, username: fjones, name: Fred Jones\n" +
            "ID: 2, username: dblake, name: Daphne Blake\n" +
            "ID: 3, username: vdinkley, name: Velma Dinkley\n" +
            "ID: 4, username: nroberts, name: Norville Rogers\n";

        // THEN
        assertEquals(expectedRoster, actualRoster,
            "Roster sorted by ID not as expected.");
    }
}
