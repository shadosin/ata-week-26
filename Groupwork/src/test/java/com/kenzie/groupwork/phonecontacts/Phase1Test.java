package com.kenzie.groupwork.phonecontacts;

import com.kenzie.groupwork.phonecontacts.activity.AddContactActivity;
import com.kenzie.groupwork.phonecontacts.activity.ClearContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsStartingAtActivity;
import com.kenzie.groupwork.phonecontacts.model.Contact;
import com.kenzie.groupwork.phonecontacts.model.Name;
import com.kenzie.groupwork.phonecontacts.model.SortBy;
import com.kenzie.groupwork.phonecontacts.model.SortOrder;
import com.kenzie.groupwork.phonecontacts.helper.ActivityProvider;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Phase1Test {

    private AddContactActivity addContactActivity;
    private GetContactsActivity getContactsActivity;
    private GetContactsStartingAtActivity getContactsStartingAtActivity;
    private ClearContactsActivity clearContactsActivity;
    private Contact contact1;
    private Contact contact2;
    private Contact contact3;

    @BeforeEach
    public void setup() {
        addContactActivity = ActivityProvider.provideAddContactActivity();
        getContactsActivity = ActivityProvider.provideGetContactsActivity();
        getContactsStartingAtActivity = ActivityProvider.provideGetContactsStartingAtActivity();
        clearContactsActivity = ActivityProvider.provideClearContactsActivity();
        clearContactsActivity.handleRequest();
        contact1 = addContactActivity.handleRequest(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
        contact2 = addContactActivity.handleRequest(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
        contact3 = addContactActivity.handleRequest(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(15), RandomStringUtils.randomNumeric(10), RandomStringUtils.randomAlphanumeric(20));
    }

    @Test
    public void clearContacts_afterAddingContacts_noContactsFound() {
        // GIVEN - in setup()

        // WHEN
        clearContactsActivity.handleRequest();
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(SortBy.FIRST_NAME, SortOrder.DESCENDING);

        // THEN
        assertTrue(contacts.isEmpty());
    }

    @Test
    public void getContacts_noSortParamsProvided_returnsContactsDefaultOrder(){
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(null, null);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getLastName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        assertEquals(new ArrayList<>(expectedKeys), new ArrayList<>(contacts.keySet()),
                     "Contacts were not ordered by default order: last name ascending.");

    }

    @Test
    public void getContacts_byLastNameAscending_returnsContactsInOrder(){
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(SortBy.LAST_NAME, SortOrder.ASCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getLastName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        assertEquals(new ArrayList<>(expectedKeys), new ArrayList<>(contacts.keySet()),
                     "Contacts were not ordered by last name ascending.");

    }

    @Test
    public void getContacts_byFirstNameAscending_returnsContactsInOrder(){
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(SortBy.FIRST_NAME, SortOrder.ASCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getFirstName));
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        assertEquals(new ArrayList<>(expectedKeys), new ArrayList<>(contacts.keySet()),
                     "Contacts were not ordered by first name ascending.");

    }

    @Test
    public void getContacts_byLastNameDescending_returnsContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(SortBy.LAST_NAME, SortOrder.DESCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getLastName).reversed());
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        assertEquals(new ArrayList<>(expectedKeys), new ArrayList<>(contacts.keySet()),
                     "Contacts were not ordered by last name descending.");

    }

    @Test
    public void getContacts_byFirstNameDescending_returnsContactsInOrder() {
        // GIVEN - in setup()

        // WHEN
        SortedMap<Name, Contact> contacts = getContactsActivity.handleRequest(SortBy.FIRST_NAME, SortOrder.DESCENDING);

        // THEN
        TreeSet<Name> expectedKeys = new TreeSet<>(Comparator.comparing(Name::getFirstName).reversed());
        expectedKeys.add(contact1.getName());
        expectedKeys.add(contact2.getName());
        expectedKeys.add(contact3.getName());
        assertEquals(new ArrayList<>(expectedKeys), new ArrayList<>(contacts.keySet()),
                     "Contacts were not ordered by first name descending.");

    }

}
