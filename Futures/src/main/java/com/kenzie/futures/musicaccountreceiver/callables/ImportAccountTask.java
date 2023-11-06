package com.kenzie.futures.musicaccountreceiver.callables;

import com.kenzie.futures.musicaccountreceiver.callables.resources.AmazonMusicAccount;
import com.kenzie.futures.musicaccountreceiver.callables.resources.MusicAccountService;

import java.util.concurrent.Callable;

public class ImportAccountTask implements Callable<AmazonMusicAccount> {
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
    public AmazonMusicAccount call() {
        return accountService.getAccount(accountID);
    }
}
