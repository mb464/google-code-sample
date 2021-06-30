package com.google;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class VideoPlayer {

  private Video playing;
  private Video paused;

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
    for (Video x:videos) {
      System.out.println("  "+ x.getTitle() + x.getVideoId() +  x.getTags());
    }

  }

  public void playVideo(String videoId) {
    if(playing != null || paused != null){
      stopVideo();
    }
    playing = videoLibrary.getVideo(videoId);
    if (playing == null){
      System.out.println("Cannot play video: Video does not exist");
    }else{
      System.out.println("Playing video: "+ playing.getTitle());
    }

  }

  public void stopVideo() {
    if (playing == null && paused == null){
      System.out.println("Cannot stop video: No video is currently playing");
    }else if(playing == null && paused != null){
      System.out.println("Stopping video: "+paused.getTitle());
      paused = null;
    }else{
      System.out.println("Stopping video: "+playing.getTitle());
      playing = null;
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
    if(paused != null){
      System.out.println("Video already paused: "+paused.getTitle());
      playing = null;
    }

    if (playing == null){
      System.out.println("Cannot pause video: No video is currently playing");
    }else{
      paused = new Video(playing.getTitle(), playing.getVideoId(), playing.getTags());
      System.out.println("Pausing video: "+paused.getTitle());
      playing = null;
    }

  }

  public void continueVideo() {
    if(paused == null){
      System.out.println("Cannot continue video: Video is not paused");
    }else {
      playing = new Video(paused.getTitle(), paused.getVideoId(), paused.getTags());
      paused = null;
    }

  }

  public void showPlaying() {
    System.out.println("showPlaying needs implementation");
  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
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