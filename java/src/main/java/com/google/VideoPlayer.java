package com.google;

import java.util.*;

public class VideoPlayer {

  private Video playing;
  private Video paused;
  private List<VideoPlaylist> playlists;

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");

    List<Video> videos =videoLibrary.getVideos();
    ArrayList<String> name = new ArrayList<>();
    for (Video x:videos) {
      name.add(name.size(),x.getVideoId());
    }
    Collections.sort(name);

    for (String x :name) {
      System.out.println(videoLibrary.getVideo(x).getTitle()+" (" + videoLibrary.getVideo(x).getVideoId()+") " +  videoLibrary.getVideo(x).getTags().toString().replaceAll(",",""));

    }

  }

  public void playVideo(String videoId) {
    if (videoLibrary.getVideo(videoId) == null){
      System.out.println("Cannot play video: Video does not exist");
    }else if(playing != null ||(paused != null && paused.getVideoId() != videoId)){
      stopVideo();
    }

    if (videoLibrary.getVideo(videoId) != null){
      playing = videoLibrary.getVideo(videoId);
      System.out.println("Playing video: "+ playing.getTitle());
    }

  }

  public void stopVideo() {
    if (playing == null){
      System.out.println("Cannot stop video: No video is currently playing");
    }else{
      System.out.println("Stopping video: "+playing.getTitle());
      playing = null;
      paused = null;
    }
  }

  public void playRandomVideo() {
    List<Video> vlib = videoLibrary.getVideos();
    if (playing != null){
      stopVideo();
    }

    if (vlib.size() < 1){
      System.out.println("No videos available");
    }else{
      Random rand = new Random(); //instance of random class
      int int_random = rand.nextInt(vlib.size());
      List<Video> videos = vlib;
      playVideo(videos.get(int_random).getVideoId());
    }
  }

  public void pauseVideo() {
    try{
      if(paused.getVideoId() == playing.getVideoId()){
        System.out.println("Video already paused: "+paused.getTitle());
      }
    }catch (Exception e){
      if (playing == null){
        System.out.println("Cannot pause video: No video is currently playing");
      }else{
        paused = new Video(playing.getTitle(), playing.getVideoId(), playing.getTags());
        System.out.println("Pausing video: "+paused.getTitle());
      }

    }

  }

  public void continueVideo() {
    if(playing == null){
      System.out.println("Cannot continue video: No video is currently playing");
    }else if (paused == null){
      System.out.println("Cannot continue video: Video is not paused");
    }else {
      playing = new Video(paused.getTitle(), paused.getVideoId(), paused.getTags());
      System.out.println("Continuing video: "+playing.getTitle());
      paused = null;
    }

  }

  public void showPlaying() {
    if(playing ==null){
      System.out.println("No video is currently playing");
    }else {
      String output = "";
      if(paused != null){
        output = " - PAUSED";
      }
      System.out.println("Currently playing: "+playing.getTitle()+" ("+playing.getVideoId()+") "+playing.getTags().toString().replaceAll(",","")+output);
    }

  }

  public void createPlaylist(String playlistName) {

    if (playlistName.indexOf(' ') == -1){
      boolean exits = false;
      for (VideoPlaylist x:playlists) {
        if (x.getId().toLowerCase()==playlistName.toLowerCase()){
          exits = true;
        }
      }
      if (!exits){
        System.out.println("Cannot create playlist: A playlist with the same name already exists");
      }else{
        playlists.add(new VideoPlaylist(playlistName));
        System.out.println("Successfully created new playlist: "+playlistName);
      }

    }else {
      System.out.println("Invalid name");
    }

  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    boolean exits = false;
    int playerIndex = 0;
    for (VideoPlaylist x:playlists) {
      playerIndex++;
      if (x.getId().toLowerCase()==playlistName.toLowerCase()){
        exits = true;
        break;
      }
    }

    if (exits){
      exits = false;
      if (videoLibrary.getVideo(videoId)!= null){
        exits = true;
      }
      if (exits){
        if(playlists.get(playerIndex).contain(videoLibrary.getVideo(videoId))){
          System.out.println("Cannot add video to my_PLAYlist: Video already added");
        }else {
          playlists.get(playerIndex).addVideo(videoLibrary.getVideo(videoId));
          System.out.println("Added video to "+playlistName+" : "+videoId);
        }
      }else {
        System.out.println("Cannot add video to my_playlist: Video does not exist");
      }
    }else{
      System.out.println("Cannot add video to another_playlist: Playlist does not exist");
    }
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    if (playlists.size() ==0){
      System.out.println("No playlists exist yet");
    }

  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}