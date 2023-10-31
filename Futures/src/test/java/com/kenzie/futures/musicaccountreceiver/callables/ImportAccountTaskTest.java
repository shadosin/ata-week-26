package com.kenzie.futures.musicaccountreceiver.callables;

import com.kenzie.futures.musicaccountreceiver.callables.resources.AmazonMusicAccount;
import com.kenzie.futures.musicaccountreceiver.callables.resources.MusicAccountService;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImportAccountTaskTest {

    @Test
    public void callableInterface_checkDeclaration_implementsCallable() {
        // GIVEN
        ImportAccountTask callableObj = new ImportAccountTask(new MusicAccountService(), "DR345");
        Class<?> callableClass = callableObj.getClass();

        // WHEN
        boolean result = Callable.class.isAssignableFrom(callableClass);

        // THEN
        assertTrue(result, "ImportAccountTask isn't a Callable!");
    }

    @Test
    public void call_isReturnTypeAccount_correctReturnType() {
        // GIVEN
        ImportAccountTask testTask = new ImportAccountTask(new MusicAccountService(), "SR6345");
        Class<?> callableClass = testTask.getClass();
        Method[] classMethods = callableClass.getMethods();
        boolean result = false;

        // WHEN
        for (Method method : classMethods) {
            if (method.getName().equals("call")) {
                if (method.getReturnType().equals(AmazonMusicAccount.class)) {
                    result = true;
                }
            }
        }

        // THEN
        assertTrue(result, "ImportAccountTask's call() does not have the correct return type!");
    }

    @Test
    public void call_returnsCorrectAccount_accountReturned() {
        // GIVEN
        MusicAccountService accountService = new MusicAccountService();
        ImportAccountTask testTask = new ImportAccountTask(accountService, "SR6345");
        AmazonMusicAccount expectedResult = accountService.getAccount("SR6345");

        // WHEN
        AmazonMusicAccount result = (AmazonMusicAccount) testTask.call();

        // THEN
        assertEquals(expectedResult, result, "ImportAccountTask's call() does not return accounts correctly!");
    }
}
