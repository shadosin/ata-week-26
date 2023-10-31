package com.kenzie.trees.participants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Note: Students do not make any changes to the Participant class for this
// exercise; this test is included to ensure they did not do so accidentally.
public class ParticipantTest {
    @Test
    public void toString_newParticipant_returnsParticipant() {
        // GIVEN
        Participant p1;
        Participant p2;
        Participant p3;
        Participant p4;

        // WHEN
        p1 = new Participant(1, "fjones", "Fred Jones");
        p2 = new Participant(2, "dblake", "Daphne Blake");
        p3 = new Participant(3, "vdinkley", "Velma Dinkley");
        p4 = new Participant(4, "nroberts", "Norville Rogers");

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
}
