package com.kenzie.futures.musicaccountreceiver.futures.resources;

public class AmazonMusicAccount {
    private String accountName;
    private int numOfPlaylists;
    private String topGenre;

    /**
     * Constructor for AmazonMusicAccount.
     * @param name Name of account.
     * @param playlists Number of playlists.
     * @param genre Top music genre.
     */
    public AmazonMusicAccount(String name, int playlists, String genre) {
        accountName = name;
        numOfPlaylists = playlists;
        topGenre = genre;
    }

    public String getAccountName() {
        return accountName;
    }

    public int getNumOfPlaylists() {
        return numOfPlaylists;
    }

    public String getTopGenre() {
        return topGenre;
    }
}
