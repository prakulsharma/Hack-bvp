package com.developer.jatin.hack_bvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class splash extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        
//         handler that closes the splash screen after 10 seconds
        Handler handle = new Handler();
        handle.postDelayed(new Runnable(){
            @Override
            public void run() {
//                 intent used to close the current activity and witch to MainScreen activity
                Intent mainIntent = new Intent(splash.this,MainScreen.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
