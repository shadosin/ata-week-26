package com.kenzie.groupwork.phonecontacts.activity;

import com.kenzie.groupwork.phonecontacts.dao.ContactDao;
import com.kenzie.groupwork.phonecontacts.model.Contact;
import com.kenzie.groupwork.phonecontacts.model.Name;
import com.kenzie.groupwork.phonecontacts.model.SortBy;
import com.kenzie.groupwork.phonecontacts.model.SortOrder;

import java.util.SortedMap;
import javax.inject.Inject;

/**
 * Handles requests to retrieve a subgroup of contacts.
 */
public class GetContactsStartingAtActivity {

    private final ContactDao contactDao;

    /**
     * Constructs an activity with the given dao.
     * @param contactDao Dao to use to get subgroup on contacts.
     */
    @Inject
    public GetContactsStartingAtActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    /**
     * Retrieves a portion of the contacts whose Name is equal to or after the given startKey based on the sorting
     * parameters.
     *
     * @param start The Name that should be the first contact in the returned Map
     * @param sortBy Attribute to sort contacts by, e.g. first name, last name.
     * @param sortOrder order to return contacts, either ascending or descending.
     * @return portion of contacts that includes startKey and all contacts after startKey based on requested sorted
     * order.
     */
    public SortedMap<Name, Contact> handleRequest(Name start, SortBy sortBy, SortOrder sortOrder) {
        return contactDao.getContactsStartingAt(start, sortBy, sortOrder);
    }
}
