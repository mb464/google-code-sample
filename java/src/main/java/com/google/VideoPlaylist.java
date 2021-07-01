package com.google;

import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private String id;
    private List<Video> playlist;

    public VideoPlaylist(String id){
        this.id = id;
    }
    public void addVideo(Video vidToAdd){
        playlist.add(vidToAdd);
    }
    public boolean contain(Video vid){
        return playlist.contains(vid);
    }
    public String getId() {
        return id;
    }

    public List<Video> getPlaylist() {
        return playlist;
    }
}
