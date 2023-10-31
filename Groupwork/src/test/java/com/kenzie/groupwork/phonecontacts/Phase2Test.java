package com.kenzie.groupwork.phonecontacts;

import com.kenzie.groupwork.phonecontacts.activity.AddContactActivity;
import com.kenzie.groupwork.phonecontacts.activity.ClearContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsStartingAtActivity;
import com.kenzie.groupwork.phonecontacts.helper.ActivityProvider;
import com.kenzie.groupwork.phonecontacts.model.Contact;
import com.kenzie.groupwork.phonecontacts.model.Name;
import com.kenzie.groupwork.phonecontacts.model.SortBy;
import com.kenzie.groupwork.phonecontacts.model.SortOrder;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Phase2Test {

    private AddContactActivity addContactActivity;
    private GetContactsActivity getContactsActivity;
    private GetContactsStartingAtActivity getContactsStartingAtActivity;
    private ClearContactsActivity clearContactsActivity;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;

    @BeforeEach
    public void setup() {
        addContactActivity = ActivityProvider.provideAddContactActivity();
        getContactsActivity = ActivityProvider.provideGetContactsActivity();
        getContactsStartingAtActivity = ActivityProvider.provideGetContactsStartingAtActivity();
        clearContactsActivity = ActivityProvider.provideClearContactsActivity();
        clearContactsActivity.handleRequest();
        contact1 = addContactActivity.handleRequest( RandomStringUtils.randomAlphabetic(10),  RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
        contact2 = addContactActivity.handleRequest( RandomStringUtils.randomAlphabetic(10),  RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
        contact3 = addContactActivity.handleRequest( RandomStringUtils.randomAlphabetic(10),  RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
        contact4 = addContactActivity.handleRequest( RandomStringUtils.randomAlphabetic(10),  RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));

    }

    @Test
    public void getContactsStartingAt_lastNameAscending_returnsSubGroupContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsStartingAtActivity.handleRequest(contact4.getName(), SortBy.LAST_NAME, SortOrder.ASCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getLastName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        expectedKeys.add(contact4.getName());
        assertEquals(expectedKeys.tailSet(contact4.getName()), contacts.keySet(), "Returned incorrect group of contacts");

    }

    @Test
    public void getContactsStartingAt_firstNameAscending_returnsSubGroupContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsStartingAtActivity.handleRequest(contact4.getName(), SortBy.FIRST_NAME, SortOrder.ASCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getFirstName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        expectedKeys.add(contact4.getName());
        assertEquals(expectedKeys.tailSet(contact4.getName()), contacts.keySet(), "Returned incorrect group of contacts");

    }

    @Test
    public void getContactsStartingAt_lastNameDescending_returnsSubGroupContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsStartingAtActivity.handleRequest(contact4.getName(), SortBy.LAST_NAME, SortOrder.DESCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getLastName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        expectedKeys.add(contact4.getName());
        assertEquals(expectedKeys.descendingSet().tailSet(contact4.getName()), contacts.keySet(), "Returned incorrect group of contacts");

    }

    @Test
    public void getContactsStartingAt_firstNameDescending_returnsSubGroupContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsStartingAtActivity.handleRequest(contact4.getName(), SortBy.FIRST_NAME, SortOrder.DESCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getFirstName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        expectedKeys.add(contact4.getName());
        assertEquals(expectedKeys.descendingSet().tailSet(contact4.getName()), contacts.keySet(), "Returned incorrect group of contacts");

    }
}
