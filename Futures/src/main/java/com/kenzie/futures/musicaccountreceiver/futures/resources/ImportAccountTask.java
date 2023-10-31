package com.kenzie.futures.musicaccountreceiver.futures.resources;

import java.util.concurrent.Callable;

public class ImportAccountTask implements Callable<AmazonMusicAccount> {

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

    /**
     * Code to be executed in ExecutorService.
     * @return Requested account object.
     */
    public AmazonMusicAccount call() {
        return accountService.getAccount(accountID);
    }
}
