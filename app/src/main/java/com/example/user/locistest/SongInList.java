package com.example.user.locistest;

/**
 * Created by ewigkeit on 25.04.17.
 */

public class SongInList {
    public String link;
    public String name;
    public String duration;
    public int songId;
    public String startStop = "Start";

    public SongInList(int songId,String link, String name, String duration) {
        this.songId = songId;
        this.link = link;
        this.name = name;
        this.duration = duration;
    }

    public SongInList() {}
}
