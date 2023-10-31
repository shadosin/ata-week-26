package com.kenzie.groupwork.phonecontacts.helper;

import com.kenzie.groupwork.phonecontacts.activity.ClearContactsActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsStartingAtActivity;
import com.kenzie.groupwork.phonecontacts.dependency.DaggerServiceComponent;
import com.kenzie.groupwork.phonecontacts.dependency.ServiceComponent;
import com.kenzie.groupwork.phonecontacts.activity.AddContactActivity;
import com.kenzie.groupwork.phonecontacts.activity.GetContactsActivity;

public final class ActivityProvider {
    private static final ServiceComponent DAGGER = DaggerServiceComponent.create();

    private ActivityProvider() {
    }

    public static GetContactsActivity provideGetContactsActivity() {
        return DAGGER.provideGetContactsActivity();
    }

    public static AddContactActivity provideAddContactActivity() {
        return DAGGER.provideAddContactActivity();
    }

    public static GetContactsStartingAtActivity provideGetContactsStartingAtActivity() {
        return DAGGER.provideGetContactsStartingAtActivity();
    }

    public static ClearContactsActivity provideClearContactsActivity() {
        return DAGGER.provideClearContactsActivity();
    }

}
