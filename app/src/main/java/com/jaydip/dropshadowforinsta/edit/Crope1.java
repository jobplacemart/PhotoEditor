package com.jaydip.dropshadowforinsta.edit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.jaydip.dropshadowforinsta.R;
import com.jaydip.dropshadowforinsta.dashboard.Glob;
import com.jaydip.dropshadowforinsta.panorama.PSHomeActivity;
import com.isseiaoki.simplecropview.CropImageView;

public class Crope1 extends AppCompatActivity implements View.OnClickListener {
    public static Bitmap addimageViewBitmap;
    CropImageView mCropView;

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_crope);
        bindViews();
        if (this.mCropView.getImageBitmap() == null) {
            this.mCropView.setImageBitmap(Glob.gallerybitmap);
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
            case R.id.button16_9 /*{ENCODED_INT: 2131296388}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_16_9);
                return;
            case R.id.button1_1 /*{ENCODED_INT: 2131296389}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.SQUARE);
                return;
            case R.id.button3_4 /*{ENCODED_INT: 2131296390}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_3_4);
                return;
            case R.id.button4_3 /*{ENCODED_INT: 2131296391}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_4_3);
                return;
            case R.id.button9_16 /*{ENCODED_INT: 2131296392}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.RATIO_9_16);
                return;
            case R.id.buttonCancel /*{ENCODED_INT: 2131296393}*/:
                finish();
                return;
            case R.id.buttonCustom /*{ENCODED_INT: 2131296394}*/:
                this.mCropView.setCustomRatio(7, 5);
                return;
            case R.id.buttonDone /*{ENCODED_INT: 2131296395}*/:
                Glob.gallerybitmap = this.mCropView.getCroppedBitmap();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return;
            case R.id.buttonFitImage /*{ENCODED_INT: 2131296396}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.FIT_IMAGE);
                return;
            case R.id.buttonFree /*{ENCODED_INT: 2131296397}*/:
                this.mCropView.setCropMode(CropImageView.CropMode.FREE);
                return;
//            case R.id.buttonPanel /*{ENCODED_INT: 2131296398}*/:
            default:
                return;
            case R.id.buttonRotateLeft /*{ENCODED_INT: 2131296399}*/:
                this.mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_M90D);
                return;
            case R.id.buttonRotateRight /*{ENCODED_INT: 2131296400}*/:
                this.mCropView.rotateImage(CropImageView.RotateDegrees.ROTATE_90D);
                return;
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, PSHomeActivity.class));
    }
}
