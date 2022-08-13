package com.jaydip.dropshadowforinsta.edit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;
import com.isseiaoki.simplecropview.CropImageView;

public class Crope extends AppCompatActivity implements View.OnClickListener {
    CropImageView mCropView;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crope);
        bindViews();
        if (this.mCropView.getImageBitmap() == null) {
            this.mCropView.setImageBitmap(Glob.bitmap);
        }
    }

    private void bindViews() {
        this.mCropView = (CropImageView) findViewById(R.id.cropImageView);
        findViewById(R.id.buttonDone).setOnClickListener(this);
        findViewById(R.id.buttonCancel).setOnClickListener(this);
        findViewById(R.id.buttonFitImage).setOnClickListener(this);
        findViewById(R.id.button1_1).setOnClickListener(this);
        findViewById(R.id.button3_4).setOnClickListener(this);
        findViewById(R.id.button4_3).setOnClickListener(this);
        findViewById(R.id.button9_16).setOnClickListener(this);
        findViewById(R.id.button16_9).setOnClickListener(this);
        findViewById(R.id.buttonFree).setOnClickListener(this);
        findViewById(R.id.buttonRotateLeft).setOnClickListener(this);
        findViewById(R.id.buttonRotateRight).setOnClickListener(this);
        findViewById(R.id.buttonCustom).setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button16_9 :
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_16_9);
                return;
            case R.id.button1_1 :
                this.mCropView.setCropMode(CropImageView.CropMode.SQUARE);
                return;
            case R.id.button3_4 :
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_3_4);
                return;
            case R.id.button4_3 :
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_4_3);
                return;
            case R.id.button9_16 :
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_9_16);
                return;
            case R.id.buttonCancel :
                finish();
                return;
            case R.id.buttonCustom :
                this.mCropView.setCustomRatio(7, 5);
                return;
            case R.id.buttonDone :
                Glob.bitmap = Crope.this.mCropView.getCroppedBitmap();
                Crope.this.setResult(-1);
                Crope.this.finish();
                return;
            case R.id.buttonFitImage :
                this.mCropView.setCropMode(CropImageView.CropMode.FIT_IMAGE);
                return;
            case R.id.buttonFree :
                this.mCropView.setCropMode(CropImageView.CropMode.FREE);
                return;
            case R.id.buttonRotateLeft :
                this.mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_M90D);
                return;
            case R.id.buttonRotateRight :
                this.mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_90D);
                return;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, PSHomeActivity.class));
    }
}
