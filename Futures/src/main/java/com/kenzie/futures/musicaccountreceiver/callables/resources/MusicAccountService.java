package com.kenzie.futures.musicaccountreceiver.callables.resources;

import java.util.HashMap;
import java.util.Map;

public class MusicAccountService {

    private Map<String, AmazonMusicAccount> accounts;

    /**
     * Constructor for MusicAccountService.
     */
    public MusicAccountService() {
        accounts = new HashMap<>();
        accounts.put("MM123", new AmazonMusicAccount("MaryMajor", 7, "Pop"));
        accounts.put("DR345", new AmazonMusicAccount("DiegoRamirez", 4, "Rock"));
        accounts.put("SR6345", new AmazonMusicAccount("ShirleyRodriguez", 6, "Country"));
        accounts.put("RR441", new AmazonMusicAccount("RichardRoe", 2, "EDM"));
        accounts.put("JR098", new AmazonMusicAccount("JaneRoe", 4, "Classical"));
    }

    /**
     * Returns mock account based on the index.
     * @param accountID ID of account to return.
     * @return AmazonMusicAccount of the account.
     */
    public AmazonMusicAccount getAccount(String accountID) {
        return accounts.get(accountID);
    }
}
