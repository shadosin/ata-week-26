package com.kenzie.futures.musicaccountreceiver.callables;

import com.kenzie.futures.musicaccountreceiver.callables.resources.AmazonMusicAccount;
import com.kenzie.futures.musicaccountreceiver.callables.resources.MusicAccountService;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MusicAccountRetrieverTest {

    @Test
    public void retrieveAccount_ifFutureNull_futureNotNull() throws ExecutionException, InterruptedException {
        // GIVEN
        MusicAccountRetriever retrieverObj = new MusicAccountRetriever();

        // WHEN
        Future<AmazonMusicAccount> result = retrieverObj.retrieveAccount("MM123");

        // THEN
        assertNotNull(result, "retrieveAccount() returns a null Future result!");
    }

    @Test
    public void retrieveAccount_returnCorrectData_returnsData() throws ExecutionException, InterruptedException {
        // GIVEN
        MusicAccountService accountService = new MusicAccountService();
        MusicAccountRetriever retrieverObj = new MusicAccountRetriever();

        //Calling retrieveAccount here to avoid blocking issues.
        Future<AmazonMusicAccount> futureResult = retrieverObj.retrieveAccount("MM123");

        String expectedResult = accountService.getAccount("MM123").getAccountName();

        // WHEN
        String result = futureResult.get().getAccountName();

        // THEN
        assertEquals(expectedResult, result, "retrieveAccount() doesn't return correct data!");
    }
}
