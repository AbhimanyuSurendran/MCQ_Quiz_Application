package abhimanyu.surendran.mcqquizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

public class LauncherActivity extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGTH = 7000; // 6 seconds
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        videoView = findViewById(R.id.videoView);
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.intro);
        videoView.setVideoURI(videoUri);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Intent mainIntent = new Intent(LauncherActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });
        videoView.start();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
            }
        }, SPLASH_DISPLAY_LENGTH);

    }

}