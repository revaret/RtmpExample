package com.example.rtmpexample2;
/*
import java.io.IOException;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.app.Activity;

public class MainActivity extends Activity implements SurfaceHolder.Callback, OnPreparedListener{
 
 MediaPlayer mediaPlayer;
 SurfaceHolder surfaceHolder;
 SurfaceView playerSurfaceView;
 String videoSrc = "rtmp://54.166.143.92:1935/vod/mp4:livetouch-demo-2-small.mp4";


 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  playerSurfaceView = (SurfaceView)findViewById(R.id.playersurface);

        surfaceHolder = playerSurfaceView.getHolder();
        surfaceHolder.addCallback(this);
 }

 @Override
 public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void surfaceCreated(SurfaceHolder arg0) {

        try {
         mediaPlayer = new MediaPlayer();
            mediaPlayer.setDisplay(surfaceHolder);
   mediaPlayer.setDataSource(videoSrc);
   mediaPlayer.prepare();
   mediaPlayer.setOnPreparedListener(this);
   mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
  } catch (IllegalArgumentException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (SecurityException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IllegalStateException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }

 @Override
 public void surfaceDestroyed(SurfaceHolder arg0) {
  // TODO Auto-generated method stub
  
 }

 @Override
 public void onPrepared(MediaPlayer mp) {
  mediaPlayer.start();
 }

}*/

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
   /** Called when the activity is first created. */
       WebView sampleWeb;
       String htmlText;
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
      
       setContentView(R.layout.activity_main);
      
       sampleWeb=(WebView)findViewById(R.id.webView);
       WebSettings webSettings=sampleWeb.getSettings();

       sampleWeb.getSettings().setJavaScriptEnabled(true);
       //sampleWeb.getSettings().setPluginsEnabled(true);
       sampleWeb.setWebViewClient(new WebViewClient());
      
     //  sampleWeb.loadUrl("m.google.com");
       htmlText="<!DOCTYPE html> ";
       htmlText+="<html lang='en'>";
       htmlText+="<head><meta charset='utf-8'>";
      
       htmlText+="</head>";
       htmlText+="<body style='margin:0; pading:0;background-color: #000000;'>";
       htmlText+="<div style='color:white'>Loading the player ...</div>";
       htmlText+="<script type='text/javascript' src='http://shourav.com/android/jwplayer.min.js'></script>";

       htmlText+="<div id='mediaspace'>This text will be replaced</div>";

       htmlText+="<script type='text/javascript'>";
       htmlText+="jwplayer('mediaspace').setup({";
       htmlText+="'flashplayer': 'http://developer.longtailvideo.com/svn/trunk/fl5/player.swf',";
       htmlText+="'file': 'rtmp://54.166.143.92:1935/vod/mp4:livetouch-demo-2-small.mp4',";
       htmlText+="'streamer': 'rtmp://54.166.143.92:1935/vod/mp4:livetouch-demo-2-small.mp4',";
       htmlText+="'controlbar': 'bottom',";
       htmlText+="'width': '200',";
       htmlText+="'height': '150'";
       htmlText+="});";
       htmlText+="</script>";

       htmlText+="</body>";
               sampleWeb.loadData(htmlText, "text/html", "utf-8");

   }
}

