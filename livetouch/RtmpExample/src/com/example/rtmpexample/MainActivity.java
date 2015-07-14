package com.example.rtmpexample;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends ActionBarActivity {

	VideoView videoView;
//	String streamURL = "rtmp://54.166.143.92:1935/vod/mp4:livetouch-demo-2-small.mp4";
	String streamURL = "udp://236.0.0.1:2000";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_main);
		if (!LibsChecker.checkVitamioLibs(this))
			return;
		videoView = (VideoView) findViewById(R.id.videoView);
		videoView.setVideoPath(streamURL);
		videoView.requestFocus();
		MediaController controller = new MediaController(this);
		videoView.setMediaController(controller);
		videoView.setOnPreparedListener(new OnPreparedListener() {

			@Override
			public void onPrepared(MediaPlayer arg0) {
				if (!videoView.isPlaying()) {
					videoView.start();
				}

			}
		});

		// videoView.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View v, MotionEvent event) {
		// LayoutParams params = videoView.getLayoutParams();
		// params.height = 508;
		// params.width = 1019;
		// videoView.setLayoutParams(params);
		// return false;
		// }
		// });

	}

}
