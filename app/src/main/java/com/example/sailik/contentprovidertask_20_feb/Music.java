package com.example.sailik.contentprovidertask_20_feb;

/**
 * Created by saili.k on 20-02-2017.
 */

public class Music {

    private String albumName,trackName;

    public Music() {
    }

    public Music(String albumName, String trackName) {
        this.albumName = albumName;
        this.trackName = trackName;
        //this.year = year;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String name) {
        this.albumName = name;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String name) {
        this.trackName = name;
    }


}
