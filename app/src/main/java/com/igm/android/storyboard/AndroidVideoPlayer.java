package com.igm.android.storyboard;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.VideoView;

//Implement SurfaceHolder interface to Play video
//Implement this interface to receive information about changes to the surface
public class AndroidVideoPlayer extends Fragment implements SurfaceHolder.Callback {
    private LinearLayout ll;
    private FragmentActivity fa;

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    boolean pausing = false;
    ;
    VideoView mVideoView;


    /**
     * Called when the activity is first created.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fa = (FragmentActivity) super.getActivity();
        ll = (LinearLayout) inflater.inflate(R.layout.video, container, false);


        //    getWindow().setFormat(PixelFormat.UNKNOWN);

        //Displays a video file.   
        mVideoView = (VideoView) ll.findViewById(R.id.videoview);


        String uriPath = "android.resource://com.algeriabrief/" + R.raw.algerie1830;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        Button play = (Button) ll.findViewById(R.id.play);
        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                mVideoView.start();


            }
        });

        Button pause = (Button) ll.findViewById(R.id.pause);
        pause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                mVideoView.pause();

            }
        });
        //


        return ll;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
}
 