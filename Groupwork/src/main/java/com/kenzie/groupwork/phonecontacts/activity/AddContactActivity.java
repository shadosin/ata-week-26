package com.kenzie.groupwork.phonecontacts.activity;

import com.kenzie.groupwork.phonecontacts.dao.ContactDao;
import com.kenzie.groupwork.phonecontacts.model.Contact;
import com.kenzie.groupwork.phonecontacts.model.Name;

import javax.inject.Inject;

/**
 * Handles requests to add a contact.
 */
public class AddContactActivity {

    private final ContactDao contactDao;

    /**
     * Constructs an activity with the given dao.
     * @param contactDao Dao to use to add contacts.
     */
    @Inject
    public AddContactActivity(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    /**
     * Creates a contact with the given parameters and adds to phone contacts.
     *
     * @param firstName first name of contact
     * @param lastName last name of contact
     * @param phoneNumber phone number of contact
     * @param email email of contact
     * @return added Contact object.
     */
    public Contact handleRequest(final String firstName, final String lastName, final String phoneNumber,
                              final String email) {
        Contact contact = Contact.builder()
            .withName(Name.builder().withFirstName(firstName).withLastName(lastName).build())
            .withPhoneNumber(phoneNumber)
            .withEmail(email).build();
        return contactDao.addContact(contact);
    }

}
