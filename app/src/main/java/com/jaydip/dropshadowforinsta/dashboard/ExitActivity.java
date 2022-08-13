package com.jaydip.dropshadowforinsta.dashboard;

import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.jaydip.dropshadowforinsta.R;

public class ExitActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mission_activity_exit);
        getWindow().setFlags(1024, 1024);
        handler.postDelayed(new Runnable() {
            public void run() {
                finishAffinity();
            }
        }, 2000);
    }

}
