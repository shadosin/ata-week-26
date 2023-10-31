package com.kenzie.groupwork.phonecontacts.dependency;

import com.kenzie.groupwork.phonecontacts.activity.AddContactActivity;
import com.kenzie.groupwork.phonecontacts.activity.ClearContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsStartingAtActivity;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Declares the dependency roots that Dagger will provide.
 */
@Singleton
@Component
public interface ServiceComponent {
    AddContactActivity provideAddContactActivity();

    GetContactsActivity provideGetContactsActivity();

    GetContactsStartingAtActivity provideGetContactsStartingAtActivity();

    ClearContactsActivity provideClearContactsActivity();

}
