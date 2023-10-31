package com.kenzie.futures.musicaccountreceiver.callables;

import com.kenzie.futures.musicaccountreceiver.callables.resources.MusicAccountService;

public class ImportAccountTask {
    // PARTICIPANTS: Complete this class's declaration and implement the call() method.

    private MusicAccountService accountService;
    private String accountID;

    /**
     * Constructor for ImportAccountTask.
     * @param acctService MusicAccountService reference.
     * @param acctID Account ID to access.
     */
    public ImportAccountTask(MusicAccountService acctService, String acctID) {
        accountService = acctService;
        accountID = acctID;
    }

    public String getAccountID() {
        return accountID;
    }

    public MusicAccountService getAccountService() {
        return accountService;
    }

    /**
     * Code to be executed in ExecutorService.
     * PARTICIPANTS: complete this method's declaration and implementation. It should retrieve the AmazonMusicAccount
     *   from the MusicAccountService.
     * @return AmazonMusicAccount object.
     */
    public Object call() {
        return null;
    }
}
