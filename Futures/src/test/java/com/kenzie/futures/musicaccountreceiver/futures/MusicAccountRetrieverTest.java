package com.kenzie.futures.musicaccountreceiver.futures;

import com.kenzie.futures.musicaccountreceiver.futures.resources.AmazonMusicAccount;
import com.kenzie.futures.musicaccountreceiver.futures.resources.MusicAccountService;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MusicAccountRetrieverTest {

    @Test
    public void retrieveAccounts_retrievingResults_correctResults() {
        // GIVEN
        MusicAccountService accountService = new MusicAccountService();
        MusicAccountRetriever retrieverTest = new MusicAccountRetriever();
        List<String> accountIDs = new ArrayList<>(Arrays.asList(
                "MM123", "DR345", "SR6345", "RR441", "JR098"
        ));

        List<String> expectedResults = new ArrayList<>();
        for (String id : accountIDs) {
            expectedResults.add(accountService.getAccount(id).getAccountName());
        }

        // WHEN
        List<AmazonMusicAccount> accounts = retrieverTest.retrieveAccounts(accountIDs);
        List<String> results = new ArrayList<>();
        for (AmazonMusicAccount account : accounts) {
            results.add(account.getAccountName());
        }

        // THEN
        assertEquals(expectedResults, results, "retrieveAccounts() is not returning correct results!");
    }
}
