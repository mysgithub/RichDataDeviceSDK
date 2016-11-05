package com.codepath.richdata;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlaybackActivity extends BaseActivity {

  public static final String VIDEO_URL = "http://techslides.com/demos/sample-videos/small.mp4";

  // VideoView is a wrapper around MediaPlayer
  VideoView mVideoView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_video_playback);


    mVideoView = (VideoView) findViewById(R.id.videoView);

    mVideoView.setVideoPath(VIDEO_URL);

    // Create a controller for play/pause/seek
    MediaController mediaController = new MediaController(this);
    mediaController.setAnchorView(mVideoView);
    mediaController.requestFocus();

    mVideoView.setMediaController(mediaController);
    mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
      @Override
      public void onPrepared(MediaPlayer mediaPlayer) {
        mVideoView.start();
      }
    });

  }
}
